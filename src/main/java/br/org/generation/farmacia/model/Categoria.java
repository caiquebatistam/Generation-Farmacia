package br.org.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table( name = "tb_categoria")
public class Categoria {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message =" O atributo tipo é obrigatório!")
	@Size(min = 3, max = 100, message = "O Atributo tipo deve ter no mínimo 3 e no máximo 100 caracteres!")
	private String tipo;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // um para muitos
	@JsonIgnoreProperties("categoria")
	private List<Produtos> produtos;
	
	

	
	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	
	
	
	
}
