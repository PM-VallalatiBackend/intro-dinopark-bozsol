package hu.progmasters.dinopark.domain;

import java.util.Objects;

public class Dinosaur {
    private Integer id;
    private String name;
    private String breed;
    private DinoType type;

    public Dinosaur() {
    }

    public Integer getId() {
        return id;
    }

    public Dinosaur setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dinosaur setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Dinosaur setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public DinoType getType() {
        return type;
    }

    public Dinosaur setType(DinoType type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dinosaur dinosaur = (Dinosaur) o;

        return Objects.equals(id, dinosaur.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
