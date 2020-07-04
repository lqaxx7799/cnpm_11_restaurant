/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Timestamp;
import models.Customer;

/**
 *
 * @author Admin
 */
public class CustomerService {

    public ArrayList<Customer> getAll() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "select * from customers";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                customer.setCreatedTime(rs.getTimestamp(3));
                customer.setCollectedPoint(rs.getInt(4));
                customer.setEmail(rs.getString(5));
                customer.setEmployeeId(rs.getInt(6));
                customer.setCustomerType(rs.getString(7));
                list.add(customer);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Customer getById(int id) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select * from customers where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                customer.setCreatedTime(rs.getTimestamp(3));
                customer.setCollectedPoint(rs.getInt(4));
                customer.setEmail(rs.getString(5));
                customer.setEmployeeId(rs.getInt(6));
                customer.setCustomerType(rs.getString(7));
                stmt.close();
                connection.close();
                return customer;
            }
            stmt.close();
            connection.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(Customer customer) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "insert into customers "
                    + "(customer_name, created_time, collected_point, email, employee_id, customer_type) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            Timestamp createdTime = customer.getCreatedTime() == null ? null : new Timestamp(customer.getCreatedTime().getTime());

            stmt.setString(1, customer.getCustomerName());
            stmt.setTimestamp(2, createdTime);
            stmt.setInt(3, customer.getCollectedPoint());
            stmt.setString(4, customer.getEmail());
            stmt.setInt(5, customer.getEmployeeId());
            stmt.setString(6, customer.getCustomerType());

            int rs = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Customer customer) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "update customers set customer_name = ?, created_time = ?, collected_point = ?, "
                    + " email = ?, employee_id = ?, customer_type = ? "
                    + " where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            Timestamp createdTime = customer.getCreatedTime() == null ? null : new Timestamp(customer.getCreatedTime().getTime());
            
            stmt.setString(1, customer.getCustomerName());
            stmt.setTimestamp(2, createdTime);
            stmt.setInt(3, customer.getCollectedPoint());
            stmt.setString(4, customer.getEmail());
            stmt.setInt(5, customer.getEmployeeId());
            stmt.setString(6, customer.getCustomerType());
            stmt.setInt(7, customer.getId());
            int rs = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "delete from customers where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
