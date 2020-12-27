/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.tyson9tech.fonctions;

/**
 *
 * @author tyson
 */
public class Fonctions {
    
    public static String generateCode(String string1, String string2, int size){
        
        int random1 = (int) (Math.random() * 99) + 1;
        int random2 = (int) (Math.random() * 99) + 1;
        
        String code = string1.substring(0, 1)+string2.substring(0, 1)
                      +"-"+(size + 1)+random1+random2;
        return code;
    }
}
