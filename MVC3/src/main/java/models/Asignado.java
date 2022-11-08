package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Asignado {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = ConexionSQL.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS asignado_a";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE asignado_a (" 
					+ "cientifico VARCHAR(8), "
					+ "proyecto CHAR(4), "
					+ "PRIMARY KEY (cientifico,proyecto), "
					+ "FOREIGN KEY(cientifico) REFERENCES cientificos(DNI) "
					+ "ON DELETE CASCADE ON UPDATE CASCADE, "
					+ "FOREIGN KEY(proyecto) REFERENCES proyecto(id) "
					+ "ON DELETE CASCADE ON UPDATE CASCADE "
					+ ");";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// M�todo para insertar datos en la tabla
	public void insertAsignado() {
		Connection c = ConexionSQL.connection;
		try {
			String query = "INSERT INTO asignado_a (cientifico, proyecto) values"
					+ "('3245679G', 6),"
					+ "('3973892V', 12);";

			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
