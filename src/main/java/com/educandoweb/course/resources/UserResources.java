package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    //endpoint para acessar os usuários
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("maria", 1L, "Maria@gmail.com", "222-2222", "12345");
        return ResponseEntity.ok().body(u);
    }
}
