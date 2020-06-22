/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import views.StatisticView;

/**
 *
 * @author Admin
 */
public class StatisticController implements BaseController {

    private StatisticView statisticView;

    private RevenueStatisticController revenueStatisticController;
    private ExpenseStatisticController expenseStatisticController;

    public StatisticController() {
        statisticView = new StatisticView();
        revenueStatisticController = new RevenueStatisticController();
        expenseStatisticController = new ExpenseStatisticController();

        statisticView.getTabStatistic().add("Doanh thu", revenueStatisticController.getPanel());
        statisticView.getTabStatistic().add("Chi phí", expenseStatisticController.getPanel());

        statisticView.getTabStatistic().addChangeListener(e -> changeTab(e));
    }

    @Override
    public JPanel getPanel() {
        return statisticView;
    }

    @Override
    public void loadData() {
        revenueStatisticController.loadData();
    }

    private void changeTab(ChangeEvent e) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        switch (index) {
            case 0:
                revenueStatisticController.loadData();
                break;
            case 1:
                expenseStatisticController.loadData();
                break;
            default:
                break;
        }
    }
}
