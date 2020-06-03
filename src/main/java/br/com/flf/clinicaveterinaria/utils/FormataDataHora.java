package br.com.flf.clinicaveterinaria.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FormataDataHora {
	
	private String dataHora;
	
	public FormataDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public Date converteDataHora() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return sdf.parse(this.dataHora);
	}
}
