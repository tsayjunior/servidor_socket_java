/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_client_thread;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class server {
    private ArrayList<Socket> Clientes;
    private int puerto;

    public server(int puerto) {
        this.puerto = puerto;
        this.Clientes = new ArrayList();
    }
    
    
}
