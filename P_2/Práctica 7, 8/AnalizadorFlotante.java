package gramatica;

public class AnalizadorFlotante {

    private int index;               // Índice para recorrer la cadena
    private String cadena;           // Cadena a analizar
    private StringBuilder pasos;     // Para registrar los pasos

    public AnalizadorFlotante() {
        pasos = new StringBuilder(); // Inicializamos los pasos
    }

    public boolean analizar(String cadena) {
        this.cadena = cadena;
        this.index = 0;
        pasos.setLength(0); // Limpia los pasos de análisis previos

        pasos.append("Analizando la cadena: ").append(cadena).append("\n");

        // Realiza el análisis con la regla principal y verifica que se procesó toda la cadena
        if (F() && index == cadena.length()) {
            pasos.append("Resultado: La cadena es válida.\n");
            return true;
        } else {
            pasos.append("Resultado: La cadena no es válida.\n");
            return false;
        }
    }

    public String getPasos() {
        return pasos.toString(); // Devuelve los pasos registrados
    }

    // F -> Es.En
    private boolean F() {
        pasos.append("F -> Es . En\n");
        int inicio = index;
        if (Es() && punto('.') && En()) {
            return true;
        }
        index = inicio;
        return false;
    }

    // Es -> SEn
    private boolean Es() {
        pasos.append("Es -> S En\n");
        int inicio = index;
        if (S() && En()) {
            return true;
        }
        index = inicio;
        return false;
    }

    // En -> DR
    private boolean En() {
        pasos.append("En -> D R\n");
        int inicio = index;
        if (D() && R()) {
            return true;
        }
        index = inicio;
        return false;
    }

    // R -> DR | ε
    private boolean R() {
        pasos.append("R -> D R | ε\n");
        int inicio = index;

        // R -> DR
        if (D() && R()) {
            return true;
        }

        // R -> ε (vacío)
        index = inicio;
        pasos.append("R -> ε\n");
        return true;
    }

    // D -> 0...9
    private boolean D() {
        if (index < cadena.length() && Character.isDigit(cadena.charAt(index))) {
            pasos.append("D -> ").append(cadena.charAt(index)).append("\n");
            index++;
            return true;
        }
        return false;
    }

    // S -> + | - | ε
    private boolean S() {
        if (index < cadena.length() && (cadena.charAt(index) == '+' || cadena.charAt(index) == '-')) {
            pasos.append("S -> ").append(cadena.charAt(index)).append("\n");
            index++;
            return true;
        }
        pasos.append("S -> ε\n");
        return true; // vacío
    }

    // Consumir un carácter específico (como '.')
    private boolean punto(char p) {
        if (index < cadena.length() && cadena.charAt(index) == p) {
            pasos.append("Punto: ").append(p).append("\n");
            index++;
            return true;
        }
        return false;
    }
}
