package com.example.lesson3_mysql.service;

import com.example.lesson3_mysql.entities.Horse;
import com.example.lesson3_mysql.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {
    @Autowired
    private HorseRepository horseRepository;

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

//    public List<Horse> getHorsesByFilter(Integer trainerId, Integer year) {
//        return horseRepository.findByTrainerIdAndFoaledYear(trainerId, year);
//    }

    //
    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }


    public Horse updateHorse(Integer id, Horse horseDetails) {
        Horse updatedHorse = horseRepository.findById(id).orElseThrow(() -> new RuntimeException("Horse not found"));
        updatedHorse.setName(horseDetails.getName());
        updatedHorse.setFoaled(horseDetails.getFoaled());
        return horseRepository.save(updatedHorse);

    }

    public void deleteHorse(Integer id) {
        horseRepository.deleteById(id);
    }
}
