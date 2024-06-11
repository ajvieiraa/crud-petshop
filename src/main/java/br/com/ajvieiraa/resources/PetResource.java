package br.com.ajvieiraa.resources;

import java.net.URI;

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
import br.com.ajvieiraa.dto.PetDTO;
import br.com.ajvieiraa.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetResource {

	@Autowired
	private PetService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pet> findById(@PathVariable String id){
		Pet obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PetDTO petDto){
		Pet obj = service.fromDTO(petDto);
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
	public ResponseEntity<Void> update(@RequestBody PetDTO objDto, @PathVariable String id) {
		Pet obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		}
	
	
}
