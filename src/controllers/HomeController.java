/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import views.HomeView;

/**
 *
 * @author Admin
 */
public class HomeController {

    private HomeView homeView;
    private JFrame homeFrame;

    public HomeController() {
        this.homeView = new HomeView();

        JFrame jframe = new JFrame();
        jframe.setSize(900, 500);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.add(homeView);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        homeFrame = jframe;
    }

    public void initController() {
        homeFrame.setVisible(true);
        generateTabByRole();
    }

    private void generateTabByRole() {
        //1 - chef
        //2 - cashier
        //3 - waiter
        //4 - owner
        switch (App.currentAccount.getRoleId()) {
            case 1: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Chấm công", new TimeKeepingController().initController());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", new ChangePasswordController().initController());
                homeView.getTabHome().addTab("Nhập Nguyên Liệu", new IngredientImportController().initController());
                break;
            }
            case 2: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Chấm công", new TimeKeepingController().initController());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", new ChangePasswordController().initController());
                homeView.getTabHome().addTab("Gọi món", new OrderController().initController());
                break;
            }
            case 3: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Chấm công", new TimeKeepingController().initController());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", new ChangePasswordController().initController());
                break;
            }
            case 4: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Quản lý", new ManagementController().initController());
                homeView.getTabHome().addTab("Thống kê", new StatisticController().initController());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", new ChangePasswordController().initController());
                homeView.getTabHome().addTab("Quản lý món ăn", new MenuItemManagementController().InitController());
                homeView.getTabHome().addTab("Quản lý danh mục món", new MenuCategoryManagementController().InitController());
                break;
            }
            default: {
            }
        }
    }
}
