package business;

import core.Helper;
import dao.ProductDao;

import java.util.ArrayList;
import entity.Product;

public class ProductController {
    private final ProductDao productDao = new ProductDao();

    public ArrayList<Product> findAll(){
        return this.productDao.findAll();
    }

    public boolean save(Product product){
        return this.productDao.save(product);
    }

    public Product getById(int id){
        return this.productDao.getById(id);
    }

    public boolean update(Product product){
        if(this.getById(product.getId()) == null) {
            Helper.showMsg(product.getId() + "Product not found");
        }
        return this.productDao.update(product);
    }

    public boolean delete(int id){
        if (this.getById(id) == null) {
            Helper.showMsg(id + "Product not found");
            return false;
        }
        return this.productDao.delete(id);
    }
}
