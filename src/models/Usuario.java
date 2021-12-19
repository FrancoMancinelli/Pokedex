package models;

public class Usuario {

	//Atributos
	protected String username;
	protected String password;
	
	/**
	 * Construye un usuario
	 * @param username Nombre del usuario
	 * @param password Contraseña del usuario
	 */
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
