/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorSocketEst;

import java.util.EventObject;

/**
 *
 * @author Junior Javier
 */
public class DataEvent extends EventObject {
    
    public static String data;

    public DataEvent(Object o) {
        super(o);
    }
}
