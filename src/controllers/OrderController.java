package controllers;

import java.awt.Color; 
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import models.BillList;
import models.MenuItem;
import models.Receipt;
import models.ReceiptDetail;
import models.Table;
import services.MenuCategoryService;
import services.MenuItemService;
import services.TableService;
import views.OrderView;
import services.ReceiptService;
import services.ReceiptDetailService;
import services.BillListService;
import app.App;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JOptionPane;

public class OrderController {
    private OrderView orderView;
    private TableService tableService;
    private MenuItemService menuItemService;
    private MenuCategoryService menuCategoryService;
    private ReceiptService receiptService;
    private ReceiptDetailService receiptDetailService;
    private BillListService billListService;
    public int CurrentTableId;
    
    public OrderController(){
        orderView = new OrderView();
        loadTable();
        menuCategoryService = new MenuCategoryService();
        menuItemService = new MenuItemService();
        ArrayList<String> menuCategoryList = menuCategoryService.getNameAll();
        orderView.getCbMenuCategory().setModel(new DefaultComboBoxModel<String>(menuCategoryList.toArray(new String[0])));
        billListService = new BillListService();
        receiptService = new ReceiptService();
        receiptDetailService = new ReceiptDetailService();
        orderView.getCbMenuCategory().addActionListener(e -> showCbMenuItem());
        orderView.getBtnAdd().addActionListener(e -> BtnAddHandler());
        orderView.getBtnPay().addActionListener(e -> BtnPayHandlder());
    } 
    public OrderView initController(){
        return orderView;
    }
    
    private void showCbMenuItem(){
        int slected = orderView.getCbMenuCategory().getSelectedIndex() + 1 ;
        ArrayList<String> menuItemList = new ArrayList<>();
        ArrayList<MenuItem> menuItem = menuItemService.getAll();
        for(MenuItem item : menuItem){
            if(item.getMenuCategoryId() == slected){
                menuItemList.add(item.getItemName());
            }
        }
        orderView.getCbMenuItem().setModel(new DefaultComboBoxModel<String>(menuItemList.toArray(new String[0])));
    }
    
    private void showBill(int tableId){
            CurrentTableId = tableId;
            orderView.getLabelTableName().setText(tableService.getById(CurrentTableId).getTableName());
            DefaultTableModel tableModel= (DefaultTableModel)orderView.getjTable2().getModel();
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                tableModel.removeRow(i);
            }
            ArrayList<BillList> billList = billListService.getByTableId(CurrentTableId);
            for(BillList item : billList){
                Object[] data = {item.getItem_name(),item.getQuantity(),item.getPrice(),item.getTotalPrice()};
                tableModel.addRow(data);
            }
    }

    private void BtnAddHandler() {
        ArrayList<MenuItem> menuItemList = menuItemService.getAll();
        String slectedMenuItem = orderView.getCbMenuItem().getSelectedItem().toString();
        MenuItem menuItem = new MenuItem();
        for(MenuItem item : menuItemList){
            if(item.getItemName().equals(slectedMenuItem)){
                menuItem = item;
                break;
            }
        }
        if(billListService.checkExistBillByTableId(CurrentTableId)== false){
            Receipt rc = new Receipt();
            rc.setArrivedTime(new Date());
            rc.setPaidTime(null);
            rc.setPaid(false);
            rc.setTableId(CurrentTableId);
            rc.setAccountId(App.currentAccount.getId());
            receiptService.insert(rc);
            Table table = tableService.getById(CurrentTableId);
            table.setOccupied(true);
            tableService.update(table);
            loadTable();
        }
            int rc_id =0;
            ArrayList<Receipt> Receipts = receiptService.getAll();
            for(Receipt item : Receipts ){
                if(item.getTableId()==CurrentTableId){
                    rc_id = item.getId();
                    break;
                }
            }
            int menu_item_id = menuItem.getId();
            int quantity = Integer.parseInt(orderView.getTxtQuantity().getText());
            Double unit_price = menuItem.getPrice();
            boolean is_made = false;
            boolean is_served = false;
            ReceiptDetail receiptDetail = new ReceiptDetail();
            receiptDetail.setReceiptId(rc_id);
            receiptDetail.setMenuItemId(menu_item_id);
            receiptDetail.setQuantity(quantity);
            receiptDetail.setUnitPrice(unit_price);
            receiptDetail.setMade(is_made);
            receiptDetail.setServed(is_served);
            receiptDetailService.insert(receiptDetail);
            showBill(CurrentTableId);
    }
    
    private void BtnPayHandlder() {
        if(billListService.checkExistBillByTableId(CurrentTableId)== false){
            JOptionPane.showMessageDialog(null,"Bàn này hiện không có hóa đơn nào" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else{
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán " + tableService.getById(CurrentTableId).getTableName()
                ,"Xác nhận", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                int rc_id =0;
                ArrayList<Receipt> Receipts = receiptService.getAll();
                for(Receipt item : Receipts ){
                    if(item.getTableId()==CurrentTableId){
                        rc_id = item.getId();
                        break;
                    }
                }
            Receipt rc_temp = receiptService.getById(rc_id);
            rc_temp.setPaid(true);
            rc_temp.setPaidTime(new Date());
            receiptService.update(rc_temp);
            Table table = tableService.getById(CurrentTableId);
            table.setOccupied(false);
            tableService.update(table);
            showBill(CurrentTableId);
            loadTable();
            }
        }
    }
    
    private void loadTable(){
        orderView.getjPanel3().removeAll();
        tableService = new TableService();
        ArrayList<Table> tableList = tableService.getAll();
        int i = tableList.size();
        int h;
        if(i%4 == 0){h=i/4;}
        else{h=i/4 + 1; }
        orderView.getjPanel3().setPreferredSize(new Dimension(400,h*100));
        for(Table item : tableList){
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(86,100));
            btn.setText(item.getTableName());
            if(item.isOccupied()){
                btn.setBackground(Color.red);
            }
            btn.addActionListener(e -> showBill(item.getId()));
            orderView.getjPanel3().add(btn);
        }
    }
 }
