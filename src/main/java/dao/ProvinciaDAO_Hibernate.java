package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import util.ConnectionBD;
import dominio.Localidad;
import dominio.Provincia;


public class ProvinciaDAO_Hibernate implements ProvinciaDAO{

	private static EntityManager manager;
	
		
		public List<Provincia> getProvincias() {
			
			manager = ConnectionBD.conectar();
			
			
			/*
			Query que = (Query) manager.createQuery("SELECT p FROM Provincia p ", Provincia.class );
			ScrollableResults scrol = 
					que.scroll(ScrollMode.FORWARD_ONLY);
			
			List<Provincia> provincias = new ArrayList<Provincia>();
			
			while (scrol.next()) {
				Provincia p = (Provincia)scrol.get(0);
				provincias.add(p);
			}

			
			List<Provincia> provincias = manager.createQuery(
					 "SELECT p FROM Provincia p ", Provincia.class ).getResultList();
					 
			
			
			List<Provincia> provincias = manager.createNativeQuery(
					 "SELECT p.* FROM Provincia p ", Provincia.class ).getResultList();		 
					 
					 
			
					 
			List<Provincia> provincias = manager.createQuery( 
					 "SELECT p FROM Provincia p ", Provincia.class ).setFirstResult(0).setMaxResults(24).getResultList();
					 
					 
			List<String> provincias = manager.createQuery(
					 "SELECT p.nombre FROM Provincia p ").getResultList();
			manager.clear();
			*/
			
			
			
			try{
		
				CriteriaBuilder builder = manager.getCriteriaBuilder();
			    CriteriaQuery<Provincia> criteria = builder.createQuery(Provincia.class);
			    criteria.from(Provincia.class);
			    List<Provincia> provincias = manager.createQuery(criteria).getResultList();
			
				return provincias;
				
			}
			finally {
				
				
			}
			
			
		}
		
		
		public Integer getId(String nombre) {
			
			manager = ConnectionBD.conectar();
			
			List<Provincia> idProvincia = (List<Provincia>) manager
					.createQuery("SELECT p FROM provincia p WHERE nombre ='"+nombre+"'",Provincia.class).getResultList();


			return idProvincia.get(0).getIdProvincia();
			
		}
		
			
			
			
}
