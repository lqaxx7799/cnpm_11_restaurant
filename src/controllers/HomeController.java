/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import views.HomeView;
import views.OrderWaitingListView;

/**
 *
 * @author Admin
 */
public class HomeController {

    private HomeView homeView;
    private JFrame homeFrame;

    private ManagementController managementController;
    private TimekeepingController timekeepingController;
    private ChangePasswordController changePasswordController;
    private LogOutController logOutController;
    private StatisticController statisticController;

    public HomeController() {
        this.homeView = new HomeView();

        managementController = new ManagementController();
        timekeepingController = new TimekeepingController();
        changePasswordController = new ChangePasswordController();
        logOutController = new LogOutController(this);
        statisticController = new StatisticController();

        JFrame jframe = new JFrame();
        jframe.setSize(600, 400);
        jframe.add(homeView);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        homeFrame = jframe;

        homeView.getTabHome().addChangeListener(l -> changeTab(l));
    }

    public void initController() {
        homeFrame.setVisible(true);
        generateTabByRole();
    }

    public JFrame getFrame() {
        return homeFrame;
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
                homeView.getTabHome().addTab("Chấm công", timekeepingController.getPanel());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", changePasswordController.getPanel());
                homeView.getTabHome().addTab("Nhập Nguyên Liệu", new IngredientImportController().initController());
                homeView.getTabHome().addTab("Đăng xuất", logOutController.getPanel());
                break;
            }
            case 2: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Chấm công", timekeepingController.getPanel());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", changePasswordController.getPanel());
                homeView.getTabHome().addTab("Đăng xuất", logOutController.getPanel());
                break;
            }
            case 3: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Chấm công", timekeepingController.getPanel());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", changePasswordController.getPanel());
                homeView.getTabHome().addTab("Đăng xuất", logOutController.getPanel());
                break;
            }
            case 4: {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Quản lý", managementController.getPanel());
                homeView.getTabHome().addTab("Thống kê", statisticController.getPanel());
                homeView.getTabHome().addTab("Thay đổi mật khẩu", changePasswordController.getPanel());
                homeView.getTabHome().addTab("Đăng xuất", logOutController.getPanel());
                break;
            }
            default: {
            }
        }
    }

    private void changeTab(ChangeEvent l) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) l.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        switch (App.currentAccount.getRoleId()) {
            case 1: {
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        timekeepingController.loadData();
                        break;
                    case 3:
                        changePasswordController.loadData();
                        break;
                    case 4:
                        break;
                    case 5:
                        logOutController.loadData();
                        break;
                    default:
                        break;
                }
                break;
            }
            case 2: {
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        timekeepingController.loadData();
                        break;
                    case 3:
                        changePasswordController.loadData();
                        break;
                    case 4:
                        logOutController.loadData();
                        break;
                    default:
                        break;
                }
                break;
            }
            case 3: {
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        timekeepingController.loadData();
                        break;
                    case 3:
                        changePasswordController.loadData();
                        break;
                    case 4:
                        logOutController.loadData();
                        break;
                    default:
                        break;
                }
                break;
            }
            case 4: {
                switch (index) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        managementController.loadData();
                        break;
                    case 3:
                        statisticController.loadData();
                        break;
                    case 4:
                        changePasswordController.loadData();
                        break;
                    case 5:
                        logOutController.loadData();
                        break;
                    default:
                        break;
                }
                break;
            }
        }
    }
}
