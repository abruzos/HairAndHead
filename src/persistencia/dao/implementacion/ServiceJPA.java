package persistencia.dao.implementacion;

import java.util.List;

import javax.persistence.Query;

import dto.ServiceDTO;
import persistencia.dao.interfaz.ServiceDAO;

public class ServiceJPA extends DAOJPA<ServiceDTO> implements ServiceDAO
{
	public List<ServiceDTO> AllServices()
	{
		Query query = _entityManager.createQuery("SELECT a FROM ServiceDTO a");
		
		@SuppressWarnings("unchecked")
		List<ServiceDTO> resultList = query.getResultList();
		
		return resultList;
	}
}