package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.PacientesEntitis;
import com.example.demo.reposities.PacientesRepositorio;




@RestController
@RequestMapping(value = "/paciente")
public class Pacientes {
	
	@Autowired
	PacientesRepositorio repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<PacientesEntitis> getListaPacientes(){
		Iterable<PacientesEntitis> listaPacientes = repository.findAll();
		
		return (Collection<PacientesEntitis>) listaPacientes;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public PacientesEntitis getPacientes(@PathVariable (name = "id") Long id) {
		Optional<PacientesEntitis> pacientes = repository.findById(id);
		PacientesEntitis result =null;
		if(pacientes.isPresent()) {
			result = pacientes.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PacientesEntitis createPaciente(@RequestBody PacientesEntitis paciente) {
		
		PacientesEntitis nuevoPaciente =repository.save(paciente);
		return nuevoPaciente;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteCliente(@PathVariable(name = "id") Long id) {
	repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public PacientesEntitis updatePacientes(@PathVariable(name = "id") Long id, @RequestBody PacientesEntitis pacientes) {
		Optional<PacientesEntitis> oPacientes = repository.findById(id);
		if (oPacientes.isPresent()) {
			PacientesEntitis actual = oPacientes.get();
			actual.setId(id);
			actual.setNombre(pacientes.getNombre());
			actual.setNombredos(pacientes.getNombredos());
			actual.setApellido(pacientes.getApellido());
			actual.setApellidodos(pacientes.getApellidodos());
			actual.setEdad(pacientes.getEdad());
			PacientesEntitis updatePacientes = repository.save(actual);
			return updatePacientes;
		}
		return null;
	}
		
}
