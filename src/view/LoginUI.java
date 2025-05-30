package view;

import business.UserController;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private UserController userController;

    public LoginUI(){

        this.userController = new UserController();
        this.add(container);
        this.setTitle("Customer Management System");
        this.setSize(400,400);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;

        this.setLocation(x,y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.btn_login.addActionListener(e -> {
            JTextField [] checkList = {this.fld_mail,this.fld_password};
            if (!Helper.isEmailValid(this.fld_mail.getText())){
                Helper.showMsg("Enter a valid email");
            } else if (Helper.isFieldListEmpty(checkList)){
                Helper.showMsg("fill");
            }else{
                User user = this.userController.findByLogin(this.fld_mail.getText(), this.fld_password.getText());
                if (user == null){
                    Helper.showMsg("User not found");
                }else {
                    this.dispose();
                    DashboardUI dashboardUI = new DashboardUI(user);
                }
            }
        });
    }
}
