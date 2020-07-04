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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import models.SalaryInformation;
import models.Timekeeping;
import services.SalaryInformationService;
import services.TimekeepingService;
import utils.CommonUltilities;
import views.SalaryReportView;

/**
 *
 * @author Admin
 */
public class SalaryReportController implements BaseController {

    private SalaryReportView salaryReportView;
    private SalaryInformationService salaryInformationService;
    private TimekeepingService timekeepingService;
    private DateFormat dfDate;
    private DateFormat dfTime;

    public SalaryReportController() {
        salaryReportView = new SalaryReportView();
        salaryInformationService = new SalaryInformationService();
        timekeepingService = new TimekeepingService();
        dfDate = new SimpleDateFormat("dd/MM/yyyy");
        dfTime = new SimpleDateFormat("HH:mm:ss");

        salaryReportView.getBtnCheckSalary().addActionListener(e -> checkSalary());
    }

    @Override
    public JPanel getPanel() {
        return salaryReportView;
    }

    @Override
    public void loadData() {
        salaryReportView.getLblErrMessage().setText("");
        salaryReportView.getLblActualSalary().setText("");
        salaryReportView.getLblActualTimekeeping().setText("");
        salaryReportView.getLblStandardSalary().setText("");
        salaryReportView.getLblStandardTimekeeping().setText("");
        salaryReportView.getLblTime().setText("");
        salaryReportView.getPnlSalaryReport().setVisible(false);
    }

    private void checkSalary() {
        salaryReportView.getLblErrMessage().setText("");
        
        ArrayList<SalaryInformation> salaryInformations = salaryInformationService.getByAccountId(App.currentAccount.getId());
        SalaryInformation salaryInformation = null;
        for (SalaryInformation si : salaryInformations) {
            if (si.getToDate() == null) {
                salaryInformation = si;
            }
        }

        String monthString = salaryReportView.getTxtMonth().getText();
        String yearString = salaryReportView.getTxtYear().getText();

        boolean isValid = true;
        if (yearString.equals("")) {
            salaryReportView.getLblErrMessage().setText("Phải nhập năm");
            isValid = false;
        } else if (!CommonUltilities.checkIntegerNumberFormat(yearString)) {
            salaryReportView.getLblErrMessage().setText("Năm phải là số");
            isValid = false;
        }
        if (monthString.equals("")) {
            salaryReportView.getLblErrMessage().setText("Phải nhập tháng");
            isValid = false;
        } else if (!CommonUltilities.checkIntegerNumberFormat(monthString)) {
            salaryReportView.getLblErrMessage().setText("Tháng phải là số");
            isValid = false;
        }

        if (!isValid) {
            return;
        }

        int month = Integer.parseInt(monthString);
        int year = Integer.parseInt(yearString);

        ArrayList<Timekeeping> timekeepings = timekeepingService.getByAccountId(App.currentAccount.getId());

        Calendar firstDayOfMonth = Calendar.getInstance();
        Calendar lastDayOfMonth = Calendar.getInstance();
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOfMonth.set(Calendar.MONTH, month - 1);
        firstDayOfMonth.set(Calendar.YEAR, year);
        firstDayOfMonth.set(Calendar.HOUR, 0);
        firstDayOfMonth.set(Calendar.MINUTE, 0);
        firstDayOfMonth.set(Calendar.SECOND, 0);

        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, CommonUltilities.getLastDayOfMonth(month, year));
        lastDayOfMonth.set(Calendar.MONTH, month - 1);
        lastDayOfMonth.set(Calendar.YEAR, year);
        lastDayOfMonth.set(Calendar.HOUR, 23);
        lastDayOfMonth.set(Calendar.MINUTE, 59);
        lastDayOfMonth.set(Calendar.SECOND, 59);

        ArrayList<Date> timeKeys = CommonUltilities.generateTimeKey(firstDayOfMonth.getTime(), lastDayOfMonth.getTime(), 1);

        DefaultTableModel timekeepingModel = (DefaultTableModel) salaryReportView.getTblTimekeeping().getModel();

        for (int i = timekeepingModel.getRowCount() - 1; i >= 0; i--) {
            timekeepingModel.removeRow(i);
        }

        for (Date timeKey : timeKeys) {
            boolean isFound = false;
            for (Timekeeping timekeeping : timekeepings) {
                Calendar inTime = Calendar.getInstance();
                Calendar time = Calendar.getInstance();
                inTime.setTime(timekeeping.getInTime());
                time.setTime(timeKey);
                if (inTime.get(Calendar.DATE) == time.get(Calendar.DATE) && inTime.get(Calendar.MONTH) == time.get(Calendar.MONTH) && inTime.get(Calendar.YEAR) == time.get(Calendar.YEAR)) {
                    Object[] rowData = new Object[]{
                        dfDate.format(timeKey),
                        dfTime.format(timekeeping.getInTime()),
                        dfTime.format(timekeeping.getOutTime()),
                        0,
                        0
                    };
                    timekeepingModel.addRow(rowData);
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                Object[] rowData = new Object[]{
                    dfDate.format(timeKey),
                    0,
                    0,
                    0,
                    0
                };
                timekeepingModel.addRow(rowData);
            }
        }
        
        salaryReportView.getPnlSalaryReport().setVisible(true);
    }

}
