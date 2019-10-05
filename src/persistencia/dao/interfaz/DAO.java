package persistencia.dao.interfaz;

import java.util.List;

public interface DAO<T> 
{
	public T create(T t);
	public void delete(T t);
	public T update(T t);
	public T byId(int id);	
	public List<T> all();
	public void close();
}