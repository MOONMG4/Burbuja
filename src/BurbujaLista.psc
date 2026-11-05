Algoritmo BurbujaLista
	
	Definir N, i, j, auxiliar Como Entero;
	Definir tarjetas Como Entero;
	
	Escribir "Ingrese la cantidad de tarjetas (N):";
	Leer N;
	
	Dimension tarjetas[N];
	
	Para i = 1 Hasta N Hacer
		Escribir "Ingrese el valor de la tarjeta ", i, ":";
		Leer tarjetas[i];
	Fin Para
	
	Para i = 1 Hasta (N - 1) Hacer
		Para j = 1 Hasta (N - i) Hacer
			Si (tarjetas[j] > tarjetas[j+1]) Entonces
				auxiliar = tarjetas[j];
				tarjetas[j] = tarjetas[j+1];
				tarjetas[j+1] = auxiliar;
			Fin Si
		Fin Para
	Fin Para
	
	Escribir "Lista ordenada:";
	Para i = 1 Hasta N Hacer
		Escribir Sin Saltar tarjetas[i], " ";
	Fin Para
	Escribir "";
	
FinAlgoritmo