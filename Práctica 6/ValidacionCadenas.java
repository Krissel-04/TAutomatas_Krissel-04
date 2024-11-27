
package com.mycompany.mavenproject1;

public class ValidacionCadenas {

    public String[] generarCadenasAb(int maxLength) {
        String[] cadenasAb = new String[maxLength];
        cadenasAb[0]="a";
        cadenasAb[1]="a_";
            for (int i = 2; i < maxLength; i++) {
                cadenasAb[i]="a" + "b".repeat(i); //Genera "a", "ab", "abb", "abbb", ...
            }
            return cadenasAb;
    }
    public String[] generarCadenasCd(int maxLength) {
            String[] cadenasCd = new String[maxLength];
            cadenasCd[0]="d";
            cadenasCd[1]="_d";
            for (int i = 2; i < maxLength; i++) {
                cadenasCd[i] = "c".repeat(i) + "d"; //Genera "d", "cd", "ccd", "cccd", ...
            }
            return cadenasCd;
    }
    public String[]combinacionCadenas(int maxLength  ){
        // Generar las cadenas válidas para ambos patrones
       String[] cadenasGeneradasAb = generarCadenasAb(maxLength);
       String[] cadenasGeneradasCd = generarCadenasCd(maxLength);

        // Combinar los arreglos
        String[] cadenasGeneradas = new String[cadenasGeneradasAb.length +cadenasGeneradasCd.length];
        System.arraycopy(cadenasGeneradasAb, 0, cadenasGeneradas, 0, cadenasGeneradasAb.length);
        System.arraycopy(cadenasGeneradasCd, 0, cadenasGeneradas, cadenasGeneradasAb.length, cadenasGeneradasCd.length);

        return cadenasGeneradas;
    }
    public boolean esValida(String cadena, String[] cadenasGeneradas) {
           int i=0;
           while (i<cadenasGeneradas.length) {
               if (cadena.equals(cadenasGeneradas[i])) {
                   return true; // La cadena es válida si está en el conjunto generado
               }
               i++; // Incrementar el índice
           }
           return false;  
    }  
}


