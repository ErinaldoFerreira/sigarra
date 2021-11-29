package br.com.sigarra.sigarra.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@JoinColumn(name = "id_servico")
	@ManyToMany
	private List<ServicoPrestado> itens = new ArrayList<>();
	
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy") //formata a data para este padrão
	private LocalDate dataPedido;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy") //formata a data para este padrão
	private LocalDate dataEntrega;

}
