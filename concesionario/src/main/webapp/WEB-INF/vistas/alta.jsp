<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/templates/includes/cabecera.jsp" %>

<form  action ="agregar" method="post">
 	<h2>Alta</h2>
 	
 	<div class="form-row">	

        <div class="form-group col-md-4">
      		<label for="marca">Marca</label>
    		<select class="custom-select mr-sm-2" id="marca" name="marca">
                    <%-- <c:forEach items="${marcas}" var="m" > 
                         <option value="${m.id}">${m.nombre}</option>
                    </c:forEach>--%>
                    <option value="1">Citroen</option>
                    <option value="2">Renault</option>
                    <option value="3">Seat</option>
     	 	</select>
    	</div>

  	</div>
  	
  	<div class="form-row">
    	<div class="form-group col-md-10">
      		<label for="modelo">Modelo</label>
      		<input type="text" class="form-control" id="modelo" name="modelo" required title="El modelo es obligatorio">
    	</div>

  	</div>
  	
  	<div class="form-row">

    	<div class="form-group col-md-2">
      		<label for="matricula">Matrícula</label>
      		<input type="text" class="form-control" id="matricula" name="matricula" required pattern="[a-z]+" title="Las calorias deben ser un numero entero">
    	</div>
  	</div>


  	
  	<div class="form-row">
    	<div class="col-auto my-1">
    		<button type="submit" class="btn btn-primary">Aceptar</button>
    	</div>
	</div>
	
</form>
  
 
<%@ include file="/templates/includes/pie.jsp" %>