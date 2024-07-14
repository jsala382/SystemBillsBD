package org.interfaces;


import org.entity.ProductList;

import java.util.List;

public interface Product {
    List<ProductList> listProdct();

    void printListProduct(List<ProductList> product);

    ProductList getProductByCode(String code);

    ProductList validatCodeProd(String code);


}
