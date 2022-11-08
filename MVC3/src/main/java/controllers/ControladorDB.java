package controllers;

import models.*;

public class ControladorDB {
	private ConexionSQL modelo;
	private Cientificos c;
	private Proyecto p;
	private Asignado_a a;

	public ControladorDB(ConexionSQL modelo, Cientificos c, Proyecto p, Asignado_a a) {
		super();
		this.modelo = modelo;
		this.c = c;
		this.p = p;
		this.a = a;
	}



	public void iniciarDB() {
		modelo.conectar();
		modelo.crearDB();
		c.createTable();
		c.insertClientes();
		p.createTable();
		p.insertClientes();
		a.createTable();
		a.insertClientes();
	}
	
	
}