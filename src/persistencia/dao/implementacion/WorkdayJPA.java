package persistencia.dao.implementacion;

import dto.WorkdayDTO;
import persistencia.dao.interfaz.WorkdayDAO;

public class WorkdayJPA extends DAOJPA<WorkdayDTO> implements WorkdayDAO
{
	public long countDays()
	{
		return _entityManager.createQuery("SELECT COUNT(a) FROM Workday a",
				Long.class).getSingleResult();
	}
}