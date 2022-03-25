package com.modulo1.crud.trabalho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modulo1.crud.trabalho.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
