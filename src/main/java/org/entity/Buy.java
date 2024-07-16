package org.entity;

public class Buy {

    private String code;
    private  String nameProduct;
    private  double total;
    private int id_product;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        id_product = id_product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
