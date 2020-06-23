/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.Color; 
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import models.BillList;
import models.MenuItem;
import models.Table;
import services.MenuCategoryService;
import services.MenuItemService;
import services.TableService;
import views.OrderView;
import services.ReceiptService;
import services.ReceiptDetailService;
import services.BillListService;


/**
 *
 * @author ASUS
 */
public class OrderController {
    private OrderView orderView;
    private TableService tableService;
    private MenuItemService menuItemService;
    private MenuCategoryService menuCategoryService;
    private ReceiptService receiptService;
    private ReceiptDetailService receiptDetailService;
    private BillListService billListService;
    
    public OrderController(){
        orderView = new OrderView();
        tableService = new TableService();
        GridLayout layout = new GridLayout(5,4);
        orderView.getjPanel3().setLayout(layout);
        ArrayList<Table> tableList = tableService.getAll();
        for(Table item:tableList){
            JButton btn = new JButton();
            btn.setText(item.getTableName());
            if(item.isOccupied()){
                btn.setBackground(Color.red);
            }
            btn.addActionListener(e -> showBill(item.getId()));
            orderView.getjPanel3().add(btn);
        }
        menuCategoryService = new MenuCategoryService();
        menuItemService = new MenuItemService();
        ArrayList<String> menuCategoryList = menuCategoryService.getNameAll();
        orderView.getCbMenuCategory().setModel(new DefaultComboBoxModel<String>(menuCategoryList.toArray(new String[0])));
        orderView.getCbMenuCategory().addActionListener(e -> showCbMenuItem());
        
        billListService = new BillListService();
        receiptService = new ReceiptService();
        receiptDetailService = new ReceiptDetailService();
        orderView.getBtnAdd().addActionListener(l -> getBtnAddHander());
        
    } 
    public OrderView initController(){
        return orderView;
    }
    
    private void showCbMenuItem(){
        int slected = orderView.getCbMenuCategory().getSelectedIndex()+ 1 ;
        ArrayList<String> menuItemList = menuItemService.getNameByCategoryId(slected);
        orderView.getCbMenuItem().setModel(new DefaultComboBoxModel<String>(menuItemList.toArray(new String[0])));
    }
    
    private void showBill(int tableId){
            ArrayList<BillList> billList = billListService.getByTableId(tableId);
            String col[] = {"Tên món","Số lượng","Đơn giá","Thành tiền"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            for(BillList item : billList){
                Object[] data = {item.getItem_name(),item.getQuantity(),item.getPrice(),item.getTotalPrice()};
                tableModel.addRow(data);
            }
            orderView.getjTable2().setModel(tableModel);
    }

    private void getBtnAddHander() {
        ArrayList<MenuItem> menuItemList = menuItemService.getAll();
        String slectedMenuItem = orderView.getCbMenuItem().getSelectedItem().toString();
        for(MenuItem item : menuItemList){
            if(item.getItemName().equals(slectedMenuItem)){
                double slectedMenuItemPrice = item.getPrice();
            }
        }
    }
 }
