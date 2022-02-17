package br.com.rodrigoeduque.app.userapi.controller;

import br.com.rodrigoeduque.app.userapi.dto.UserDto;
import br.com.rodrigoeduque.app.userapi.dto.UserResumidoDto;
import br.com.rodrigoeduque.app.userapi.model.User;
import br.com.rodrigoeduque.app.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsuariosCompleto() {

        List<UserDto> users = service.getUsuariosCompleto();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users-resumidos")
    public ResponseEntity<List<UserResumidoDto>> getUsuariosResumidos() {

        List<UserResumidoDto> usuariosResumidos = service.getUsuariosResumidos();
        return ResponseEntity.ok().body(usuariosResumidos);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        User usuario = service.getUserById(id);
        UserDto userResumidoDto = usuario.convertToDto();
        return ResponseEntity.ok().body(userResumidoDto);
    }

    @GetMapping("/users/search")
    public ResponseEntity<List<UserDto>> getUserLikeNome(@RequestParam(name = "nome", required = true) String nome) {

        List<UserDto> userDto = service.queryByNome(nome);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/users/cpf/{cpf}")
    public ResponseEntity<UserDto> findUserByCpf(@PathVariable String cpf) {

        User user = service.findByCpf(cpf);
        UserDto userDto = user.convertToDto();
        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto userDto) {

        User usuario = service.save(userDto);
        UserDto dto = usuario.convertToDto();
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
