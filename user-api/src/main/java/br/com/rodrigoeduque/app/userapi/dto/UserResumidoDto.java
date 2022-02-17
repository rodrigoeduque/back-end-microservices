package br.com.rodrigoeduque.app.userapi.dto;

import br.com.rodrigoeduque.app.userapi.model.User;

public class UserResumidoDto {

    private String nome;
    private String email;
    private String telefone;

    public UserResumidoDto(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    private static UserResumidoDto convertToDto(User user) {
        return new UserResumidoDto(user.getNome(), user.getEmail(), user.getTelefone());
    }

    public User convertToModel() {
        return new User(nome, email, telefone);
    }
}
