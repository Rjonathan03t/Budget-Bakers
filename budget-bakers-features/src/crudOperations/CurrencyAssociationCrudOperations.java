package crudOperations;

import genericInterface.CrudOperations;
import model.CurrencyAssociation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyAssociationCrudOperations implements CrudOperations<CurrencyAssociation> {
    private Connection connection;

    public CurrencyAssociationCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CurrencyAssociation> findAll() throws SQLException {
        List<CurrencyAssociation> allAssociations = new ArrayList<>();
        String sql = "SELECT * FROM currency_association";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                allAssociations.add(new CurrencyAssociation(
                        result.getInt("id_association"),
                        result.getInt("id_account"),
                        result.getInt("id_currency")
                    )
                );
            }
        }
        System.out.println(allAssociations);
        return allAssociations;
    }

    @Override
    public List<CurrencyAssociation> saveAll(List<CurrencyAssociation> toSave) throws SQLException {
        List<CurrencyAssociation> allAssociations = new ArrayList<>();
        String sql = "INSERT INTO currency_association (id_association, id_account, id_currency) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            for (CurrencyAssociation association : toSave) {
                preparedStatement.setInt(1, association.getId_association());
                preparedStatement.setInt(2, association.getId_account());
                preparedStatement.setInt(3, association.getId_currency());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("INSERT currency associations");
        return allAssociations;
    }

    @Override
    public CurrencyAssociation save(CurrencyAssociation toSave) throws SQLException {
       
        throw new UnsupportedOperationException("Save individual not supported for CurrencyAssociation");
    }

    @Override
    public CurrencyAssociation delete(CurrencyAssociation toDelete) throws SQLException {
        String sql = "DELETE FROM currency_association WHERE id_association = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setInt(1, toDelete.getId_association());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DELETE currency association");
        return toDelete;
    }
}
