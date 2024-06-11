package br.com.ajvieiraa.dto;

import java.io.Serializable;

import br.com.ajvieiraa.domain.Pet;
import br.com.ajvieiraa.domain.Tutor;

public class PetDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	private String raça;
	private String cor;
	private String idade;
	private Tutor tutor;
	
	public PetDTO() {
		
	}
	
	public PetDTO(Pet obj) {
		id = obj.getId();
		name = obj.getName();
		raça = obj.getRaça();
		cor = obj.getCor();
		idade = obj.getIdade();
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

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
}
