package view;

import core.Helper;

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

    public LoginUI(){
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
                System.out.println("Please enter a valid e-mail address");
            }
            if (Helper.isFieldListEmpty(checkList)){
                System.out.println("Please fill all informations");
            }else {
                System.out.println("You can login");
            }
        });
    }

}
