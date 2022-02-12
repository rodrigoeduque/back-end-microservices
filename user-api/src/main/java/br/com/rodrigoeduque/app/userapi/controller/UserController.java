package br.com.rodrigoeduque.app.userapi.controller;

import br.com.rodrigoeduque.app.userapi.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public String getUsuarios(UserDto userDto){
        return userDto.toString();
    }


}
