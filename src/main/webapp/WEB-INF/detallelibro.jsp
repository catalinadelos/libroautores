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
		
		<h4 class="p-1 text-primary border rounded-3"">Libro & Autores</h3>
		<div class="row">
	        <div class="col-6">
	        	<div class="m-3">
					<form action="/LibrosAutores/DetalleLibro" method="post">
						<% Libro l = (Libro)request.getAttribute("miLibro");%>
						<label class="form-label p-1 text-light bg-primary border rounded-3">id</label>
					    <input type="text" name="id_libro" class="form-control" value="<%=l.id%>" readonly></input>
					   	<label class="form-label p-1 text-light bg-primary border rounded-3">Titulo</label>
					    <input type="text" name="titulo" class="form-control" value="<%=l.titulo%>" readonly></input>	
						<label class="form-label p-1 text-light bg-primary border rounded-3">Descripcion</label>
					    <textarea rows="3" cols="33" name="descripcion" class="form-control" readonly><%=l.descripcion%></textarea>	
						
						<div class="row">
  							<div class="col-auto">
								<label class="form-label p-1 text-light bg-primary border rounded-3">Autores</label>	
							</div>
							<div class="col-auto">
								<select name="id_autor" class="form-select" required>
					                <option selected>Seleccione 1</option>
										<% ArrayList<Autor>autores = (ArrayList<Autor>)request.getAttribute("autores");
										if (autores!=null){
											for (Autor a: autores){%>
												<option value="<%=a.id%>"><%=a.nombre%> <%=a.apellido%></option>
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
				<% ArrayList<Autor>autoresxLibro = (ArrayList<Autor>)request.getAttribute("autoresxLibro");
					if (autoresxLibro!=null){%>
						<dl type="circle">
							<% for (Autor a: autoresxLibro){%>
								<dd><%=a.id %> - <%=a.nombre%> <%=a.apellido%></dd> 
							<%}%>
						</dl>
						
					<%}%>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>