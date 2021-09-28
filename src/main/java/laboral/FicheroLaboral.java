package laboral;

import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Sebas
 *
 */
public class FicheroLaboral {

	File fichero = null;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;
	BufferedWriter bw = null;
	List<Empleado> listaEmpleados = new ArrayList<>();

	/**
	 * Metodo que lee el fichero empleados.txt y devuelve una lista de los empleados.
	 * 
	 * @return
	 */
	public List<Empleado> leerFichero() {
		try {

			fr = new FileReader("empleados.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				Empleado emp;

				String[] separador = linea.split(",");

				emp = new Empleado(separador[0], separador[1], separador[2].charAt(0), Integer.parseInt(separador[3]),
						Integer.parseInt(separador[4]));

				listaEmpleados.add(emp);

				linea = br.readLine();

			}
		} catch (DatosNoCorrectosException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el fichero");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				;
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error al intentar cerrar el fichero");
			}
		}
		return listaEmpleados;
	}

	/**
	 * Metodo que toma como entrada una lista de empleados y escribe el dni y sueldo de todos los empleados.
	 * 
	 * @param emp
	 */
	public void escribirFicheroDat(List<Empleado> emp) {
		try {
			fichero = new File("sueldos.dat");
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < emp.size(); i++) {

				bw.write("DNI: " + emp.get(i).dni + " Salario: " + Nomina.sueldo(emp.get(i)) + "\n");

			}

		} catch (Exception e) {
			System.err.println("Error a la hora de crear o escribir en el fichero");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {
				System.err.println("Error a la hora de cerrar el fichero");
			}

		}
	}

	/**
	 * Metodo que crea el archivo empleados.txt a partir de una lista de empleados.
	 * @param emp
	 */
	public void escribirFicheroTxt(List<Empleado> emp) {
		try {
			fichero = new File("empleados.txt");
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < emp.size(); i++) {

				bw.write(emp.get(i).nombre + "," + emp.get(i).dni + "," + emp.get(i).sexo + ","
						+ emp.get(i).getCategoria() + "," + emp.get(i).anyos + "," + Nomina.sueldo(emp.get(i)) + "\n");

			}

		} catch (Exception e) {
			System.err.println("Error a la hora de crear o escribir en el fichero");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {
				System.err.println("Error a la hora de cerrar el fichero");
			}

		}
	}

}
