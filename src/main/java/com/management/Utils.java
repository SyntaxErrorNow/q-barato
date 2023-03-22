package com.management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;


import javax.swing.JTextField;



public class Utils {

    public static String [] opciones(String categoria){
        String [] bebidas = {"jugos", "gaseosas", "alcoholica", "naturales", "derivado de lacteos"};
        String [] comestibles = {"dulces", "postres", "helados", "frituras", "derivados de cereales"};
        String [] despensas = {"verduras", "frutas", "condimentos", "carne", "lacteos", "cereales"};
        String [] aseo = {"detergentes", "lavavajillas", "utensilios", "desinfectantes"};
        String [] cuidadoPersonal = {"jabones", "shampoo", "cremas", "productos dentales", "cuidado intimo"};
        String [] otros = {"otros"};
        HashMap<String, String []> opciones = new HashMap<>();
        opciones.put("despensas", despensas);
        opciones.put("comestibles", comestibles);
        opciones.put("bebidas", bebidas);
        opciones.put("aseo", aseo);
        opciones.put("cuidado personal", cuidadoPersonal);
        opciones.put("otros", otros);
        return opciones.get(categoria);
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
