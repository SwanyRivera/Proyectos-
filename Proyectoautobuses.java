/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoautobuses;

/**
 *
 * @author Rivera
 */
public class Proyectoautobuses {

    private String nombre;
    private String destino;
	private int precio;
	private char [][] asientos;
	private int filasAsientos;

	// Constantes

	private final int COLUMNAS_ASIENTOS = 4;
	private final int FILAS_ASIENTOS;
	private final int CANT_ASIENTOS;

	/*
	 *  Constructor
	 */

	public Autobus (String nombre, String destino, int precio, int cantAsientos)
	{
		this.nombre = nombre;
		this.destino = destino;
		this.precio = precio;
		this.CANT_ASIENTOS = cantAsientos;
		this.FILAS_ASIENTOS = cantAsientos / COLUMNAS_ASIENTOS;

		if ((cantAsientos % this.COLUMNAS_ASIENTOS) == 0) {
			this.filasAsientos = cantAsientos / this.COLUMNAS_ASIENTOS;
			this.asientos = new char [this.FILAS_ASIENTOS][this.COLUMNAS_ASIENTOS];
		}
		else
			System.out.println ("-- La catidad de asientos no es valida --");

		this.habilitarAsientos();
	}

	/*
	 *  Métodos
	 */

	public void asignarAsientoMalo (int numAsiento)
	{
		int contAsiento = 1;
		boolean ready = false;

		// Valida si es un asiento valido
		ready = (this.isAsiento(numAsiento)) ? false : true;

		for (int i = 0; i < this.FILAS_ASIENTOS && ready == false; i++) {
			for (int j = 0; j < this.COLUMNAS_ASIENTOS && ready == false; j++) {
				if (contAsiento == numAsiento) {
					if (asientos[i][j] == ' ') {
						asientos[i][j] = 'X';
						ready = true;
					}
					else
						System.out.println ("-- Ese asiento no esta disponible --");
				}

				contAsiento++;
			}
		}
	}

	public void asignarAsiento (int numAsiento) 
	{
		int contAsiento = 1;
		boolean ready = false;

		// Valida si es un asiento valido
		ready = (this.isAsiento(numAsiento)) ? false : true;

		for (int i = 0; i < this.FILAS_ASIENTOS && ready == false; i++) {
			for (int j = 0; j < this.COLUMNAS_ASIENTOS && ready == false; j++) {
				if (contAsiento == numAsiento) {
					if (asientos[i][j] == ' ') {
						asientos[i][j] = 'O';
						ready = true;
					}
					else
						System.out.println ("-- Ese asiento no esta disponible --");
				}

				contAsiento++;
			}
		}
	}

	public void showAsientos ()
	{
		int numAsiento = 1;

		System.out.println ("Asientos");

		for (int i = 0; i < this.FILAS_ASIENTOS; i++) {
			for (int j = 0; j < this.COLUMNAS_ASIENTOS; j++) {
				System.out.print (String.format("[%2d ", numAsiento) + this.asientos[i][j] + "]");
				
				if ((numAsiento % 4) == 2)
					System.out.print ("  ");

				numAsiento++;
			}

			System.out.println ();
		}
	}
	
	private boolean isAsiento (int numAsiento)
	{
		boolean isAsiento = true;

		if (numAsiento > this.FILAS_ASIENTOS * this.COLUMNAS_ASIENTOS) {
			System.out.println ("-- El número de asiento no es válido --");
			isAsiento = false;
		}

		return isAsiento;
	}

	// Pone todos los asientos disponibles
	private void habilitarAsientos ()
	{
		for (int i = 0; i < this.FILAS_ASIENTOS; i++) {
			for (int j = 0; j < this.COLUMNAS_ASIENTOS; j++)
				asientos[i][j] = ' ';
		}
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
