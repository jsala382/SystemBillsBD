package org.view;


import org.entity.BuyList;
import org.entity.ProductList;
import org.interfaces.clients.BillsImpl;
import org.interfaces.clients.ClientsImpl;
import org.interfaces.clients.ProductImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientsImpl clienteImpl= new ClientsImpl();
        OptionMenu optionMenu=new OptionMenu();
        List<ProductList> productList = new ArrayList<>();
        BuyList getProduct=new BuyList();
        BillsImpl bills=  new BillsImpl();
        String code="";


       /* ProductImpl productBillboard= new ProductImpl();
        productBillboard.printListProduct(productList);
        bills.inputBuy( getProduct,  code);
        bills.addElininateProducto();*/
        //clienteImpl.inputCustomerData();

        optionMenu.viewMenuOption();





    }
}