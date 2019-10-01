package modelo;

import java.time.LocalDateTime;
import java.util.List;
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
	
	//Eliminacion de un turno.
	public void deleteTurn(TurnDTO turn_to_delete) throws Exception 
	{
		_turn.delete(turn_to_delete);
	}
	
	//Modificacion de un turno.
	public void updateTurn(TurnDTO turn_to_update) throws Exception 
	{
		_turn.update(turn_to_update);
	}
	
	//Lista de todos los turnos.
	public List<TurnDTO> obtainTurns() throws Exception 
	{
		return _turn.all();
	}
	
	//Creacion de un nuevo turno en base a los datos proporcionados.
	public void creationOfTurn(LocalDateTime reservationDay, LocalDateTime serviceDay) throws Exception 
	{
		TurnDTO newTurn = new TurnDTO(reservationDay, serviceDay, "valid");
		createTurn(newTurn);
	}
}
