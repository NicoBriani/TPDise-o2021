package dao;

import java.util.List;

import dominio.Provincia;

public interface ProvinciaDAO {
	public List<Provincia> getProvincias();
	public Integer getId(String nombre);
	
}
