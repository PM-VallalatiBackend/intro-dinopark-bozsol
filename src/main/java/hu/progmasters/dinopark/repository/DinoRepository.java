package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;

import java.util.List;

public interface DinoRepository {

    List<Dinosaur> findAll();

    Dinosaur findById(Integer id);

    List<Dinosaur> findByType(DinoType dinoType);

    Dinosaur saveDinosaur(Dinosaur dinosaur);
}
