package persistencia.dao.implementacion;

import modelo.BranchOffice;
import persistencia.dao.interfaz.BranchOfficeDAO;

public class BranchOfficeJPA extends DAOJPA<BranchOffice> implements BranchOfficeDAO
{
	public long cantidadSucursales() 
	{
		return _entityManager.createQuery("SELECT COUNT(a) FROM BranchOffice a",
				Long.class).getSingleResult();
	}
}