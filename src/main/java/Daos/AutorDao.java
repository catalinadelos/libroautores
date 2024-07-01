package Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Autor;
import models.MyConn;

public class AutorDao {

	static public Autor BuscarAutor(String id)throws SQLException{
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from autores where id=" + id );
		respuesta.next();

		Autor a = new Autor(
			respuesta.getInt("id"),
			respuesta.getString("nombre"),
			respuesta.getString("apellido"),
			respuesta.getString("notas")
		);
		// retornamos el autor
		return a;	
	}

	static public ArrayList<Autor> getAutores()throws SQLException{
		//creamos arraylist vacio
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from autores");
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Autor a = new Autor(
				respuesta.getInt("id"),
				respuesta.getString("nombre"),
				respuesta.getString("apellido"),
				respuesta.getString("notas")
			);

			autores.add(a);
		}
		 
		// retornamos el arraylist llenado
		return autores;
	}
	
	static public ArrayList<Autor> getAutoresxLibro(String id_libro)throws SQLException{
		//creamos arraylist vacio
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("SELECT * FROM autores WHERE id IN (SELECT id_autor FROM libros_autores WHERE id_libro =" + id_libro + ")");
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Autor a = new Autor(
				respuesta.getInt("id"),
				respuesta.getString("nombre"),
				respuesta.getString("apellido"),
				respuesta.getString("notas")
			);

			autores.add(a);
		}
		 
		// retornamos el arraylist llenado
		return autores;
	}
	
	
	
	static public ArrayList<Autor> getAutoresSinLibro(String id_libro)throws SQLException{
		//creamos arraylist vacio
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("SELECT * FROM autores WHERE id NOT IN (SELECT id_autor FROM libros_autores WHERE id_libro =" + id_libro + ")");
		
		
		//vamos llenando el arraylist con la respuesta a la consulta
		while (respuesta.next()){
			Autor a = new Autor(
				respuesta.getInt("id"),
				respuesta.getString("nombre"),
				respuesta.getString("apellido"),
				respuesta.getString("notas")
			);

			autores.add(a);
		}
		 
		// retornamos el arraylist llenado
		return autores;
	}
	
	
	static public void guardar(String nombre, String apellido, String notas)throws SQLException{

		//pedimos coneccion nueva
		Connection conn = MyConn.getConnection();
		
		//creamos y ejecutamos la consulta
		Statement consulta=conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("insert into autores (nombre, apellido,notas) values ('"+ nombre +"','" + apellido +"','" + notas + "')");
		

	}
}
