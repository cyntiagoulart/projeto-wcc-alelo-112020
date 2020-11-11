package br.com.alelo.apicyntia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.apicyntia.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
