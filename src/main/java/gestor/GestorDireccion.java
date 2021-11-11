package gestor;

import java.util.List;

import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dominio.Direccion;
import dominio.Localidad;

public class GestorDireccion {

	LocalidadDAO localidadDAO = new LocalidadDAO_Hibernate();
	
	public Direccion generarDireccion (String calle, Integer numero, Integer dpto, Integer piso, Integer ciudad) {
		
	Direccion direccion = new Direccion();
	direccion.setCalle(calle);
	direccion.setNumero(numero);
	direccion.setDto(dpto);
	direccion.setPiso(piso);
	direccion.setLocalidad(ciudad);
	
	return direccion;
	}
	
	public List<Localidad> obtenerLocalidades (String nombreProvincia){
		
		return localidadDAO.getLocalidades(nombreProvincia);
		
		
	}
	
	
}
