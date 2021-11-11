package dominio;

import java.util.Date;

import enumClasses.EstadoDeFactura;

public class Factura {

	private Date fechaEmision;
	private Integer numFactura;
	private Integer cuit;
	private char tipoDeFactura;
	private EstadoDeFactura estado;
	private Boolean iva;
	
	public Factura(Date fechaEmision, Integer numFactura, Integer cuit, char tipoDeFactura, EstadoDeFactura estado,Boolean iva) {
	
		this.fechaEmision = fechaEmision;
		this.numFactura = numFactura;
		this.cuit = cuit;
		this.tipoDeFactura = tipoDeFactura;
		this.estado = estado;
		this.iva = iva;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Integer getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(Integer numFactura) {
		this.numFactura = numFactura;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public char getTipoDeFactura() {
		return tipoDeFactura;
	}

	public void setTipoDeFactura(char tipoDeFactura) {
		this.tipoDeFactura = tipoDeFactura;
	}

	public EstadoDeFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeFactura estado) {
		this.estado = estado;
	}

	public Boolean getIva() {
		return iva;
	}

	public void setIva(Boolean iva) {
		this.iva = iva;
	}
	
	

	
}
