package org.interfaces;

import org.entity.BuyList;

import java.sql.SQLException;

public interface SalesNotesInterfaces {
    void buyList(String code);

    BuyList getBuyByCode(String code);

    BuyList validateAmount(String code, int amount);

    void amount(String code ,int amount);

    void insertBill();
}
