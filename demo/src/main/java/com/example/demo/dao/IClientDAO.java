package com.example.demo.dao;

import com.example.demo.commons.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientDAO extends JpaRepository<Client, Long> {

   public Optional<Client> findByName(String name);
}
