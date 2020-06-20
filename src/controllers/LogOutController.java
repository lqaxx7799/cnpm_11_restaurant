/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import javax.swing.JOptionPane;
import views.LogOutView;

/**
 *
 * @author Admin
 */
public class LogOutController {
    private LogOutView logOutView;
    private HomeController homeController;
    
    public LogOutController(){
        logOutView = new LogOutView();
        
        logOutView.getBtnLogOut().addActionListener(l -> logOutHandler());
    }
    
    public LogOutView initController(HomeController homeController){
        this.homeController = homeController;
        return logOutView;
    }
    
    private void logOutHandler(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn đăng xuất?", "Thông báo", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            App.currentAccount = null;
            homeController.getFrame().setVisible(false);
            LogInController logInController = new LogInController();
            logInController.initController();
        }
    }
}
