package com.badiagroup.Library.controller;

import com.badiagroup.Library.model.loans;
import com.badiagroup.Library.repository.loans_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class loans_controller {

    @Autowired
    loans_repository loansRepository;


}
