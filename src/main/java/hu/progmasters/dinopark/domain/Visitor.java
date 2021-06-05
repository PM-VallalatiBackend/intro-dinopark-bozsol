package hu.progmasters.dinopark.domain;

import java.util.Objects;

public class Visitor {
    private Integer id;
    private String name;
    private DinoType preference;
    private Integer rating;

    public Visitor() {
    }

    public Integer getId() {
        return id;
    }

    public Visitor setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Visitor setName(String name) {
        this.name = name;
        return this;
    }

    public DinoType getPreference() {
        return preference;
    }

    public Visitor setPreference(DinoType preference) {
        this.preference = preference;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Visitor setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        return Objects.equals(id, visitor.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
