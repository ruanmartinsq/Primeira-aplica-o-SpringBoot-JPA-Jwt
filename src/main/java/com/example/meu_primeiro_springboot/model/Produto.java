package com.example.meu_primeiro_springboot.model;

import jakarta.persistence.*;

@Entity //indica que é uma entidade JPA
@Table(name = "produtos") //define o nome da tabela
public class Produto {

    @Id //indica que vai ser um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que sera uma chave primaria gerada automaticamente
    private Long id;

    private String nome;
    private Double preco;

    public Produto() {}

    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
