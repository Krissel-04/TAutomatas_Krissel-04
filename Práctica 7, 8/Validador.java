/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gramaticas;

public class Validador {
    private static int index;
    public static StringBuilder pasos;

    public static String getPasos() {
        return pasos.toString();
    }

    public static boolean validarCadena(String cadena) {
        index = 0;
        pasos = new StringBuilder();
        if (C(cadena) && index == cadena.length()) {
            return true;
        }
        return false;
    }

    public static boolean C(String cadena) {
        int inicio = index;
        if (F(cadena)) {
            if (Ex(cadena) && Es(cadena)) {
                pasos.insert(0, "F Ex Es\n");
                return true;
            }
            pasos.insert(0, "F\n");
            return true;
        }
        index = inicio;
        return false;
    }

    public static boolean F(String cadena) {
        int inicio = index;
        if (Es(cadena)) {
            pasos.insert(0, "Es\n");
            if (punto('.', cadena) && En(cadena)) {
                pasos.insert(0, "Es.En\n");
                return true;
            } else {
                return true;
            }
        }
        index = inicio;
        return false;
    }

    public static boolean Es(String cadena) {
        int inicio = index;
        if (S(cadena) && En(cadena)) {
            return true;
        }
        index = inicio;
        return false;
    }

    public static boolean S(String cadena) {
        if (index < cadena.length() && (cadena.charAt(index) == '+' || cadena.charAt(index) == '-')) {
            pasos.append("S ->").append(cadena.charAt(index)).append("\n");
            index++;
            return true;
        }
        pasos.append("S -> ε\n");
        return true;
    }

    public static boolean En(String cadena) {
        int inicio = index;
        if (D(cadena) && R(cadena)) {
            return true;
        }
        index = inicio;
        return false;
    }

    public static boolean D(String cadena) {
        if (index < cadena.length() && Character.isDigit(cadena.charAt(index))) {
            pasos.append("D -> ").append(cadena.charAt(index)).append("\n");
            index++;
            return true;
        }
        return false;
    }

    public static boolean R(String cadena) {
        int inicio = index;
        if (index < cadena.length() && D(cadena)) {
            pasos.append("R -> DR\n");
            if (R(cadena)) {
                return true;
            }
        } else {
            pasos.append("R -> ε\n");
            return true;
        }
        index = inicio;
        return false;
    }

    public static boolean Ex(String cadena) {
        if (index < cadena.length() && (cadena.charAt(index) == 'E' || cadena.charAt(index) == 'e')) {
            pasos.append("Ex -> ").append(cadena.charAt(index)).append("\n");
            index++;
            return true;
        }
        pasos.append("Ex -> ε\n");
        return false;
    }

    public static boolean punto(char p, String cadena) {
        if (index < cadena.length() && cadena.charAt(index) == p) {
            pasos.append("punto -> ").append(p).append("\n");
            index++;
            return true;
        }
        return false;
    }
}
