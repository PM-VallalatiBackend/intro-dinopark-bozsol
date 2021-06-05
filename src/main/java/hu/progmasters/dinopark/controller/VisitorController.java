package hu.progmasters.dinopark.controller;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.dto.VisitorCreateCommand;
import hu.progmasters.dinopark.dto.VisitorInfo;
import hu.progmasters.dinopark.service.ParkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    private final ParkService parkService;

    public VisitorController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping
    public ResponseEntity<List<VisitorInfo>> findAll() {
        return new ResponseEntity<>(parkService.findAllVisitors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitorInfo> saveVisitor(@RequestBody VisitorCreateCommand command) {
        if (!DinoType.getPossibleDinoTypes().contains(command.getPreference())) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(parkService.saveVisitor(command), HttpStatus.CREATED);
    }
}
