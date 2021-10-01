package br.org.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table( name = "tb_produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message =" O atributo medicamento é obrigatório!")
	@Size(min = 3, max = 100, message = "O Atributo medicamento deve ter no mínimo 3 e no máximo 100 caracteres!")
	private String nome;
	
	
	@NotNull(message =" O atributo preço é obrigatório!")
	private BigDecimal preco;
	
	@NotNull(message =" O atributo quantidade é obrigatório!")
	private int quantidade;

	 
	@ManyToOne // tipo de relação que esta classe vai ter com a outra classe
	@JsonIgnoreProperties("produtos") // evitar lopp infinito
	private Categoria categoria;
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	
	
	
	
	
	
	
}
