package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DinoRepositoryInMemory implements DinoRepository {
    private final Map<Integer, Dinosaur> dinosaurs = new HashMap<>();
    private int lastIndexUsed = 0;

    @Override
    public List<Dinosaur> findAll() {
        return dinosaurs.values().stream()
                .sorted(Comparator.comparing(Dinosaur::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Dinosaur findById(Integer id) {
        return dinosaurs.get(id);
    }

    @Override
    public List<Dinosaur> findByType(DinoType dinoType) {
        return dinosaurs.values().stream()
                .filter(dinosaur -> dinosaur.getType().equals(dinoType))
                .sorted(Comparator.comparing(Dinosaur::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Dinosaur saveDinosaur(Dinosaur dinosaur) {
        dinosaurs.put(++lastIndexUsed, dinosaur);
        dinosaur.setId(lastIndexUsed);
        return dinosaur;
    }

}
