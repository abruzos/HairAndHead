package modelo;

import java.util.List;

import dto.CustomerDTO;
import persistencia.dao.implementacion.CustomerJPA;
import persistencia.dao.interfaz.CustomerDAO;


public class Customer 
{
	public static CustomerDAO _customer;
	
	public static CustomerDAO getCustomerDAO() 
	{
		return new CustomerJPA();
	}
	
	//Creacion de un Cliente.
	public void createCustomer(CustomerDTO newCustomer) throws Exception 
	{
		_customer.create(newCustomer);
	}
	
	public void deleteCustomer(CustomerDTO CustomerDelete) throws Exception 
	{
		_customer.delete(CustomerDelete);
	}
	
	public void updateCustomer(CustomerDTO CustomerUpdate) throws Exception 
	{
		_customer.update(CustomerUpdate);
	}
	
	public CustomerDTO getCustomerID(int CustomerId) 
	{
		return _customer.byId(CustomerId);
	}
	
	public List<CustomerDTO> obtainCustomers() throws Exception 
	{
		return _customer.all();
	}
	
	public static void algo(){
		
	}
}

