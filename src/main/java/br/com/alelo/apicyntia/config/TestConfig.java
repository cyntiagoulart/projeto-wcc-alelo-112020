package br.com.alelo.apicyntia.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.alelo.apicyntia.entities.Category;
import br.com.alelo.apicyntia.entities.Order;
import br.com.alelo.apicyntia.entities.User;
import br.com.alelo.apicyntia.entities.enums.OrderStatus;
import br.com.alelo.apicyntia.repositories.CategoryRepository;
import br.com.alelo.apicyntia.repositories.OrderRepository;
import br.com.alelo.apicyntia.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Livros");
		Category cat2 = new Category(null, "Ebooks");
		Category cat3 = new Category(null, "Jornais");
		Category cat4 = new Category(null, "Revistas");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3, cat4));
		
		User u1 = new User(null, "Sirigueijo", "sirigueijo@siricascudo.com", "977777777", "123456");
		User u2 = new User(null, "Patrick Estrela", "patrick@estrela.com", "988888888", "123456");
		User u3 = new User(null, "Sandy Bochechas", "sandy@bochechas.com", "966666666", "123456");
		User u4 = new User(null, "Bob Esponja", "bob@esponja.com.br", "955555555", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
