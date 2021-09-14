package br.com.app.modelo.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
	
	public static BigDecimal regraTres(BigDecimal valor,BigDecimal mult,BigDecimal div) {
		BigDecimal valorCalculado = valor.multiply(mult);
		valorCalculado = valorCalculado.setScale(2,RoundingMode.HALF_UP);
		valorCalculado = valorCalculado.divide(div, 2,RoundingMode.HALF_UP);
		return valorCalculado;
	}

}