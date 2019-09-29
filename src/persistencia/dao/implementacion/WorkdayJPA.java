package persistencia.dao.implementacion;

import modelo.Workday;
import persistencia.dao.interfaz.WorkdayDAO;

public class WorkdayJPA extends DAOJPA<Workday> implements WorkdayDAO
{
	public long countDays()
	{
		return _entityManager.createQuery("SELECT COUNT(a) FROM Workday a",
				Long.class).getSingleResult();
	}
}