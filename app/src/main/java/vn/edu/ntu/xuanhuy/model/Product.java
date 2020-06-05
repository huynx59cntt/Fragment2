package vn.edu.ntu.xuanhuy.model;

public class Product {
    String Name;
    int Price;
    String Desc;

    public Product(String name, int price, String desc) {
        Name = name;
        Price = price;
        Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
