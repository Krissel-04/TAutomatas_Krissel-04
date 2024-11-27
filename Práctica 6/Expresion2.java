/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

public class Expresion2 {
    public boolean expresion2(String entrada) {
        
        if (entrada.length() > 1 && entrada.charAt(entrada.length() - 1) == 'b') {
            boolean todasSonA = true;
            for (int i = 0; i < entrada.length() - 1; i++) {
                if (entrada.charAt(i) != 'a') {
                    todasSonA = false;
                }
            }
            if (todasSonA) {
                return true;
            }
        }
        if (entrada.length() > 1 && entrada.charAt(entrada.length() - 1) == 'd') {
            boolean todasSonC = true;  
            for (int i = 0; i < entrada.length() - 1; i++) {
                if (entrada.charAt(i) != 'c') {
                    todasSonC = false; 
                }
            } 
            if (todasSonC) {
                return true;  
            }
        }
        return false;
    }
}
   
