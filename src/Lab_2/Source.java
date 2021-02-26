package Lab_2;

public class Source {
    private String name;
    private SourceType type;

    public Source() {
    }

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    // Getters + setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "name=" + name +
                        ", type=" + type;
    }
}
