/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import views.IngredientImportView;
import models.Ingredient;
import models.IngredientImport;
import services.IngredientImportService;
import services.IngredientService;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class IngredientImportController {

    private IngredientImportView ingredientImportView;
    private IngredientService ingredientService;
    private IngredientImportService ingredientImportService;
    private JList<String> IngredientList;

    public IngredientImportController() {
        ingredientImportView = new IngredientImportView();
        ingredientService = new IngredientService();
        ingredientImportService = new IngredientImportService();

        ArrayList<Ingredient> ingredientList = ingredientService.getAll();
        ArrayList<String> ingredientName = new ArrayList<>();
        for (Ingredient item : ingredientList) {
            ingredientName.add(item.getIngredientName());
        }
        ingredientImportView.getCbIngredientList().setModel(new DefaultComboBoxModel<String>(ingredientName.toArray(new String[0])));
        
        ingredientImportView.getLblUnit().setText(ingredientList.get(0).getUnit());
        ingredientImportView.getCbIngredientList().addActionListener(al -> onIngredientChange());
        ingredientImportView.getNhapnlButton().addActionListener(al -> ingredientImportHandler());
    }

    public IngredientImportView initController() {
        return ingredientImportView;
    }

    private void onIngredientChange() {
        int ingredientIndex = ingredientImportView.getCbIngredientList().getSelectedIndex();
        ArrayList<Ingredient> ingredientList = ingredientService.getAll();
        Ingredient ingredient = ingredientList.get(ingredientIndex);
        ingredientImportView.getLblUnit().setText(ingredient.getUnit());
    }

    private void ingredientImportHandler() { // Chi xử lí khi mình ấn vào nút nhập nguyên liệu
        // CAN LUU
        // ID nguyen lieu .
        // Thoi gian nhap .
        // So luong .
        // Gia . 
        // ID tai khoan .
        if (ingredientImportView.getCbIngredientList().getItemCount() == 0) {
            return;
        }

        int ingredientIndex = ingredientImportView.getCbIngredientList().getSelectedIndex();
        ArrayList<Ingredient> ingredientList = ingredientService.getAll();
        Ingredient ingredient = ingredientList.get(ingredientIndex);

        int ingredientID = ingredient.getId(); // day la id cua nguyen lieu duoc chon

        String amountString = ingredientImportView.getTxtAmount().getText();
        int amount = Integer.parseInt(amountString); // day la so luong cua nguyen lieu muon nhap

        String costString = ingredientImportView.getTxtCost().getText();
        int cost = Integer.parseInt(costString); // day la thanh tien cua nguyen lieu

        int accountId = App.currentAccount.getId(); // day la ID cua tai khoan nguoi dang nhap

        Date import_Time = new Date(); // Day la thoi gian nhap

        IngredientImport ingredientImport = new IngredientImport();
        ingredientImport.setIngredientId(ingredientID);
        ingredientImport.setImportTime(import_Time);
        ingredientImport.setAmount(amount);
        ingredientImport.setCost(cost);
        ingredientImport.setAccountId(accountId);

        ingredientImportService.insert(ingredientImport);

        ingredientImportView.getTxtMessage().setText("Thêm nguyên liệu thành công !");

        ingredientImportView.getCbIngredientList().setSelectedIndex(0);
        ingredientImportView.getTxtAmount().setText("0");
        ingredientImportView.getTxtCost().setText("0");

    }

}
