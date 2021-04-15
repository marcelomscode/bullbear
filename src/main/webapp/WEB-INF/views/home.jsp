<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="_comum/header.jsp" />

<c:set var="totalGain" value="0"/>

<c:forEach items="${registros}" var="registros">
	 <c:set var="totalTaxas" value="${totalTaxas + registros.getTaxas().getEmolumentos() + registros.getTaxas().getRegistro()+ registros.getTaxas().getIrrf()}"/>
	 <c:set var="totalGain" value="${totalGain + registros.getGainLoss()}"/>
	 <c:set var="totalDarf" value="${totalDarf + registros.getDarf()}"/>
</c:forEach>

<c:set var="total" value="${total + totalGain - totalTaxas - totalDarf}"/>


<div id="container-fluid" style="padding-right: 30px;padding-left: 30px;">

<div class="row">
<div class="col-md-12"><h1 align="center">REGISTRO DAY TRADE</h1></div> 


 	 <table class="table table-bordered table-shadow">
		<tr>
			<th class="font-gorda">DATA</th>
			<th class="font-gorda">Total Sem taxas</th>
			<th class="font-gorda">Total taxas</th>
			<th class="font-gorda">Total DARF</th>
			<th class="font-gorda">Total Gain/Loss</th>
		</tr>
		
		<tr>
			<td class="font-gorda size-25px"><fmt:formatDate value="${registros[0].getData()}" pattern="MM/yyyy"/></td>
			<td class="font-gorda size-25px"><span class="${total < 0  ? 'red-fonte': ''}"><fmt:formatNumber value="${total}" pattern="#,##0.00"/></span></td>
			<td class="font-gorda size-25px"><span><fmt:formatNumber value="${totalTaxas}" pattern="#,##0.00"/> </span></td>
			<td class="font-gorda size-25px"><span><fmt:formatNumber value="${totalDarf}" pattern="#,##0.00"/></span></td>
			<td class="font-gorda size-25px"><span class="${totalGain < 0  ? 'red-fonte': ''}"><fmt:formatNumber value="${totalGain}" pattern="#,##0.00"/></span></td>
		</tr>		
	</table>
</div>


 <div class="row">
	   	<table class="table table-striped table-shadow">
	   		<tr>
	   			<th>ATIVO</th>
	   			<th>DATA</th>
	   			<th>GAIN/LOSS</th>
	   			<th>Emolumentos</th>
	   			<th>Tx Registro</th>
	   			<th>IRRF</th>
	   			<th>DARF</th>
	   			<th></th>
	   			<th>TOTAL</th>
	   			<th>SALVAR</th>
	   		</tr>
	   		<tr>
	   		<form action="/addBullBear" method="post">
<!-- 	   		<th><input name="" type="text" class="form-control" id="add_ativo" placeholder="Ativo" value="Mini Indice"></th> -->
				<th>
					<select name="ativo" class="form-control">
						<c:forEach items="${ativos}" var="ativo">
							<option value="${ativo.getCodigoAtivo()}">${ativo.getAtivo()}</option>
						</c:forEach>
					</select>
				</th>
				<th><input name="data" type="date" class="form-control" id="add_data" placeholder="Data"></th>
	   			<th><input onblur="bullBearSad();"  name="gainLoss" type="text" class="form-control" id="add_gain_loss" placeholder="gain/loss"></th>
	   			<th><input name="emolumentos" type="text" class="form-control" id="emolumentos" placeholder="emolumentos" ></th>
	   			<th><input onblur="bullBearRegistro();" name="txRegistro" type="text" class="form-control" id="txRegistro" placeholder="Tx Registro" ></th>
	   			<th><input onblur="darf2();" name="irrf" type="text" class="form-control" id="irrf" placeholder="IRRF"></th>
	   			<th><input name="darf" type="text" class="form-control" id="darf" placeholder="DARF"></th>
	   			<th>=</th>
	   			<th><input name="total" type="text" class="form-control" id="total" placeholder="Total"></th>
	   			<th>
	   				<button type="submit" class="btn btn-primary">Salvar</button>
	   			</th>
	   		</form>	
	   		</tr>
	   		
	   	</table>
  </div>


  
  <div class="row">	
 	   	<table class="table table-bordered table table-striped  table-shadow">
			<tr>
				<th>Ativo</th>
				<th>Data</th>
				<th>Gain/Loss</th>
				<th>Taxas</th>
				<th>Darf</th>
				<th>Total</th>
			</tr>
		<c:forEach items="${registros}" var="registros">
			<tr>
				<td>${registros.getAtivo().getAtivo()}</td>
 				<td><fmt:formatDate value="${registros.getData()}" pattern="dd/MM/yyyy"/></td>
				<td class="${registros.getGainLoss() < 0  ? 'red-fonte': ''}" ><fmt:formatNumber value="${registros.getGainLoss()}" pattern="#,##0.00"/></td>
				<td>
				   <fmt:formatNumber value="${registros.getTaxas().getEmolumentos() + registros.getTaxas().getRegistro()+ registros.getTaxas().getIrrf()}" pattern="#,##0.00"/>	
				</td>
				<td><fmt:formatNumber value="${registros.getDarf()}" pattern="#,##0.00"/></td>
				<td class="${registros.getTotal() < 0  ? 'red-fonte': ''}" ><fmt:formatNumber value="${registros.getTotal()}" pattern="#,##0.00"/></td>
				
			</tr>
		</c:forEach>
		</table>	
		
  </div>
  <br><br><br><br><br><br><br><br><br><br><br><br>	
