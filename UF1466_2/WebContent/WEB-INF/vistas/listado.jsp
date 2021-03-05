3<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Listado de productos</h2>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>UF1466 Actividad 2</caption>
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Título</th>
				<th scope="col">ISBN</th>
				<th scope="col">Autor</th>
				<th scope="col">Acción</th>
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

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>