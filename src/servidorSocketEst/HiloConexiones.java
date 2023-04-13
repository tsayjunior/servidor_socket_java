/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Junior Javier
 */
public class HiloConexiones extends Thread {

    Socket socket;
    ServerSocket servidor;
    DataInputStream in;
    DataOutputStream out;

    // ----------------- eventos ----------------------------
    protected EventListenerList listenerList = new EventListenerList();

    public void addMyEventListener(SocketEventListenner listener) {
        listenerList.add(SocketEventListenner.class, listener);
    }

    public void removeMyEventListener(SocketEventListenner listener) {
        listenerList.remove(SocketEventListenner.class, listener);
    }

    void fireMyEvent(ConnectEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i + 2) {
            if (listeners[i] == SocketEventListenner.class) {
                ((SocketEventListenner) listeners[i + 1]).myEventOccurred(evt);
            }
        }
    }
    // fin eventos
    public HiloConexiones(ServerSocket servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {

        try {
            System.out.println("entra a run en cliente Conexiones ");
            while (true) {
                socket = servidor.accept();

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                //envio mensaje del cliente
//                out.writeUTF("Hola mundo desde Hilo Conexiones !!!");
                //Recibo el mensaje del servidor
                String mensaje = in.readUTF();
                System.out.println(mensaje);

            }
        } catch (IOException ex) {
            Logger.getLogger(HiloConexiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
