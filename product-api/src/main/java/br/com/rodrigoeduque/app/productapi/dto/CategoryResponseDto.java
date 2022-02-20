package br.com.rodrigoeduque.app.productapi.dto;

import br.com.rodrigoeduque.app.productapi.model.Category;

public class CategoryResponseDto {

    private String nome;

    public String getNome() {

        return nome;
    }

    public CategoryResponseDto(String nome) {

        this.nome = nome;
    }

    public Category toModel(){
        return new Category(nome);
    }

}
