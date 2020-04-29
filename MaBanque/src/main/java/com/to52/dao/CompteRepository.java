package com.to52.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.to52.entities.Compte;

public interface CompteRepository
extends JpaRepository<Compte, String>{

}
