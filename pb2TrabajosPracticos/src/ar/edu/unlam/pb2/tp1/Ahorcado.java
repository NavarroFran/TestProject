package ar.edu.unlam.pb2.tp1;

import java.util.Scanner;
public class Ahorcado {
	public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			Integer a;
			Integer b;
			Integer opcion;
			Integer resultado;
			do{
				System.out.println("Ingrese su operacion \n1 para sumar \n2 para restar \n3 para multiplicar \n4 para dividir ");

			opcion = teclado.nextInt();
			}while(opcion < 1 && opcion > 4) ;
				System.out.println("Ingrese el primer numero");
			a = teclado.nextInt();
			System.out.println("Ingrese el segundo numero");
			b = teclado.nextInt();
			/*if(opcion.equals(1)){
				resultado = a + b;
			}else if(opcion.equals(2)){
				resultado = a - b;
			}else if(opcion.equals(3)){
				resultado = a * b;
			}else{
				resultado = a / b;
			}*/
			switch(opcion) {
			case 1:
				resultado = a + b;
				break;
			case 2:
				resultado = a - b;
				break;
			case 3:
				resultado = a * b;
				break;
			case 4:
				resultado = a / b;
				break;
			}
			System.out.println("El resultado es " + resultado.toString());
			}
}
