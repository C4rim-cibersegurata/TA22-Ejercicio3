package controllers;

import models.*;

public class ControladorDB {
	private ConexionSQL modelo;
	private Cientificos c;
	private Proyectos p;
	private Asignado a;

	public ControladorDB(ConexionSQL modelo, Cientificos c, Proyectos p, Asignado a) {
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
		c.insertCientificos();
		p.createTable();
		p.insertProyectos();
		a.createTable();
		a.insertAsignado();
	}
	
	
}