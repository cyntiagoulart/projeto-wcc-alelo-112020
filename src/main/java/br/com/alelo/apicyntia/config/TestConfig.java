package br.com.alelo.apicyntia.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.alelo.apicyntia.entities.Category;
import br.com.alelo.apicyntia.entities.Order;
import br.com.alelo.apicyntia.entities.Product;
import br.com.alelo.apicyntia.entities.User;
import br.com.alelo.apicyntia.entities.enums.OrderStatus;
import br.com.alelo.apicyntia.repositories.CategoryRepository;
import br.com.alelo.apicyntia.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Livros");
		Category cat2 = new Category(null, "Ebooks");
		
		
		Product p1 = new Product(null, "Saga Otori - A rede do céu é vasta - prelúdio by Lian Hearn", "Lorem ipsum dolor sit amet, consectetur.", 64.8, "");
		Product p2 = new Product(null, "Saga Otori - A relva por travesseiro: 2 by Lean Hearn", "Nulla eu imperdiet purus. Maecenas ante.", 36.0, "");
		Product p3 = new Product(null, "Turma da Mônica Geração 12 - Número Zero by Mauricio de Souza", "Nam eleifend maximus tortor, at mollis.", 6.0, "");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));		
		
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
