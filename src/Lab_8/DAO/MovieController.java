package Lab_8.DAO;


import Lab_8.Database;
import Lab_8.Entities.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MovieController {
    public List<Movie> findAll() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet res = statement.executeQuery("select * from movies")) {
                List<Movie> listOfMovies = new ArrayList<Movie>();
                while (res.next()) {
                    listOfMovies.add(new Movie(res.getInt(1), res.getString(2),
                            res.getString(3), res.getString(4), res.getFloat(5)));
                }
                return listOfMovies;
        }
    }

    public List<String> findByID(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet res = statement.executeQuery("select id, title, release_date, duration, score" +
                     " from movies where id = '" + id + "'")) {
                List<String> row = new ArrayList<String>();

            while (res.next()) {
                row.add(res.getString("id"));
                row.add(res.getString("title"));
                row.add(res.getString("release_date"));
                row.add(res.getString("duration"));
                row.add(res.getString("score"));
            }
            return row;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void create(String title, String release_date, String duration, float score) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("insert into movies " +
                "(id, title, release_date, duration, score) values (?,?,?,?,?)")) {
            try (Statement stmt = con.createStatement()) {
                ResultSet res = stmt.executeQuery("select max(id) from movies");
                Integer result= res.next() ? res.getInt(1) : null;
                preparedStatement.setInt(1 ,result+1);
            }
            preparedStatement.setString(2 , title);
            preparedStatement.setString(3, release_date);
            preparedStatement.setString(4, duration);
            preparedStatement.setFloat(5, score);
            preparedStatement.executeUpdate();
        }
    }
}
