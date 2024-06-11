package br.com.ajvieiraa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ajvieiraa.domain.Tutor;

@Repository
public interface TutorRepository extends MongoRepository<Tutor, String>{

}
