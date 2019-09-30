package modelo;

import java.util.List;
import dto.TurnDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.TurnDAO;

public class Turn 
{	
	private TurnDAO turn;
	
	public Turn(DAOAbstractFactory metod_persistence) 
	{
		this.turn = metod_persistence.createTurnDAO();             
	}
	
	public void addTurn(TurnDTO turn) throws Exception 
	{
		this.turn.create(turn);
	}

	public void deleteTurn(TurnDTO turn_to_delete) throws Exception 
	{
		this.turn.delete(turn_to_delete);
	}
	
	public List<TurnDTO> obtainTurns() throws Exception 
	{
		return this.turn.all();		
	}
	
	public void editTurn(TurnDTO turn_to_edit) throws Exception 
	{
		this.turn.update(turn_to_edit);
	}
}
