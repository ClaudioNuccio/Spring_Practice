package com.example.Unittest.controllers;

import com.example.Unittest.entities.Users;
import com.example.Unittest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/create")
    public @ResponseBody Users create(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @GetMapping(path = "/getall")
    public @ResponseBody List<Users> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/getone/{id}")
    public @ResponseBody Users getSingle(@PathVariable long id) {
        return userService.getSingleUser(id);
    }

    @PutMapping(path = "/patch/{id}")
    public @ResponseBody Users update(@PathVariable long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @PutMapping(path = "/{id}/active")
    public void setActive(@PathVariable long id, @RequestParam boolean active) {
        userService.setUserActive(id, active);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable long id) {
        return userService.deleteUser(id);
    }

}
