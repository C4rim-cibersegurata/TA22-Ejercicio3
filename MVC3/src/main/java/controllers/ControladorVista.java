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

import models.ConexionSQL;
//import models.ConexionSQL;
import views.ClienteFrame;
import views.PanelFormularios;
import views.PanelOpciones;

public class ControladorVista implements ActionListener {
	private ClienteFrame cframe;
	private PanelOpciones panelOpciones;
	private PanelFormularios panelFormularios;
	private int crudOption;

	private ConexionSQL conSQL = new ConexionSQL();

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
				listarCientificos();
			} else if (crudOption == 2) {
				listarProyectos();
			} else {
				listarAsignados();
			}
			conSQL.closeConnection();

		} else if (panelFormularios.crearButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				crearCientifico();
			} else if (crudOption == 2) {
				crearProyecto();
			} else {
				crearAsignado();
			}
			conSQL.closeConnection();

		} else if (panelFormularios.borrarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				borrarCientifico();
			} else if (crudOption == 2) {
				borrarProyecto();
			} else {
				borrarAsignado();
			}
			conSQL.closeConnection();

		} else if (panelFormularios.buscarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				buscarCientifico();
			} else if (crudOption == 2) {
				buscarProyecto();
			} else {
				buscarAsignado();
			}
			conSQL.closeConnection();

		} else if (panelFormularios.actualizarButton == e.getSource()) {
			conSQL.conectar();
			if (crudOption == 1) {
				modificarCientifico();
			} else if (crudOption == 2) {
				modificarProyecto();
			} else {
				modificarAsignado();
			}
			conSQL.closeConnection();
		}
	}

	// ----------------------------METODOS CIENTIFICOS-----------------------------

	public void buscarCientifico() {
		Connection c = ConexionSQL.connection;
		String dni = panelFormularios.buscarTextfield1.getText();
		String data = "";
		try {
			String query = "SELECT * FROM cientificos WHERE DNI=" + dni + ";";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "<html>DNI: " + resultSet.getString("dni");
				data += "<br/>NomApels: " + resultSet.getString("nomapels") + "</html>";
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
			String dni = panelFormularios.textfield2.getText();
			String nomApels = panelFormularios.textfield1.getText();

			String query = "INSERT INTO cientificos (DNI, nomapels) values" + "('" + dni + "','" + nomApels + "');";
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
			String dni = panelFormularios.borrarTexfield1.getText();

			String query = "DELETE FROM cientificos " + "WHERE DNI=" + dni + ";";
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
			String dniActual = panelFormularios.textfield4.getText();

			String dni = panelFormularios.textfield6.getText();
			String nomApels = panelFormularios.textfield5.getText();

			String query = "UPDATE cientificos " + "SET DNI = " + dni + ", nomapels='" + nomApels + "'" + "WHERE DNI = "
					+ dniActual + ";";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException | NumberFormatException ex) {
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
				data += "DNI: " + resultSet.getString("DNI");
				data += "<br/>NomApels: " + resultSet.getString("nomapels");
				data += "<br/>-----------------<br/>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText("<html>" + data + "</html>");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	// ----------------------------METODOS PROYECTO-----------------------------

	public void buscarProyecto() {
		Connection c = ConexionSQL.connection;
		String nombre = panelFormularios.buscarTextfield1.getText();
		String data = "";
		try {
			String query = "SELECT * FROM proyecto WHERE nombre=" + nombre + ";";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "<html>Nombre: " + resultSet.getString("nombre");
				data += "<br/>Horas: " + resultSet.getString("horas") + "</html>";
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
			String id = panelFormularios.textfield1.getText();
			String nombre = panelFormularios.textfield2.getText();
			int horas = Integer.parseInt(panelFormularios.textfield3.getText());

			String query = "INSERT INTO proyecto (id, nombre, horas) values" + "('" + id + "','" + nombre + "', '"
					+ horas + "');";
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
			String nombre = panelFormularios.borrarTexfield1.getText();
			String query = "DELETE FROM proyecto " + "WHERE nombre='" + nombre + "';";
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
			String idActual = panelFormularios.textfield4.getText();
			String nombre = panelFormularios.textfield5.getText();
			String nuevoId = panelFormularios.textfield6.getText();
			int horas = Integer.parseInt(panelFormularios.textfield7.getText());

			String query = "UPDATE proyecto " + "SET id = " + nuevoId + ", nombre='" + nombre + "', horas='" + horas
					+ "' WHERE id = " + idActual + ";";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void listarProyectos() {
		Connection c = ConexionSQL.connection;
		String data = "";
		try {
			String query = "SELECT * FROM proyecto;";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "ID: " + resultSet.getString("id");
				data += "<br/>Nombre: " + resultSet.getString("nombre");
				data += "<br/>Horas: " + resultSet.getString("horas");
				data += "<br/>-----------------<br/>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText("<html>" + data + "</html>");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	// ---------------------ASIGNADO_A-----------------------------
	public void buscarAsignado() {
		Connection c = ConexionSQL.connection;
		String cientifico = panelFormularios.buscarTextfield1.getText();
		String proyecto = panelFormularios.buscarTextfield2.getText();
		String data = "";
		try {
			String query = "SELECT * FROM asignado_a WHERE cientifico=" + cientifico + " AND proyecto= " + proyecto
					+ ";";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "<html>DNI Cientifico: " + resultSet.getString("cientifico");
				data += "<br/>ID Proyecto: " + resultSet.getString("proyecto") + "</html>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText(data);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void crearAsignado() {
		// INSERT VALUES
		Connection c = ConexionSQL.connection;
		try {
			String cientifico = panelFormularios.textfield1.getText();
			String proyecto = panelFormularios.textfield2.getText();

			String query = "INSERT INTO asignado_a (cientifico, proyecto) values" + "('" + cientifico + "','" + proyecto
					+ "');";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void borrarAsignado() { // DELETE
		Connection c = ConexionSQL.connection;
		try {
			String cientifico = panelFormularios.borrarTexfield1.getText();
			String proyecto = panelFormularios.borrarTexfield2.getText();
			String query = "DELETE FROM asignado_a " + "WHERE cientifico='" + cientifico + "' AND proyecto= '" +proyecto +"';";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Cliente borrado con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void modificarAsignado() {
		Connection c = ConexionSQL.connection;
		try {
			String idActual = panelFormularios.textfield4.getText();
			String cientificoActual = panelFormularios.textfield5.getText();
			String nuevoId = panelFormularios.textfield6.getText();
			String nuevoCientifico = panelFormularios.textfield7.getText();

			String query = "UPDATE asignado_a " + "SET cientifico = '" + nuevoCientifico + "', proyecto='" + nuevoId
					+ "'" + "WHERE cientifico = '" + cientificoActual + "' AND proyecto='" + idActual + "';";
			System.out.println(query);
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Datos insertados con exito!");
		} catch (SQLException | NumberFormatException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	public void listarAsignados() {
		Connection c = ConexionSQL.connection;
		String data = "";
		try {
			String query = "SELECT * FROM asignado_a;";
			Statement st = c.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				data += "DNI Cientifico: " + resultSet.getString("cientifico");
				data += "<br/>ID Proyecto: " + resultSet.getString("proyecto");
				data += "<br/>-----------------<br/>";
			}
			nextImage(cframe.panelContainer);
			cframe.labelResultados.setText("<html>" + data + "</html>");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar datos.");
		}
	}

	// ----------------CRUDVIEWS---------------------------

	public void changeCrudViews() {
		switch (panelOpciones.comboBox.getSelectedIndex()) {
		case 1:
			crudOption =1;
			showCientificosCrud();
			break;
		case 2:
			crudOption =2;
			showProyectosView();
			break;
		case 3:
			crudOption=3;
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
