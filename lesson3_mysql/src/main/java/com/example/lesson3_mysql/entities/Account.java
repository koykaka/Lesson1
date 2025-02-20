package com.example.lesson3_mysql.entities;

import lombok.*;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "account")
    private List<HorseAccount> horseAccounts;

    public Account(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
