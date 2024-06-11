package br.com.ajvieiraa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ajvieiraa.domain.Pet;
import br.com.ajvieiraa.dto.PetDTO;
import br.com.ajvieiraa.repository.PetRepository;
import br.com.ajvieiraa.services.exception.ObjectNotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository repo;
	
	public List<Pet> findAll(){
		return repo.findAll();
	}
	public Pet findById(String id) {
		Optional<Pet> pet = repo.findById(id);
		if (pet == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return pet.get();
	}
	public Pet insert(Pet obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Pet update(Pet obj) {
		Pet newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	private void updateData(Pet newObj, Pet obj) {
		newObj.setName(obj.getName());
	}

	public Pet fromDTO(PetDTO objDto) {
		return new Pet(objDto.getId(), objDto.getName(), objDto.getRaça(), objDto.getCor(), objDto.getIdade(),objDto.getTutor());
	}
	
} 
