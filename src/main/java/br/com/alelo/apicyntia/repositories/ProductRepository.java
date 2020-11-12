package br.com.alelo.apicyntia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.apicyntia.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
