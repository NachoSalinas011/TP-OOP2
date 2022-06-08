package com.springboot.clienteapp.util;

import java.sql.Date;
import java.time.LocalDate;

public class modelDTO {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	
	
	public modelDTO() {
		super();
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "modelDTO [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
}
