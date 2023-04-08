/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_client_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class customer implements Runnable {
        private Socket socketCliente;
        private BufferedReader entrada;
        private PrintWriter salida;
        
        public customer(Socket socketCliente) {
            this.socketCliente = socketCliente;
        }
        
        public void run() {
            try {
                // Crear los streams de entrada y salida para el cliente
                entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                salida = new PrintWriter(socketCliente.getOutputStream(), true);
                
                // Leer los mensajes del cliente y enviarlos a todos los demás clientes
                String mensaje;
                while ((mensaje = entrada.readLine()) != null) {
                    System.out.println("Mensaje recibido de " + socketCliente.getInetAddress().getHostAddress() + ": " + mensaje);
//                    enviarATodos(mensaje);
                }
                
                // Cerrar los streams y el socket cuando el cliente se desconecta
                entrada.close();
                salida.close();
                socketCliente.close();
                System.out.println("Cliente desconectado");
            } catch (IOException e) {
                System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
            }
        }
        
        // Enviar un mensaje a todos los clientes conectados, excepto al cliente que envió el mensaje
//        private void enviarATodos(String mensaje) {
//            for (int i = 0; i < numClientes; i++) {
//                if (clientes[i] != null && clientes[i] != this) {
//                    clientes[i].salida.println(mensaje);
//                }
//            }
//        }
    
}
