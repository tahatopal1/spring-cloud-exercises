package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.Post;
import com.example.demo.model.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/jpa")
public class UserJpaController {

    private UserRepository repository;
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }


    // With HATEOAS
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User is not found with id: " + id);
        }

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> entityModel = EntityModel.of(user.get());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
