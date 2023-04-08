/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_client_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class server {

    // Puerto que se utilizará para la conexión de clientes
    private static final int PUERTO = 12345;
    
    // Array que almacenará a los clientes conectados
    private static customer[] clientes = new customer[10];
    private static int numClientes = 0;
    
    public static void main(String[] args) {
        try {
            // Crear un socket del servidor en el puerto especificado
            ServerSocket servidorSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado en el puerto " + PUERTO);
            
            // Esperar a que los clientes se conecten
            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Nuevo cliente conectado desde " + clienteSocket.getInetAddress().getHostAddress());
                
                // Crear un hilo para manejar la conexión del cliente
                customer cliente = new customer(clienteSocket);
                clientes[numClientes] = cliente;
                numClientes++;
                Thread hiloCliente = new Thread(cliente);
                hiloCliente.start();
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    
}
}
