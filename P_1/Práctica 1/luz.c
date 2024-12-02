#include <stdio.h>

//Krissel de Jesús Reyes Rivera

void encendido(int opcion);
void apagado(int opcion);

int main(){
	int opcion;
	printf("Interruptor \n\n");
	printf("Selecciona una opción:\n");
	printf("-------------------------\n");
	printf("| Encender=1 | Apagar=0 |\n");
	printf("-------------------------\n");
	do{
	scanf("%d", &opcion);
	switch(opcion){
		case 1:
		encendido(opcion);
			break;
		case 0:
		apagado(opcion);
			break;
		}
	}while(opcion==1 || opcion==0);	
	return 0;
}	

 void encendido(int opcion){
	printf("El foco está encendido\n");
}
void apagado(int opcion){
	printf("El foco está apagado\n");
}
