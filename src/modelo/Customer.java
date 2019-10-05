package modelo;

import java.util.List;

import dto.CustomerDTO;
import dto.TurnDTO;
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
	
	// RETORNA LA LISTA DE TURNOS DE UN CLIENTE.
	public static List<TurnDTO> getListTurns(CustomerDTO client)
	{
		return client.getTurns();
	}
	
	// RETORNA CLIENTE POR MAIL (Login).
	public static CustomerDTO getClientLogin(String mail)
	{
		if(validateMail(mail))
		{
			for (CustomerDTO client : Customer.getCustomerDAO().all())
			{
				if(client.getMail().equals(mail))
				{
					return client;
				}
			}
		}
		return null;
	}
	
	// VALIDA SI EL MAIL ESTA EN LA BDD.
	public static boolean validateMail(String mail)
	{
		for (CustomerDTO client : Customer.getCustomerDAO().all())
		{
			if(client.getMail().equals(mail))
			{
				return true;
			}
		}
		return false;
	}
	
}

