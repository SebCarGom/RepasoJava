package laboral;

public class CalculaNominas {

	public static void main(String[] args) {
		try {
			Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
			Empleado emp2 = new Empleado("Ada Lovelace", "32000031R", 'F');

			escribe(emp1, emp2);

			emp2.incrAnyo();
			emp1.setCategoria(9);

			escribe(emp1, emp2);
		} catch (DatosNoCorrectosException e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo que recibe dos empleados y muestra todas sus propiedades incluyendo el sueldo.
	 * 
	 * @param emp1
	 * @param emp2
	 */
	private static void escribe(Empleado emp1, Empleado emp2) {
		System.out.println("Nombre: " + emp1.nombre + ", dni: " + emp1.dni + ", categoria: " + emp1.getCategoria()
				+ ", años: " + emp1.anyos + ", sueldo: " + Nomina.sueldo(emp1));
		System.out.println("Nombre: " + emp2.nombre + ", dni: " + emp2.dni + ", categoria: " + emp2.getCategoria()
				+ ", años: " + emp2.anyos + ", sueldo: " + Nomina.sueldo(emp2));
	}
}
