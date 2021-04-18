package Lab_8;
import Lab_8.DAO.MovieController;
import Lab_8.Entities.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        Connection con = Database.getConnection();
        MovieController movies = new MovieController();

        List<Movie> movieList = movies.findAll();

        for(Movie movie : movieList)
            System.out.println(movie.toString());


        List<String> movieById = movies.findByID(1);

        System.out.println(movieById.toString());

        movies.create("Fight Club ", "1999-10-14", "02:30:00",(float)8.8);

        Database.closeConnection();
    }
}
