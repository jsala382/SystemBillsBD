package org.interfaces;

import org.entity.Buy;
import org.entity.BuyList;
import org.entity.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Bills {
    List<Buy> listCar = new ArrayList<>();


    void listBuy(String code, String namerProducto, double valueTotal, List<Buy> listCar);

    void printBuys(List<Buy> listCar, double acumulated);

    //Buy getBuystByCode(String code);
    void inputBuy(BuyList getProduuct, String code);

    int validateAmount(int cantidad, int inventario);

    public List<BuyList> listBuys();

    BuyList getBuyByCode(String code);

    BuyList validateBuysNew(String code);

    void changeBuyProduct(List<Buy> newList, double acum, Clients clients, List<BuyList> buyLists);

    boolean validateBuyCodes(String codigoProd, List<Buy> buyLists);

    double printBuyTwo(List<Buy> listBuy, double acumu2);

    String validateEliminateBuy(String codProd, List<Buy> listCar, Scanner ingreso);

    void addElininateProducto();

    double eliminatedProduct(List<Buy> buyList, int index, double acum);

    int getComprasByCode2(String codigoProductoCompra, List<Buy> listBuy);

    boolean validatesBuyCodeTwo(String codePrdo, List<BuyList> actuaListCar);


}
