package br.com.ajvieiraa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ajvieiraa.domain.Tutor;
import br.com.ajvieiraa.dto.TutorDTO;
import br.com.ajvieiraa.repository.TutorRepository;
import br.com.ajvieiraa.services.exception.ObjectNotFoundException;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repo;
	
	public List<Tutor> findAll(){
		return repo.findAll();
	}
	
	public Tutor findById(String id) {
		Optional<Tutor> tutor = repo.findById(id);
		if (tutor == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return tutor.get();
	}
	
	public Tutor insert(Tutor obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Tutor update(Tutor obj) {
		Tutor newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	
	private void updateData(Tutor newObj, Tutor obj) {
		newObj.setName(obj.getName());
		newObj.setCpf(obj.getCpf());
	}

	public Tutor fromDTO(TutorDTO objDto) {
		return new Tutor(objDto.getId(), objDto.getName(), objDto.getCpf(), objDto.getTelefone());
	}
} 
