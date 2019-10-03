package modelo;

import java.util.List;
import dto.BagDTO;
import persistencia.dao.implementacion.BagJPA;
import persistencia.dao.interfaz.BagDAO;

public class Bag 
{
	
	private BagDAO _bag;
	
	public BagDAO createBagDAO() 
	{
		return new BagJPA();
	}

	public void createBag(BagDTO newBag) throws Exception 
	{
		_bag.create(newBag);
	}
	
	public void deleteBag(BagDTO deleteBag) throws Exception 
	{
		_bag.delete(deleteBag);
	}
	
	//Modificacion de la cartera.
	public void updateBag(BagDTO updateBag) throws Exception 
	{
		_bag.update(updateBag);
	}
	
	//Retorno de una cartera por ID
		public void getPaymentID(long bagID) throws Exception 
		{
			_bag.byId(bagID);
		}
	
	//Lista de todos los pagos (DENTRO DEL SISTEMA)
	public List<BagDTO> obtainPayments() throws Exception 
	{
		return _bag.all();
	}

	// Convertidor de puntos en pesos Argentinos $
	public int convetPointsMoney(BagDTO customerBag)
	{
		int costPoint = 2; /** RELACION --->  1 PUNTO = 2 PESOS */
		int moneyForPoints = costPoint * customerBag.getPoints();
		return moneyForPoints;
	}
	
}
