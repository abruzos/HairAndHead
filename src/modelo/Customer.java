package modelo;

import java.util.List;

import dto.CustomerDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.CustomerDAO;

public class Customer 
{
	private CustomerDAO customer;
	
	public Customer(DAOAbstractFactory metod_persistence) 
	{
		this.customer = metod_persistence.createCustomerDAO();             
	}
	
	public void addCustomer(CustomerDTO customer) throws Exception 
	{
		this.customer.create(customer);
	}

	public void deleteCustomer(CustomerDTO customer_to_delete) throws Exception 
	{
		this.customer.delete(customer_to_delete);
	}
	
	public List<CustomerDTO> obtainCustomer() throws Exception 
	{
		return this.customer.all();		
	}
	
	public void editCustomer(CustomerDTO customer_to_edit) throws Exception 
	{
		this.customer.update(customer_to_edit);
	}	
}
