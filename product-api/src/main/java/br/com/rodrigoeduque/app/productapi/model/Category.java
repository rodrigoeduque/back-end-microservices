package br.com.rodrigoeduque.app.productapi.model;

import br.com.rodrigoeduque.app.productapi.dto.CategoryDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Category() {
    }

    public Category(Long id , String nome) {

        this.id = id;
        this.nome = nome;
    }

    public Category(String nome) {
        this.nome = nome;
    }

    public Long getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    public CategoryDto convertToDto(){
        return new CategoryDto(nome);
    }

}
