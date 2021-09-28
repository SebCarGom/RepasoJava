package laboral;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 * @author Sebas
 *
 */
public class ConexionBaseDatos {

	FileReader fr = null;
	BufferedReader br = null;
	List<Empleado> listaEmpleados = new ArrayList<>();
	List<Empleado> listaEmpleadosAlta = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	String url = "jdbc:oracle:thin:@localhost:1521/XE";
	String user = "Sebas";
	String pass = "1234";

	/**
	 * Metodo que introduce los 2 empleados de ejemplo a la base de datos
	 * @param emp1
	 * @param emp2
	 */
	public void conexionEmpleados(Empleado emp1, Empleado emp2) {
		try {
			conn = DriverManager.getConnection(url, user, pass);

			PreparedStatement st = conn
					.prepareStatement("INSERT INTO Empleados (nombre,DNI,sexo,categoria,anyos) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, emp1.nombre);
			st.setString(2, emp1.dni);
			st.setString(3, String.valueOf(emp1.sexo));
			st.setInt(4, emp1.getCategoria());
			st.setInt(5, emp1.anyos);
			st.executeUpdate();
			st.close();

			PreparedStatement st2 = conn.prepareStatement("INSERT INTO Nominas (dni, sueldo) VALUES(?, ?)");
			st2.setString(1, emp1.dni);
			st2.setInt(2, Nomina.sueldo(emp1));
			st2.executeUpdate();
			st2.close();

			PreparedStatement st3 = conn
					.prepareStatement("INSERT INTO Empleados (nombre,DNI,sexo,categoria,anyos) VALUES (?, ?, ?, ?, ?)");
			st3.setString(1, emp2.nombre);
			st3.setString(2, emp2.dni);
			st3.setString(3, String.valueOf(emp2.sexo));
			st3.setInt(4, emp2.getCategoria());
			st3.setInt(5, emp2.anyos);
			st3.executeUpdate();
			st3.close();

			PreparedStatement st4 = conn.prepareStatement("INSERT INTO Nominas (dni, sueldo) VALUES(?, ?)");
			st4.setString(1, emp2.dni);
			st4.setInt(2, Nomina.sueldo(emp2));
			st4.executeUpdate();
			st4.close();

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar conectarse a la base de datos");

		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Ha ocurrido un error al cerrarse a la base de datos");
			}
		}

	}

	/**
	 * Metodo que le pide al usuario los datos de un empleado para darle de alta en la base de datos.
	 */
	public void altaEmpleado() {

		System.out.println("Alta nuevo empleado: ");
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("DNI: ");
		String dni = sc.nextLine();
		System.out.println("Sexo: ");
		char sexo = sc.nextLine().charAt(0);
		System.out.println("Categoría: ");
		int categoria = sc.nextInt();
		System.out.println("Años en la empresa: ");
		int anyos = sc.nextInt();
		sc.nextLine();
		sc.close();

		try {
			conn = DriverManager.getConnection(url, user, pass);
			Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);

			PreparedStatement st = conn
					.prepareStatement("INSERT INTO Empleados (nombre,DNI,sexo,categoria,anyos) VALUES (?, ?, ?, ?, ?)");

			st.setString(1, emp.nombre);
			st.setString(2, emp.dni);
			st.setString(3, String.valueOf(emp.sexo));
			st.setInt(4, emp.getCategoria());
			st.setInt(5, emp.anyos);
			st.executeUpdate();
			st.close();

			PreparedStatement st2 = conn.prepareStatement("INSERT INTO Nominas (dni, sueldo) VALUES(?, ?)");

			st2.setString(1, emp.dni);
			st2.setInt(2, Nomina.sueldo(emp));

			st2.executeUpdate();
			st2.close();

		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar conectarse a la Base de Datos");
		} catch (DatosNoCorrectosException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo que toma por entrada un fichero con los datos de un empleado y los introduce en la base de datos.
	 * @param fichero
	 */
	public void altaEmpleado(File fichero) {

        try  {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            
            while (linea != null) {
				Empleado emp;

				String[] separador = linea.split(",");

				emp = new Empleado(separador[0], separador[1], separador[2].charAt(0), Integer.parseInt(separador[3]),
						Integer.parseInt(separador[4]));

				listaEmpleadosAlta.add(emp);

				linea = br.readLine();

			}

            Iterator<Empleado> iter = listaEmpleadosAlta.iterator();
            int i = 0;

            while (iter.hasNext()) {

                String nombre = listaEmpleadosAlta.get(i).nombre;
                String dni = listaEmpleadosAlta.get(i).dni;
                char sexo = listaEmpleadosAlta.get(i).sexo;
                int categoria = listaEmpleadosAlta.get(i).getCategoria();
                int anyos = listaEmpleadosAlta.get(i).anyos;
        
               

        			conn = DriverManager.getConnection(url, user, pass);
        			Empleado emp1 = new Empleado(nombre, dni, sexo, categoria, anyos);
        			listaEmpleados.add(emp1);

        			PreparedStatement st = conn
        					.prepareStatement("INSERT INTO Empleados (nombre,DNI,sexo,categoria,anyos) VALUES (?, ?, ?, ?, ?)");

        			st.setString(1, emp1.nombre);
        			st.setString(2, emp1.dni);
        			st.setString(3, String.valueOf(emp1.sexo));
        			st.setInt(4, emp1.getCategoria());
        			st.setInt(5, emp1.anyos);
        			st.executeUpdate();
        			st.close();

        			PreparedStatement st2 = conn.prepareStatement("INSERT INTO Nominas (dni, sueldo) VALUES(?, ?)");

        			st2.setString(1, emp1.dni);
        			st2.setInt(2, Nomina.sueldo(emp1));

        			st2.executeUpdate();
        			st2.close();
        			i++;
        		}

            

        } catch (DatosNoCorrectosException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
        } catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar conectarse a la Base de Datos");
		}

}
}