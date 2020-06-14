/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import views.LogInView;

/**
 *
 * @author Admin
 */
public class LogInController {

    private LogInView logInView;
    private JFrame logInFrame;

    public LogInController() {
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

        logInView.getLblResult().setText(email + " " + password);
        logInFrame.setVisible(false);
        
        HomeController homeController = new HomeController();
        homeController.initController();

    }

}
