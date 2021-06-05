package hu.progmasters.dinopark.dto;

public class VisitorInfo {
    private String name;
    private Integer rating;

    public VisitorInfo() {
    }

    public String getName() {
        return name;
    }

    public VisitorInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public VisitorInfo setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
