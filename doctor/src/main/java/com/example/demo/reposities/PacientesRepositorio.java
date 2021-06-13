package com.example.demo.reposities;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.PacientesEntitis;

public interface PacientesRepositorio extends CrudRepository<PacientesEntitis, Long>{

}