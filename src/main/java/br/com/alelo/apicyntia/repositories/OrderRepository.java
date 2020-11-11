package br.com.alelo.apicyntia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.apicyntia.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
