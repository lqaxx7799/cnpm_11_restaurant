/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.ManagementView;

/**
 *
 * @author Admin
 */
public class ManagementController {
    private ManagementView managementView;
    
    public ManagementController(){
        managementView = new ManagementView();
        managementView.getTabManagement().addTab("Tài khoản", new AccountManagementController().initController());
    }
    
    public ManagementView initController(){
        return managementView;
    }
}
