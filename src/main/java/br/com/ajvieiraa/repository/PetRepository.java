package br.com.ajvieiraa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ajvieiraa.domain.Pet;

@Repository
public interface PetRepository extends MongoRepository<Pet, String>{

}
