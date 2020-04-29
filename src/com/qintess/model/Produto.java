package com.qintess.model;

	import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

	@Entity
	public class Produto implements EntidadeBase{

	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 200, nullable = false)
	    private String nome;

	    @Column(nullable = false)
	    private double preco;
	    
	    @OneToMany(mappedBy = "produto")
	    private List<ItemVenda> itens = new ArrayList<ItemVenda>();
	    
	    public Produto() {}

	    public Produto(String nome, double preco) {
	        this.nome = nome;
	        this.preco = preco;
	    }


	    @Override
	    public String toString() {
	        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public double getPreco() {
	        return preco;
	    }

	    public void setPreco(double preco) {
	        this.preco = preco;
	    }
}
