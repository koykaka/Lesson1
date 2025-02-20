package com.example.lesson3_mysql.service;

import com.example.lesson3_mysql.entities.Trainer;
import com.example.lesson3_mysql.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainerById(Integer id) {
        return trainerRepository.findById(id);
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Optional<Trainer> updateTrainer(int id, Trainer trainer) {
        return trainerRepository.findById(id).map(existingTrainer -> {
            existingTrainer.setName(trainer.getName());
            existingTrainer.setAccount(trainer.getAccount());
            return trainerRepository.save(existingTrainer);
        });
    }

    public boolean deleteTrainer(int id) {
        if (trainerRepository.existsById(id)) {
            trainerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
