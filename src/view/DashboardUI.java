package view;

import javax.swing.*;

import entity.User;
import core.Helper;

import java.awt.*;

public class DashboardUI extends JFrame {
    private JPanel container;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JTabbedPane tab_menu;
    private JPanel pnl_customer;
    private JScrollPane scrl_customer;
    private JTable tbl_customer;
    private JPanel pnl_customer_filter;
    private JTextField fld_f_customer_name;
    private JComboBox cmb_f_customer_type;
    private JButton btn_customer_filter;
    private JButton btn_customer_filter_reset;
    private JButton btn_customer_new;
    private JLabel lbl_f_customer_name;
    private JLabel lbl_f_customer_type;
    private User user;

    public DashboardUI(User user){
        this.user = user;
        if (user == null) {
            Helper.showMsg("Error");
            dispose();
        }

        this.add(container);
        this.setTitle("Customer Management System");
        this.setSize(1000,500);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;

        this.setLocation(x,y);
        this.setVisible(true);

        this.lbl_welcome.setText("Welcome " + this.user.getName());

        btn_logout.addActionListener(e ->{
            dispose();
            LoginUI loginUI = new LoginUI();
        });
    }

}
