package hu.progmasters.dinopark.service;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;
import hu.progmasters.dinopark.dto.DinoCreateCommand;
import hu.progmasters.dinopark.dto.DinoInfo;
import hu.progmasters.dinopark.repository.DinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DinoService {
    private final DinoRepository dinoRepository;

    public DinoService(DinoRepository dinoRepository) {
        this.dinoRepository = dinoRepository;
    }

    public List<DinoInfo> findAll() {
        return dinoRepository.findAll().stream()
                .map(this::convertToDinoInfo)
                .collect(Collectors.toList());
    }

    public DinoInfo findById(Integer id) {
        Dinosaur dinosaur = dinoRepository.findById(id);
        return dinosaur == null ? null : convertToDinoInfo(dinosaur);
    }

    public List<DinoInfo> findByType(String type) {
        return dinoRepository.findByType(DinoType.valueOf(type)).stream()
                .map(this::convertToDinoInfo)
                .collect(Collectors.toList());
    }

    public DinoInfo saveDinosaur(DinoCreateCommand command) {
        return convertToDinoInfo(dinoRepository.saveDinosaur(convertToDinosaur(command)));
    }


    private DinoInfo convertToDinoInfo(Dinosaur dinosaur) {
        return new DinoInfo()
                .setId(dinosaur.getId())
                .setName(dinosaur.getName())
                .setBreed(dinosaur.getBreed())
                .setType(dinosaur.getType().name().toLowerCase());
    }

    private Dinosaur convertToDinosaur(DinoCreateCommand command) {
        return new Dinosaur()
                .setName(command.getName())
                .setBreed(command.getBreed())
                .setType(DinoType.valueOf(command.getType().toUpperCase()));
    }
}
