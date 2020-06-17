/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.SalaryInformation;
import services.SalaryInformationService;
import views.SalaryManagementView;

/**
 *
 * @author Admin
 */
public class SalaryManagementController {

    private SalaryManagementView salaryManagementView;
    private JFrame salaryMangementFrame;
    private SalaryInformationService salaryInformationService;

    public SalaryManagementController() {
        salaryInformationService = new SalaryInformationService();
        salaryManagementView = new SalaryManagementView();
        salaryMangementFrame = new JFrame();
        salaryMangementFrame.setSize(600, 400);
        salaryMangementFrame.add(salaryManagementView);
        
        salaryManagementView.getLblErrSalary().setText("");

        loadData();
        
        salaryManagementView.getBtnUpdate().addActionListener(e -> editSalaryHandler());
    }

    public JFrame initController() {
        return salaryMangementFrame;
    }

    private void loadData() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<SalaryInformation> salaryInformations = salaryInformationService.getByAccountId(AccountManagementController.activeAccountId);

        DefaultTableModel salaryModel = (DefaultTableModel) salaryManagementView.getTblSalary().getModel();

        for (int i = salaryModel.getRowCount() - 1; i >= 0; i--) {
            salaryModel.removeRow(i);
        }

        for (SalaryInformation salaryInformation : salaryInformations) {
            String fromDate = salaryInformation.getFromDate() == null ? "" : df.format(salaryInformation.getFromDate());
            String toDate = salaryInformation.getToDate() == null ? "" : df.format(salaryInformation.getToDate());

            Object[] rowData = new Object[]{
                salaryInformation.getSalary(),
                fromDate,
                toDate
            };

            salaryModel.addRow(rowData);

            if (salaryInformation.getToDate() == null) {
                salaryManagementView.getTxtSalary().setText(String.valueOf(salaryInformation.getSalary()));
            }
        }
    }
    
    private void editSalaryHandler(){
        
    }
}
