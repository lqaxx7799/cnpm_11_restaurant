/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.statistics;

import controllers.BaseController;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.CustomerStatistic;
import models.ExpenseStatistic;
import models.IngredientImport;
import models.Receipt;
import models.ReceiptDetail;
import models.RevenueStatistic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import services.CustomerService;
import services.IngredientImportService;
import services.ReceiptDetailService;
import services.ReceiptService;
import utils.CommonUltilities;
import views.statistics.CustomerStatisticView;
import views.statistics.ExpenseStatisticView;

/**
 *
 * @author Admin
 */
public class CustomerStatisticController implements BaseController {

    private CustomerStatisticView customerStatisticView;
    private CustomerService customerService;
    private DateFormat dfDate;
    private DateFormat dfTime;

    public CustomerStatisticController() {
        customerStatisticView = new CustomerStatisticView();
        customerService = new CustomerService();
        dfDate = new SimpleDateFormat("dd/MM/yyyy");
        dfTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        customerStatisticView.getCbxTimeRange().addActionListener(e -> changeTimeRange());
        customerStatisticView.getBtnFilter().addActionListener(e -> filterHandler());
    }

    @Override
    public JPanel getPanel() {
        return customerStatisticView;
    }

    @Override
    public void loadData() {
        customerStatisticView.getTblCustomerStatistic().getColumnModel().getColumn(0).setMaxWidth(50);

        customerStatisticView.getCbxTimeRange().removeAllItems();
        customerStatisticView.getCbxTimeRange().addItem("Hôm nay");
        customerStatisticView.getCbxTimeRange().addItem("Hôm qua");
        customerStatisticView.getCbxTimeRange().addItem("7 ngày qua");
        customerStatisticView.getCbxTimeRange().addItem("Tháng này");
        customerStatisticView.getCbxTimeRange().addItem("Tùy chọn");

        customerStatisticView.getCbxPeriod().removeAllItems();
        customerStatisticView.getCbxPeriod().addItem("Giờ");
        customerStatisticView.getCbxPeriod().addItem("Ngày");
        customerStatisticView.getCbxPeriod().addItem("Tuần");
        customerStatisticView.getCbxPeriod().addItem("Tháng");

        customerStatisticView.getLblErrFilter().setText("");
        customerStatisticView.getPnlInformation().setVisible(false);
        customerStatisticView.getLblTimeRange().setText("");
        
        customerStatisticView.getTxtFromDate().setEnabled(false);
        customerStatisticView.getTxtToDate().setEnabled(false);

        customerStatisticView.getCbxTimeRange().setSelectedIndex(2);
        customerStatisticView.getCbxPeriod().setSelectedIndex(1);
    }

    private void changeTimeRange() {
        int timeRangeIndex = customerStatisticView.getCbxTimeRange().getSelectedIndex();
        if (timeRangeIndex == 4) {
            customerStatisticView.getTxtFromDate().setEnabled(true);
            customerStatisticView.getTxtToDate().setEnabled(true);
        } else {
            customerStatisticView.getTxtFromDate().setEnabled(false);
            customerStatisticView.getTxtToDate().setEnabled(false);
        }
    }

    private void filterHandler() {
        loadStatistic();
    }

    private void loadStatistic() {
        ArrayList<Customer> customers = customerService.getAll();

        customerStatisticView.getLblErrFilter().setText("");

        int timeRangeIndex = customerStatisticView.getCbxTimeRange().getSelectedIndex();
        int periodIndex = customerStatisticView.getCbxPeriod().getSelectedIndex();
        String fromDateString = customerStatisticView.getTxtFromDate().getText();
        String toDateString = customerStatisticView.getTxtToDate().getText();

        Date[] timeRange = CommonUltilities.generateTimeRange(timeRangeIndex, fromDateString, toDateString);
        if (timeRange == null) {
            customerStatisticView.getLblErrFilter().setText("Ngày không hợp lệ");
            return;
        }
        Date fromDate = timeRange[0], toDate = timeRange[1];
        ArrayList<Date> timePeriods = CommonUltilities.generateTimeKey(fromDate, toDate, periodIndex);

        ArrayList<Customer> validCustomer = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCreatedTime().after(fromDate) && customer.getCreatedTime().before(toDate)) {
                validCustomer.add(customer);
            }
        }

        String timeRangeString = String.format("Từ %s đến %s", dfTime.format(fromDate), dfTime.format(toDate));
        double totalCustomer = 0;

        ArrayList<CustomerStatistic> tableData = new ArrayList<>();
        for (int i = 0; i < timePeriods.size(); i++) {
            int countCustomer = 0;
            for (Customer customer : validCustomer) {
                if (i == timePeriods.size() - 1) {
                    if (customer.getCreatedTime().after(timePeriods.get(i))) {
                        countCustomer++;
                    }
                } else {
                    if (customer.getCreatedTime().after(timePeriods.get(i)) && customer.getCreatedTime().before(timePeriods.get(i + 1))) {
                        countCustomer++;
                    }
                }
            }
            String formattedTime = "";
            if (periodIndex == 0) {
                formattedTime = dfTime.format(timePeriods.get(i));
            } else {
                formattedTime = dfDate.format(timePeriods.get(i));
            }
            CustomerStatistic customerStatistic = new CustomerStatistic();

            customerStatistic.setTime(formattedTime);
            customerStatistic.setCount(countCustomer);
            tableData.add(customerStatistic);

            totalCustomer += countCustomer;
        }

        DefaultTableModel revenueStatisticModel = (DefaultTableModel) customerStatisticView.getTblCustomerStatistic().getModel();
        for (int i = revenueStatisticModel.getRowCount() - 1; i >= 0; i--) {
            revenueStatisticModel.removeRow(i);
        }
        for (int i = 0; i < tableData.size(); i++) {
            Object[] rowData = new Object[]{
                i + 1,
                tableData.get(i).getTime(),
                tableData.get(i).getCount(),
            };
            revenueStatisticModel.addRow(rowData);
        }

        customerStatisticView.getPnlInformation().setVisible(true);
        customerStatisticView.getLblTimeRange().setText(timeRangeString);
        customerStatisticView.getLblTotalNewCustomer().setText(String.valueOf(totalCustomer));

        CategoryDataset ds = createDataset(tableData);

        JFreeChart chart = ChartFactory.createBarChart("Thống kê chi phí", "Thời gian", "Chi phí", ds, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createDownRotationLabelPositions(Math.PI / 4.0));
        ChartPanel cp = new ChartPanel(chart);
        customerStatisticView.getjSplitPane1().setBottomComponent(cp);
        customerStatisticView.getjSplitPane1().setDividerLocation(250);
    }

    private CategoryDataset createDataset(ArrayList<CustomerStatistic> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (CustomerStatistic es : data) {
            dataset.addValue(es.getCount(), "Khách hàng", es.getTime());
        }
        return dataset;
    }
}
