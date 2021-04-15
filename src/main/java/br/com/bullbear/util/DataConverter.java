package br.com.bullbear.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataConverter {
	
	
	public static Date converteStringDate(String data) throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     Date datas = sdf.parse(data);
	     return datas;
	}
	
	public static Date converteDatasStringParaCalendar(String data){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", new Locale("pt", "BR"));
		try {
			c.setTime(df.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return c.getTime();
	}
	
	// ----------------Converte Valores de Reais para Dolar ---------------------//
	public static BigDecimal realParaDolar(String valor){
		if (valor == null || valor.isEmpty()) {
			valor = "0";
			BigDecimal v = new BigDecimal(formataValores(valor));
			return v;
		} else {
			BigDecimal v = new BigDecimal(formataValores(valor));
			return v;
		}
	}

	public static String formataValores(String i){
		String j;
		j = i.replace('.', ' ').replace(',', '.').replaceAll(" ", "");	
		return j;
	}
	
// ----------------Converte Valores de Dolar para Real ---------------------//
	public static String dolarParaReal(String ValorEmDolar){
		
		final Locale BRAZIL = new Locale("pt","BR");
		final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);    
		final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00",REAL); 
		
		Double ValorEmDolarParaDouble = Double.parseDouble(ValorEmDolar);
		
		String ValorConvertidoEmReal = mascaraDinheiro(ValorEmDolarParaDouble, DINHEIRO_REAL);
		ValorConvertidoEmReal = ValorConvertidoEmReal.replace("R$ ", "");
		
		return ValorConvertidoEmReal;
	}
	
	public static String mascaraDinheiro(double valor, DecimalFormat moeda){    
		         return moeda.format(valor);    
	} 


//	public String converteValoresPorExtenso(BigDecimal valorEmDolar){
//		
//		NumericToWordsConverter converter;  
//		converter = new NumericToWordsConverter(new FormatoDeReal());  
//		double numero = valorEmDolar.doubleValue();  
//		String extenso = converter.toWords(numero); 
//		
//		return extenso;
//	}	
	
	
	
	
	
	
	
}