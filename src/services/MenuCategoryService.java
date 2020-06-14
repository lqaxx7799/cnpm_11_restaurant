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
import models.MenuCategory;

/**
 *
 * @author Admin
 */
public class MenuCategoryService {

    public ArrayList<MenuCategory> getAll() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "select * from menu_categories";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<MenuCategory> list = new ArrayList<>();
            while (rs.next()) {
                MenuCategory menuCategory = new MenuCategory();
                menuCategory.setId(rs.getInt(1));
                menuCategory.setCategoryName(rs.getString(2));
                menuCategory.setAvailable(rs.getBoolean(3));
                menuCategory.setCreatedTime(rs.getDate(4));
                list.add(menuCategory);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public MenuCategory getById(int id) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select * from menu_categories where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                MenuCategory menuCategory = new MenuCategory();
                menuCategory.setId(rs.getInt(1));
                menuCategory.setCategoryName(rs.getString(2));
                menuCategory.setAvailable(rs.getBoolean(3));
                menuCategory.setCreatedTime(rs.getDate(4));
                stmt.close();
                connection.close();
                return menuCategory;
            }
            stmt.close();
            connection.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(MenuCategory menuCategory) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "insert into menu_categories "
                    + "(category_name, is_available, created_time) "
                    + "values (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            Date createdTime = menuCategory.getCreatedTime() == null ? null : new Date(menuCategory.getCreatedTime().getTime());
            stmt.setString(1, menuCategory.getCategoryName());
            stmt.setBoolean(2, menuCategory.isAvailable());
            stmt.setDate(3, createdTime);
            int rs = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(MenuCategory menuCategory) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "update menu_categories set category_name = ?, is_available = ?, created_time = ? "
                    + "where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            Date createdTime = menuCategory.getCreatedTime() == null ? null : new Date(menuCategory.getCreatedTime().getTime());

            stmt.setString(1, menuCategory.getCategoryName());
            stmt.setBoolean(2, menuCategory.isAvailable());
            stmt.setDate(3, createdTime);
            stmt.setInt(4, menuCategory.getId());
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
            String query = "delete from menu_categories where id = ?";
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
