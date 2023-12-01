package Main;

import crudOperations.AccountCrudOperations;
import model.Account;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = System.getenv("url");
        String user = System.getenv("user");
        String password = System.getenv("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            AccountCrudOperations accountCrudOperations = new AccountCrudOperations(connection);
            //====FIND ALL
            accountCrudOperations.findAll();

            //====SAVE ALL
            List<Account> accountToSave = new ArrayList<>();
            Account account1 = new Account(6,"Mina",0006,90000,"active");
            Account account2 = new Account(7,"Crom",0007,40000,"active");
            accountToSave.add(account1);
            accountToSave.add(account2);
            //accountCrudOperations.saveAll(accountToSave);

            //====SAVE
            Account account = new Account(8,"Ilay",8,100000,"active");
            //accountCrudOperations.save(account);



            //====DELETE
            //accountCrudOperations.delete(account1);
            //accountCrudOperations.delete(account2);

        } catch (Exception e) {
            System.out.println("Error about DB connection!");
            e.printStackTrace();
        }

    }
}