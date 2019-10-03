package modelo;

import java.time.LocalDate;
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

	// Convertidor de puntos en pesos Argentinos $ (usa todos los puntos)
	public int convetPointsMoney(CustomerDTO customerBag)
	{
		/** RELACION --->  1 PUNTO = 2 PESOS */ // Prodria ser otra intancia de Bag
		int costPoint = 2; 
		int moneyForPoints = costPoint * customerBag.getBag().getPoints();
		return moneyForPoints;
	}
	
	// Devuelve TRUE si los puntos expiraron.
	/** DURACION TOTAL DE LOS PUNTOS = 6 MESES DESPUES DEL ULTIMO PAGO */
	public boolean espiredPoints (CustomerDTO customerBag)
	{
		if(customerBag.getBag().getExpiration().isBefore(LocalDate.now()) || 
				customerBag.getBag().getExpiration().equals(LocalDate.now()))
		{
			return false;
		}
		return true;
	}
	
	// Actualiza Fecha de expiracion de puntos por pago.
	/** SE EXTIENDE A 6 MESES MAS DESDE EL ULTIMO PAGO*/
	public void updateExpirationDate (CustomerDTO customerBag)
	{
		int monthsExpiration = 6;
		LocalDate currentDate = LocalDate.now();
		customerBag.getBag().setExpiration(currentDate.plusMonths(monthsExpiration));
	}
	
	// Actualiza puntos de cartera (recibe los puntos usados)
	public void updateOfPoints (CustomerDTO customerBag, int usedPoints)
	{
		if(customerBag.getBag().getPoints() >= usedPoints)
		{
			int points = customerBag.getBag().getPoints() - usedPoints;
			customerBag.getBag().setPoints(points);
		}
	}
}
