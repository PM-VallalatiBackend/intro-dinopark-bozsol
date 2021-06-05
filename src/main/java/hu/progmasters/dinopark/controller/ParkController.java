package hu.progmasters.dinopark.controller;

import hu.progmasters.dinopark.service.ParkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/park")
public class ParkController {

    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping("/averageRating")
    public ResponseEntity<Integer> getAverageRating() {
        return new ResponseEntity<>(parkService.getParkAverageRating(), HttpStatus.OK);
    }
}
