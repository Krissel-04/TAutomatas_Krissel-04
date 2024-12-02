/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Hp
 */
public class DigitosCadenas {
     
     public boolean isDigit (String cadena){
        
        boolean esSoloDigitos = true;
        int i=0;
        while(i<cadena.length()&&esSoloDigitos){
            if (!Character.isDigit(cadena.charAt(i))) {
                esSoloDigitos = false;

            }
            i++;
        }
        return esSoloDigitos;
    }
}
