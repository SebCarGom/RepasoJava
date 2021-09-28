package laboral;

/**
 * 
 * @author Sebas
 *
 */
public class CalculaNominas {

	public static void main(String[] args) {
		try {
			Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
			Empleado emp2 = new Empleado("Ada Lovelace", "32000031R", 'F');
			FicheroLaboral fich = new FicheroLaboral();
			ConexionBaseDatos con = new ConexionBaseDatos();
			
			fich.listaEmpleados.add(emp1);
			fich.listaEmpleados.add(emp2);
			
			fich.escribirFicheroTxt(fich.listaEmpleados);
			
			escribe(emp1, emp2);
			emp2.incrAnyo();
			emp1.setCategoria(9);
			
			fich.escribirFicheroTxt(fich.listaEmpleados);
			fich.escribirFicheroDat(fich.leerFichero());
			con.conexionEmpleados(emp1, emp2);
			con.altaEmpleado();
			
			escribe(emp1, emp2);
		} catch (DatosNoCorrectosException e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo que recibe dos empleados y muestra todas sus propiedades incluyendo el
	 * sueldo.
	 * 
	 * @param emp1
	 * @param emp2
	 */
	private static void escribe(Empleado emp1, Empleado emp2) {
		System.out.println("Nombre: " + emp1.nombre + ", dni: " + emp1.dni + ", sexo: " + emp1.sexo + ", categoria: " + emp1.getCategoria()
				+ ", años: " + emp1.anyos + ", sueldo: " + Nomina.sueldo(emp1));
		System.out.println("Nombre: " + emp2.nombre + ", dni: " + emp2.dni + ", sexo: " + emp2.sexo + ", categoria: " + emp2.getCategoria()
				+ ", años: " + emp2.anyos + ", sueldo: " + Nomina.sueldo(emp2));
	}

}
