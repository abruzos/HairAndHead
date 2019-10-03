package modelo;

import java.util.List;

import dto.BagDTO;
import dto.CustomerDTO;
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
	
	// Suma puntos por cada pago. 
	public void addPointsPay(CustomerDTO customerBag ,int payment)
	{
		/** RELACION --->  500 PESOS = 10 PUNTOS */ // Prodrian ser otras intancias de Bag
		int pointForPay = 10;
		int everyAmount = 500;
		if(payment >= 500)
		{
			int pointsAccumulated = customerBag.getBag().getPoints() + (payment/everyAmount)*pointForPay;
			customerBag.getBag().setPoints(pointsAccumulated);
		}
	}

	// Convertidor de puntos en pesos Argentinos $
	public int convetPointsMoney(CustomerDTO customerBag)
	{
		/** RELACION --->  1 PUNTO = 2 PESOS */ // Prodria ser otra intancia de Bag
		int costPoint = 2; 
		int moneyForPoints = costPoint * customerBag.getBag().getPoints();
		return moneyForPoints;
	}
	
}
