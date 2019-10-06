package modelo;

import java.util.List;
import javax.swing.JOptionPane;
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
	
	
	/******************METODOS ESTATICOS *************/
	
	// DEVUELVE EL COSTO DE SERVICIO EN BASE A LISTA DE TURNOS DEL CLIENTE.
	public static String CostService(CustomerDTO client)
	{
		int cost = 0;
		for (TurnDTO turn : getListTurns(client))
		{
			/** FalTa ValidaR FecHa DE TuRnos */
			cost = cost + turn.getService().getCost();
		}
		return Integer.toString(cost);
	}
	
	// RETORNA LOS PUNTOS TOTALES DE UN CLIENTE.
	public static String AccumulatedPoints(CustomerDTO client)
	{
		int points = client.getBag().getPoints();
		return Integer.toString(points);
	}
				
	// RETORNA LA DEUDA ACTUAL DE UN CLIENTE.
	public static String CurrentDebt(CustomerDTO client)
	{
		int debt = client.getDebt().getCost();
		return Integer.toString(debt);
	}
	
	// RETORNA LA LISTA DE TURNOS DE UN CLIENTE.
	public static List<TurnDTO> getListTurns(CustomerDTO client)
	{
		return client.getTurns();
	}
	
	// RETORNA CLIENTE POR MAIL (Login).
	public static CustomerDTO getClientForMail(String mail)
	{
		if(foundMail(mail))
		{
			for (CustomerDTO client : Customer.getCustomerDAO().all())
			{
				if(client.getMail().equals(mail))
				{
					return client;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "ERROR! El usuario no esta registrado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		return null;
	}
	
	// VALIDA SI EL MAIL ESTA EN LA BDD. (eliminar static Cambiar a private
	public static boolean foundMail(String mail)
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

