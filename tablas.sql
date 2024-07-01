
create table libros(
	id serial primary key,
	titulo varchar(100) not null,
	descripcion varchar(255)
);

create table autores(
	id serial primary key,
	nombre varchar(100) not null,
	apellido varchar(100),
	notas varchar(255)
);

create table libroautor(
	libro_id int not null,
	autor_id int not null,
	primary key (libro_id,autor_id),
	foreign key (libro_id) references libros(id),
	foreign key (autor_id) references autores(id)
);



