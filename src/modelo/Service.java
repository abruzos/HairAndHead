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
	
	//Creacion de un servicio.
	public void createService(ServiceDTO new_service) throws Exception 
	{
		_service.create(new_service);
	}
	
	//Eliminacion de un servicio.
	public void deleteService(ServiceDTO service_to_delete) throws Exception 
	{
		_service.delete(service_to_delete);
	}
	
	//Modificacion de un servicio.
	public void updateService(ServiceDTO service_to_update) throws Exception 
	{
		_service.update(service_to_update);
	}
	
	//Retorno de un servicio por ID
	public void getServiceID(long service_id) throws Exception 
	{
		_service.byId(service_id);
	}
	
	//Lista de todos los servicios ----> DESPLEGABLE SERVICIOS.
	public List<ServiceDTO> obtainServices() throws Exception 
	{
		return _service.all();
	}
}
