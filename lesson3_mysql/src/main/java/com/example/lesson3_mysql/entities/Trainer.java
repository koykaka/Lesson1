package com.example.lesson3_mysql.entities;

import lombok.*;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    public Trainer(Integer id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }
}
