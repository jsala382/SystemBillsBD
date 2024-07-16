package org.interfaces;


import org.entity.ProductList;

import java.util.List;

public interface Product {
    void insertProduct(ProductList pr);
    ProductList getProductoByCode(String code);
    void elimiinateProduct(String code);
    void updatesProduct(String code,double price);

}
