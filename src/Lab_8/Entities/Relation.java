package Lab_8.Entities;

public class Relation {
    private int id_movie;
    private int id_genre;


    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{id_movie=").append(id_movie).append(", id_genre=").append(id_genre).append("}\n");
        return str.toString();
    }
}
