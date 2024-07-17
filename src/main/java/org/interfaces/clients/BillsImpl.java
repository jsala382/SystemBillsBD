package org.interfaces.clients;

import org.entity.Buy;
import org.entity.BuyList;
import org.entity.Clients;
import org.excepetion.ExceptionCompras;
import org.interfaces.Bills;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BillsImpl extends ClientsImpl implements Bills {
    Scanner input = new Scanner(System.in);
    List<BuyList> listBuy= new ArrayList<>();
    Clients clients = new Clients();
    List<Buy> listsBuys = new ArrayList<>();
    double acumulated = 0.0;
    double acumulated1=0.0;


    @Override
    public void listBuy(String code, String namerProducto, double valueTotal, List<Buy> listCar) {
        Buy buy = new Buy();
        buy.setCode(code);
        buy.setNameProduct(namerProducto);
        buy.setTotal(valueTotal);
        listCar.add(buy);

    }

    @Override
    public void printBuys(List<Buy> listCar, double acumulated) {
        List<Buy> compras = listCar;
        for (int i = 0; i < compras.size(); i++) {
            System.out.println(compras.get(i).getCode() + "  " + compras.get(i).getNameProduct() + " " + compras.get(i).getTotal());

        }
        System.out.println("VALOR TOTAL:\t" + acumulated);

    }

    public void inputBuy(BuyList getProduct, String code) {
        double acumulated = 0.0;
        getProduct = validateBuysNew(code);
        while (true) {
            System.out.println(getProduct);
            System.out.print("Ingrese la cantidad:\t");
            int amountProduct = input.nextInt();
            amountProduct = validateAmount(amountProduct, getProduct.getAmount());
            double valueTotal = getProduct.price * amountProduct;
            acumulated = acumulated + valueTotal;
            System.out.print("El precio a pagar es: " + valueTotal);
            System.out.println("\nDESEA INGRESAR MAS PRODUCTOS ?");
            String inputProduct = input.next();
            System.out.println("\n");
            listBuy(getProduct.getCode(), getProduct.getNameProducto(), valueTotal, listCar);
            if (inputProduct.equals("n")) {
                clients = inputCustomerData();
                printCustomeData(clients);
                getClientsByIdentification("093045878");
                printBuys(listCar, acumulated);
                break;
            }
            if (inputProduct.equalsIgnoreCase("s")) {
                getProduct = validateBuysNew(code);
            }
        }
    }


    public Buy getBuystByCode(String code) {
        Buy codeFound = new Buy();
        for (Buy b : listCar) {
            if (code.equals(b.getCode())) {
                codeFound.setCode(b.getCode());
                codeFound.setNameProduct(b.getNameProduct());
                codeFound.setTotal(b.getTotal());
            }
        }
        return codeFound;
    }


    @Override
    public int validateAmount(int amount, int inventary) {
        Scanner ingreso = new Scanner(System.in);
        while (amount > inventary) {
            System.out.println("No possemos esa cantidad, haga el favor de ingresar una nueva cantiad");
            amount = ingreso.nextInt();
        }
        return amount;
    }

    @Override
    public BuyList  validateBuysNew(String code) {
        System.out.print("\nEscoja codigo el producto: ");
        code = input.next();
        BuyList getProduct = getBuyByCode(code);
        while (Objects.isNull(getProduct.getCode())) {
            System.out.println("No fue encontrado el codigo del producto por favor ingrese un nuevo codigo: ");
            String founded = input.next();
            getProduct = getBuyByCode(founded);
        }
        return getProduct;
    }

    @Override
    public void changeBuyProduct(List<Buy> newList, double acum, Clients clients, List<BuyList> buyLists) {
        Scanner enter = new Scanner(System.in);
        boolean founded = true;
        String product2 = "";
        while (founded) {
            System.out.println("Ingrese el codigo del producto que desea agregar");
            product2 = enter.next();
            boolean codeFounded = validatesBuyCodeTwo(product2,  buyLists);
            if (codeFounded) {
                founded = false;
            }
        }

        System.out.println("Ingrese la cantidad:");
        int cant = enter.nextInt();
        BuyList actProd = getBuyByCode(product2);
        listBuy(actProd.getCode(), actProd.getNameProducto(), actProd.getPrice() * cant, newList);
        System.out.println("\n");
        printCustomeData(clients);
        acum = printBuyTwo(listCar, acumulated);

        System.out.println("VALOR TOTAL " + acum);
    }



    @Override
    public boolean validateBuyCodes(String codigoProd, List<Buy> buyLists) {
        boolean founded = false;
        for (Buy buy : buyLists) {
            if (codigoProd.equals(buy.getCode())) {
                founded = true;
            }
        }
        return founded;
    }

    @Override
    public double printBuyTwo(List<Buy> listBuy, double acumu2) {
        System.out.println("-------------DETALLE FACTURA---------------");
        List<Buy> compras = listBuy;
        for (int i = 0; i < compras.size(); i++) {
            System.out.println(compras.get(i).getCode() + "  " + compras.get(i).getNameProduct() + " " + compras.get(i).getTotal());
            acumu2 = acumu2 + compras.get(i).getTotal();

        }
        return acumu2;
    }

    @Override
    public String validateEliminateBuy(String codProd, List<Buy> listCar, Scanner ingreso) {
        boolean encuentro = true;
        while (encuentro) {
            boolean codEnc = validateBuyCodes(codProd, listCar);
            if (!codEnc) {
                System.out.println("El codigo no esta en la lista de compras. Ingresse uno correcto");
                codProd = ingreso.next();
            }
            if (codEnc) {
                encuentro = false;
            }
        }
        return codProd;
    }

    @Override
    public void addElininateProducto() {
        System.out.println("Esta seguro de realizar esta compra  ?");
        String eliminarProd = input.next();
        boolean esCompraValida = true;
        while (esCompraValida) {
            if (eliminarProd.equals("s")) {
                break;
            } else {
                System.out.println("Deseas agregar o eliminar un nuevo produtoc. Digite \\\"A\\\" para agregar o \\\"E\\\"\" + \" para eliminar y F para finalizar");
                String digitoCompras = input.next();
                if (digitoCompras.equalsIgnoreCase("F")) {
                    esCompraValida = false;
                } else if (digitoCompras.equalsIgnoreCase("A")) {
                    listBuy=listBuys();
                    changeBuyProduct(  listCar, acumulated1,  clients,  listBuy);
                } else if (digitoCompras.equalsIgnoreCase("E")) {
                    System.out.println("Ingrese el codigo del producto para eliminar:");
                    String codigoProductoCompra = input.next();
                    String code =validateEliminateBuy(codigoProductoCompra, listCar, input);
                    System.out.println("\n\n");
                    int index = getComprasByCode2(code, listCar);
                    printCustomeData(clients);
                    double  acumulado2 = eliminatedProduct(listCar, index, acumulated);
                    System.out.println("VALOR TOTAL: " + acumulado2);
                } else {
                    throw new ExceptionCompras("Opcion invalidad. Por favor intente de nuevo");
                }
            }

        }

    }

    @Override
    public double eliminatedProduct(List<Buy> buyList, int index, double acum) {
        buyList.remove(index);
        System.out.println("Codigo" + "  " + "    " + "Nombre_producto" + " " + "Total ");
        for (Buy comprasObj : buyList) {
            System.out.println(comprasObj.getCode() + "     " + comprasObj.getNameProduct() + "     " + comprasObj.getTotal());
            acum = acum + comprasObj.getTotal();
        }
        return acum;

    }

    @Override
    public int getComprasByCode2(String codigoProductoCompra, List<Buy> listBuy) {
        int index = 0;
        for (int i = 0; i < listBuy.size(); i++) {
            if (Objects.equals(listBuy.get(i).getCode(), codigoProductoCompra)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean validatesBuyCodeTwo(String codePrdo, List<BuyList> actuaListCar) {
        boolean founded = false;
        for (BuyList buy :actuaListCar) {
            if (codePrdo.equals(buy.getCode())) {
                founded = true;
            }
        }
        return founded;
    }


    @Override
    public BuyList getBuyByCode(String code) {
        BuyList codeFound = new BuyList();
        for (BuyList p : listBuys()) {
            if (code.equals(p.code)) {
                codeFound.setCode(p.getCode());
                codeFound.setAmount(p.getAmount());
                codeFound.setPrice(p.getPrice());
                codeFound.setNameProducto(p.getNameProducto());
            }

        }
        return codeFound;
    }


    public List<BuyList> listBuys() {
        List<BuyList> buyLists = new ArrayList<>();
        BuyList buy = new BuyList();
        buy.code = "001";
        buy.nameProduct = "PC-PORTATIL";
        buy.amount = 200;
        buy.price = 450.00;
        buyLists.add(buy);
        BuyList buy2 = new BuyList();
        buy2.code = "002";
        buy2.nameProduct = "PC-ESCRITORIO";
        buy2.amount = 300;
        buy2.price = 700.0;
        buyLists.add(buy2);
        BuyList buy3 = new BuyList();
        buy3.code = "003";
        buy3.nameProduct = "CAMARAS DIGITALES";
        buy3.amount = 300;
        buy3.price = 650.00;
        buyLists.add(buy3);
        BuyList buy4 = new BuyList();
        buy4.code = "004";
        buy4.nameProduct = "CABLES USB";
        buy4.amount = 300;
        buy4.price = 10.00;
        buyLists.add(buy4);
        return buyLists;
    }

    @Override
    public Clients inputCustomerData() {
        return super.inputCustomerData();
    }

    @Override
    public void printCustomeData(Clients clients) {
        super.printCustomeData(clients);
    }
}
