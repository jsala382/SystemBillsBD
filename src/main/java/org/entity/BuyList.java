package org.entity;

public class BuyList {
    public String nameProduct;
    public  String code;
    public int amount;
    public double price;

    public String getNameProducto() {
        return nameProduct;
    }

    public void setNameProducto(String nameProducto) {
        this.nameProduct = nameProducto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return nameProduct;
    }
}
