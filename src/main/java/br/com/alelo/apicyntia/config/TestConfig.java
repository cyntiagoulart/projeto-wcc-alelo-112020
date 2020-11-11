package br.com.alelo.apicyntia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.alelo.apicyntia.entities.User;
import br.com.alelo.apicyntia.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		// Id será gerado pelo javax.persistence.GenerationType
		User u1 = new User(null, "Sirigueijo", "sirigueijo@siricascudo.com", "977777777", "123456");
		User u2 = new User(null, "Patrick Estrela", "patrick@estrela.com", "988888888", "123456");
		User u3 = new User(null, "Sandy Bochechas", "sandy@bochechas.com", "966666666", "123456");
		User u4 = new User(null, "Bob", "bob@esponja.com.br", "5555555", "senha");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

	}

}
