package testModelo;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;
import modelo.Turn;

public class TestTurn 
{
	@Test
	public void creationOfTurn() throws Exception 
	{	
		Turn turn = new Turn();
		LocalDateTime reservationDay = LocalDateTime.of(2019, 10, 1, 18, 28);
		LocalDateTime serviceDay = LocalDateTime.of(2019, 10, 3, 19, 00);
		
		turn.creationOfTurn(reservationDay, serviceDay);
		System.out.print(turn);
		
		assertEquals(1,turn.obtainTurns().size());	
	}
}
