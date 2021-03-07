package Lab_2;

public abstract class Source {
    private String name;

    public Source() {
    }

    public Source(String name) {
        this.name = name;
    }

    // Getters + setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)) {
            return false;
        }
        Source other = (Source) obj;
        return name.equals(other.name);
    }


    @Override
    public String toString() {
        return
                "name=" + name;
    }


}
