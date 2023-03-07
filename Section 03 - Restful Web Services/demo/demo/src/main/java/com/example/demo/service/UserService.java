package com.example.demo.service;

import com.example.demo.model.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Tim", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Don", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        users.removeIf(user -> user.getId().equals(id));
    }
}
