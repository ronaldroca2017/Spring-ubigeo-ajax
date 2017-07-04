<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ubigeo Ajax</title>
	<script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous"></script>
</head>
<body>
		<table>
			<tr>
				<td>Departamento</td>
				<td>
					<select name="departamento" id="departamento" onchange="cargarProvincias()">
						<option value="0">--seleccione--</option>
					
					</select>
				</td>
			</tr>
			<tr>
			<td>Provincia</td>
				<td>
					<select name="provincia" id="provincia" onchange="cargarDistrito()">
						<option value="0">--seleccione--</option>
					
					</select>
				</td>
			</tr>
			<tr>
			<td>Distrito</td>
				<td>
					<select name="distrito" id="distrito">
						<option value="0">--seleccione--</option>
					
					</select>
				</td>
			</tr>
		</table>
		
		<script type="text/javascript">
			
			$(document).ready(function() {
				cargarComboDepartamento();
			});
				
			var cargarComboDepartamento = function(){			
				 $.ajax({
			            type:'GET',
			            url:'Departamento',
			            dataType:'json',
			            success:function (result) {
			            	  for(var i = 0; i<result.length; i++){
				                	var select = document.getElementById("departamento");
				                	select.options[i+1] = new Option(result[i].nomDep);
				                	select.options[i+1].value = result[i].idDep;            	
				                }
			            },
			            error:function (jqXHR, textStatus, errorThrown) {
			                alert("textStatus " + textStatus + " " + errorThrown + " !");
			            }

			        }); 
			}
			
			
			function cargarProvincias(){
					 document.getElementById("provincia").options.length = 1 //Borramos los datos del combo provincia y 1 para que solo tenga el valor de --seleccionar--
					 var idDep = document.getElementById("departamento").value;
					 $.ajax({
				            type:'GET',
				            url:"Provincia/"+idDep,
				            dataType:'json',
				            success:function (result) {
				            	//Recorriendo el resultado con javascript usando for
				            	  for(var i = 0; i<result.length; i++){
					                	var select = document.getElementById("provincia");
					                	select.options[i+1] = new Option(result[i].nomProv);
					                	select.options[i+1].value = result[i].idProv;            	
					                
					                }

				            },
				            error:function (jqXHR, textStatus, errorThrown) {
				                alert("textStatus " + textStatus + " " + errorThrown + " !");
				            }

				        });
					 document.getElementById("distrito").options.length = 1;//Borramos los datos del combo distrito y 1 para que solo tenga el valor de --seleccionar--
			}
			
			
			function cargarDistrito(){
				document.getElementById("distrito").options.length = 1;//Borramos los datos del combo distrito y 1 para que solo tenga el valor de --seleccionar--
				 var idProv = document.getElementById("provincia").value;
				 $.ajax({
			            type:'GET',
			            url:"Distrito/"+idProv,
			            dataType:'json',
			            success:function (result) {		            	
			            	//Recorriendo el resultado con jquery $.each
			            	$.each(result, function (indice, objeto) { 
			            		var select = document.getElementById("distrito");
			                	select.options[indice+1] = new Option(objeto.nomDist);
			                	select.options[indice+1].value = objeto.idDist;       
			            	
			            		}); 		            	
			            /* for(var i = 0; i<result.length; i++){
				                var select = document.getElementById("distrito");
				                select.options[i+1] = new Option(result[i].nomDist);
				                select.options[i+1].value = result[i].idDist;            	
				                
				         }*/
			            },
			            error:function (jqXHR, textStatus, errorThrown) {
			                alert("textStatus " + textStatus + " " + errorThrown + " !");
			            }

			        });	
			}	
		</script>
</body>
</html>