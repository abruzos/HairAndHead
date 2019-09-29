package persistencia.dao.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagers 
{
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("org.hibernate.tutorial.jpa");
		
	private EntityManagers() {}
		
	public static EntityManager createEntityManager() 
	{
		return entityManagerFactory.createEntityManager();
	}
}