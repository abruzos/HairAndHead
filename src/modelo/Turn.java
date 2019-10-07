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
	public void createTurn(TurnDTO new_turn) throws Exception 
	{
		_turn.create(new_turn);
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
	
	//Retorno de un turno por ID.
	public void getTurnID(int turn_id) throws Exception 
	{
		_turn.byId(turn_id);
	}
	
	//Lista de todos los turnos.
	public List<TurnDTO> obtainTurns() throws Exception 
	{
		return _turn.all();
	}
	
	//Creacion de un nuevo turno en base a la hora del servicio.
	public static TurnDTO creationOfTurn(LocalDateTime service_day) throws Exception 
	{
		TurnDTO new_turn = new TurnDTO(LocalDateTime.now(), service_day, "Vigente");
		
		return new_turn;
	}

	//Cancelacion de un turno
	public void cancelATurn(TurnDTO turno_to_cancel) throws Exception 
	{
		turno_to_cancel.setState("Cancelado");
	}	
}
