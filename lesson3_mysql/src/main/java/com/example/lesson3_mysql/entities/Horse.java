package com.example.lesson3_mysql.entities;

import lombok.*;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "horse")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date foaled;

    @OneToMany(mappedBy = "horse")
    private List<HorseAccount> horseAccounts;

    public Horse(Integer id, String name, Date foaled, List<HorseAccount> horseAccounts) {
        this.id = id;
        this.name = name;
        this.foaled = foaled;
        this.horseAccounts = horseAccounts;
    }
}
