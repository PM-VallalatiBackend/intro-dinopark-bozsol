package hu.progmasters.dinopark.controller;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.dto.DinoCreateCommand;
import hu.progmasters.dinopark.dto.DinoInfo;
import hu.progmasters.dinopark.service.DinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dino")
public class DinoController {

    private final DinoService dinoService;

    public DinoController(DinoService dinoService) {
        this.dinoService = dinoService;
    }

    @GetMapping
    public ResponseEntity<List<DinoInfo>> findAll() {
        return new ResponseEntity<>(dinoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DinoInfo> findById(@PathVariable Integer id) {
        DinoInfo dinoInfo = dinoService.findById(id);
        return dinoInfo == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(dinoInfo, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DinoInfo>> findByType(@PathVariable String type) {
        if (!DinoType.getPossibleDinoTypes().contains(type)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        List<DinoInfo> dinoInfoList = dinoService.findByType(type.toUpperCase());

        return dinoInfoList.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(dinoInfoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DinoInfo> saveDinosaur(@RequestBody DinoCreateCommand command) {
        if (!DinoType.getPossibleDinoTypes().contains(command.getType())) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(dinoService.saveDinosaur(command), HttpStatus.CREATED);
    }
}
