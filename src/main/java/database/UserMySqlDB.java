package database;

import br.edu.fesa.teladelogin.Encriptador;
import database.dataModel.User;

import java.sql.*;
import java.util.ArrayList;

public class UserMySqlDB implements UserDB {
    public static Connection connection;

    static {
        try {
            connection = ConexaoMySql.getLoginDBInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Integer id, User user) {
        String sql = "insert into users values(?, ?, ?, ?, ?);";
        PreparedStatement preparedstatement = null;
        try {
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setInt(1, id);
            preparedstatement.setString(2, user.getFirstname());
            preparedstatement.setString(3, user.getLastname());
            preparedstatement.setString(4, user.getUsername());
            //encriptar senha
            preparedstatement.setString(5, Encriptador.encriptar(user.getPassword()));

            preparedstatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedstatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public User read(Integer id) {
        String sql = "select * from users where id = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return montarModel(resultSet);
    }

    private User montarModel(ResultSet rs) {
        User u = null; // colocar NullUser, NullObject
        try {
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String username = rs.getString(4);
            String password = rs.getString(5);

            u = new User(firstname, lastname, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }



    @Override
    public void update(Integer id, User user) {
        String sql = "UPDATE users SET firstname = ?, lastname = ?, username = ?, user_password = ? WHERE id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, Encriptador.encriptar(user.getPassword()));
            preparedStatement.setInt(5, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from users where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ArrayList<User> read() {
        ArrayList<User> lista = new ArrayList<>();

        String sql = "select * from users;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lista.add(montarModel(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public static Integer getValidId() {
        String sql = "SELECT MAX(id) FROM users;";
        Statement s = null;
        Integer validId = -1;
        ResultSet rs = null;
        try {
            s = connection.createStatement();
            rs = s.executeQuery(sql);
            rs.next();
            validId = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                rs.close();
                s.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ++validId;
    }
}
