/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import views.ManagementView;

/**
 *
 * @author Admin
 */
public class ManagementController implements BaseController {

    private ManagementView managementView;

    private AccountManagementController accountManagementController;
    private IngredientManagementController ingredientManagementController;
    private TableManagementController tableManagementController;
    private MenuItemManagementController menuItemManagementController;
    private MenuCategoryManagementController menuCategoryManagementController; 

    public ManagementController() {
        managementView = new ManagementView();
        accountManagementController = new AccountManagementController();
        ingredientManagementController = new IngredientManagementController();
        tableManagementController = new TableManagementController();

        managementView.getTabManagement().addTab("Tài khoản", accountManagementController.getPanel());
        managementView.getTabManagement().addTab("Nguyên Liệu", ingredientManagementController.getPanel());
        managementView.getTabManagement().addTab("Bàn", tableManagementController.getPanel());
        managementView.getTabManagement().addTab("Món ăn", menuItemManagementController.getPanel());
        managementView.getTabManagement().addTab("Danh mục món", menuCategoryManagementController.getPanel());

        managementView.getTabManagement().addChangeListener(e -> changeTab(e));
    }

    @Override
    public void loadData() {
        accountManagementController.loadData();
    }

    @Override
    public ManagementView getPanel() {
        return managementView;
    }

    private void changeTab(ChangeEvent e) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        switch (index) {
            case 0:
                accountManagementController.loadData();
                break;
            case 1:
                ingredientManagementController.loadData();
                break;
            case 2:
                tableManagementController.loadData();
                break;
            default:
                break;
        }
    }
}
