package com.example.demo.controllers;

import com.example.demo.commons.beans.City;
import com.example.demo.commons.beans.Client;
import com.example.demo.commons.exceptions.CityNotFoundByNameException;
import com.example.demo.commons.exceptions.ClientNotFoundByIdException;
import com.example.demo.commons.exceptions.ClientNotFoundByNameException;
import com.example.demo.commons.exceptions.InvalidParametersToUpdateClientException;
import com.example.demo.dao.IClientDAO;
import net.bytebuddy.description.type.TypeDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.Validation;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientResource {

    @Autowired
    private IClientDAO clientDAO;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Client client) {
        Client savedClient = this.clientDAO.save(client);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedClient.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<Client> retrieveAll() {
        return this.clientDAO.findAll();
    }

    @GetMapping("/{id}")
    public Client retrieve(@PathVariable long id) {
        return this.clientDAO.findById(id).orElseThrow(() -> new ClientNotFoundByIdException(id));
    }

    @GetMapping("/search/byName")
    public Client retrieveByName(@RequestParam("name") String name) {
        return this.clientDAO.findByName(name).orElseThrow(() -> new ClientNotFoundByNameException(name));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.clientDAO.deleteById(id);
    }

    @PatchMapping("/{id}")
    public void partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

        Client client = this.clientDAO.findById(id).orElseThrow(() -> new ClientNotFoundByIdException(id));

        try { // Should be in a service, but for demo it's ok!
            fields.forEach((k, v) -> {
                Field field = ReflectionUtils.findField(Client.class, k);
                field.setAccessible(true);
                ReflectionUtils.setField(field, client, v);
            });
        } catch (Exception e) {
            throw new InvalidParametersToUpdateClientException(fields.keySet());
        }

        Validation.buildDefaultValidatorFactory().getValidator().validate(client);

        this.clientDAO.save(client);
    }

}
