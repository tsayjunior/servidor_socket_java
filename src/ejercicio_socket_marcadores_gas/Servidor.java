/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_socket_marcadores_gas;

//import ejercicio_sockets_ddr_3.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviidor_tcp.Serviidor;

/**
 *
 * @author hp
 */
public class Servidor implements Runnable{

    private ArrayList<Socket> Clientes;
    private int puerto;
    private int auxCant;
    
    public Servidor(int puerto) {
        this.puerto = puerto;
        this.Clientes = new ArrayList();
        this.auxCant = 0;
    }
    
    
    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc= null;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor Iniciado");
            while(true){
                sc = servidor.accept();//este metodo se queda a la espera, esperando en esa linea, 
                //no ejecutara nada mas, hasta que venga algo
                //esto que devuelve es el socket del cliente, el socket del cliente es este
                System.out.println("cliente Conectado");
                Clientes.add(sc);
                
                
//                in = new DataInputStream(sc.getInputStream());
                System.out.println("entra a while ");
                //leo el mensaje que me envia
//                String mensaje = in.readUTF(); //esto se queda a la espera a que el cliente envie algo
//                int cant = in.readInt();
//                double aux = in.readDouble();
//                getOfClient(mensaje, cant, aux);
                
//                System.out.println(mensaje);
            }
        } catch (IOException ex) {
            Logger.getLogger(Serviidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getOfClient(String mensaje, int cant, double aux){
        System.out.println("entra a getOfClient");
        if(auxCant == 0){
            System.out.println("mensaje = > " + mensaje);
            System.out.println("cant = > " + cant);
            System.out.println("aux = > " + aux);
        }else{
            
        }
    }
    public void EnviarInfoObject(Gasolinera g){
        System.out.println("entra a EnviarInfoObject");
        for (Socket sock : Clientes) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
                oos.writeObject(g);
                oos.close(); 
            } catch (IOException ex) {
                System.out.println("entra a IOException ex de servidor");
               Logger.getLogger("entra xd", "prueba");
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        System.out.println("salir a EnviarInfoObject");
    }
    public void EnviarInfo(String[] nombres, double[] valores){
        
        System.out.println("entra a EnviarInfo");
        for (Socket sock : Clientes) {
            try {
                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                for (int i = 0; i < nombres.length; i++) {
                    dos.writeUTF(nombres[i]);                    
//                    dos.writeUTF("prueba que es para que vaya a consola");

                    dos.writeDouble(valores[i]);
                }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println("salir a EnviarInfo");
    }
}
