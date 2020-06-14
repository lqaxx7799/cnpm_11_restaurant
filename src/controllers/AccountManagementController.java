/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Account;
import models.Role;
import services.AccountService;
import services.RoleService;
import views.AccountManagementView;

/**
 *
 * @author Admin
 */
public class AccountManagementController {

    private AccountManagementView accountManagementView;
    private AccountService accountService;
    private RoleService roleService;

    public AccountManagementController() {
        accountManagementView = new AccountManagementView();
        accountService = new AccountService();
        roleService = new RoleService();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<Account> accounts = accountService.getAll();
        ArrayList<Role> roles = roleService.getAll();
        
        DefaultTableModel accountModel = (DefaultTableModel) accountManagementView.getTblAccount().getModel();
        
        for (Account account : accounts) {
            String roleName = "";
            for (Role role : roles) {
                if (role.getId() == account.getRoleId()) {
                    roleName = role.getRoleName();
                    break;
                }
            }
            String dateOfBirth = account.getDateOfBirth() == null ? "" : df.format(account.getDateOfBirth());
            String startWorkDate = account.getStartWorkDate() == null ? "" : df.format(account.getStartWorkDate());

            Object[] rowData = new Object[]{
                account.getId(),
                account.getEmail(),
                account.getUserName(),
                account.getAddress(),
                account.getGender(),
                dateOfBirth,
                roleName,
                startWorkDate,
                account.isWorking()
            };

            accountModel.addRow(rowData);
        }
    }

    public AccountManagementView initController() {
        return accountManagementView;
    }
}
