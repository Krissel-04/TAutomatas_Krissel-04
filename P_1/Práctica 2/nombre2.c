#include <stdio.h>
#include <string.h>

void k(char *nombre);
void r(char *nombre);
void i(char *nombre);
void s1(char *nombre);
void s2(char *nombre);
void e(char *nombre);
void l(char *nombre);

int main() {
    char nombre[20]=""; 
    k(nombre);
    printf("%s", nombre); 
    return 0;
}

void k(char *nombre) {
    strcat(nombre, "K");
    r(nombre);
}

void r(char *nombre) {
    strcat(nombre, "r");
    i(nombre);
}

void i(char *nombre) {
    strcat(nombre, "i");
    s1(nombre);
}

void s1(char *nombre) {
    strcat(nombre, "s");
    s2(nombre);
}

void s2(char *nombre) {
    strcat(nombre, "s");
    e(nombre);
}

void e(char *nombre) {
    strcat(nombre, "e");
    l(nombre);
}

void l(char *nombre) {
    strcat(nombre, "l");
}
