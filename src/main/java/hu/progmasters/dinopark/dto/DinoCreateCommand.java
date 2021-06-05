package hu.progmasters.dinopark.dto;

public class DinoCreateCommand {
    private String name;
    private String breed;
    private String type;

    public DinoCreateCommand() {
    }

    public String getName() {
        return name;
    }

    public DinoCreateCommand setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DinoCreateCommand setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getType() {
        return type;
    }

    public DinoCreateCommand setType(String type) {
        this.type = type;
        return this;
    }
}
