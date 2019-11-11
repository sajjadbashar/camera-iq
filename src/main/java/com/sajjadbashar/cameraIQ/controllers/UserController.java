package com.sajjadbashar.cameraIQ.controllers;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sajjadbashar.cameraIQ.models.User;
import com.sajjadbashar.cameraIQ.models.Organization;
import com.sajjadbashar.cameraIQ.services.UserService;


import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user)
                .map(createdUser -> ResponseEntity.ok(createdUser))
                .orElseThrow();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElseThrow();
    }

    @DeleteMapping(path = "/{id}")
    public void removeUser(@PathVariable Integer id) {
        userService.removeUser(id);
    }

    @GetMapping(path = "/{id}/organizations")
    public ResponseEntity<List<Organization>> getOrganizationsOfUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(user.getOrganizations().stream().collect(toList())))
                .orElseThrow();
    }
}
