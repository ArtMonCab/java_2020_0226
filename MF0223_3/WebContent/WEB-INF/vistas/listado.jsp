<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="listado" method="post">
<h2>Listado de platos</h2>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Calorias</th>
				<th scope="col">Elaboración</th>
				<th scope="col">Dificultad</th>
				<th scope="col">Categoria</th>
				<th scope="col">Origen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${platos}" var="p">
				<tr>
					<th scope="row">${p.id}</th>
					<td>${p.nombre_plato}</td>
					<td>${p.calorias}</td>
					<td>${p.elaboracion}</td>
					<td>${p.dificultad}</td>
					<td>${p.categoria.nombre_categoria}</td>
					<td>${p.origen.nombre_origen}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
  <div class="form-inline">
    <div class="col-auto my-1">
    	<button type="submit" class="btn btn-primary">Agregar plato</button>
    </div>
</div>
	
</form>

</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>