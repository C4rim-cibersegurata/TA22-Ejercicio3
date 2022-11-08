package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proyectos {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = ConexionSQL.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS proyecto";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE proyecto(" 
					+ "id CHAR(4) PRIMARY KEY, "
					+ "nombre NVARCHAR(255), "
					+ "horas INT "
					+ ");";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// M�todo para insertar datos en la tabla
	public void insertProyectos() {
		Connection c = ConexionSQL.connection;
		try {
			String query = "INSERT INTO proyecto (id, nombre, horas) values"
					+ "('12', 'Manhattan', 11304),"
					+ "('6', 'Dolly', 42);";

			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
