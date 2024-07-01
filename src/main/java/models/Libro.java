package models;


public class Libro {

	// esta clase actua como modelo y DAO
	public int id;
	public String titulo;
	public String descripcion;

	public Libro(int id, String titulo,String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;

	}

	
}
