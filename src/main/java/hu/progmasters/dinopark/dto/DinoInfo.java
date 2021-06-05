package hu.progmasters.dinopark.dto;

public class DinoInfo {
    private Integer id;
    private String name;
    private String breed;
    private String type;

    public DinoInfo() {

    }

    public Integer getId() {
        return id;
    }

    public DinoInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DinoInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DinoInfo setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getType() {
        return type;
    }

    public DinoInfo setType(String type) {
        this.type = type;
        return this;
    }
}
