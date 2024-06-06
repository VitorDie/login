package br.edu.fesa.teladelogin.funcionarioData;

import br.edu.fesa.teladelogin.Encriptador;
import database.ConexaoMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static database.UserMySqlDB.connection;

public class FuncionarioDTO {
    private static Connection connection;

    static {
        try {
            connection = ConexaoMySql.getAgendaDBInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private FuncionarioModel montarModel(ResultSet rs) {
        FuncionarioModel u = null;

        try {
            Integer id = rs.getInt(1);
            String nome = rs.getString(2);

            u = new FuncionarioModel(id, nome);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;
    }

    public ArrayList<FuncionarioModel> read() {
        ArrayList<FuncionarioModel> lista = new ArrayList<>();

        String sql = "select * from profissionais;";
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

    public void create(Integer id, String nome) {
        String sql = "insert into profissionais values (?, ?);";
        PreparedStatement preparedstatement = null;
        try {
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setInt(1, id);
            preparedstatement.setString(2, nome);

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

    public void delete(int id) {
        String sql = "delete from profissionais where ID_prof = ?;";
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

    public void update(Integer id, String nome) {
        String sql = "update profissionais set nome_prof = ? where ID_prof = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, id);

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
}
