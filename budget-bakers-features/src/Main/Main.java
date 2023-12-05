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

            // Currency CRUD
            CurrencyCrudOperations currencyCrudOperations = new CurrencyCrudOperations(connection);
            //====FIND ALL
            currencyCrudOperations.findAll();

            //====SAVE
            Currency currency = new Currency(1, "USD", "US Dollar");
            currencyCrudOperations.save(currency);

            //====DELETE
            currencyCrudOperations.delete(currency);

             // Operations on currency associations
            CurrencyAssociationCrudOperations associationCrudOperations = new CurrencyAssociationCrudOperations(connection);

            // ==== FIND ALL CURRENCY ASSOCIATIONS
            associationCrudOperations.findAll();

            // ==== SAVE CURRENCY ASSOCIATIONS
            List<CurrencyAssociation> associationsToSave = new ArrayList<>();
            CurrencyAssociation association1 = new CurrencyAssociation(1, 1, 6);  // Currency 1 is associated with Account 6
            CurrencyAssociation association2 = new CurrencyAssociation(2, 2, 7);  // Currency 2 is associated with Account 7
            associationsToSave.add(association1);
            associationsToSave.add(association2);
            // associationCrudOperations.saveAll(associationsToSave);

            // ==== DELETE CURRENCY ASSOCIATION
            // associationCrudOperations.delete(association1);
            // associationCrudOperations.delete(association2);

        } catch (Exception e) {
            System.out.println("Error about DB connection!");
            e.printStackTrace();
        }

    }
}