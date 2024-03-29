<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form  action ="agregar" method="post">
 	<h2>Nuevo plato</h2>
 	
  	<div class="form-row">
    	<div class="form-group col-md-10">
      		<label for="nombrePlato">Plato</label>
      		<input type="text" class="form-control" id="nombrePlato" name="nombrePlato" required title="El nombre del plato es obligatorio">
    	</div>

    	<div class="form-group col-md-2">
      		<label for="calorias">Calorias</label>
      		<input type="text" class="form-control" id="calorias" name="calorias" required pattern="[0-9]+" title="Las calorias deben ser un numero entero">
    	</div>
  	</div>
  	
  	<div class="form-row">
  		<div class="form-group col-md-12">
    		<label for="elaboracion">Elaboración</label>
    		<textarea class="form-control" id="elaboracion" name="elaboracion" rows="10" required title="La elaboración es obligatorio"></textarea>
  		</div>
  	</div>

  	<div class="form-row">	
    	<div class="form-group col-md-4">
      		<label for="dificultad">Dificultad</label>
    		<select class="custom-select mr-sm-2" id="dificultad" name="dificultad">
        		<option value="1">Alta</option>
        		<option value="2">Media</option>
        		<option value="3">Baja</option>
     	 	</select>
    	</div>
        <div class="form-group col-md-4">
      		<label for="categoria">Categoría</label>
    		<select class="custom-select mr-sm-2" id="categoria" name="categoria">
                    <c:forEach items="${categorias}" var="c" >
                        <option value="${c.id}">${c.nombre_categoria}</option>
                    </c:forEach>
     	 	</select>
    	</div>
    	<div class="form-group col-md-4">
      		<label for="origen">Origen</label>
    		<select class="custom-select mr-sm-2" id="origen" name="origen">
                    <c:forEach var="o" items="${origenes}">
                        <option value="${o.id}">${o.nombre_origen}</option>
                    </c:forEach>
     	 	</select>
    	</div>
  	</div>
  	
  	<div class="form-row">
    	<div class="col-auto my-1">
    		<button type="submit" class="btn btn-primary">Agregar plato</button>
    	</div>
	</div>
	
</form>
  
 
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>