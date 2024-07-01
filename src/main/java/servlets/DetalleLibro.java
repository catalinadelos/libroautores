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
 * Servlet implementation class DetalleLibro
 */
public class DetalleLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // Recuperamos el id desde los parámetros de la consulta
		String id = request.getParameter("id");
		
		try {
			// buscar los libro por id
			request.setAttribute("miLibro", LibroDao.BuscarLibro(id));
			
			//cargar los autores por id del libro
			ArrayList<Autor> autoresxLibro = AutorDao.getAutoresxLibro(id);
			request.setAttribute("autoresxLibro", autoresxLibro);
			
			System.out.println(autoresxLibro);
			
			//cargar los autores sin id del libro
			ArrayList<Autor> autores = AutorDao.getAutoresSinLibro(id);
			request.setAttribute("autores", autores);
			
			
			System.out.println(autores);
			
			

		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		// cargamos el jsp
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/detallelibro.jsp");
		vista.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_libro = request.getParameter("id_libro");
		String id_autor = request.getParameter("id_autor");
		
		try {
			
			LibroDao.guardarLibroAutor(id_libro, id_autor);
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}
		response.sendRedirect("/LibrosAutores/DetalleLibro?id=" + id_libro );
	}
}
