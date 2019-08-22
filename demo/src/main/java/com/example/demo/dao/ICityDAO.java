package com.example.demo.dao;

import com.example.demo.commons.beans.City;
import com.example.demo.commons.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICityDAO extends JpaRepository<City, Long> {

    public List<City> findByNameIgnoreCaseContaining(String name);

    public Optional<City> findByName(String name);

    public List<City> findByState(String state);

}
