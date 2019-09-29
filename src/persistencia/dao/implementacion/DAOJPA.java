package persistencia.dao.implementacion;

import persistencia.dao.interfaz.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOJPA<T> implements DAO<T>
{
	protected EntityManager _entityManager;
	private Class<T> _entityClass;
	
	@SuppressWarnings("unchecked")
	public DAOJPA() 
	{
		_entityManager = EntityManagers.createEntityManager();
		ParameterizedType _genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	    this._entityClass = (Class<T>) _genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public T create(T t)
	{
		_entityManager.getTransaction().begin();		
		_entityManager.persist(t);		
		_entityManager.getTransaction().commit();		
		return t;
	}
	
	@Override
	public void delete(T t)
	{
		_entityManager.getTransaction().begin();
		t = this._entityManager.merge(t);
		this._entityManager.remove(t);
		_entityManager.getTransaction().commit();	
	}

	@Override
	public T update(T t)
	{
		_entityManager.getTransaction().begin();		
		T resultado = this._entityManager.merge(t);
		_entityManager.getTransaction().commit();
		return resultado;
	}
	
	@Override
	public T byId(long id)
	{
		_entityManager.getTransaction().begin();
		 T resultado = (T) this._entityManager.find(_entityClass, id);
		 _entityManager.getTransaction().commit();
		 return resultado;
	}
	
	@Override
	public List<T> all()
	{
		_entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<T> resultados = _entityManager.createQuery( "from " + _entityClass.getName() ).getResultList();
		_entityManager.getTransaction().commit();
		return resultados;
	}
	
	@Override
	public void close() 
	{
		_entityManager.close();
	}	
}