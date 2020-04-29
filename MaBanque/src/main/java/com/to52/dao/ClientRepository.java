package com.to52.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.to52.entities.Client;

public interface ClientRepository
extends JpaRepository<Client, Long>{

}
