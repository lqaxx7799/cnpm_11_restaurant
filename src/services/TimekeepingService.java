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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import models.Timekeeping;

/**
 *
 * @author Admin
 */
public class TimekeepingService {

    public ArrayList<Timekeeping> getAll() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "select * from timekeepings";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Timekeeping> list = new ArrayList<>();
            while (rs.next()) {
                Timekeeping timekeeping = new Timekeeping();
                timekeeping.setId(rs.getInt(1));
                timekeeping.setAccountId(rs.getInt(2));
                timekeeping.setInTime(rs.getDate(3));
                timekeeping.setOutTime(rs.getDate(4));
                list.add(timekeeping);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Timekeeping getById(int id) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select * from timekeepings where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Timekeeping timekeeping = new Timekeeping();
                timekeeping.setId(rs.getInt(1));
                timekeeping.setAccountId(rs.getInt(2));
                timekeeping.setInTime(rs.getDate(3));
                timekeeping.setOutTime(rs.getDate(4));
                stmt.close();
                connection.close();
                return timekeeping;
            }
            stmt.close();
            connection.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(Timekeeping timekeeping) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Connection connection = ConnectionFactory.getConnection();
            String query = "insert into timekeepings "
                    + "(account_id, in_time, out_time) "
                    + "values (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, timekeeping.getAccountId());
            stmt.setDate(2, java.sql.Date.valueOf(df.format(timekeeping.getInTime())));
            stmt.setDate(3, java.sql.Date.valueOf(df.format(timekeeping.getOutTime())));
            int rs = stmt.executeUpdate();
            stmt.close();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Timekeeping timekeeping) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Connection connection = ConnectionFactory.getConnection();
            String query = "update timekeepings set account_id = ?, in_time = ?, out_time = ? "
                    + " where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, timekeeping.getAccountId());
            stmt.setDate(2, java.sql.Date.valueOf(df.format(timekeeping.getInTime())));
            stmt.setDate(3, java.sql.Date.valueOf(df.format(timekeeping.getOutTime())));
            stmt.setInt(4, timekeeping.getId());
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
            String query = "delete from timekeepings where id = ?";
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
