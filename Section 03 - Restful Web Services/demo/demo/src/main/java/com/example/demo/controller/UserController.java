package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

/*    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userService.findOne(id);
        if (Objects.isNull(user)){
            throw new UserNotFoundException("User is not found with id: " + id);
        }
        return user;
    }*/

    // With HATEOAS
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = userService.findOne(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("User is not found with id: " + id);
        }

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

/*    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }*/

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }

}
