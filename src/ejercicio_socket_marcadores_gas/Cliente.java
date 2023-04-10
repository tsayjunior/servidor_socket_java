/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_socket_marcadores_gas;

//import ejercicio_sockets_ddr_3.*;
//import java.io.DataInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Cliente extends Observable implements Runnable{
    
    private int puerto;
    private Socket sc;
    private String HOST;
    private DataInputStream dis;
    private DataOutputStream out;

            
    public Cliente(int puerto) {
        this.puerto = puerto;
    }
    
    public void initCliente(){
        try {
            sc = new Socket(this.HOST, this.puerto);
            dis = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            System.out.println("entra a init cliente");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
//        final String HOST = "127.0.0.1";
//        
//            DataInputStream dis;
            
        try {
//            Socket sc = new Socket(HOST, puerto);
//            dis = new DataInputStream(sc.getInputStream());
//            System.out.println("entra a cliente recien inicializado");

//                System.out.println("antes de ois");
//            ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
//                System.out.println("desoues de ois");
            String nombre;
            double valor;
            
            while (true) {                
                System.out.println("antes de nombre");
                nombre = dis.readUTF();
                System.out.println("despues de nombre");
                this.setChanged();
                this.notifyObservers(nombre);
                this.clearChanged();
                
                valor = dis.readDouble();
                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
                
//                System.out.println("antes de gasolinera");
//                Gasolinera g = (Gasolinera) ois.readObject();
//                System.out.println("luego de gasolinera");
//                this.setChanged();
//                this.notifyObservers(g);
//                this.clearChanged();
            }
            
        } catch (IOException ex) {
            System.out.println("entra a IOException ex");
            Logger.getLogger(serviidor_tcp.Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (ClassNotFoundException ex) {
//            System.out.println("entra a ClassNotFoundException ex");
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public void sendMessageToServe(String[] nombres, double[] valores){
        
        try {
            
            out = new DataOutputStream(sc.getOutputStream());
            int auxCant = nombres.length;
                out.writeUTF("auxCant");
                out.writeInt(auxCant);
                System.out.println("auxCant => " + auxCant);
            for (int i = 0; i < auxCant; i++) {
                System.out.println(nombres[i]);
                System.out.println(valores[i]);
                out.writeUTF(nombres[i]);
                out.writeDouble(valores[i]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