</div>	
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!-- <input type="text" maxlength="9" id="valor" onkeyup="formatarMoeda()"> -->
<script>
    function formatarMoeda(id) {
        var elemento = document.getElementById(id);
        var valor = elemento.value;

        valor = valor + '';
        valor = parseInt(valor.replace(/[\D]+/g, ''));
        valor = valor + '';
        valor = valor.replace(/([0-9]{2})$/g, ",$1");

        if (valor.length > 6) {
            valor = valor.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");
        }

        elemento.value = valor;
        if(valor == 'NaN') elemento.value = '';
    }


	function bullBearRegistro(){

		var gainLoss = converteValor($("#add_gain_loss").val());
		var emolumentos = converteValor($("#emolumentos").val());
		var txRegistro = converteValor($("#txRegistro").val());
		var total = "";
		var totalIRRF="";
		if(gainLoss < 0){
			total = gainLoss - 	emolumentos -txRegistro;
			$("#total").val(total.toLocaleString('pt-BR', {minimumFractionDigits: 2}));
		}else{
			totalIRRF = (gainLoss - emolumentos -txRegistro ) /100;
			$("#irrf").val(totalIRRF.toLocaleString('pt-BR', {minimumFractionDigits: 2}));
		}
	}


	function bullBearSad(){

		var gainLoss = converteValor($("#add_gain_loss").val());
		if(gainLoss < 0){
			$("#darf").val("0,00");
			$("#irrf").val("0,00");
		}

	}
	
    
	function gainDarf(){

		var valor = converteValor($("#add_gain_loss").val());

		var resultado = valor*0.2;
		var valorFormatado = resultado.toLocaleString('pt-BR', {minimumFractionDigits: 2});

		 if(valor < 0){
			$("#darf").val("0,00");
		}else{
			$("#darf").val(valorFormatado);
		}
			
		return resultado;
  }

   function darf2(){


	   var gainLoss = converteValor($("#add_gain_loss").val());
	   var emolumentos = converteValor($("#emolumentos").val());
	   var txRegistro = converteValor($("#txRegistro").val());
	   var irrf = converteValor($("#irrf").val());
	  

	   var gainLossMenosCustosOperacionais = parseFloat(gainLoss) -	parseFloat(emolumentos) - parseFloat(txRegistro);

	   var gainMaisIrrf =  parseFloat(gainLossMenosCustosOperacionais);

	   var calculaDarf = (parseFloat(gainMaisIrrf)*0.20) - parseFloat(irrf);

       var darf = 	calculaDarf.toLocaleString('pt-BR', {maximumFractionDigits: 2});

		if(darf < 0){
			$("#darf").val("0,00");
		}else{
			$("#darf").val(darf);
		}


		var lucro = gainLossMenosCustosOperacionais - parseFloat(irrf) - calculaDarf; 
		$("#total").val(lucro.toLocaleString('pt-BR', {maximumFractionDigits: 2}));
				
		return darf;
   }

		
   function calculaTotal(){
	   var darf = converteValor($("#darf").val());
	   var emolumentos = converteValor($("#emolumentos").val());
	   var txRegistro = converteValor($("#txRegistro").val());
	   var irrf = converteValor($("#irrf").val());
	   var darf = gainDarf();

	   var gainLossMenosCustosOperacionais = gainLoss -	emolumentos - txRegistro;
	   var gainMaisIrrf =  gainLossMenosCustosOperacionais + irrf;

	   var calculaDarf = gainMaisIrrf*0.2;



		
 	   var resultado = gainLoss-emolumentos-txRegistro-irrf-darf;

 	   var total = 	resultado.toLocaleString('pt-BR', {minimumFractionDigits: 2});

	  
	   
	   $("#total").val(total);

  }



     function converteValor(valor){
		var valor1 = valor.replace('.', '');
		var valor2 = valor1.replace(',', '.');
		return valor2;
  	}
   
</script>

			
</body>
</html>