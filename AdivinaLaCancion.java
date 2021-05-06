import javax.swing.*;
import java.util.Scanner;	
public class AdivinaLaCancion {
	public static void displayVacio(int n,int m){
		for (int i=0;i<n;i++) 
		{
			for (int j=0;j<m;j++)
			{
				System.out.print("  ");
			}
			System.out.println();
		}
 }

public static void imprimirDisplay(int n,int m){
		String simbolo = Math.random()>5?"*":" ";
		for (int i=0;i<n;i++) 
		{
			if(i+1==n)
			{
				simbolo = "#";

			}
			for (int j=0;j<m;j++)
			{
				System.out.print(i+simbolo);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int nombre_cancion = 1;
		int creditos = 40;
		int rondas = 0;
		Scanner ingreso = new Scanner(System.in);

		System.out.println();
				System.out.println("Bienvenido a Adivina la Canción, tienes las siguientes opciones para comenzar:");
				System.out.println("1. Comenzar Juego");
				System.out.println("2. Balance de créditos");	
				System.out.println("3. Reglas del juego");
				System.out.println("4. Tienda");
				System.out.println("5. Realizar Tutorial");
				System.out.println("6. Salir. \n");

				int opcion = ingreso.nextInt();

				if (opcion == 1){
					System.out.println("Cuantas canciones deseas adivinar? (1-22) ");
					rondas = ingreso.nextInt();

					if (rondas == 1) {
						//reproduce la primer cancion//
						System.out.println("¿Como se llama esta cancion? \n");

						int respuesta = ingreso.nextInt();

					if (respuesta == nombre_cancion) {
						System.out.println("Has acertado!");
						creditos = creditos + 10;
						System.out.println("Tus creditos ahora son: " + creditos);
					} 
					else{
						System.out.println("No has acertado!");
						creditos = creditos - 5;
					}
						
					}
					//se reproduce la cancion 
					 
				}

				else if (opcion == 2) {
					System.out.println("Tu numero de creditos es: " + creditos);
				
				}
				else if (opcion == 3) {
					System.out.println("Las reglas del juego son: \n 1.Solamente se tienen 3 intentos para adivinar la cancion. \n 2.si no se tienen los creditos no podra continuar. \n 3. El nombre le cancion debe ser escrito completo y con buena ortografia \n 4. se puede retirar en cualquier momento con los creditos que al final le daran un puntaje.");

					
				}
				else if (opcion == 4) {
					System.out.println("La tienda no se encuentra disponible en este momento.");
					
				}

		

		


	}






}

















/*

	String mensaje, mensajeMayus;
		int creditos = 100, numero;
		mensaje = JOptionPane.showInputDialog("Ingrese un mensaje: ");
		System.out.println("El mensaje ingresado es: " + mensaje);
	
	mensajeMayus = mensaje.toUpperCase();
		System.out.println("Su mensaje en mayúsculas es: " + mensajeMayus);

		displayVacio(5,6);

		JOptionPane.showMessageDialog(null, "Comienza el juego, tienes 100 creditos que podras usar para ayudas");
		JOptionPane.showMessageDialog(null, "¿Este coro pertenece a qué canción?");
		JOptionPane.showMessageDialog(null, "Ingresa un número del 1 al 5 dependendiendo de la canción");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero del 1 al 5"));


if ((numero < 1) || (numero > 5)){

			JOptionPane.showMessageDialog(null, "Has ingresado un número erróneo");
		}
		else {
		switch ((numero)) {	

			case 1 : System.out.println("Camisa Negra - Juanes");
			break;

			case 2 : System.out.println("Rayando el sol - Maná");
			break;

			case 3 : System.out.println("Gasolina - Daddy Yankee");
			break;

			case 4 : System.out.println("Titanic - ");
			break;

			case 5 : System.out.println("Mis Ojos Lloran por ti");
			break;

			default : System.out.println("El numero ingresado no es válido");
			break;
		}

			}
*/