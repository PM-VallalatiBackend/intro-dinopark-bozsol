package hu.progmasters.dinopark.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DinoType {
    HERBIVORE, CARNIVORE;

    public static List<String> getPossibleDinoTypes() {
        return Arrays.stream(DinoType.values())
                .map(type -> type.toString().toLowerCase())
                .collect(Collectors.toList());
    }
}
