package database;

import database.dataModel.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class UserMySqlDB implements UserDB {
    private static Connection connection;

    static {
        try {
            connection = ConexaoMySql.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    String dbUrl = "jdbc:mysql://localhost:3306/LoginDB";
    String user = "vitordie";
    String password = "Lp53688!";

    @Override
    public void create(Integer id, User user) {
        String sql = "insert into users values(?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setInt(1, id);
            preparedstatement.setString(2, user.getFirstname());
            preparedstatement.setString(3, user.getLastname());
            preparedstatement.setString(4, user.getUsername());
            preparedstatement.setString(5, user.getPassword());

            preparedstatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User read(Integer id) {
        return null;
    }

    @Override
    public void update(Integer id, User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ArrayList<User> read() {
        return null;
    }

    public static Integer getValidId() {
        String sql = "SELECT MAX(id) FROM users;";
        Statement s = null;
        Integer validId = -1;
        try {
            s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            validId = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                s.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ++validId;
    }
}
