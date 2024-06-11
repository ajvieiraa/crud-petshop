package br.com.ajvieiraa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ajvieiraa.domain.Pet;
import br.com.ajvieiraa.domain.Tutor;

public class TutorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String cpf;
	private String telefone;
	
	@JsonIgnore
	@DBRef(lazy = true)
	private List<Pet> pets = new ArrayList<>();
	
	public TutorDTO() {
		
	}
	
	public TutorDTO(Tutor obj) {
		id = obj.getId();
		name = obj.getName();
		cpf = obj.getCpf();
		telefone = obj.getTelefone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
}
