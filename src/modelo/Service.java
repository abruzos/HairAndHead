package modelo;

import java.util.List;
import dto.ServiceDTO;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.interfaz.ServiceDAO;

public class Service 
{
	private ServiceDAO _service;
	
	public ServiceDAO createServiceDAO() 
	{
		return new ServiceJPA();
	}
	
	//Lista de todos los servicios ----> DESPLEGABLE SERVICIOS.
	public List<ServiceDTO> obtainServices() throws Exception 
	{
		return _service.all();
	}
}
