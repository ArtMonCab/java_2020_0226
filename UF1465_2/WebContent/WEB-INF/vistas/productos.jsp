<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Listado de productos</h2>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<caption>UF1465 Actividad 2</caption>
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Precio</th>
				<th scope="col">Categoría</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th scope="row">${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td>${p.categoria.nombreCategoria}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>