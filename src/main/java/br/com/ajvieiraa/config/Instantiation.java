package br.com.ajvieiraa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ajvieiraa.domain.Pet;
import br.com.ajvieiraa.domain.Tutor;
import br.com.ajvieiraa.repository.PetRepository;
import br.com.ajvieiraa.repository.TutorRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired 
	private PetRepository petRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		tutorRepository.deleteAll();
		petRepository.deleteAll();
		
		Tutor arthur = new Tutor(null, "Arthur Vieira","11223344556","11223344556");
		Tutor suellen = new Tutor(null, "Suellen Bruna","22334455667","22334455667");
		Tutor raelma = new Tutor(null, "Raelma Kecia","33445566778","33445566778");
		
		tutorRepository.saveAll(Arrays.asList(arthur,suellen,raelma));
		
		Pet pet1 = new Pet(null,"Biel", "Atentado","laranja", "1", raelma);
		Pet pet2 = new Pet(null,"Gabi", "Mansa","siamês", "1", raelma);
		Pet pet3 = new Pet(null,"Zezo", "Golden","amrelo-mel", "1", suellen);
		
		petRepository.saveAll(Arrays.asList(pet1,pet2,pet3));
		
		raelma.getPets().addAll(Arrays.asList(pet1,pet2));
		suellen.getPets().addAll(Arrays.asList(pet3));
		tutorRepository.saveAll(Arrays.asList(raelma,suellen));
	}

}
