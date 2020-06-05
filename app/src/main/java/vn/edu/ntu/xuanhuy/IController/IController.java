package vn.edu.ntu.xuanhuy.IController;

import java.util.ArrayList;

import vn.edu.ntu.xuanhuy.model.Product;

public interface IController {
    //mảng của ds mặt hàng
    public ArrayList<Product> listProduct();

    //mảng của shopping
    public ArrayList<Product>  listShopping();
    //hàm kiểm tra có trong giỏ hàng chưa
    public  boolean Check(Product p);

    public void clearShopping();
    public int tinhTien();
}
