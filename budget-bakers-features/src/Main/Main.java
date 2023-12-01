package Main;

import crudOperations.AccountCrudOperations;
import model.Account;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = System.getenv("url");
        String user = System.getenv("user");
        String password = System.getenv("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            AccountCrudOperations accountCrudOperations = new AccountCrudOperations(connection);
            accountCrudOperations.findAll();

        } catch (Exception e) {
            System.out.println("Error about DB connection!");
            e.printStackTrace();
        }

    }
}