package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import models.ConexionSQL;
import views.ClienteFrame;
import views.PanelFormularios;
import views.PanelOpciones;

public class ControladorVista implements ActionListener {
	private ClienteFrame cframe;
	private PanelOpciones panelOpciones;
	private PanelFormularios panelFormularios;
	private int crudOption;

	// private ConexionSQL conSQL = new ConexionSQL();

	public ControladorVista(ClienteFrame cframe, PanelOpciones panelOpciones, PanelFormularios panelFormularios) {
		super();
		this.cframe = cframe;
		this.panelOpciones = panelOpciones;
		this.panelFormularios = panelFormularios;
		crudOption = 1;
		agregarEventos();
	}

	public void iniciarVista() {
		cframe.setTitle("Clientes CRUD");
		cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cframe.setBounds(100, 100, 345, 350);
		cframe.setVisible(true);
	}

	public void agregarEventos() {
		panelOpciones.btnCrear.addActionListener(this);
		panelOpciones.btnBuscar.addActionListener(this);
		panelOpciones.btnEliminar.addActionListener(this);
		panelOpciones.btnListar.addActionListener(this);
		panelOpciones.btnModificar.addActionListener(this);
		panelFormularios.crearButton.addActionListener(this);
		panelFormularios.buscarButton.addActionListener(this);
		panelFormularios.borrarButton.addActionListener(this);
		panelFormularios.actualizarButton.addActionListener(this);
		panelOpciones.comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeCrudViews();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (panelOpciones.btnBuscar == e.getSource()) {
			firstImage(cframe.panelContainer);
			selectCard(cframe.panelFormularios, "buscar");

		} else if (panelOpciones.btnCrear == e.getSource()) {
			firstImage(cframe.panelContainer);
			selectCard(cframe.panelFormularios, "crear");

		} else if (panelOpciones.btnEliminar == e.getSource()) {
			firstImage(cframe.panelContainer);
			selectCard(cframe.panelFormularios, "borrar");

		} else if (panelOpciones.btnModificar == e.getSource()) {
			firstImage(cframe.panelContainer);
			selectCard(cframe.panelFormularios, "actualizar");

		} else if (panelOpciones.btnListar == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				// Algo
			} else if (crudOption == 2) {
				// Otra cosa
			} else {
				// Algo más
			}
			conSQL.closeConnection();

		} else if (panelFormularios.crearButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				// Algo
			} else if (crudOption == 2) {
				// Otra cosa
			} else {
				// Algo más
			}
			conSQL.closeConnection();

		} else if (panelFormularios.borrarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				// Algo
			} else if (crudOption == 2) {
				// Otra cosa
			} else {
				// Algo más
			}
			conSQL.closeConnection();

		} else if (panelFormularios.buscarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				// Algo
			} else if (crudOption == 2) {
				// Otra cosa
			} else {
				// Algo más
			}
			conSQL.closeConnection();

		} else if (panelFormularios.actualizarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				// Algo
			} else if (crudOption == 2) {
				// Otra cosa
			} else {
				// Algo más
			}
			conSQL.closeConnection();
		}
	}

	// ----------------------------METODOS CIENTIFICOS-----------------------------
	/*
	 * public void buscarCientifico() { Connection c = ConexionSQL.connection;
	 * String dni = panelFormularios.buscarTextfield.getText(); String data = "";
	 * try { String query = "SELECT * FROM cientificos WHERE dni=" + dni + ";";
	 * Statement st = c.createStatement(); java.sql.ResultSet resultSet; resultSet =
	 * st.executeQuery(query); while (resultSet.next()) { data += "<html>DNI: " +
	 * resultSet.getString("dni"); data += "<br/>NomApels: " +
	 * resultSet.getString("nomApels")+ "</html>"; }
	 * nextImage(cframe.panelContainer); cframe.labelResultados.setText(data); }
	 * catch (SQLException ex) { System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void crearCientifico() { // INSERT VALUES Connection c =
	 * ConexionSQL.connection; try { String dni =
	 * panelFormularios.crearNombre.getText(); String nomApels =
	 * panelFormularios.crearApellido.getText();
	 * 
	 * String query = "INSERT INTO cientificos (dni, nomApels) values" + "('" + dni
	 * + "','" + nomApels + "');"; System.out.println(query); Statement st =
	 * c.createStatement(); st.executeUpdate(query);
	 * System.out.println("Datos insertados con exito!"); } catch (SQLException |
	 * NumberFormatException ex) { System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void borrarCientifico() { // DELETE Connection c =
	 * ConexionSQL.connection; try { String dni =
	 * panelFormularios.borrarTexfield.getText();
	 * 
	 * String query = "DELETE FROM cientificos " + "WHERE dni=" + dni + ";";
	 * System.out.println(query); Statement st = c.createStatement();
	 * st.executeUpdate(query); System.out.println("Cliente borrado con exito!"); }
	 * catch (SQLException | NumberFormatException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void modificarCientifico() { Connection c = ConexionSQL.connection;
	 * try { String dniActual = panelFormularios.dniActual.getText();
	 * 
	 * String dni = panelFormularios.actualizarNombre.getText(); String nomApels =
	 * panelFormularios.actualizarApellidos.getText();
	 * 
	 * String query = "UPDATE clientes "+
	 * "SET dni = "+dni+", nomApels='"+nomApels+"'"+ "WHERE dni = "+ dniActual +";";
	 * System.out.println(query); Statement st = c.createStatement();
	 * st.executeUpdate(query); System.out.println("Datos insertados con exito!");
	 * }catch(SQLException | NumberFormatException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void listarCientificos() { Connection c = ConexionSQL.connection;
	 * String data = ""; try { String query = "SELECT * FROM cientificos;";
	 * Statement st = c.createStatement(); java.sql.ResultSet resultSet; resultSet =
	 * st.executeQuery(query); while (resultSet.next()) { data += "DNI: " +
	 * resultSet.getString("dni"); data += "<br/>NomApels: " +
	 * resultSet.getString("nomApels"); data += "<br/>-----------------<br/>"; }
	 * nextImage(cframe.panelContainer); cframe.labelResultados.setText("<html>" +
	 * data + "</html>"); } catch (SQLException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 */

	// ----------------------------METODOS PROYECTO-----------------------------
	/*
	 * public void buscarProyecto() { Connection c = ConexionSQL.connection; String
	 * nombre = panelFormularios.buscarTextfield.getText(); String data = ""; try {
	 * String query = "SELECT * FROM proyectos WHERE nombre=" + nombre + ";";
	 * Statement st = c.createStatement(); java.sql.ResultSet resultSet; resultSet =
	 * st.executeQuery(query); while (resultSet.next()) { data += "<html>Nombre: " +
	 * resultSet.getString("nombre"); data += "<br/>Horas: " +
	 * resultSet.getString("horas")+ "</html>"; } nextImage(cframe.panelContainer);
	 * cframe.labelResultados.setText(data); } catch (SQLException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void crearProyecto() { // INSERT VALUES Connection c =
	 * ConexionSQL.connection; try { String dni =
	 * panelFormularios.crearNombre.getText(); int horas =
	 * Integer.parseInt(panelFormularios.borrarTexfield.getText());
	 * 
	 * String query = "INSERT INTO proyecto (nombre, horas) values" + "('" + dni +
	 * "','" + nomApels + "');"; System.out.println(query); Statement st =
	 * c.createStatement(); st.executeUpdate(query);
	 * System.out.println("Datos insertados con exito!"); } catch (SQLException |
	 * NumberFormatException ex) { System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void borrarProyecto() { // DELETE Connection c =
	 * ConexionSQL.connection; try { String nombre =
	 * panelFormularios.borrarTexfield.getText();
	 * 
	 * String query = "DELETE FROM proyecto " + "WHERE nombre=" + nombre + ";";
	 * System.out.println(query); Statement st = c.createStatement();
	 * st.executeUpdate(query); System.out.println("Cliente borrado con exito!"); }
	 * catch (SQLException | NumberFormatException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void modificarProyecto() { Connection c = ConexionSQL.connection; try
	 * { String dniActual = panelFormularios.dniActual.getText();
	 * 
	 * String dni = panelFormularios.actualizarNombre.getText(); String nomApels =
	 * panelFormularios.actualizarApellidos.getText();
	 * 
	 * String query = "UPDATE clientes "+
	 * "SET dni = "+dni+", nomApels='"+nomApels+"'"+ "WHERE dni = "+ dniActual +";";
	 * System.out.println(query); Statement st = c.createStatement();
	 * st.executeUpdate(query); System.out.println("Datos insertados con exito!");
	 * }catch(SQLException | NumberFormatException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 * 
	 * public void listarProyectos() { Connection c = ConexionSQL.connection; String
	 * data = ""; try { String query = "SELECT * FROM cientificos;"; Statement st =
	 * c.createStatement(); java.sql.ResultSet resultSet; resultSet =
	 * st.executeQuery(query); while (resultSet.next()) { data += "DNI: " +
	 * resultSet.getString("dni"); data += "<br/>NomApels: " +
	 * resultSet.getString("nomApels"); data += "<br/>-----------------<br/>"; }
	 * nextImage(cframe.panelContainer); cframe.labelResultados.setText("<html>" +
	 * data + "</html>"); } catch (SQLException ex) {
	 * System.out.println(ex.getMessage());
	 * System.out.println("Error al insertar datos."); } }
	 */

	public void changeCrudViews() {
		switch (panelOpciones.comboBox.getSelectedIndex()) {
		case 1:
			showCientificosCrud();
			break;
		case 2:
			showProyectosView();
			break;
		case 3:
			showAsignadoView();
			break;
		}
	}

	public void showCientificosCrud() {
		// CREAR
		panelFormularios.label1.setText("Nombre y apellidos: ");
		panelFormularios.label2.setText("DNI: ");
		panelFormularios.label3.setVisible(false);
		panelFormularios.textfield3.setVisible(false);

		// BUSCAR
		panelFormularios.lblBuscar1.setText("DNI del científico: ");
		panelFormularios.buscarTextfield2.setVisible(false);
		panelFormularios.lblBuscar2.setVisible(false);

		// BORRAR
		panelFormularios.lblBorrar1.setText("DNI del científico: ");
		panelFormularios.borrarTexfield2.setVisible(false);
		panelFormularios.lblBorrar2.setVisible(false);

		// ACTUALIZAR
		panelFormularios.label4.setText("DNI actual: ");
		panelFormularios.label5.setText("Nombre y apellidos: ");
		panelFormularios.label6.setText("Nuevo DNI: ");
		panelFormularios.label7.setVisible(false);
		panelFormularios.textfield7.setVisible(false);
	}

	public void showProyectosView() {
		// CREAR
		panelFormularios.label1.setText("ID: ");
		panelFormularios.label2.setText("Nombre: ");
		panelFormularios.label3.setVisible(true);
		panelFormularios.textfield3.setVisible(true);

		// BUSCAR
		panelFormularios.lblBuscar1.setText("ID del proyecto: ");
		panelFormularios.buscarTextfield2.setVisible(false);
		panelFormularios.lblBuscar2.setVisible(false);

		// BORRAR
		panelFormularios.lblBorrar1.setText("ID del proyecto: ");
		panelFormularios.borrarTexfield2.setVisible(false);
		panelFormularios.lblBorrar2.setVisible(false);

		// ACTUALIZAR
		panelFormularios.label4.setText("ID actual: ");
		panelFormularios.label5.setText("Nuevo nombre: ");
		panelFormularios.label6.setText("Nuevo ID: ");
		panelFormularios.label7.setText("Horas: ");
		panelFormularios.label7.setVisible(true);
		panelFormularios.textfield7.setVisible(true);
	}
	
	public void showAsignadoView() {
		// CREAR
		panelFormularios.label1.setText("DNI científico: ");
		panelFormularios.label2.setText("ID proyecto: ");
		panelFormularios.label3.setVisible(false);
		panelFormularios.textfield3.setVisible(false);

		// BUSCAR
		panelFormularios.lblBuscar1.setText("DNI del científico: ");
		panelFormularios.buscarTextfield2.setVisible(true);
		panelFormularios.lblBuscar2.setVisible(true);

		// BORRAR
		panelFormularios.lblBorrar1.setText("DNI del científico: ");
		panelFormularios.borrarTexfield2.setVisible(true);
		panelFormularios.lblBorrar2.setVisible(true);

		// ACTUALIZAR
		panelFormularios.label4.setText("ID actual: ");
		panelFormularios.label5.setText("Científico actual: ");
		panelFormularios.label6.setText("Nuevo ID: ");
		panelFormularios.label7.setText("Nuevo científico: ");
		panelFormularios.label7.setVisible(true);
		panelFormularios.textfield7.setVisible(true);
	}

	public void selectCard(JPanel container, String carta) {
		CardLayout cl = (CardLayout) container.getLayout();
		cl.show(container, carta);
	}

	public void nextImage(JPanel container) {
		CardLayout cl = (CardLayout) container.getLayout();
		cl.next(container);
	}

	public void firstImage(JPanel container) {
		CardLayout cl = (CardLayout) container.getLayout();
		cl.first(container);
	}
}