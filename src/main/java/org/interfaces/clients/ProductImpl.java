package org.interfaces.clients;

import org.entity.Buy;
import org.entity.Clients;
import org.entity.ProductList;
import org.interfaces.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductImpl implements Product {
    Scanner input=new Scanner(System.in);
    List<Buy> listCar= new ArrayList<>();
    Clients clients=new Clients();
    List<ProductList> productList =new ArrayList();
    @Override
    public List<ProductList> listProdct() {
        List<ProductList> productList = new ArrayList<>();
        ProductList product = new ProductList();
        product.code = "001";
        product.nameProduct = "PC-PORTATIL";
        product.amount = 200;
        product.price = 450.00;
        productList.add(product);
        ProductList product1 = new ProductList();
        product1.code = "002";
        product1.nameProduct = "PC-ESCRITORIO";
        product1.amount = 300;
        product1.price = 700.0;
        productList.add(product1);
        ProductList product2 = new ProductList();
        product2.code = "003";
        product2.nameProduct = "CAMARAS DIGITALES";
        product2.amount = 300;
        product2.price = 650.00;
        productList.add(product2);
        ProductList product3 = new ProductList();
        product3.code = "004";
        product3.nameProduct = "CABLES USB";
        product3.amount = 300;
        product3.price = 10.00;
        productList.add(product3);
        return productList;
    }


    @Override
    public void printListProduct(List<ProductList> product) {
        System.out.println(" \t\t\t LISTA DE PRECIOS NOVICOMPU\t\t\t");
        product = listProdct();
        System.out.println("CODIGO \t  NOMBRE \t    PRECIO UNITARIO");
        for (int i = 0; i < product.size(); i++) {
            System.out.println(product.get(i).code + "   " + product.get(i).nameProduct + "     " + product.get(i).price);
        }
        System.out.println("\n\n");
    }

    @Override
    public ProductList getProductByCode(String code) {
        ProductList codeFound = new ProductList();
        for (ProductList p : listProdct()) {
            if (code.equals(p.code)) {
                codeFound.setCode(p.getCode());
                codeFound.setAmount(p.getAmount());
                codeFound.setPrice(p.getPrice());
                codeFound.setNameProducto(p.getNameProducto());
            }

        }
        return codeFound;
    }

    @Override
    public ProductList validatCodeProd(String code) {
        System.out.print("\nEscoja codigo el producto: ");
        code = input.next();
        ProductList getProduct = getProductByCode(code);
        while (Objects.isNull(getProduct.getCode())) {
            System.out.println("No fue encontrado el codigo del producto por favor ingrese un nuevo codigo: ");
            String founded = input.next();
            getProduct =getProductByCode(founded);
        }
        return getProduct;
    }


}
