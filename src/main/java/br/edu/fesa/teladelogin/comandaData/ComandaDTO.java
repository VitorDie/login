package br.edu.fesa.teladelogin.comandaData;

import br.edu.fesa.teladelogin.funcionarioData.FuncionarioModel;
import database.ConexaoMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ComandaDTO {
    private static Connection connection;

    static {
        try {
            connection = ConexaoMySql.getAgendaDBInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ComandaModel montarModel(ResultSet rs) {
        ComandaModel c = null;

        try {
            Integer id = rs.getInt(1);
            LocalDateTime data_comanda = rs.getTimestamp(2).toLocalDateTime();
            String cliente = rs.getString(3);
            String profissional = rs.getString(4);
            String servico = rs.getString(5);
            String pagamento = rs.getString(6);
            Double valor = rs.getDouble(7);

            c = new ComandaModel(id, data_comanda, cliente, profissional, servico, pagamento, valor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }

    public ArrayList<ComandaModel> read() {
        ArrayList<ComandaModel> lista = new ArrayList<>();

        String sql = "select * from comandas_provisorio;";
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

    public void create(Integer id, LocalDateTime data_comanda, String cliente, String profissional, String servico, String pagamento, Double valor){
        String sql = "INSERT INTO comandas_provisorio (id, data_comanda, cliente, profissional, servico, pagamento, valor) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedstatement = null;

        try {
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setInt(1, id);
            preparedstatement.setString(2, data_comanda.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            preparedstatement.setString(3, cliente);
            preparedstatement.setString(4, profissional);
            preparedstatement.setString(5, servico);
            preparedstatement.setString(6, pagamento);
            preparedstatement.setDouble(7, valor);

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

    public void delete(Integer id) {
        String sql = "delete from comandas_provisorio where id = ?;";
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

    public void update(Integer id, LocalDateTime data_comanda, String cliente, String profissional, String servico, String pagamento, Double valor) {
        String sql = "update comandas_provisorio set data_comanda = ?, cliente = ?, profissional = ?, servico = ?, pagamento = ?, valor = ? where id = ?;";

        PreparedStatement preparedstatement = null;

        try {
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setString(1, data_comanda.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            preparedstatement.setString(2, cliente);
            preparedstatement.setString(3, profissional);
            preparedstatement.setString(4, servico);
            preparedstatement.setString(5, pagamento);
            preparedstatement.setDouble(6, valor);
            preparedstatement.setInt(7, id);

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

}
