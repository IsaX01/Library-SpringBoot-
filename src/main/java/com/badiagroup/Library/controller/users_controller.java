package com.badiagroup.Library.controller;

import com.badiagroup.Library.model.users;
import com.badiagroup.Library.repository.users_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class users_controller {

    @Autowired
    users_repository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public ResponseEntity<List<users>> getAllUsers() {
        try {
            List<users> users = new ArrayList<users>();

            usersRepository.findAll().forEach(users::add);

            if (users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<users> getUserById(@PathVariable("id") long id) {
        Optional<users> userData = usersRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<users> createUser(@RequestBody users user) {
        try {
            users _user = usersRepository
                    .save(new users(user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(),
                            user.getAddress(), user.getUser_type_id(), user.getProfile_picture(), user.getStatus()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<users> updateUser(@PathVariable("id") long id, @RequestBody users user) {
        Optional<users> userData = usersRepository.findById(id);

        if (userData.isPresent()) {
            users _user = userData.get();
            _user.setFirst_name(user.getFirst_name());
            _user.setLast_name(user.getLast_name());
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setAddress(user.getAddress());
            _user.setUser_type_id(user.getUser_type_id());
            _user.setProfile_picture(user.getProfile_picture());
            _user.setStatus(user.getStatus());
            return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<users> signUp(@RequestBody users user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            users _user = usersRepository.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<users> login(@RequestBody users user) {
        users existingUser = usersRepository.findByEmail(user.getEmail());
        if (existingUser != null && bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
