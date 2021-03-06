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

import com.example.demo.entities.CitasEntitis;
import com.example.demo.reposities.CitasRepo;

@RestController
@RequestMapping(value = "/cita")
public class CitasControl {
	
	@Autowired
	CitasRepo repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<CitasEntitis> getListaCitas(){
		Iterable<CitasEntitis> listaCitas = repository.findAll();
		
		return (Collection<CitasEntitis>) listaCitas;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CitasEntitis getCitas(@PathVariable (name = "id") Long id) {
		Optional<CitasEntitis> citas = repository.findById(id);
		CitasEntitis result =null;
		if(citas.isPresent()) {
			result = citas.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CitasEntitis createCitas(@RequestBody CitasEntitis cita) {
		
		CitasEntitis nuevaCitas =repository.save(cita);
		return nuevaCitas;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deletecita(@PathVariable(name = "id") Long id) {
	repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public CitasEntitis updatecita(@PathVariable(name = "id") Long id, @RequestBody CitasEntitis cita) {
			Optional<CitasEntitis> oCitas = repository.findById(id);
			if (oCitas.isPresent()) {
				CitasEntitis actual = oCitas.get();
				actual.setId(id);
				actual.setFecha(cita.getFecha());
				actual.setHora(cita.getHora());
				actual.setPaciente(cita.getPaciente());
				actual.setEstado(cita.getEstado());
				actual.setObservaciones(cita.getObservaciones());
				CitasEntitis updatecitas= repository.save(actual);
				return updatecitas;
			}
			return null;
		}

}