package org.view;

import org.entity.Clients;
import org.interfaces.clients.ClientsImpl;

import java.util.Scanner;

public class OptionMenu {
    public void viewMenuOption() {
        boolean state = true;
        Scanner input = new Scanner(System.in);
        ClientsImpl clientsImpl = new ClientsImpl();
        String identification = "";
        Clients clients;
        while (true) {
            System.out.println("FCTURAR (1) / PRODUCTOS (2) /  CLIENTES (3)");
            System.out.println("Ingrese una opcion:");
            int option = input.nextInt();
            switch (option) {
                case 0:
                    state = false;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Para agregar un cliente presione \'A\' , para eliminar presion \"E\"  y para actualizar presione \"U\"");
                    char option2 = input.next().charAt(0);
                    switch (option2) {
                        case 'A':
                            clients = clientsImpl.inputCustomerData();
                            clientsImpl.saveClients(clients);
                            clientsImpl.getClient();
                            break;
                        case 'E':
                            System.out.println("Ingrese el numero de identificacion");
                            identification = input.next();
                            clientsImpl.eliminateClients(identification);
                            System.out.println("Eliminar");
                            break;
                        case 'U':
                            System.out.println("Ingrese la identificacion");
                            identification = input.next();
                            System.out.println("Ingrese el email");
                            String email = input.next();
                            System.out.println("Ingrese el telefono");
                            String phone = input.next();
                            clientsImpl.updateClientsByIdentification(identification, email, phone);
                            clientsImpl.getClient();
                            break;
                        default:
                    }
                    clientsImpl.getClient();
                    break;
                default:
                    System.exit(1);
            }

        }
    }
}
