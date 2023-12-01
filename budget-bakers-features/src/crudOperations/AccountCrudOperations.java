package crudOperations;

import genericInterface.CrudOperations;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountCrudOperations implements CrudOperations<Account> {
    private Connection connection;

    public AccountCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> allAccount = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
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
        List<Account> allAccount = new ArrayList<>();
        String sql = "INSERT INTO account (id_account, username, number, balance, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            for (Account account : toSave) {
                preparedStatement.setInt(1, account.getId_account());
                preparedStatement.setString(2, account.getUsername());
                preparedStatement.setInt(3, account.getNumber());
                preparedStatement.setInt(4, account.getBalance());
                preparedStatement.setString(5, account.getStatus());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("INSERT 01");
        return allAccount;
    }

    @Override
    public Account save(Account toSave) throws SQLException {
        String sql = "INSERT INTO account (id_account, username, number, balance, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setInt(1, toSave.getId_account());
            preparedStatement.setString(2, toSave.getUsername());
            preparedStatement.setInt(3, toSave.getNumber());
            preparedStatement.setInt(4, toSave.getBalance());
            preparedStatement.setString(5, toSave.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("INSERT 01");
        return toSave;
    }

    @Override
    public Account delete(Account toDelete) throws SQLException {
        String sql = "DELETE FROM account WHERE id_account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try{
            preparedStatement.setInt(1, toDelete.getId_account());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("DELETE 01");
        return toDelete;
    }
}
