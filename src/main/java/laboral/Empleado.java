package laboral;

/**
 * 
 * @author Sebas
 *
 */
public class Empleado extends Persona {
	private int categoria;
	public int anyos;

	/**
	 * Primer Constructor.
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @param categoria
	 * @param anyos
	 * @throws DatosNoCorrectosException
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {

		super(nombre, dni, sexo);
		if (categoria >= 0 && categoria <= 9 && anyos > 0) {
			this.categoria = categoria;
			this.anyos = anyos;
		} else
			throw new DatosNoCorrectosException("Datos no correctos");
	}

	/**
	 * Segundo Constructor.
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		categoria = 1;
		anyos = 0;
	}

	/**
	 * Metodo que comprueba el valor de la categoria ingresada y lo asigna si cumple
	 * la condicion.
	 * 
	 * @param categoria
	 */
	public void setCategoria(int categoria) {
		if (categoria >= 1 && categoria <= 10) {
			this.categoria = categoria;
		}
	}

	/**
	 * Metodo que devuelve la propiedad categoria.
	 * 
	 * @return
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Metodo que incrementa la propiedad anyos 1
	 */
	public void incrAnyo() {
		this.anyos += 1;
	}

	/**
	 * Metodo que imprime todas las propiedades de Empleado
	 */
	public void imprime() {
		System.out.println("Nombre: " + nombre + ", dni: " + dni + ", categoria: " + categoria + ", años: " + anyos);
	}

}
