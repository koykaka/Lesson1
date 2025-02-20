package com.example.lesson3_mysql.entities;

import lombok.*;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Setter
@Getter
@Entity

@NoArgsConstructor
@Table(name = "horse_account")
public class HorseAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "horse_id", referencedColumnName = "id", nullable = false)
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @Column(name = "archive", nullable = false, columnDefinition = "TINYINT DEFAULT 0")
    private Integer archive;

}
