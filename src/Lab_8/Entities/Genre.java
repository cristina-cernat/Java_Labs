package Lab_8.Entities;

public class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{id=").append(id).append(", name=").append(name).append("}\n");
        return str.toString();
    }
}
