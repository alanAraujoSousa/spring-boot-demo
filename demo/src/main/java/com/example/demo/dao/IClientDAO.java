package com.example.demo.dao;

import com.example.demo.commons.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDAO extends JpaRepository<Client, Long> {
}
