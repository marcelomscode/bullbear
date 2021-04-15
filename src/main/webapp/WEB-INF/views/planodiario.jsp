<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="_comum/header.jsp" />

<div id="container-fluid" style="padding-right: 30px;padding-left: 30px;">


<c:forEach items="${registros}" var="pontos">
	<c:set var="pontosMes" value="${pontosMes + pontos.getPontos()}" />
	<c:set var="gainLossMes" value="${gainLossMes + pontos.getGainLoss()}" />
</c:forEach>



<div class="row">
<div class="col-md-12"><h1 align="center">PLANO DIÁRIO</h1></div> 

<table class="table table-bordered table-shadow">
	<tr>
		<th class="font-gorda">DATA</th>
		<th class="font-gorda">Pontos nesse Mês</th>
		<th class="font-gorda">Gain/Loss Mês</th>
	</tr>
	<tr>
		<td class="font-gorda size-25px"><fmt:formatDate value="${registros[0].getData()}" pattern="MM/yyyy"/></td>
		<td class="${diario.getGainLoss() < 0  ? 'red-fonte': ''} font-gorda size-25px">${pontosMes}</td>
		<td class="${diario.getGainLoss() < 0  ? 'red-fonte': ''} font-gorda size-25px"><fmt:formatNumber value="${gainLossMes}" pattern="#,##0.00"/></td>
	</tr>
</table>

</div>




<div class="row">
	   	<table class="table table-striped table-shadow">
	   		<tr>
	   			<th>ATIVO</th>
	   			<th>DATA</th>
	   			<th>Pontos</th>
	   			<th>Contratos</th>
	   			<th>GAIN/LOSS</th>

	   			<th>SALVAR</th>
	   		</tr>
	   		<tr>
	   		<form action="/addPlanoDiario" method="post">
<!-- 	   		<th><input name="" type="text" class="form-control" id="add_ativo" placeholder="Ativo" value="Mini Indice"></th> -->
				<th>
					<select name="ativo" class="form-control">
						<c:forEach items="${ativos}" var="ativo">
							<option value="${ativo.getCodigoAtivo()}">${ativo.getAtivo()}</option>
						</c:forEach>
					</select>
				</th>
				<th><input name="data" type="date" class="form-control" id="add_data" placeholder="Data"></th>
	   			<th><input name="pontos" type="text" class="form-control" id="pontos" placeholder="Pontos"></th>
	   			<th><input name="contratos" type="text" class="form-control" id="contratos" placeholder="Contratos"></th>
	   			<th><input name="gainLoss" type="text" class="form-control" id="gainLoss" placeholder="Gain/loss"></th>
	   			<th>
	   				<button type="submit" class="btn btn-primary">Salvar</button>
	   			</th>
	   		</form>	
	   		</tr>
	   		
	   	</table>
  </div>
  
  <div class="row">
	    <table class="table table-striped table-shadow">
	  		<tr>
	  			<th>ATIVO</th>
	  			<th>DATA</th>
	  			<th>Pontos</th>
	  			<th>Contratos</th>
	  			<th>GAIN/LOSS</th>
	  		</tr>
	  		<c:forEach items="${registros}" var="diario">
		  		<tr>
				    <th>${diario.getAtivo().getAtivo()}</th>
				    <th><fmt:formatDate value="${diario.getData()}" pattern="dd/MM/yyyy"/></th>
		  			<th class="${diario.getPontos() < 0  ? 'red-fonte': ''}"><fmt:formatNumber value="${diario.getPontos()}" pattern="#,##0.00"/></th>
		  			<th><fmt:formatNumber value="${diario.getContratos()}" pattern="#,##0.00"/></th>
		  			<th class="${diario.getGainLoss() < 0  ? 'red-fonte': ''}"><fmt:formatNumber value="${diario.getGainLoss()}" pattern="#,##0.00"/></th>
		  		</tr>
	  		</c:forEach>
		</table>
  </div>



  
</div>

</body>
</html>