package persistencia.dao.interfaz;

public interface DAOAbstractFactory 
{
	public CustomerDAO createCustomerDAO();
	
	public EmployeeDAO createEmployeeDAO();
	
	public ServiceDAO createServiceDAO();
	
	public TurnDAO createTurnDAO();		
}
