package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
    private ConexaoMySql() {
    }

    private static Connection loginDBInstance = null;

    private static Connection agendaDBInstance = null;

    private static Connection getConnection(String dbUrl, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, user, password);
        connection.setAutoCommit(true);
        return connection;
    }

    public static Connection getLoginDBInstance() throws SQLException {
        String dbUrl = "jdbc:mysql://salao.mysql.database.azure.com:3306/LoginDB";
        String user = "salao_db";
        String password = "Fesa@123";

        if (loginDBInstance == null)
        {
            loginDBInstance = getConnection(dbUrl, user, password);
        }

        return loginDBInstance;
    }

    public static Connection getAgendaDBInstance() throws SQLException {
        String dbUrl = "jdbc:mysql://salao.mysql.database.azure.com:3306/SalaoDB";
        String user = "salao_db";
        String password = "Fesa@123";

        if (agendaDBInstance == null)
        {
            agendaDBInstance = getConnection(dbUrl, user, password);
        }
        return agendaDBInstance;
    }
}
