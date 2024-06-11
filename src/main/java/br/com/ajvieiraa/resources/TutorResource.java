package br.com.ajvieiraa.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ajvieiraa.domain.Pet;
import br.com.ajvieiraa.domain.Tutor;
import br.com.ajvieiraa.dto.TutorDTO;
import br.com.ajvieiraa.services.TutorService;

@RestController
@RequestMapping("/tutor")
public class TutorResource {

	@Autowired
	private TutorService service;
	
	@GetMapping
	public ResponseEntity<List<TutorDTO>> findAll(){
		List<Tutor> list = service.findAll();
		List<TutorDTO> listDTO = list.stream().map(x -> new TutorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<TutorDTO> findById(@PathVariable String id){
		Tutor obj = service.findById(id);
		return ResponseEntity.ok().body(new TutorDTO (obj));
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TutorDTO tutorDto){
		Tutor obj = service.fromDTO(tutorDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping (value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping (value="/{id}")
	public ResponseEntity<Void> update(@RequestBody TutorDTO objDto, @PathVariable String id) {
		Tutor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		}
	@GetMapping(value="/{id}/pets")
	public ResponseEntity<List<Pet>> findPets(@PathVariable String id){
		Tutor obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPets());
	}
	
}
