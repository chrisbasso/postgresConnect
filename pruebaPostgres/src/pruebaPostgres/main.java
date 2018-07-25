package pruebaPostgres;

import java.sql.*;

public class main {

	public static void main(String[] args) {

		Connection BaseDatos = null;
		Statement st = null;

		// Donde se localiza la base de datos
		String url = "jdbc:postgresql://localhost/prueba";

		// Credenciales de la base de datos
		String usuario = "postgres";
		String contrasena = "postgres";

		try {
			// Conexion con la base de datos
			BaseDatos = DriverManager.getConnection(url, usuario, contrasena);

			// Se hara una consulta de la tabla alumnos
			st = BaseDatos.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");

			while (rs.next()) {

				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");

				System.out.println(dni + " " + nombre);

			}

			rs.close();
			st.close();
			BaseDatos.close();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}