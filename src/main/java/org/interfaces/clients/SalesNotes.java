package org.interfaces.clients;

import org.conexion.ConnexionBD;
import org.entity.BuyList;
import org.excepetion.ExceptionCompras;
import org.interfaces.SalesNotesInterfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesNotes implements SalesNotesInterfaces {

    Scanner input = new Scanner(System.in);

    @Override
    public void buyList(String code) {
        BuyList getProduct = getBuyByCode(code);
        while (getProduct.getCode() == null) {
            System.out.println("NO EXISTE EL CODIGO DEL PRODUCTO EN LA BASE DE DATOS, POR FAVOR INGRES UN NUEVO CODIGO");
            String founded = input.next();
            getProduct = getBuyByCode(founded);
            System.out.println("Ingrese la canitdad");
            int amounProduct = input.nextInt();
            amount(founded, amounProduct);
        }
    }


    @Override
    public BuyList getBuyByCode(String code) {
        BuyList buyList = new BuyList();
        try {
            Connection connection = ConnexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select *from db_factura.producto where codigo_producto=?");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buyList.setId(resultSet.getInt("id"));
                buyList.setCode(resultSet.getString("codigo_producto"));
                buyList.setNameProducto(resultSet.getString("nombre"));
                buyList.setAmount(resultSet.getInt("cantidad"));
                buyList.setPrice(resultSet.getDouble("precio"));
            }
        } catch (SQLException e) {
            throw new ExceptionCompras("ERROR AL OBTENR UN PRODUCTIO");
        }
        return buyList;
    }

    @Override
    public BuyList validateAmount(String code, int amount) {
        BuyList buyList = new BuyList();
        try {
            Connection connection = ConnexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM db_factura.producto where codigo_producto =? and cantidad > ?");
            preparedStatement.setString(1, code);
            preparedStatement.setInt(2, amount);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                buyList.setId(resultSet.getInt("id"));
                buyList.setCode(resultSet.getString("codigo_producto"));
                buyList.setNameProducto(resultSet.getString("nombre"));
                buyList.setAmount(resultSet.getInt("cantidad"));
                buyList.setPrice(resultSet.getDouble("precio"));
            }
        } catch (SQLException e) {
            throw new ExceptionCompras("ERROR AL OBTENER LA CANTIDAD");
        }
        return buyList;
    }


    @Override
    public void amount(String code, int amount) {
        BuyList getAmount = validateAmount(code, amount);
        while (getAmount.getAmount() == 0) {
            System.out.println("No possemos esa canitdad.Ingrese  una nueva cantidad");
            int cant = input.nextInt();
            getAmount = validateAmount(code, cant);

        }
    }

    @Override
    public void insertBill() {
        try{
            Connection connection=ConnexionBD.getConnection();
            

        }catch (SQLException e){

        }


    }
}
