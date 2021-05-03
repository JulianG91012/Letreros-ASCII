import javax.swing.*;
public class ADIVINA_LA_CANCION {
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
		

		displayVacio(5,5);
		System.out.println("Espacio");
		imprimirDisplay(6,7);
		System.out.println("Espacio 2");
		

		

		


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