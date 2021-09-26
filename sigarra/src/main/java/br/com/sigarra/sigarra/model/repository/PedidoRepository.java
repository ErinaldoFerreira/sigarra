package br.com.sigarra.sigarra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigarra.sigarra.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
