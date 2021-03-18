<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="agregar" method="post">
  <h2>Nuevo plato</h2>
  <div class="form-row">
    <div class="form-group col-md-10">
      <label for="plato">Plato</label>
      <input type="text" class="form-control" id="plato" name="plato">
    </div>

    <div class="form-group col-md-2">
      <label for="calorias">Calorias</label>
      <input type="text" class="form-control" id="calorias" name="calorias">
    </div>
  </div>
  <div class="form-group">
    <label for="elaboracion">Elaboración</label>
    <textarea class="form-control" id="elaboracion" name="elaboracion" rows="10"></textarea>
  </div>

  <div class="form-row">

    <div class="form-group col-md-4">
      <label for="dificultad">Dificultad</label>
    	<select class="custom-select mr-sm-2" id="dificultad" name=dificultad">
        	<option value="1">Facil</option>
        	<option value="2">Medio</option>
        	<option value="3">Dificil</option>
     	 </select>
    </div>
        <div class="form-group col-md-6">
      <label for="categoria">Categoría</label>
      <input type="text" class="form-control" id="categoria" name="categoria">
    </div>
    <div class="form-group col-md-2">
      <label for="origen">Origen</label>
      <input type="text" class="form-control" id="origen" name="origen"">
    </div>
  </div>
  <div class="form-group">
  	<button type="submit" class="btn btn-primary">Agregar plato</button>
  </div>
  
</form>
 
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>