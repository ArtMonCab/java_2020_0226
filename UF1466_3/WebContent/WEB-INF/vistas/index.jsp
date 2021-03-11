<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form method="post" novalidate enctype="multipart/form-data">

  	<div class="form-group">
    	<input type="file" class="form-control-file" id="archivoRestaurar" name="archivoRestaurar">
  	</div>

	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="cargar" name="cargar">Restaurar</button>
		</div>
	</div>
 

	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="cargar" name="cargar">&nbsp;Guardar&nbsp;</button>
		</div>
	</div>
</form>

<br>




<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>