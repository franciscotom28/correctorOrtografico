/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correctorortografico;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Diccionarios {

    static private ArrayList<String> diccionarioESP = new ArrayList<String>();
    static private ArrayList<String> diccionarioENG = new ArrayList<String>();
    static private ArrayList<String> diccionarioGER = new ArrayList<String>();

    public static void agregaDiccionarioESP(String palabra) {
        diccionarioESP.add(palabra);
        for(int f=0;f<diccionarioESP.size();f++){
            if (f==diccionarioESP.size()-1)
                System.out.println("Palabra agregada al diccionario español: "+diccionarioESP.get(f));
        }
        System.out.println("Diccionario español: "+diccionarioESP);
        System.out.println();
        salir(palabra);
    }

    public static void agregaDiccionarioENG(String palabra) {
        diccionarioENG.add(palabra);
        for(int f=0;f<diccionarioENG.size();f++){
            if (f==diccionarioENG.size()-1)
                System.out.println("Palabra agregada al diccionario ingles: "+diccionarioENG.get(f));
        }
        System.out.println("Diccionario inglés: "+diccionarioENG);
        System.out.println();
        salir(palabra);
    }

    public static void agregaDiccionarioGER(String palabra) {
        diccionarioGER.add(palabra);
        for(int f=0;f<diccionarioGER.size();f++){
            if (f==diccionarioGER.size()-1)
                System.out.println("Palabra agregada al diccionario alemán: "+diccionarioGER.get(f));
        }
        System.out.println("Diccionario alemán: "+diccionarioGER);
        System.out.println();
        salir(palabra);
    }
    
    public static void salir(String palabra){
        JOptionPane.showMessageDialog(null,"Palabra '"+palabra+"' agregada al diccionario");
    }
}
