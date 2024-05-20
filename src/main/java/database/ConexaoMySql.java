package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
    private ConexaoMySql() {
    }

    private static Connection instance = null;


    private static Connection getConnection(String dbUrl, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, user, password);
        connection.setAutoCommit(true);
        return connection;
    }

    public static Connection getInstance() throws SQLException {
        /*
        String dbUrl = "jdbc:mysql://localhost:3306/LoginDB";
        String user = "vitordie";
        String password = "Lp53688!";

         */

        String dbUrl = "jdbc:mysql://salao.mysql.database.azure.com:3306/LoginDB";
        String user = "salao_db";
        String password = "Fesa@123";

        if (instance == null)
        {
            instance = getConnection(dbUrl, user, password);
        }

        return instance;
    }
}
