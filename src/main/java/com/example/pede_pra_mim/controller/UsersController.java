package com.example.pede_pra_mim.controller;


import com.example.pede_pra_mim.users.Users; //Entidade que exista na tabela
import com.example.pede_pra_mim.users.UsersDTO;
import com.example.pede_pra_mim.users.UsersRequestDTO;
import com.example.pede_pra_mim.users.UsersRepository; // Extensão do Jpa pra contemplar métodos abstratos SQL
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")

public class UsersController {

    @Autowired
    private UsersRepository repository;

    @CrossOrigin(origins ="*", allowedHeaders = "*")
    @GetMapping
    public List<UsersDTO> getAll(){


        List<UsersDTO> usersList = repository.findAll().stream().map(UsersDTO::new).toList();
        return usersList;
        }

    @CrossOrigin(origins ="*", allowedHeaders = "*")
    @PostMapping
    public void saveUsers(@RequestBody UsersRequestDTO data){

        Users usersData = new Users(data);
        repository.save(usersData);

    }
    }

