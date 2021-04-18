package Lab_8.Entities;


public class Movie {
    private int id;
    private String title;
    private String release_date;
    private String duration;
    private float score;


    public Movie(int id, String title, String release_date, String duration, float score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{id=").append(id).append(", title=").append(title).append(", release date=").append(release_date).
                append(", duration=").append(duration).append(", score=").append(score).append("}\n");
        return str.toString();
    }
}
