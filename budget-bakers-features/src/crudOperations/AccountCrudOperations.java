package crudOperations;

import genericInterface.CrudOperations;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountCrudOperations  implements CrudOperations <Account> {
    private Connection connection;

    public AccountCrudOperations (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> allAccount = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                allAccount.add(new Account(
                        result.getInt("id_account"),
                        result.getString("username"),
                        result.getInt("number"),
                        result.getInt("balance"),
                        result.getString("status")
                        )
                );
            }
        }
        System.out.println(allAccount);
        return allAccount;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) throws SQLException {
        return null;
    }

    @Override
    public Account save(Account toSave) throws SQLException {
        return null;
    }

    @Override
    public Account delete(Account toDelete) throws SQLException {
        return null;
    }
}
