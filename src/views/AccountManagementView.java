/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class AccountManagementView extends javax.swing.JPanel {

    /**
     * Creates new form AccountManagementView
     */
    private DefaultTableModel tblAccountModel;

    public AccountManagementView() {
        initComponents();
    }

    public DefaultTableModel getTblAccountModel() {
        return tblAccountModel;
    }

    public void setTblAccountModel(DefaultTableModel tblAccountModel) {
        this.tblAccountModel = tblAccountModel;
    }

    public JButton getBtnAddNew() {
        return btnAddNew;
    }

    public void setBtnAddNew(JButton btnAddNew) {
        this.btnAddNew = btnAddNew;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public JComboBox<String> getCbxGender() {
        return cbxGender;
    }

    public void setCbxGender(JComboBox<String> cbxGender) {
        this.cbxGender = cbxGender;
    }

    public JComboBox<String> getCbxRole() {
        return cbxRole;
    }

    public void setCbxRole(JComboBox<String> cbxRole) {
        this.cbxRole = cbxRole;
    }

    public JCheckBox getChbIsWorking() {
        return chbIsWorking;
    }

    public void setChbIsWorking(JCheckBox chbIsWorking) {
        this.chbIsWorking = chbIsWorking;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblAddress() {
        return lblAddress;
    }

    public void setLblAddress(JLabel lblAddress) {
        this.lblAddress = lblAddress;
    }

    public JLabel getLblDateOfBirth() {
        return lblDateOfBirth;
    }

    public void setLblDateOfBirth(JLabel lblDateOfBirth) {
        this.lblDateOfBirth = lblDateOfBirth;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public JLabel getLblErrAddress() {
        return lblErrAddress;
    }

    public void setLblErrAddress(JLabel lblErrAddress) {
        this.lblErrAddress = lblErrAddress;
    }

    public JLabel getLblErrDateOfBirth() {
        return lblErrDateOfBirth;
    }

    public void setLblErrDateOfBirth(JLabel lblErrDateOfBirth) {
        this.lblErrDateOfBirth = lblErrDateOfBirth;
    }

    public JLabel getLblErrEmail() {
        return lblErrEmail;
    }

    public void setLblErrEmail(JLabel lblErrEmail) {
        this.lblErrEmail = lblErrEmail;
    }

    public JLabel getLblErrGender() {
        return lblErrGender;
    }

    public void setLblErrGender(JLabel lblErrGender) {
        this.lblErrGender = lblErrGender;
    }

    public JLabel getLblErrIsWorking() {
        return lblErrIsWorking;
    }

    public void setLblErrIsWorking(JLabel lblErrIsWorking) {
        this.lblErrIsWorking = lblErrIsWorking;
    }

    public JLabel getLblErrRole() {
        return lblErrRole;
    }

    public void setLblErrRole(JLabel lblErrRole) {
        this.lblErrRole = lblErrRole;
    }

    public JLabel getLblErrUserName() {
        return lblErrUserName;
    }

    public void setLblErrUserName(JLabel lblErrUserName) {
        this.lblErrUserName = lblErrUserName;
    }

    public JLabel getLblGender() {
        return lblGender;
    }

    public void setLblGender(JLabel lblGender) {
        this.lblGender = lblGender;
    }

    public JLabel getLblIsWorking() {
        return lblIsWorking;
    }

    public void setLblIsWorking(JLabel lblIsWorking) {
        this.lblIsWorking = lblIsWorking;
    }

    public JLabel getLblRole() {
        return lblRole;
    }

    public void setLblRole(JLabel lblRole) {
        this.lblRole = lblRole;
    }

    public JLabel getLblUserName() {
        return lblUserName;
    }

    public void setLblUserName(JLabel lblUserName) {
        this.lblUserName = lblUserName;
    }

    public JTable getTblAccount() {
        return tblAccount;
    }

    public void setTblAccount(JTable tblAccount) {
        this.tblAccount = tblAccount;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(JTextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    public JTextField getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public void setTxtDateOfBirth(JTextField txtDateOfBirth) {
        this.txtDateOfBirth = txtDateOfBirth;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        btnAddNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox<>();
        cbxGender = new javax.swing.JComboBox<>();
        lblErrEmail = new javax.swing.JLabel();
        lblErrUserName = new javax.swing.JLabel();
        lblErrAddress = new javax.swing.JLabel();
        lblErrGender = new javax.swing.JLabel();
        lblErrDateOfBirth = new javax.swing.JLabel();
        lblErrRole = new javax.swing.JLabel();
        chbIsWorking = new javax.swing.JCheckBox();
        lblIsWorking = new javax.swing.JLabel();
        lblErrIsWorking = new javax.swing.JLabel();

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Email", "User Name", "Address", "Gender", "Date of Birth", "Role", "Start Work Date", "Is Working"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAccount);

        lblEmail.setText("Email");

        btnAddNew.setText("Thêm mới");

        btnEdit.setText("Sửa");

        btnDelete.setText("Xóa");

        btnCancel.setText("Hủy");

        btnSubmit.setText("OK");

        lblUserName.setText("Tên người dùng");

        lblAddress.setText("Địa chỉ");

        lblGender.setText("Giới tính");

        lblDateOfBirth.setText("Ngày sinh");

        lblRole.setText("Chức vụ");

        cbxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblErrEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblErrEmail.setText("jLabel7");

        lblErrUserName.setForeground(new java.awt.Color(255, 0, 0));
        lblErrUserName.setText("jLabel7");

        lblErrAddress.setForeground(new java.awt.Color(255, 0, 0));
        lblErrAddress.setText("jLabel7");

        lblErrGender.setForeground(new java.awt.Color(255, 0, 0));
        lblErrGender.setText("jLabel7");

        lblErrDateOfBirth.setForeground(new java.awt.Color(255, 0, 0));
        lblErrDateOfBirth.setText("jLabel7");

        lblErrRole.setForeground(new java.awt.Color(255, 0, 0));
        lblErrRole.setText("jLabel7");

        lblIsWorking.setText("Đang làm viêc");

        lblErrIsWorking.setForeground(new java.awt.Color(255, 0, 0));
        lblErrIsWorking.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblUserName)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAddress)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDateOfBirth)
                                        .addComponent(lblRole)
                                        .addComponent(lblGender)
                                        .addComponent(lblIsWorking))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chbIsWorking)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(cbxRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrEmail)
                            .addComponent(lblErrUserName)
                            .addComponent(lblErrAddress)
                            .addComponent(lblErrGender)
                            .addComponent(lblErrDateOfBirth)
                            .addComponent(lblErrRole)
                            .addComponent(lblErrIsWorking))
                        .addGap(169, 169, 169)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblErrEmail)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblErrUserName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblErrAddress)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender)
                            .addComponent(cbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrGender))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateOfBirth)
                            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrDateOfBirth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRole)
                            .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrRole))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbIsWorking)
                    .addComponent(lblIsWorking)
                    .addComponent(lblErrIsWorking))
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbxGender;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JCheckBox chbIsWorking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrAddress;
    private javax.swing.JLabel lblErrDateOfBirth;
    private javax.swing.JLabel lblErrEmail;
    private javax.swing.JLabel lblErrGender;
    private javax.swing.JLabel lblErrIsWorking;
    private javax.swing.JLabel lblErrRole;
    private javax.swing.JLabel lblErrUserName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIsWorking;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
