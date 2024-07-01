package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Daos.LibroDao;


/**
 * Servlet implementation class Libros
 */
public class Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Libros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cargamos el jsp
		
		try {
			
			//cargar los libros
			ArrayList<Libro> libros = LibroDao.getLibros();
			System.out.println(libros);
			request.setAttribute("libros", libros);
			
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		// cargamos el jsp
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/libros.jsp");
		vista.forward(request, response);
				

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String titulo = request.getParameter("titulo");
			String descripcion = request.getParameter("descripcion");
			
			LibroDao.guardar(titulo, descripcion);
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		response.sendRedirect("/LibrosAutores/Libros");

	}
	

}
