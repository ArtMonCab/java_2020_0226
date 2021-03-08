<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Restaurar base de datos</h2>

<form method="post">

  <div class="form-group">
    <input type="file" class="form-control-file" id="archivo" name="archivo">
  </div>

	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary" id="cargar" name="cargar">Cargar archivo</button>
		</div>
	</div>
 

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>