package com.victorgabriel.eventos.shared.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntityUser {

    /*
    * Com o MappedSuperClass toda classe qu extender BaseEntityUser alem de ter
    * ela como superclasse ainda vai ter como herança as suas anotations
    * Ou seja, ela vai Receber a anotation @Id, exclarecendo para a JPA
    * que a classe filha tambem tem uma primary key*/
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String email;
    private String password;
}
