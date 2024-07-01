package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.MyConn;
import models.Libro;

public class LibroDao {
	
	static public Libro BuscarLibro(String id)throws SQLException{
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from libros where id=" + id );
		respuesta.next();

		Libro l = new Libro(
			respuesta.getInt("id"),
			respuesta.getString("titulo"),
			respuesta.getString("descripcion")
		);
		// retornamos el libro
		return l;	
	}
	

	
	static public void guardarLibroAutor(String id_libro, String id_autor)throws SQLException{

		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("insert into libros_autores (id_libro, id_autor) values ("+ id_libro +"," + id_autor +")");
		
	}
	
	
	static public ArrayList<Libro> getLibros()throws SQLException{
		//creamos arraylist vacio
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from libros");
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Libro l = new Libro(
				respuesta.getInt("id"),
				respuesta.getString("titulo"),
				respuesta.getString("descripcion")
			);

			libros.add(l);
		}
		 
		// retornamos el arraylist llenado
		return libros;
	}
	
	
	static public void guardar(String titulo, String descripcion)throws SQLException{

		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("insert into Libros (titulo, descripcion) values ('"+ titulo +"','" + descripcion +"')");
	}

	static public ArrayList<Libro> getLibrosxAutor(String id_autor)throws SQLException{
		//creamos arraylist vacio
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("SELECT * FROM libros WHERE id IN (SELECT id_libro FROM libros_autores WHERE id_autor =" + id_autor + ")");
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Libro l = new Libro(
				respuesta.getInt("id"),
				respuesta.getString("titulo"),
				respuesta.getString("descripcion")
			);

			libros.add(l);
		}
		 
		// retornamos el arraylist llenado
		return libros;
	}
	
	
	
	static public ArrayList<Libro> getLibrosSinAutor(String id_autor)throws SQLException{
		//creamos arraylist vacio
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("SELECT * FROM libros WHERE id NOT IN (SELECT id_libro FROM libros_autores WHERE id_autor =" + id_autor + ")");
		
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Libro l = new Libro(
				respuesta.getInt("id"),
				respuesta.getString("titulo"),
				respuesta.getString("descripcion")
			);

			libros.add(l);
		}
		 
		// retornamos el arraylist llenado
		return libros;
	}
	
}
