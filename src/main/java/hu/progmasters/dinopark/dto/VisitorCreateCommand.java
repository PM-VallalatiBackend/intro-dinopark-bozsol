package hu.progmasters.dinopark.dto;

public class VisitorCreateCommand {
    private String name;
    private String preference;

    public VisitorCreateCommand() {
    }

    public String getName() {
        return name;
    }

    public VisitorCreateCommand setName(String name) {
        this.name = name;
        return this;
    }

    public String getPreference() {
        return preference;
    }

    public VisitorCreateCommand setPreference(String preference) {
        this.preference = preference;
        return this;
    }
}
