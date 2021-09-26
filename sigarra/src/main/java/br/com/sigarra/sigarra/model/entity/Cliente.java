package br.com.sigarra.sigarra.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //cria getters, setters, toString e construtor sem parametros
@NoArgsConstructor //construtor padrão
@AllArgsConstructor //construtor com todos argumentos
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o numero do ID automaticamente
	private Integer id;
	
	@Column(nullable = false, length = 150) //"nulable = false" - indica que o campo não pode ser nulo	
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(nullable = false, length = 11) //"length = 11" - indica o tamanho do campo no BD, neste caso 11
	@NotNull(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@Column(name = "data_cadastro", updatable = false) // "updatable = false" restringe a possibilidade de modificar a data
	@JsonFormat(pattern = "dd/MM/yyyy") //formata a data para este padrão
	private LocalDate dataCadastro;	
	
	@PrePersist //antes de persistir este metodo coloca a data de cadastro atual
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
	
}
