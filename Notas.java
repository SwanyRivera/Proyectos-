import javax.swing.JOptionPane;

public class Notas {
 
	public static void main(String[] args) {
 
		int cantidadAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de Alumnos"));
 
		
		String[] nombres = new String[cantidadAlumnos];
		
		double[] notas = new double[cantidadAlumnos];
 
		
		for (int i = 0; i < cantidadAlumnos; i++) {
			
			nombres[i] = JOptionPane.showInputDialog("Escriba el nombre del alumno:");
			
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Nota Final:"));
		}
 
		
		StringBuilder reporte = new StringBuilder();
 
		reporte.append("\nEstos son los Alumnos matriculados:\n");
		for (String nom: nombres)
			reporte.append(nom + "\n");
 
		
		
		String nombreMayor = nombres[0];
		String nombreMenor = nombres[0];
		double notaMayor = notas[0];
		double notaMenor = notas[0];
 
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] > notaMayor) { 
				notaMayor = notas[i]; 
				nombreMayor = nombres[i];
			}
			if (notas[i] < notaMenor) { 
				notaMenor = notas[i];
				nombreMenor = nombres[i];
			}
		}
		
		
		reporte.append(String.format("\n\nEl Alumno: %s tiene la mayor Nota: %.2f \n", nombreMayor, notaMayor));
		reporte.append(String.format("\nEl Alumno: %s tiene la menor Nota: %.2f \n", nombreMenor, notaMenor));
 
		
		double sumaNotas = 0d;
		for (int i = 0; i < notas.length; i++)
			sumaNotas += notas[i];
		
		reporte.append(String.format("\n\nLa nota promedio es: %.2f", sumaNotas/cantidadAlumnos));
 
		reporte.append("\n\n-- LISTO DATOS INGRESADOS --");
 
		
		JOptionPane.showMessageDialog(null, reporte);
 
	}
 
}