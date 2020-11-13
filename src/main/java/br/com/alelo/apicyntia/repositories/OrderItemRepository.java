package br.com.alelo.apicyntia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.apicyntia.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
