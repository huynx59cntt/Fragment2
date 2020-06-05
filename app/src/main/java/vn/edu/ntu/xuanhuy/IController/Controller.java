package vn.edu.ntu.xuanhuy.IController;

import android.app.Application;

import java.util.ArrayList;

import vn.edu.ntu.xuanhuy.model.Product;

public class Controller extends Application implements IController{

    ArrayList<Product> listProduct = new ArrayList<>();
    ArrayList<Product> listShopping = new ArrayList<>();
    public Controller() {
        listProduct.add(new Product("Xoài cát", 6000, "Xoài cát loại 1"));
        listProduct.add(new Product("Khoai lang", 4500, "Khoai lang tím giống Nhật"));
        listProduct.add(new Product("Me Thái", 12000, "Me Thái lan loại A"));
        listProduct.add(new Product("Ổi", 42000, "Ổi hồng "));
        listProduct.add(new Product("Mận tím", 13000, "Mận loại 2"));
        listProduct.add(new Product("Táo đỏ", 2400, "Táo đỏ Bắc Mỹ"));
        listProduct.add(new Product("Sầu riêng", 6700, "Sầu riêng Cà Mau"));
        listProduct.add(new Product("Bưởi", 1600, "Buổi 5roi"));
        listProduct.add(new Product("Mít", 30000, "Mít tố nữ"));
    }

    @Override
    public ArrayList<Product> listProduct() {
        return listProduct;
    }

    @Override
    public ArrayList<Product> listShopping() {
        return listShopping;
    }
    @Override
    public boolean Check(Product p) {
        if(listShopping.contains(p))
            return false;
        else{
            listShopping.add(p);
            return true;
        }
    }
    @Override
    public void clearShopping() {
        listShopping.clear();
    }

    @Override
    public int tinhTien() {
        int k = 0;
        for(Product p : listShopping)
            k+= p.getPrice();
        return k;
    }
}
