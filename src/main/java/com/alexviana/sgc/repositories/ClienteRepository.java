package com.alexviana.sgc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexviana.sgc.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
