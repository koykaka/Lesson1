package com.example.lesson3_mysql.repository;

import com.example.lesson3_mysql.entities.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Integer> {
//    List<Horse> findByTrainerIdAndFoaledYear(Integer trainerId, Integer year);
}
