package dao;

import javax.persistence.EntityManager;

import dominio.Pasajero;
import util.ConnectionBD;

public class PasajeroDAO_Hibernate implements PasajeroDAO{
	
	private static EntityManager manager;

	DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();
	
	public void guardarPasajero(Pasajero pasajero) {
	
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		daoDireccion.guardarDireccion(pasajero.getPersona().getDireccion());
		daoPersona.guardarPersona(pasajero.getPersona());
		manager.persist(pasajero);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}

	}

}