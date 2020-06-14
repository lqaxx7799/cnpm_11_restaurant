/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.App;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import models.Account;
import services.AccountService;
import utils.CommonUltilities;
import views.LogInView;

/**
 *
 * @author Admin
 */
public class LogInController {

    private LogInView logInView;
    private JFrame logInFrame;
    private AccountService accountService;

    public LogInController() {
        accountService = new AccountService();
        this.logInView = new LogInView();

        logInView.getBtnLogIn().addActionListener(e -> logInHandler());

        JFrame jframe = new JFrame();
        jframe.setSize(600, 400);
        jframe.add(logInView);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        logInFrame = jframe;
    }

    public void initController() {
        logInFrame.setVisible(true);
    }

    private void logInHandler() {
        String email = logInView.getTxtEmail().getText();
        String password = logInView.getTxtPassword().getText();
        logInView.getLblMessage().setText("");

        ArrayList<Account> accounts = accountService.getAll();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(CommonUltilities.generateSHA1(password))) {
                logInFrame.setVisible(false);
                App.currentAccount = account;
                HomeController homeController = new HomeController();
                homeController.initController();
                return;
            }
        }
        
        logInView.getLblMessage().setText("Wrong email or password");
    }
}
