#include <stdio.h> 
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define tamMaxAlfabeto 10
#define maxLongitudCadenas 20

int existeCadena(char cadenas[][maxLongitudCadenas], int totalCadenas, char *nuevaCadena) {
    for (int i = 0; i < totalCadenas; i++) {
        if (strcmp(cadenas[i], nuevaCadena) == 0) {
            return 1;  
        }
    }
    return 0;
}

void cerraduraKleene(char alfabeto[][maxLongitudCadenas], int numElementos, int maxLongitud, char *cadena) {
    int longitudCadena = rand() % (maxLongitud + 1); 
    cadena[0] = '\0';
    for (int i = 0; i < longitudCadena; i++) {
        int indiceAleatorio = rand() % numElementos;  
        strcat(cadena, alfabeto[indiceAleatorio]);
    }
}

int main() {
    int numElementosAlfabeto, maxCadenas, maxLongitud;
    char alfabeto[tamMaxAlfabeto][maxLongitudCadenas];  
    srand(time(NULL)); 
    printf("-----------------------\n");
    printf("| Cerradura de Kleene |\n");
    printf("-----------------------\n");
    printf("Introduce el número de elementos del alfabeto: ");
    scanf("%d", &numElementosAlfabeto);
    printf("Introduce los elementos del conjunto (separados por espacios):\n");
    for (int i = 0; i < numElementosAlfabeto; i++) {
        scanf("%s", alfabeto[i]);
    }
    printf("Introduce la cantidad de cadenas que deseas generar: ");
    scanf("%d", &maxCadenas);
    printf("Introduce la longitud máxima de las cadenas: ");
    scanf("%d", &maxLongitud);
    char cadenasGeneradas[maxCadenas][maxLongitudCadenas];
    int totalGeneradas = 0;
    strcpy(cadenasGeneradas[totalGeneradas++], "");
    while (totalGeneradas < maxCadenas) {
        char cadena[maxLongitudCadenas] = "";  
        cerraduraKleene(alfabeto, numElementosAlfabeto, maxLongitud, cadena);

        if (!existeCadena(cadenasGeneradas, totalGeneradas, cadena)) {
            strcpy(cadenasGeneradas[totalGeneradas], cadena);
            totalGeneradas++;
        }
    }  
    printf("\nCadenas generadas usando la cerradura de Kleene:\n{ ");
    for (int i = 0; i < totalGeneradas; i++) {
        printf("\"%s\"", cadenasGeneradas[i]);
        if (i < totalGeneradas - 1) {
            printf(", ");
        }
    }
    printf(" }\n");

    return 0;
}
