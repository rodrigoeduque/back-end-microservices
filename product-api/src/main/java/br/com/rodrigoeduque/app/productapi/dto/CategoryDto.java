package br.com.rodrigoeduque.app.productapi.dto;

import br.com.rodrigoeduque.app.productapi.model.Category;

public class CategoryDto {

    private String nome;

    public CategoryDto() {

    }

    public CategoryDto(String nome) {
        this.nome = nome;
    }


    public String getNome() {

        return nome;
    }

    public Category convertToModel() {

        return new Category(nome);
    }

}
