package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cientificos {
	// M�todo para crear la tabla
	public void createTable() {
		Connection c = ConexionSQL.connection;
		try {
			// Borrar la tabla en caso que exista
			String query = "DROP TABLE IF EXISTS cientificos";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			// Crear la tabla y su estructura
			query = "CREATE TABLE cientificos(" 
					+ "DNI VARCHAR(8) PRIMARY KEY, "
					+ "nom_apels NVARCHAR(255) " 
					+ ");";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// M�todo para insertar datos en la tabla
	public void insertCientificos() {
		Connection c = ConexionSQL.connection;
		try {
			String query = "INSERT INTO cientificos (DNI, nom_apels) values"
					+ "('3245679G', 'Keith Campbell'),"
					+ "('3960148L', 'Richard Feyman'),"
					+ "('3973892V', 'Ian Wilmut'),"
					+ "('4127890D', 'Robert Oppenheimer'),"
					+ "('4368921Z', 'Enrico Fermi');";

			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
