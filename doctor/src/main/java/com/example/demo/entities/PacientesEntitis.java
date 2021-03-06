package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class PacientesEntitis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "NOMBREDOS")
	private String nombredos;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "APELLIDODOS")
	private String apellidodos;
	@Column(name = "EDAD")
	private int edad;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombredos() {
		return nombredos;
	}
	public void setNombredos(String nombredos) {
		this.nombredos = nombredos;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getApellidodos() {
		return apellidodos;
	}
	public void setApellidodos(String apellidodos) {
		this.apellidodos = apellidodos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	
}