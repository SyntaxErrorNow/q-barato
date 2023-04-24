package com.management.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;


import javax.swing.JTextField;



public class Utils {

    public static Integer [] generacionDeDias(int mes){
        Integer[] diasDisponibles1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        Integer[] diasDisponibles2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        Integer[] diasDisponibles3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
        HashMap<Integer, Integer []> opciones = new HashMap<>();
        for(Integer i = 1; i <= 12; i++){
            if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
                opciones.put(i, diasDisponibles1);
            }
            if(mes==4 || mes==6 || mes==9 || mes==11){
                opciones.put(i, diasDisponibles2);
            }
            if(mes==2){
                opciones.put(i, diasDisponibles3);
            }
        }
        return opciones.get(mes);
    }


    public static void numInteger(JTextField num){
        num.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent event){
                char c = event.getKeyChar();
                if(!Character.isDigit(c)){
                    event.consume();
                }
            }
        });
    }

    public static void numDouble(JTextField num){
        num.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent event){
                char c = event.getKeyChar();
                if(!Character.isDigit(c) && c != '.'){
                    event.consume();
                }
            }
        });
    }

}
