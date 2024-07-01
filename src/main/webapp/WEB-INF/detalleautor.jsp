<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" import="models.Autor" import="models.Libro" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mi Biblioteca</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="assets/style.css" rel="stylesheet">
</head>
<body>

<div class="container border border-primary-subtle rounded-3 bg-light bg-gradient">
		<nav class="navbar navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">
		          <img src="assets/logo3.png" width="55"alt="logo"> Mi Biblioteca
		        </a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" href="/LibrosAutores/Libros" role="button">
			            Libros
			          </a>
			          <a class="nav-link" href="/LibrosAutores/Autores" role="button">
			            Autores
			          </a>
			        </li>
			      </ul>
			    </div>
		  	</div>
		</nav>
		
		<h4 class="p-1 text-primary border rounded-3">Detalle Autor</h3>
		<div class="row">
	        <div class="col-6">
	        	<div class="m-3">
					<form action="/LibrosAutores/DetalleAutor" method="post">
						<% Autor a = (Autor)request.getAttribute("miAutor");%>
						<label class="form-label p-1 text-light bg-primary border rounded-3">id</label>
					    <input type="text" name="id_autor" class="form-control" value="<%=a.id%>" readonly></input>
						<label class="form-label p-1 text-light bg-primary border rounded-3">Nombre</label>
					    <input type="text" name="nombre" class="form-control" value="<%=a.nombre%>" readonly></input>	
					   	<label class="form-label p-1 text-light bg-primary border rounded-3">Apellido</label>
					    <input type="text" name="apellido" class="form-control" value="<%=a.apellido%>" readonly></input>	
						<label class="form-label p-1 text-light bg-primary border rounded-3">Notas</label>
					    <textarea rows="3" cols="33" name="descripcion" class="form-control" readonly><%=a.notas%></textarea>	
						
						<div class="row">
  							<div class="col-auto">
								<label class="form-label p-1 text-light bg-primary border rounded-3">Libros</label>	
							</div>
							<div class="col-auto">
								<select name="id_libro" class="form-select" required>
					                <option selected>Seleccione 1</option>
										<% ArrayList<Libro>libros = (ArrayList<Libro>)request.getAttribute("libros");
										if (libros!=null){
											for (Libro l: libros){%>
												<option value="<%=l.id%>"><%=l.titulo%></option>
											<%}%>
										<%}%>
					            </select>
							</div>
						</div>
			           	<input type="submit" name="btn" value="agregar" class="btn btn-outline-primary">
					</form>
				</div>
			</div>
			<div class="col-6">
				<label class="form-label p-1 text-light bg-primary border rounded-3">Lista de Autores</label>
				<% ArrayList<Libro>librosxAutor = (ArrayList<Libro>)request.getAttribute("librosxAutor");
					if (librosxAutor!=null){%>
						<dl type="circle">
							<% for (Libro l: librosxAutor){%>
								<dd><%=l.id %> - <%=l.titulo%></dd> 
							<%}%>
						</dl>
					<%}%>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>