package modelo;

import java.util.List;
import dto.ServiceDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.ServiceDAO;

public class Service 
{
	private ServiceDAO service;
	
	public Service(DAOAbstractFactory metod_persistence) 
	{
		this.service = metod_persistence.createServiceDAO();             
	}
	
	public void addService(ServiceDTO service) throws Exception 
	{
		this.service.create(service);
	}

	public void deleteService(ServiceDTO service_to_delete) throws Exception 
	{
		this.service.delete(service_to_delete);
	}
	
	public List<ServiceDTO> obtainService() throws Exception 
	{
		return this.service.all();		
	}
	
	public void editService(ServiceDTO service_to_edit) throws Exception 
	{
		this.service.update(service_to_edit);
	}	
}
