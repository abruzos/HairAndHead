package persistencia.dao.implementacion;

import dto.BranchOfficeDTO;
import persistencia.dao.interfaz.BranchOfficeDAO;

public class BranchOfficeJPA extends DAOJPA<BranchOfficeDTO> implements BranchOfficeDAO
{
	public long cantidadSucursales() 
	{
		return _entityManager.createQuery("SELECT COUNT(a) FROM BranchOffice a",
				Long.class).getSingleResult();
	}
}