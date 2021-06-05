package hu.progmasters.dinopark.service;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;
import hu.progmasters.dinopark.domain.Visitor;
import hu.progmasters.dinopark.dto.VisitorCreateCommand;
import hu.progmasters.dinopark.dto.VisitorInfo;
import hu.progmasters.dinopark.repository.DinoRepository;
import hu.progmasters.dinopark.repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkService {
    private final DinoRepository dinoRepository;
    private final VisitorRepository visitorRepository;

    public ParkService(DinoRepository dinoRepository, VisitorRepository visitorRepository) {
        this.dinoRepository = dinoRepository;
        this.visitorRepository = visitorRepository;
    }

    public List<VisitorInfo> findAllVisitors() {
        return visitorRepository.findAll().stream()
                .map(this::convertToVisitorInfo)
                .collect(Collectors.toList());
    }

    public VisitorInfo saveVisitor(VisitorCreateCommand command) {
        Visitor visitor = new Visitor()
                .setName(command.getName())
                .setPreference(DinoType.valueOf(command.getPreference().toUpperCase()));

        visitor.setRating(calculateRating(visitor.getPreference()));

        return convertToVisitorInfo(visitorRepository.saveVisitor(visitor));
    }

    public Integer getParkAverageRating() {
        return (int) (visitorRepository.findAll().stream()
                .mapToInt(Visitor::getRating)
                .average()
                .orElse(0.0)
        );
    }


    private VisitorInfo convertToVisitorInfo(Visitor visitor) {
        return new VisitorInfo()
                .setName(visitor.getName())
                .setRating(visitor.getRating());
    }

    private int calculateRating(DinoType dinoType) {
        List<Dinosaur> allDinos = dinoRepository.findAll();

        if (allDinos.size() < 3) {
            return 1;
        }

        return (int) (allDinos.stream()
                .mapToInt(dino -> dino.getType().equals(dinoType) ? 5 : 2)
                .average()
                .orElse(0.0)
        );
    }
}
