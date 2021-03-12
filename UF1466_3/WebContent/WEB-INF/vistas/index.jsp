<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="index" method="post">
	<h1>Copiar base de dato gestiondocente</h1>
  	<div class="form-group">
    	<label for="nombre"><h4>Nuevo nombre</h4></label>
    	<input type="text" class="form-control" id="nombre" name="nombre" value="backup_gestiondocente">
  	</div>

	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="ejecutar" name="ejecutar">ejecutar</button>
		</div>
	</div>
 

</form>

<br>




<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>