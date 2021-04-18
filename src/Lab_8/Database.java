package Lab_8;
import java.sql.*;
import java.util.TimeZone;

public class Database {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/my_movies?useSSL=false&serverTimezone=" +
            TimeZone.getDefault().getID();
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private Database() throws SQLException {
    }

    public static Connection getConnection()
    {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }


    public static void createConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() throws SQLException{
        try{connection.close(); }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
