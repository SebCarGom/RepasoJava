package laboral;

/**
 * 
 * @author Sebas
 *
 */
public class Persona {
	String nombre;
	String dni;
	char sexo;

	/**
	 * Primer Constructor.
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 */
	public Persona(String nombre, String dni, char sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Segundo Constructor.
	 * 
	 * @param nombre
	 * @param sexo
	 */
	public Persona(String nombre, char sexo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
	}

	/**
	 * Metodo que establece la propiedad dni a la deseada.
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo que imprime todas las propiedades de Persona.
	 */
	public void imprime() {
		System.out.println("Nombre: " + nombre + ", dni:" + dni);
	}
}