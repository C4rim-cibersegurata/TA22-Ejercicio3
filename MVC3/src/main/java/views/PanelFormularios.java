package views;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormularios extends JPanel {
	
	public JTextField textfield1;
	public JTextField textfield2;
	public JTextField textfield3;
	public JTextField buscarTextfield1;
	public JTextField buscarTextfield2;
	public JTextField textfield5;
	public JTextField textfield6;
	public JTextField textfield4;
	public JTextField borrarTexfield1;
	public JTextField borrarTexfield2;
	public JButton crearButton;
	public JButton buscarButton;
	public JButton borrarButton;
	public JButton actualizarButton;
	public JButton listarButton;
	public JLabel resultadoBusqueda;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	public JLabel label5;
	public JLabel label6;
	public JLabel lblBuscar1;
	public JLabel lblBorrar1;
	public JLabel lblBorrar2;
	public JLabel lblBuscar2;
	

	public PanelFormularios() {
		setLayout(new CardLayout(0, 0));
		
		/*--------------FORMULARIO CREAR -------------------*/
		JPanel formularioCrear = new JPanel();
		add(formularioCrear, "crear");
		formularioCrear.setLayout(null);
		
		label1 = new JLabel("Nombre y apellidos: ");
		label1.setBounds(10, 11, 124, 14);
		formularioCrear.add(label1);
		
		textfield1 = new JTextField();
		textfield1.setBounds(10, 24, 124, 20);
		formularioCrear.add(textfield1);
		textfield1.setColumns(10);
		
		label2 = new JLabel("DNI: ");
		label2.setBounds(10, 55, 124, 14);
		formularioCrear.add(label2);
		
		textfield2 = new JTextField();
		textfield2.setColumns(10);
		textfield2.setBounds(10, 70, 124, 20);
		formularioCrear.add(textfield2);
		
		label3 = new JLabel(" Horas: ");
		label3.setBounds(10, 101, 124, 14);
		label3.setVisible(false);
		formularioCrear.add(label3);
		
		textfield3 = new JTextField();
		textfield3.setColumns(10);
		textfield3.setBounds(10, 115, 124, 20);
		textfield3.setVisible(false);
		formularioCrear.add(textfield3);
		
		crearButton = new JButton("Crear");
		crearButton.setBounds(10, 235, 89, 23);
		formularioCrear.add(crearButton);
		
		/*--------------FORMULARIO BUSCAR --------------------*/
		JPanel formularioBuscar = new JPanel();
		add(formularioBuscar, "buscar");
		formularioBuscar.setLayout(null);
		
		lblBuscar1 = new JLabel("DNI del científico: ");
		lblBuscar1.setBounds(10, 11, 133, 14);
		formularioBuscar.add(lblBuscar1);
		
		buscarTextfield1 = new JTextField();
		buscarTextfield1.setBounds(10, 24, 133, 20);
		formularioBuscar.add(buscarTextfield1);
		buscarTextfield1.setColumns(10);
		
		buscarTextfield2 = new JTextField();
		buscarTextfield2.setColumns(10);
		buscarTextfield2.setBounds(10, 69, 133, 20);
		buscarTextfield2.setVisible(false);
		formularioBuscar.add(buscarTextfield2);
		
		lblBuscar2 = new JLabel("Id del proyecto: ");
		lblBuscar2.setBounds(10, 55, 133, 14);
		lblBuscar2.setVisible(false);
		formularioBuscar.add(lblBuscar2);
		
		buscarButton = new JButton("Buscar");
		buscarButton.setBounds(54, 103, 89, 23);
		formularioBuscar.add(buscarButton);
		
		resultadoBusqueda = new JLabel("");
		resultadoBusqueda.setBounds(10, 137, 133, 151);
		formularioBuscar.add(resultadoBusqueda);
		
		
		
		/*--------------FORMULARIO BORRAR -----------------*/
		JPanel formularioBorrar = new JPanel();
		add(formularioBorrar, "borrar");
		formularioBorrar.setLayout(null);
		
		lblBorrar1 = new JLabel("DNI del científico: ");
		lblBorrar1.setBounds(10, 11, 130, 14);
		formularioBorrar.add(lblBorrar1);
		
		borrarTexfield1 = new JTextField();
		borrarTexfield1.setBounds(10, 25, 130, 20);
		formularioBorrar.add(borrarTexfield1);
		borrarTexfield1.setColumns(10);
		
		lblBorrar2 = new JLabel("Id del proyecto: ");
		lblBorrar2.setBounds(10, 56, 130, 14);
		lblBorrar2.setVisible(false);
		formularioBorrar.add(lblBorrar2);
		
		borrarTexfield2 = new JTextField();
		borrarTexfield2.setBounds(10, 69, 130, 20);
		borrarTexfield2.setVisible(false);
		formularioBorrar.add(borrarTexfield2);
		borrarTexfield2.setColumns(10);
		
		
		borrarButton = new JButton("Borrar");
		borrarButton.setBounds(10, 116, 89, 23);
		formularioBorrar.add(borrarButton);
		
		/*------------FORMULARIO ACTUALIZAR ----------------------*/
		JPanel formularioActualizar = new JPanel();
		add(formularioActualizar, "actualizar");
		formularioActualizar.setLayout(null);
		
		textfield4 = new JTextField();
		textfield4.setColumns(10);
		textfield4.setBounds(14, 35, 120, 20);
		formularioActualizar.add(textfield4);
		
		label4 = new JLabel("DNI actual: ");
		label4.setBounds(14, 21, 120, 14);
		formularioActualizar.add(label4);
		
		label5 = new JLabel("Nombre y apellidos: ");
		label5.setBounds(14, 64, 120, 14);
		formularioActualizar.add(label5);
		
		textfield5 = new JTextField();
		textfield5.setBounds(14, 80, 120, 20);
		formularioActualizar.add(textfield5);
		textfield5.setColumns(10);
		
		label6 = new JLabel("Horas: ");
		label6.setBounds(14, 104, 120, 14);
		label6.setVisible(false);
		formularioActualizar.add(label6);
		
		textfield6 = new JTextField();
		textfield6.setBounds(14, 120, 120, 20);
		textfield6.setVisible(false);
		formularioActualizar.add(textfield6);
		textfield6.setColumns(10);
		
		actualizarButton = new JButton("Actualizar");
		actualizarButton.setBounds(14, 266, 108, 23);
		formularioActualizar.add(actualizarButton);
	}
}
