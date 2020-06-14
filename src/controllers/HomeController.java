/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import views.HomeView;
import views.OrderWaitingListView;

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
        jframe.setSize(600, 400);
        jframe.add(homeView);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        homeFrame = jframe;
    }

    public void initController() {
        homeFrame.setVisible(true);
        generateTabByRole();
    }

    private void generateTabByRole() {
        String role = "owner";
        switch (role) {
            case "cashier": {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                break;
            }
            case "waiter": {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                break;
            }
            case "chef": {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                break;
            }
            case "owner": {
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                homeView.getTabHome().addTab("Waited Order", new OrderWaitingListController().initController());
                break;
            }
            default: {
            }
        }
    }
}
