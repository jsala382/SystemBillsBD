package org.interfaces;


import org.entity.Clients;

public interface CustomerData {

    Clients getClientsByIdentification(String identification);

    void saveClients(Clients clients);

    void getClient();
    void eliminateClients(String identification);
    void updateClientsByIdentification(String  identification,String email,String phone);



}
