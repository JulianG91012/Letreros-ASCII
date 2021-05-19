//import org.fusesource.jansi.AnsiConsole;
//import static org.fusesource.jansi.Ansi.*;
//import static org.fusesource.jansi.Ansi.Color.*;

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
				  imprimir("	|                           2. Balance de puntajes		                        |");
				  imprimir("	|                           3. Reglas del juego		                                |");
				  imprimir("	|                           4. Rachas				                        |");
				  imprimir("	|                           5. Informacion musical 				                        |");
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
		int puntaje = 50;
		int i = 0;
		int n = 0;
		int p = 0;
		int o = 0;
		int victorias = 0;
		int derrotas = 0;
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

				

				System.out.println();
				
				menu();
				
				centinela = ConsoleInput.getInt();
				if (centinela == 1){
					
					 	
					while (i < 2){
						
							
					
					 valorDado = (Math.random()*(info_canciones.length-1));
					 int value = (int)Math.round(valorDado);

					 audio.seleccionarCancion(info_canciones[value][ConsoleData.RUTA_CANCION]);
					 audio.reproducir();

					 SeleccionMultiple = Math.random()*2 + 1;
					 int MultipleSeleccion = (int)Math.round(SeleccionMultiple);
					 
					valorDado2 = (Math.random()*(info_canciones.length-1));
					opcion1 = (int)Math.round(valorDado2);
				    valorDado3 = (Math.random()*(info_canciones.length-1));
					opcion2 = (int)Math.round(valorDado3);
				if (opcion1 != opcion2 && opcion2 != value) {
					 switch(MultipleSeleccion){
					 	case 1:
					 		 System.out.println("¿Como se llama esta canción? \n");
							 
					 	 	System.out.println("1. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						 	System.out.println("2. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
							System.out.println("3. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						 	respuesta = ConsoleInput.getInt();
						 		if (respuesta == 3) {
						 			System.out.println("Has acertado!\n");
						 			puntaje = puntaje + 10;
						 			victorias = victorias + 1;
						 			System.out.println("\nAhora tu puntaje es: " + puntaje + ", felicidades!");
						 			 
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("No has acertado!\n");
						 			if (puntaje == 0) {
						 				System.out.println("ahora tu puntaje es: 0, sigue intentandolo!");
						 			}
						 			else{
						 			puntaje =puntaje - 10;
						 			System.out.println("ahora tu puntaje es: " + puntaje + ", sigue intentandolo!");
						 			}
						 			derrotas = derrotas + 1;
						 			audio.detener();

						 		}
						 		System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						 break;

						 case 2: 
							 System.out.println("¿Como se llama esta canción? \n");
				
						 	System.out.println("1. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						  	System.out.println("2. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						  	System.out.println("3. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
						  	respuesta = ConsoleInput.getInt();
						 		if (respuesta == 2) {
						 			System.out.println("Has acertado!\n");
						 			puntaje = puntaje + 10;
						 			victorias = victorias + 1;
						 			System.out.println("\nAhora tu puntaje es: " + puntaje + ", felicidades!");
						 			 
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("\nNo has acertado!");
						 			if (puntaje == 0) {
						 				System.out.println("ahora tu puntaje es: 0, sigue intentandolo!");
						 			}
						 			else{
						 			puntaje =puntaje - 10;
						 			System.out.println("ahora tu puntaje es: " + puntaje + ", sigue intentandolo!");
						 			}
						 			derrotas = derrotas + 1;
						 			audio.detener();
						 		}
						 		System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						 		
						  break;

						  case 3: 
						 System.out.println("¿Como se llama esta canción? \n");
						  
						  System.out.println("1. " + info_canciones[value][ConsoleData.NOMBRE_CANCION]);
						  System.out.println("2. " + info_canciones[opcion1][ConsoleData.NOMBRE_CANCION]);
						  System.out.println("3. " + info_canciones[opcion2][ConsoleData.NOMBRE_CANCION]);
						  respuesta = ConsoleInput.getInt();
						 		if (respuesta == 1) {
						 			System.out.println("\nHas acertado!");
						 			puntaje = puntaje + 10;
						 			victorias = victorias + 1;
						 			System.out.println("\nAhora tu puntaje es: " + puntaje + ", felicidades!");
						 			audio.detener();
						 		}
						 		else{
						 			System.out.println("\nNo has acertado!");
						 			if (puntaje == 0) {
						 				System.out.println("ahora tu puntaje es: 0, sigue intentandolo!");
						 			}
						 			else{
						 			puntaje =puntaje - 10;
						 			System.out.println("ahora tu puntaje es: " + puntaje + ", sigue intentandolo!");
						 			}
						 			derrotas = derrotas + 1;
						 			audio.detener();
						 		}
						 		
						 		System.out.println("\nPara continuar digite 1.\nPara volver al menu principal digite 2.");
						 		i = ConsoleInput.getInt();
						 	
						  break;

						  default : 

					 
					 	}
					}
				}
									
		}
	
	

	

				if(centinela == 2)
				{
					while(n < 2){
						if (puntaje > 0) {
						System.out.println("Tu puntaje actual es: " + puntaje);
						System.out.println("Para volver al menu principal digite 2.");
						n = ConsoleInput.getInt();
						}
						else{
						System.out.println("No tienes puntaje juega para tener mas!");
						System.out.println("\nPara volver al menu principal digite 2.");
						n = ConsoleInput.getInt();

						}
								}
					
				}

				if(centinela == 3)
				{
					System.out.println("Las reglas del juego son: ");					
					System.out.println("1. Sebe poner el valor correcto de la cancion. ");
					System.out.println("2. Se puede retirar en cualquier momento con los puntajes que al final le daran.");
				}

				if(centinela == 4)
				{
					while(p < 2){
					System.out.println("Racha de victorias: " + victorias);
					System.out.println("Racha de derrotas: " + derrotas);
					System.out.println("\nPara volver al menu principal digite 2.");
						p = ConsoleInput.getInt();
					}
				}

				if(centinela==5)
				{
					while (o < 2){ 
					
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();

					inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
					fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

					System.out.println();
					imprimir("Inicio letra "+inicio_letra);
					imprimir("Fin letra "+fin_letra);
					imprimir("Nombre "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION].replace(";", " "));
					imprimir("Autor "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION].replace(";", " "));
					imprimir("Archivo "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION].replace(";", " "));

					imprimir("Primera estrofa: "+canciones[inicio_letra].replace(";", " "));
					imprimir("Última estrofa: "+canciones[fin_letra].replace(";", " "));
					imprimir("LETRA: \n");

					letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);
					System.out.println(letra_cancion.toString().replace(";", " "));
					System.out.println("\nPara volver al menu principal digite 2.");
						o = ConsoleInput.getInt();
					
					
				}
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

