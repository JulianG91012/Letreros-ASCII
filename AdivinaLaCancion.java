import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class AdivinaLaCancion{

	public static String convertirUnicode(String letra,String cadena){
		
		StringBuilder str = new StringBuilder(cadena);
		int indice = -1;
		char caracter = 0;
		indice = str.lastIndexOf(letra);
		
		if(indice>=0 )
		{
			switch(letra){
				case "Á": caracter = '\u00C1';
						  break;
				case "á": caracter = '\u00E1';
					      break;
				case "é": caracter = '\u00E9';
					      break;
				case "í": caracter = '\u00ED';
					      break;
		        case "ó": caracter = '\u00F3';
					      break;
			    case "ú": caracter = '\u00FA';
					      break;
				case "ñ": caracter = '\u00F1';
					      break;
			}
			// System.out.println("\\u" + Integer.toHexString('÷' | 0x10000).substring(1));
			str.replace(indice,indice+1,""+caracter);
		}

		return str.toString();
	}

	public static void imprimir(String cadena)
	{
		String str; 
		str = convertirUnicode("Á",cadena);
		str = convertirUnicode("á",str);
		str = convertirUnicode("é",str);
		str = convertirUnicode("í",str);
		str = convertirUnicode("ó",str);
		str = convertirUnicode("ú",str);
		str = convertirUnicode("ñ",str);

		System.out.println(str);
	}

	public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
		StringBuilder str = new StringBuilder();

		for(int i = inicio; i<=fin; i++)
		{
			str.append(data[i]+"\n");
		}

		return str;
	}

	public static void menu(){
       System.out.println("                                                            ||||                                            ");
	   System.out.println("                                                   |||||||||||||                                            ");
	   System.out.println("                                             |||||||||||||||||||                                            ");
	   System.out.println("                                      ||||||||||||||||       |||                                            ");
	   System.out.println("                                      ||||||||||             |||                                            ");
	   System.out.println("                                      |||                  |||||                                            ");
	   System.out.println("                                      |||         ||||||||||||||                                            ");
	   System.out.println("                                      |||||||||||||||||||||  |||                                            ");
	   System.out.println("                                      ||||||||||||           |||                                            ");
	   System.out.println("                              ||||||||||              ||||||||||                                            ");
	   System.out.println("                            ||||||||||||            ||||||||||||                                            ");
	   System.out.println("                           |||||    ||||          ||||||  ||||||                                            ");
	   System.out.println("                           |||       |||         |||||       |||                                            ");
	   System.out.println("                           |||       |||        ||||||       |||                                            ");
	   System.out.println("                           |||      ||||         |||||      ||||                                            ");
	   System.out.println("                           |||||||||||             ||||||||||||                                            ");
	   System.out.println("                                                                                                     ");
	   System.out.println("          		                                                                                  ");
       System.out.println("                                                                                                 ");
       System.out.println("                        _ _       _               _          _____                 _             ");
       System.out.println("               /\\      | (_)     (_)             | |        / ____|               (_)            ");
       System.out.println("              /  \\   __| |___   ___ _ __   __ _  | | __ _  | |     __ _ _ __   ___ _  ___  _ __  ");
       System.out.println("             / /\\ \\ / _` | \\ \\ / / | '_ \\ / _` | | |/ _` | | |    / _` | '_ \\ / __| |/ _ \\| '_ \\ ");
       System.out.println("            / ____ \\ (_| | |\\ V /| | | | | (_| | | | (_| | | |___| (_| | | | | (__| | (_) | | | |");
       System.out.println("           /_/    \\_\\__,_|_| \\_/ |_|_| |_|\\__,_| |_|\\__,_|  \\_____\\__,_|_| |_|\\___|_|\\___/|_| |_|");
       System.out.println("                                                                                               ");
       System.out.println("                                                                                                 ");
				  imprimir("	|        Bienvenido, tienes las siguientes opciones para comenzar:                      |");
				  imprimir("	|                           1. Comenzar juego		 	                        |");
				  imprimir("	|                           2. Balance de créditos		                        |");
				  imprimir("	|                           3. Reglas del juego		                                |");
				  imprimir("	|                           4. Tienda de pistas				                        |");
				  imprimir("	|                           5. Realizar tutorial		                        |");
				  imprimir("	|                           6. Salir.					                |");
		System.out.println("	|_______________________________________________________________________________________|");
		System.out.print("	AdivinaLaCancion$ ");
	}

	public static void main(String[] args) {
		
		//AnsiConsole.systemInstall();
		
		Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int respuesta = 0;
		int opcion1 = 0;
		int opcion2 = 0;
		int creditos = 50;
		int i = 0;
		double SeleccionMultiple = 0;
		double valorDado = 0;
		double valorDado2 = 0;
		double valorDado3 = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;

		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

		try{
			
			do{

				// imprimir(""+RandomHelper.random(1,10));

				System.out.println();
				//TODO: Terminar la funcion para que imprima todos los caracteres especiales que use el programa
				menu();
				//TODO: Ojo falta validar la entrada de datos
				//TODO: Recuerde usar el helper ConsoleInput y validar
				centinela = ConsoleInput.getInt();
				if (centinela == 1){
					while (i < 2){
					
					 valorDado = (Math.random()*(info_canciones.length-1) + 1);
					 int value = (int)Math.round(valorDado);

					 audio.seleccionarCancion(info_canciones[value][ConsoleData.RUTA_CANCION]);
					 audio.reproducir();

					 SeleccionMultiple = Math.random()*2 + 1;
					 int MultipleSeleccion = (int)Math.round(SeleccionMultiple);
					 
					 

					 switch(MultipleSeleccion){
					 	case 1:
					 		 System.out.println("¿Como se llama esta canción? \n");
							 valorDado2 = (Math.random()*(info_canciones.length-1) + 1);
							  opcion1 = (int)Math.round(valorDado2);
							 valorDado3 = (Math.random()*(info_canciones.length-1) + 1);
							  opcion2 = (int)Math.round(valorDado3);
					 	 	System.out.println("1. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						 	System.out.println("2. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
							System.out.println("3. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						 	respuesta = ConsoleInput.getInt();
						 		if (respuesta == 3) {
						 			System.out.println("Has acertado!\n");
						 			creditos = creditos + 10;
						 			System.out.println("\nAhora tus creditos son: " + creditos + ", felicidades!");
						 			//hacer creditos 
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("No has acertado!\n");
						 			creditos =creditos - 10;
						 			System.out.println("ahora tus creditos son: " + creditos + ", sigue intentandolo!");
						 			audio.detener();

						 		}
								System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						 break;

						 case 2: 
							 System.out.println("¿Como se llama esta canción? \n");
							 valorDado2 = (Math.random()*(info_canciones.length-1) + 1);
							  opcion1 = (int)Math.round(valorDado2);
							 valorDado3 = (Math.random()*(info_canciones.length-1) + 1);
							  opcion2 = (int)Math.round(valorDado3);
						 	System.out.println("1. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						  	System.out.println("2. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						  	System.out.println("3. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
						  	respuesta = ConsoleInput.getInt();
						 		if (respuesta == 2) {
						 			System.out.println("Has acertado!\n");
						 			creditos = creditos + 10;
						 			System.out.println("\nAhora tus creditos son: " + creditos + ", felicidades!");
						 			//hacer creditos 
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("\nNo has acertado!");
						 			creditos = creditos - 10;
						 			System.out.println("\nAhora tus creditos son: " + creditos + ", sigue intentandolo!");
						 			audio.detener();
						 		}
						 		System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						 		
						  break;

						  case 3: 
						 System.out.println("¿Como se llama esta canción? \n");
						  valorDado2 = (Math.random()*(info_canciones.length-1) + 1);
						   opcion1 = (int)Math.round(valorDado2);
			           	  valorDado3 = (Math.random()*(info_canciones.length-1) + 1);
					       opcion2 = (int)Math.round(valorDado3);
						  System.out.println("1. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						  System.out.println("2. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						  System.out.println("3. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
						  respuesta = ConsoleInput.getInt();
						 		if (respuesta == 1) {
						 			System.out.println("\nHas acertado!");
						 			creditos = creditos + 10;
						 			System.out.println("\nAhora tus creditos son: " + creditos + ", felicidades!");
						 			//hacer creditos 
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("\nNo has acertado!");
						 			creditos = creditos - 10;
						 			System.out.println("\nAhora tus creditos son: " + creditos + ", sigue intentando!");
						 			audio.detener();
						 		}
						 		System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						  break;

						  default : 
					 
					 }
				}
			}
				if(centinela == 2)
				{
					System.out.println("Tus creditos actuales son: " + creditos);
				}

				if(centinela == 3)
				{
					System.out.println("Las reglas del juego son: ");
					System.out.println("1. Solamente se tienen 3 intentos para adivinar la cancion.");
					System.out.println("2. Si no se tienen los creditos no podra continuar.");
					System.out.println("3. El nombre le cancion debe ser escrito completo y con buena ortografia");
					System.out.println("4. Se puede retirar en cualquier momento con los creditos que al final le daran un puntaje.");
				}

				if(centinela == 4)
				{
					audio.detener();
				}

				if(centinela==5)
				{
					/* La informacion de las canciones esta
					en la matriz info_canciones, acá un ejemplo de como imprimir
					el nombre de la primer canción y su autor */
					
					//TODO: Ojo, falta validar el valor ingresado
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();

					inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
					fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

					System.out.println();
					imprimir("Inicio letra "+inicio_letra);
					imprimir("Fin letra "+fin_letra);
					imprimir("Nombre "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
					imprimir("Autor "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
					imprimir("Archivo "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);

					imprimir("Primera estrofa: "+canciones[inicio_letra]);
					imprimir("Última estrofa: "+canciones[fin_letra]);
					
					//TODO:Convertir a unicode mayúsculas y caracteres especiales
					//TODO:Explicar como funciona el archivo y como se analiza cada línea
					//TODO:Imprimir la lista completa
				}

			}while(centinela!=6);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			audio.detener();
		}
	}
}



/*
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
*/

















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