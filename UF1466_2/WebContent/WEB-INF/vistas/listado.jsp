<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Listado de libros</h2>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
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
	
	<form>
  <div class="form-inline">
    <div class="col-auto my-1">
      <label class="mr-sm-2" for="inlineFormCustomSelect">Opciones de busqueda</label>

    </div>

    <div class="col-auto my-1">
    	<select class="custom-select mr-sm-2" id="opcionBusqueda" name="opcionBusqueda">
        	<option selected></option>
        	<option value="1">Por título</option>
        	<option value="2">Por ISBN</option>
     	 </select>
    </div>
    <div class="col-auto my-1">
    	<button type="submit" class="btn btn-primary">Buscar</button>
    </div>
  </div>
</form>

</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>