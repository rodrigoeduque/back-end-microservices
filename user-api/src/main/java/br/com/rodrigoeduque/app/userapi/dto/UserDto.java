package br.com.rodrigoeduque.app.userapi.dto;

import br.com.rodrigoeduque.app.userapi.model.User;

import java.time.LocalDate;

public class UserDto {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;

    public UserDto(String nome, String cpf, String endereco, String email, String telefone, LocalDate dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

    private static UserDto convertToDto(User user) {
        return new UserDto(user.getNome(), user.getCpf(), user.getEndereco(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
    }
}
