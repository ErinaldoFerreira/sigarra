package br.com.sigarra.sigarra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigarra.sigarra.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
