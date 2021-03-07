<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Libros encontrados</h2>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Autor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="l">
				<tr>
					<th scope="row">${l.id}</th>
					<td>${l.titulo}</td>
					<td>${l.isbn}</td>
					<td>${l.autor.nombre}&nbsp;${l.autor.apellidos}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

	
</div>

<div class="container">
	<div class="row">
		<a class="btn btn-primary" href="listado" role="button">Volver al listado</a>
	</div>
	<div class="row">
		&nbsp;
  	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>