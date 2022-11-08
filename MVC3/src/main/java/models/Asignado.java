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
<<<<<<< HEAD
			query = "CREATE TABLE asignado_a(" 
=======
			query = "CREATE TABLE asignado_a (" 
>>>>>>> b7bd84527c732208e91f2a4cf04692fee76c3b6c
					+ "cientifico VARCHAR(8), "
					+ "proyecto CHAR(4), "
					+ "PRIMARY KEY (cientifico,proyecto), "
					+ "FOREIGN KEY(cientifico) REFERENCES cientificos(DNI) "
					+ "ON DELETE CASCADE ON UPDATE CASCADE, "
					+ "FOREIGN KEY(proyecto) REFERENCES proyecto(id) "
<<<<<<< HEAD
					+ "ON DELETE CASCADE ON UPDATE CASCADE, "
=======
					+ "ON DELETE CASCADE ON UPDATE CASCADE "
>>>>>>> b7bd84527c732208e91f2a4cf04692fee76c3b6c
					+ ");";
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// M�todo para insertar datos en la tabla
<<<<<<< HEAD
	public void insertCientificos() {
		Connection c = ConexionSQL.connection;
		try {
			String query = "INSERT INTO proyecto (id, nombre, horas) values"
					+ "('12', 'Manhattan', 11304),"
					+ "('6', 'Dolly', 42);";
=======
	public void insertAsignado() {
		Connection c = ConexionSQL.connection;
		try {
			String query = "INSERT INTO asignado_a (cientifico, proyecto) values"
					+ "('3245679G', 6),"
					+ "('3973892V', 12);";
>>>>>>> b7bd84527c732208e91f2a4cf04692fee76c3b6c

			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}
}
