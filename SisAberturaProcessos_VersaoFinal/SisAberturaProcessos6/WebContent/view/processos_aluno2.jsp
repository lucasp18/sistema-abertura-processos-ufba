<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<%@page import="br.com.sistemaaberturaprocessos.controller.*"%>
<%@page import="br.com.sistemaaberturaprocessos.model.*"%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>


<html lang="pt-br">
<head>
<meta charset="utf-8">

<title>UFBA - Sistema de Abertura de Processos UFBA</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<style>
	.processo{
  		width: auto; 
    	left: auto; 
    	margin: -190px 0 0px -150px; 
    	padding:190px;
	}

	.formulario{
		display: none;
	}

	.tabela{
		display: block;
	}
		
	.cadastro{
		width: 900px;
		left: 900%;
		margin: -100px 0 0 -130px;
		padding:150px;
	}

	.footer {
	    position: relative;
	    bottom:0;
	    width:100%;
	    font-size: 14px;
	    padding-top: 50px;
	    padding-bottom: 15px;
	    background-color: #000000;
	    color: #bdc3c7;
	}

</style>
<script> 
		window.onload=function(){
			document.getElementById("mostrar_listagem_processos").onclick=function(){
				document.getElementsByClassName("tabela")[0].style.display="block";
				document.getElementsByClassName("formulario")[0].style.display="none";
			};
			document.getElementById("mostrar_cadastro_processo").onclick=function(){
				document.getElementsByClassName("formulario")[0].style.display="block";
				document.getElementsByClassName("tabela")[0].style.display="none";
			};
		};
</script>

<body>
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
  		<div class="container">
  			<img src="img/logo.png">
  		</div>
	</nav>

	<div class="container">
		<div class="processo">
			<ul class="nav nav-tabs" role="tablist">
				<li id="mostrar_listagem_processos"><a href="#">Lista de processos</a></li>
	        	<li  id="mostrar_cadastro_processo"><a href="#">Criar processo</a></li>
	      	</ul>
	      	<div class="formulario">
	      		<br>
	      		<form enctype="multipart/form-data"  method="POST"  action="adicionar_processo"> 
  					<fieldset>
    					<legend>Requerimento</legend>
    					<div class="radio">
						    <label>
  								<input type="radio" name="optionsRadios" id="optionsRadios1" value="1" checked> Aproveitamento de Cursos, Atividades e Programas Institucionais
  							</label>
  						</div>
  						<div class="radio">
  							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios2" value="2"> Aproveitamento de Estudos
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios3" value="3"> Avaliação Curricular
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios4" value="4"> CERTIDÃO de 
								<input class="input-sm" type="text" name="tipo_certidao" placeholder="Tipo de certidao">
							</label> 
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios5" value="5"> Certidão de Estudos de Aluno Especial da Graduação
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios6" value="6"> Certificado de Aluno Especial da Pós-Graduação
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios7" value="7"> Certificado de Especialização
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios8" value="8"> Desistência definitiva de Curso
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios9" value="9"> Dilatação do Prazo Máximo para Conclusão do Curso
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios10" value="10"> Dispensa de Pré-requisito
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios11" value="11"> Dispensa de Tirocínio Docente
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios12" value="12"> Homologação e autorização para emissão de diploma
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios13" value="13"> Matrícula Aluno Convênio (Acordo Cultural)
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios14" value="14"> Matrícula Aluno Especial
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios15" value="15"> Matrícula Aluno Intercâmbio (Acordo Cultural)
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios16" value="16"> Matrícula como Portador de Diploma de Nível Superior de caráter especial
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios17" value="17"> Matrícula de Ingresso através de Processo Seletivo de Vagas Residuais
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios18" value="18"> Permanência no Curso
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios19" value="19"> Reconsideração de despacho/Recurso
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios20" value="20"> Retificação de Histórico
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios21" value="21"> Revalidação de Diploma ou Certificado
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios22" value="22"> Transferência “ex-officio”
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios23" value="23"> Transferência Interna de Caráter Especial
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios24" value="24"> Transferência Pós-Graduação
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios25" value="25"> Trancamento
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios26" value="26"> Total de inscrição em disciplinas
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios27" value="27"> Parcial de inscrição em disciplinas
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios28" value="28"> Por tempo determinado
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios29" value="29"> Outros ( especificar)
								<input class="input-sm" type="text" name="tipo_homologacao" placeholder="Outros">
							</label>
						</div>
												
						
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<label> Anexar arquivo
									<input type="file" name="arquivo" class="filestyle" data-size="sm">
								</label>
							</div>
						</div>
						
						<legend>Esclarecimentos</legend>
						<textarea name="esclarecimento" class="form-control"  rows="5"></textarea>
    		
    					
   						
   						<button type="submit" class="btn btn-default btn-lg">
  							<span class="glyphicon glyphicon-floppy-disk"></span> Enviar
						</button>
  						<button type="button" class="btn btn-default btn-lg">
  							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
						
  					</fieldset>
				</form>
			
	      	</div>
	      	
	      	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		      
		      <jsp:useBean id="listaDeProcessos" class="br.com.sistemaaberturaprocessos.model.ListaDeProcessos" scope="request"/>
	      		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	      	<div class="tabela">     
		       
		        <table class="table table-striped">
		        	
		        	<thead>
		              <tr>
		                <th>C&oacute;digo</th>
		                <th>Data de abertura</th>
		                <th>Data de finaliza&ccedil;&atilde;o</th>
		                <th>Situa&ccedil;&atilde;o</th>
		                <th>Resultado</th>
		              </tr>
		            </thead>
		            
		            <tbody>
		              <tr>
		                <td></td>
		                <td></td>
		                <td>-</td>
		                <td>Em andamento</td> 		<!-- falta esses dois campos na tabela  -->
		                <td>ainda nao finalizado</td> <!-- falta esses dois campos na tabela  -->
		              </tr>
		           </tbody>
		            
		           <!--     
		              <tr>
		                <td>0002</td>
		                <td>18/06/2014</td>
		                <td>-</td>
		                <td>Em andamento</td>
		                <td>ainda nao finalizado</td>
		              </tr>
		              <tr>
		                <td>0003</td>
		                <td>18/06/2014</td>
		                <td>-</td>
		                <td>Em andamento</td>
		                <td>ainda nao finalizado</td>
		              </tr>
		              <tr>
		                <td>0004</td>
		                <td>18/06/2014</td>
		                <td>-</td>
		                <td>Em andamento</td>
		                <td>ainda nao finalizado</td>
		              </tr>
		              
		            </tbody> -->
		          </table>
		   </div>
	    </div>
    </div>
	

<footer class="footer">
	<div class="container">
		<address>
			<strong>UFBA - Universidade Federal da Bahia</strong><br>
			Avenida Ademar de Barros, S/N - Campus de Ondina <br> CEP
			40.170-110 Salvador-Bahia.<br> Telefone: 3283-6124 / Fax: 3283-6123
		</address>
	</div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js" charset="utf-8"></script>
<script src="js/bootstrap.min.js"></script>


</body>
</html>