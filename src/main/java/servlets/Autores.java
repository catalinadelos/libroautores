package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Autor;
import models.Libro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Daos.AutorDao;
import Daos.LibroDao;

/**
 * Servlet implementation class Autores
 */
public class Autores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cargamos el jsp
		
		try {
			
			//cargar los autores
			ArrayList<Autor> autores = AutorDao.getAutores();
			System.out.println(autores);
			request.setAttribute("autores", autores);
			
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		// cargamos el jsp
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/autores.jsp");
		vista.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String notas = request.getParameter("notas");
			
			AutorDao.guardar(nombre, apellido,notas);
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		response.sendRedirect("/LibrosAutores/Autores");
	}

}
