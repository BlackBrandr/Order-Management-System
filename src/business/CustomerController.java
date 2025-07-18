package business;

import core.Helper;
import dao.CustomerDao;
import entity.Customer;

import java.util.ArrayList;
public class CustomerController {
    private final CustomerDao customerDao = new CustomerDao();

    public ArrayList<Customer> findAll(){
        return this.customerDao.findAll();
    }

    public boolean save(Customer customer){
        return this.customerDao.save(customer);
    }

    public Customer getById(int id){
        return this.customerDao.getById(id);
    }

    public boolean update(Customer customer){
        if (this.getById(customer.getId()) == null) {
            Helper.showMsg(customer.getId() + "Customer not found");
            return false;
        }

        return this.customerDao.update(customer);
    }

    public boolean delete(int id){
        if (this.getById(id) == null) {
            Helper.showMsg(id + "Customer not found");
            return false;
        }
        return this.customerDao.delete(id);
    }

    public ArrayList<Customer> filter (String name, Customer.TYPE type){
        String query = "SELECT * FROM customer";

        ArrayList<String> whereList = new ArrayList<>();

        if (name.length() > 0) {
            whereList.add("name LIKE '%" + name + "%'");
        }

        if (type != null) {
            whereList.add("type = '" + type + "'");
        }

        if (whereList.size() > 0) {
            String whereQuery = String.join(" AND ", whereList);
            query += " WHERE " + whereQuery;
        }

        return this.customerDao.query(query);
    }
}
