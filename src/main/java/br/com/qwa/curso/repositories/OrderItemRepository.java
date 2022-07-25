package br.com.qwa.curso.repositories;

import br.com.qwa.curso.entities.OrderItem;
import br.com.qwa.curso.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}