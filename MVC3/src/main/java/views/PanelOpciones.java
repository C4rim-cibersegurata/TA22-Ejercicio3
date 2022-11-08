package views;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class PanelOpciones extends JPanel{
	
	public JButton btnCrear;
	public JButton btnEliminar;
	public JButton btnModificar;
	public JButton btnListar;
	public JButton btnBuscar;
	public JComboBox comboBox;
	
	
	public PanelOpciones() {
		
		
		setBounds(10, 11, 122, 239);
		setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Operación a realizar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addItem("Científicos");
		comboBox.addItem("Proyectos");
		comboBox.addItem("Asignado a");
		add(comboBox);
		
		btnCrear = new JButton("Crear");
		add(btnCrear);
		
		btnEliminar = new JButton("Eliminar");
		add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		add(btnModificar);
		
		btnListar = new JButton("Listar");
		add(btnListar);
		
		btnBuscar = new JButton("Buscar");
		add(btnBuscar);
		
		
		
	}
	
}
