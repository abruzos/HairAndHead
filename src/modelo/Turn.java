package modelo;

import java.time.LocalDateTime;
import dto.TurnDTO;
import persistencia.dao.implementacion.TurnJPA;
import persistencia.dao.interfaz.TurnDAO;

public class Turn 
{	 
	private TurnDAO _turn;
	
	public TurnDAO createTurnDAO() 
	{
		return new TurnJPA();
	}
	
	//Creacion de nuevo turno.
	public void createTurn(TurnDTO newTurn) throws Exception 
	{
		_turn.create(newTurn);
	}
	
	//Creacion de un nuevo turno en base a los datos proporcionados.
	public void creationOfTurn(LocalDateTime reservationDay, LocalDateTime serviceDay) throws Exception 
	{
		TurnDTO newTurn = new TurnDTO(reservationDay, serviceDay, "valid");
		createTurn(newTurn);
	}
}
