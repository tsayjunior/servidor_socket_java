/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Junior Javier
 */
public interface SocketEventListenner extends EventListener {
    
  public void onConnected(ConnectEvent evt);
  public void onReader(DataEvent evt);

  public void myEventOccurred(ConnectEvent evt);

}
