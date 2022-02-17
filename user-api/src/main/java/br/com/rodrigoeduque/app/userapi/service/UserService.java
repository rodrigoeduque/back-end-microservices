package br.com.rodrigoeduque.app.userapi.service;

import br.com.rodrigoeduque.app.userapi.dto.UserDto;
import br.com.rodrigoeduque.app.userapi.dto.UserResumidoDto;
import br.com.rodrigoeduque.app.userapi.model.User;
import br.com.rodrigoeduque.app.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDto> getUsuariosCompleto() {

        List<User> usuarios = repository.findAll();


        List<UserDto> userDto = usuarios.stream().map(User::convertToDto).collect(Collectors.toList());

        return userDto;
    }

    public List<UserResumidoDto> getUsuariosResumidos() {

        List<User> usuarios = repository.findAll();
        List<UserResumidoDto> collect = usuarios.stream().map(User::convertToDtoResumido).collect(Collectors.toList());
        return collect;
    }

    public User getUserById(Long id) {

        System.out.println("ID >" + id);
        return repository.findById(id).orElseThrow(null);
    }

    public List<UserDto> queryByNome(String nome) {

        List<User> usuarios = repository.queryByNomeLike("%" + nome + "%");
        List<UserDto> userDto = usuarios.stream().map(User::convertToDto).collect(Collectors.toList());
        return userDto;
    }

    public User findByCpf(String cpf) {

        User user = repository.findByCpf(cpf);
        return user;
    }

    public User save(UserDto userDto) {

        userDto.setDataCadastro(LocalDate.now());
        User user = userDto.convertToModel();
        User save = repository.save(user);

        return save;
    }

    public void delete(Long id) {

        User userById = getUserById(id);
        repository.delete(userById);
    }

}
