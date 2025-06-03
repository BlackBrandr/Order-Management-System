package view;

import business.CustomerController;
import core.Helper;
import entity.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerUI extends JFrame {
    private JPanel container;
    private JTextField fld_customer_name;
    private JComboBox<Customer.TYPE> cmb_customer_type;
    private JTextField fld_customer_phone;
    private JLabel lbl_title;
    private JLabel lbl_name;
    private JLabel lbl_type;
    private JLabel lbl_customer_phone;
    private JLabel lbl_customer_mail;
    private JTextField fld_customer_mail;
    private JTextArea tarea_customer_address;
    private JLabel lbl_customer_address;
    private JButton btn_customer_save;
    private Customer customer;
    private CustomerController customerController;

    public CustomerUI(Customer customer) {
        this.customer = customer;
        this.customerController = new CustomerController();

        this.add(container);
        this.setTitle("Customer Add / Edit");
        this.setSize(300,500);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;

        this.setLocation(x,y);
        this.setVisible(true);

        this.cmb_customer_type.setModel(new DefaultComboBoxModel<>(Customer.TYPE.values()));

        if(this.customer.getId() == 0){
            this.lbl_title.setText("Add Customer");
        } else {
            this.lbl_title.setText("Edit Customer");
            this.fld_customer_name.setText(customer.getName());
            this.fld_customer_phone.setText(customer.getPhone());
            this.fld_customer_mail.setText(customer.getMail());
            this.tarea_customer_address.setText(customer.getAddress());
            this.cmb_customer_type.getModel().setSelectedItem(customer.getType());
        }

        this.btn_customer_save.addActionListener(e -> {
           JTextField[] checklist = {this.fld_customer_name, this.fld_customer_phone};
           if(Helper.isFieldListEmpty(checklist)){
               Helper.showMsg("fill");
           }else if(!Helper.isFieldEmpty(this.fld_customer_mail) && !Helper.isEmailValid(this.fld_customer_mail.getText())) {
               Helper.showMsg("Please enter a valid email address");
           }else {
                boolean result = false;
                this.customer.setName(this.fld_customer_name.getText());
                this.customer.setPhone(this.fld_customer_phone.getText());
                this.customer.setMail(this.fld_customer_mail.getText());
                this.customer.setAddress(this.tarea_customer_address.getText());
                this.customer.setType((Customer.TYPE) this.cmb_customer_type.getSelectedItem());

               if (this.customer.getId() == 0) {
                   result = this.customerController.save(this.customer);
               }

               if (result) {
                   Helper.showMsg("Customer saved");
                   dispose();
               } else {
                   Helper.showMsg("Error");
               }
           }


        });


    }
}
