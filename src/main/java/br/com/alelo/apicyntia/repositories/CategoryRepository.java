package br.com.alelo.apicyntia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.apicyntia.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
