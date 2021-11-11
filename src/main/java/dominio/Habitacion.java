package dominio;

import enumClasses.EstadoDeHabitacion;

public class Habitacion {

	private Integer numero;
	private EstadoDeHabitacion estado;
	
	public Habitacion(Integer numero, EstadoDeHabitacion estado) {
	
		this.numero = numero;
		this.estado = estado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public EstadoDeHabitacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeHabitacion estado) {
		this.estado = estado;
	}

	
	
}
