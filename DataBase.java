package db.connect;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class DataBase {
    private Connection connection = null;
    private Statement statement;
    private ResultSet rs;

    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E://Stuff/Work & Stuff/AB InBev - Test/SQLi-Test/myDataBase.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeUpdate(String s) {

        try {
            statement.executeUpdate(s);
            /*
             * statement.executeUpdate("drop table if exists person"); statement
             * .executeUpdate("create table person (id integer, name string)");
             * statement.executeUpdate("insert into person values(1, 'leo')");
             * statement.executeUpdate("insert into person values(2, 'yui')");
             */
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public ResultSet select(String s) {
        try {
            rs = statement.executeQuery(s);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

    public ResultSet select(PreparedStatement s) {
        try {
            rs = s.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

    public ResultSet StatementExec(String s, String[] values) {
        try {
            PreparedStatement state = connection.prepareStatement(s);
            for (int i = 0; i < values.length; ++i){
                state.setString(i+1, values[i]);
            }
            rs = state.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }


    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
