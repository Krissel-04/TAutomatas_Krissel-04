
package gramatica;

public class NewClass {
    public String procesarCadena(String cadena) {
        boolean valida = false;
        char array[] = cadena.toCharArray();
        String salida = " ( q0, " + cadena + ", ε )" + "\n" +
                        " ( q1, " + cadena + ", $ )" + "\n" +
                        " ( q2, " + cadena + ", lD$ )" + "\n";

        for (int index = 0; index < array.length; index++) {
            String restante = cadena.substring(index + 1);
            String restanteFormato = restante.isEmpty() ? "ε" : restante;

            if (esLetra(array[index])) {
                salida += " ( q2, " + cadena.substring(index) + ", LRI$ )" + "\n" +
                          " ( q2, " + cadena.substring(index) + ", " + array[index] + "RI$ )" + "\n" +
                          " ( q2, " + restanteFormato + ", RI$ )" + "\n";
                valida = true;
            } else if (index > 0 && esDigito(array[index])) {
                salida += " ( q2, " + cadena.substring(index) + ", DRI$ )" + "\n" +
                          " ( q2, " + cadena.substring(index) + ", " + array[index] + "RI$ )" + "\n" +
                          " ( q2, " + restanteFormato + ", RI$ )" + "\n";
                valida = true;
            } else if (array[index] == '_') {
                salida += " ( q2, _" + cadena.substring(index + 1) + ", _RI$ )" + "\n" +
                          " ( q2, " + restanteFormato + ", RI$ )" + "\n";
                valida = true;
            } else {
                valida = false; // Si encuentra un carácter inválido, se marca como no válida.
                break; // Salimos del bucle inmediatamente.
            }
        }

        if (valida) {
            salida += " ( q2, ε, $ )" + "\n" + " ( q3, ε, ε )" + "\n\n" + " Cadena válida";
        } else {
            salida += "\n\n Cadena no válida";
        }
        return salida;
    }

    public static boolean esLetra(char c) {
        return Character.isLetter(c);
    }

    public static boolean esDigito(char c) {
        return Character.isDigit(c);
    }
}
