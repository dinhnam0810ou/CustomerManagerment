package com.ndn.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ndn.model.Customer;







public class CustomerDAO {
    public void addCustomer(Customer customer) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            
            connection.setAutoCommit(false);    
            preparedStatement = connection.prepareStatement(
                                    "insert into customer values (?, ?, ? , ? ,? , ?)");
            
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getGender());
            preparedStatement.setString(3, customer.getPhone_number());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setInt(6, 0);
            
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    
    private void closeQuietly(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    
}
