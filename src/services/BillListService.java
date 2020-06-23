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
import models.BillList;
public class BillListService {
    public ArrayList<BillList> getByTableId(int tableId){
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select menu_items.item_name,receipt_details.quantity, menu_items.price, menu_items.price * receipt_details.quantity as totalPrice " +
                           "from menu_items , receipt_details , receipts  where " +
                           "receipt_details.receipt_id = receipts.id and receipt_details.menu_item_id = menu_items.id and receipts.is_paid = 0 and receipts.table_id = ? ";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,tableId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BillList> list = new ArrayList<>();
            while (rs.next()) {
                BillList billList = new BillList();
                billList.setItem_name(rs.getString(1));
                billList.setQuantity(rs.getInt(2));
                billList.setPrice(rs.getDouble(3));
                billList.setTotalPrice(rs.getDouble(4));
                list.add(billList);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public boolean checkExistBillByTableId(int tableId){
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select * from ";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,tableId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BillList> list = new ArrayList<>();
            while (rs.next()) {
                BillList billList = new BillList();
                billList.setItem_name(rs.getString(1));
                billList.setQuantity(rs.getInt(2));
                billList.setPrice(rs.getDouble(3));
                billList.setTotalPrice(rs.getDouble(4));
                list.add(billList);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
