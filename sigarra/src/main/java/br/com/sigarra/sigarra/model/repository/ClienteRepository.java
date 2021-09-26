package br.com.sigarra.sigarra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigarra.sigarra.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
