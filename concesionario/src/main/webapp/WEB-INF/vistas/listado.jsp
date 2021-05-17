<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="listado" method="post">
<h2>Listado</h2>

 <div class="form-inline">
    <div class="col-auto my-1">
    	<button type="submit" class="btn btn-primary">Consultar</button>
    </div>
</div>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead>
			<tr>
				<th scope="col">Modelo</th>
				<th scope="col">Matrícula</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${coches}" var="c">
				<tr>
					<td>${c.modelo}</td>
					<td>${c.matricula}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	

	
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>