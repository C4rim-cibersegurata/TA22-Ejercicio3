package utils;

public class Credentials {

	private String usuario;
	private String password;
	private String ip;

	public Credentials() {
		usuario = "remote";
		password = "Arcangel1999!";
		ip = "192.168.0.45";
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getIp() {
		return ip;
	}
	
}
