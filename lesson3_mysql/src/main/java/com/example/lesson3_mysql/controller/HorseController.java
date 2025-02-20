package com.example.lesson3_mysql.controller;

import com.example.lesson3_mysql.entities.*;
import com.example.lesson3_mysql.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horse")
public class HorseController {
    @Autowired
    private HorseService horseService;

    @GetMapping("/all")
    public ResponseEntity<List<Horse>> getAllHorses() {
        return ResponseEntity.ok(horseService.getAllHorses());
    }

//    @GetMapping
//    public ResponseEntity<List<Horse>> getHorsesByFilter(
//            @RequestParam(required = false) Integer trainerId,
//            @RequestParam(required = false) Integer year) {
//        return ResponseEntity.ok(horseService.getHorsesByFilter(trainerId, year));
//    }

    @PostMapping
    public ResponseEntity<Horse> addHorse(@RequestBody Horse horse) {
        return ResponseEntity.ok(horseService.createHorse(horse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horse> updateHorse(@PathVariable Integer id, @RequestBody Horse horse) {
        return ResponseEntity.ok(horseService.updateHorse(id, horse));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHorse(@PathVariable Integer id) {
        horseService.deleteHorse(id);
        return ResponseEntity.ok("Horse is deleted");
    }
}

