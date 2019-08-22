package com.example.demo.controllers;

import com.example.demo.commons.beans.City;
import com.example.demo.commons.exceptions.CityNotFoundByNameException;
import com.example.demo.dao.ICityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityResource {

    @Autowired
    private ICityDAO cityDAO;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody City city) {
        City savedCity = this.cityDAO.save(city);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCity.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public List<City> retrieveAll() {
        return this.cityDAO.findAll();
    }

    @GetMapping("search/byName")
    public City retrieveByName(@RequestParam("name") String name) {

        Optional<City> city = this.cityDAO.findByName(name);

        if (!city.isPresent())
            throw new CityNotFoundByNameException(name);

        return city.get();
    }

    @GetMapping("search/byState")
    public List<City> retrieveByState(@RequestParam("state") String state) {
        return this.cityDAO.findByState(state);
    }

}
