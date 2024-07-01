package models;

public class Autor {
	// esta clase actua como modelo y DAO
	public int id;
	public String nombre;
	public String apellido;
	public String notas;
	
	public Autor(int id, String nombre,String apellido,String notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = notas;
	}

}
