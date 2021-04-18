package Lab_8.DAO;

import Lab_8.Database;
import Lab_8.Entities.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreController {
    public List<Genre> findAll() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet res = statement.executeQuery("select * from genres")) {
            List<Genre> listOfGenres = new ArrayList<Genre>();
            while (res.next()) {
                listOfGenres.add(new Genre(res.getInt(1), res.getString(2)));
            }
            return listOfGenres;
        }
    }

    public List<String> findByID(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet res = statement.executeQuery("select id, name from genres where id = '" + id + "'")) {
            List<String> row = new ArrayList<String>();

            while (res.next()) {
                row.add(res.getString("id"));
                row.add(res.getString("name"));

            }
            return row;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("insert into genres (id, name) values (?,?)")) {
            try (Statement stmt = con.createStatement()) {
                ResultSet res = stmt.executeQuery("select max(id) from genres");
                Integer result= res.next() ? res.getInt(1) : null;
                preparedStatement.setInt(1 ,result+1);
            }
            preparedStatement.setString(2 , name);

            preparedStatement.executeUpdate();
        }
    }
}
