package laboral;

/**
 * 
 * @author Sebas
 *
 */
public class Nomina {
	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	/**
	 * Metodo que calcula el sueldo de un empleado dependiendo de su categoria y
	 * anyos.
	 * 
	 * @param emp
	 * @return
	 */
	public static int sueldo(Empleado emp) {
		int sueldo;
		sueldo = SUELDO_BASE[emp.getCategoria() - 1] + 5000 * emp.anyos;
		return sueldo;
	}
}
