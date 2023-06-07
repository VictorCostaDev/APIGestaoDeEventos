package com.victorgabriel.eventos.modules.customers.controllers;

import com.victorgabriel.eventos.modules.customers.dto.JWTToken;
import com.victorgabriel.eventos.modules.customers.dto.LoginDTO;
import com.victorgabriel.eventos.modules.customers.repositories.ICustomerRepository;
import com.victorgabriel.eventos.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class LoginCustomerController {

    @Autowired
    private ICustomerRepository customerRepository;

    @PostMapping("/login")
    public JWTToken login(@RequestBody LoginDTO loginDTO) {
        //verificar se existe email no customer
        var customerExists = this.customerRepository.findByEmail(loginDTO.getEmail());
        if(customerExists == null) throw new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);

        // se existir verificar a senha
        if(!loginDTO.getPassword().equals(customerExists.getPassword())) throw new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);

        // se tudo tiver ok Gerar o Token
        //senao gerar um Erro
        return new JWTToken("TOKENCRIADO");
    }
}