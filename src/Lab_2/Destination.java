package Lab_2;

public class Destination {
    private String name;

    public Destination() {
    }

    public Destination(String name) {
        this.setName(name);
    }

    // Getter + setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
