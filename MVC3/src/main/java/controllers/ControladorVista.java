package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import models.ConexionSQL;

public class ControladorVista implements ActionListener {
	//Agregar atributos
	private ConexionSQL conSQL = new ConexionSQL();
	
	// Agregar constructor con atributos
	
	public void iniciarVista() {
		/*cframe.setTitle("Clientes CRUD");
		cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cframe.setBounds(100, 100, 345, 350);
		cframe.setVisible(true);*/
	}
	
	public void agregarEventos() {
		/*panelOpciones.btnCrearCliente.addActionListener(this);
		panelOpciones.btnBuscarCliente.addActionListener(this);
		panelOpciones.btnEliminarCliente.addActionListener(this);
		panelOpciones.btnListarClientes.addActionListener(this);
		panelOpciones.btnModificarCliente.addActionListener(this);
		panelFormularios.crearButton.addActionListener(this);
		panelFormularios.buscarButton.addActionListener(this);
		panelFormularios.borrarButton.addActionListener(this);
		panelFormularios.actualizarButton.addActionListener(this);*/
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//----------------------------METODOS CIENTIFICOS-----------------------------
	public void buscarCientifico() {
		Connection c = ConexionSQL.connection;
		String dni = panelFormularios.buscarTextfield.getText();
		String data = "";
		try {
			String query = "SELECT * FROM cientificos WHERE dni=" + dni + ";";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "<html>DNI: " + resultSet.getString("dni");
				data += "<br/>NomApels: " + resultSet.getString("nomApels")+ "</html>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText(data);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void crearCientifico() {
		// INSERT VALUES
		Connection c = ConexionSQL.connection;
		try {
			String dni = panelFormularios.crearNombre.getText();
			String nomApels = panelFormularios.crearApellido.getText();

			String query = "INSERT INTO cientificos (dni, nomApels) values" + "('" + dni
					+ "','" + nomApels + "');";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void borrarCientifico() {
		// DELETE
		Connection c = ConexionSQL.connection;
		try {
			String dni = panelFormularios.borrarTexfield.getText();

			String query = "DELETE FROM cientificos " + "WHERE dni=" + dni + ";";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Cliente borrado con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void modificarCientifico() {
		Connection c = ConexionSQL.connection;
		try {
			String dniActual = panelFormularios.dniActual.getText();
			
			String dni = panelFormularios.actualizarNombre.getText();
			String nomApels = panelFormularios.actualizarApellidos.getText();
			
			String query = "UPDATE clientes "+
					"SET dni = "+dni+", nomApels='"+nomApels+"'"+
					"WHERE dni = "+ dniActual +";";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		}catch(SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void listarCientificos() {
		Connection c = ConexionSQL.connection;
		String data = "";
		try {
			String query = "SELECT * FROM cientificos;";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "DNI: " + resultSet.getString("dni");
				data += "<br/>NomApels: " + resultSet.getString("nomApels");
				data += "<br/>-----------------<br/>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText("<html>" + data + "</html>");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	//----------------------------METODOS PROYECTO-----------------------------
		public void buscarProyecto() {
			Connection c = ConexionSQL.connection;
			String nombre = panelFormularios.buscarTextfield.getText();
			String data = "";
			try {
				String query = "SELECT * FROM proyectos WHERE nombre=" + nombre + ";";
				Statement st = c.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(query);
				while (resultSet.next()) {
					data += "<html>Nombre: " + resultSet.getString("nombre");
					data += "<br/>Horas: " + resultSet.getString("horas")+ "</html>";
				}
				nextImage(cframe.panelContainer);
				cframe.labelResultados.setText(data);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error al insertar datos.");
			}
		}

		public void crearProyecto() {
			// INSERT VALUES
			Connection c = ConexionSQL.connection;
			try {
				String dni = panelFormularios.crearNombre.getText();
				int horas = Integer.parseInt(panelFormularios.borrarTexfield.getText());

				String query = "INSERT INTO proyecto (nombre, horas) values" + "('" + dni
						+ "','" + nomApels + "');";
				System.out.println(query);
				Statement st = c.createStatement();
				st.executeUpdate(query);
				System.out.println("Datos insertados con exito!");
			} catch (SQLException | NumberFormatException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error al insertar datos.");
			}
		}

		public void borrarProyecto() {
			// DELETE
			Connection c = ConexionSQL.connection;
			try {
				String nombre = panelFormularios.borrarTexfield.getText();

				String query = "DELETE FROM proyecto " + "WHERE nombre=" + nombre + ";";
				System.out.println(query);
				Statement st = c.createStatement();
				st.executeUpdate(query);
				System.out.println("Cliente borrado con exito!");
			} catch (SQLException | NumberFormatException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error al insertar datos.");
			}
		}

		public void modificarProyecto() {
			Connection c = ConexionSQL.connection;
			try {
				String dniActual = panelFormularios.dniActual.getText();
				
				String dni = panelFormularios.actualizarNombre.getText();
				String nomApels = panelFormularios.actualizarApellidos.getText();
				
				String query = "UPDATE clientes "+
						"SET dni = "+dni+", nomApels='"+nomApels+"'"+
						"WHERE dni = "+ dniActual +";";
				System.out.println(query);
				Statement st = c.createStatement();
				st.executeUpdate(query);
				System.out.println("Datos insertados con exito!");
			}catch(SQLException | NumberFormatException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error al insertar datos.");
			}
		}

		public void listarProyectos() {
			Connection c = ConexionSQL.connection;
			String data = "";
			try {
				String query = "SELECT * FROM cientificos;";
				Statement st = c.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(query);
				while (resultSet.next()) {
					data += "DNI: " + resultSet.getString("dni");
					data += "<br/>NomApels: " + resultSet.getString("nomApels");
					data += "<br/>-----------------<br/>";
				}
				nextImage(cframe.panelContainer);
				cframe.labelResultados.setText("<html>" + data + "</html>");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error al insertar datos.");
			}
		}
}
