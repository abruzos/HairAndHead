package testModelo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import dto.BagDTO;
import dto.CustomerDTO;
import dto.DebtDTO;
import dto.PaymentDTO;
import dto.TurnDTO;
import persistencia.dao.implementacion.CustomerJPA;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.implementacion.TurnJPA;

public class TestCrud 
{
	CustomerDTO customer = new CustomerDTO("Lionel", "Messi", "30", "messi@barca.es", "10101010", "Vip");
	CustomerJPA cust_DAO = new CustomerJPA();
	TurnDTO turn = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 10, 10, 12, 00), "Vigente");
	TurnJPA turn_DAO= new TurnJPA();
	BagDTO bag = new BagDTO(20, LocalDate.now());
	DebtDTO debt = new DebtDTO(100, LocalDate.now());
	PaymentDTO payment = new PaymentDTO("Efectivo", LocalDateTime.now());
	PaymentJPA pay_DAO = new PaymentJPA();		

	/************
	 * CREATES
	 * **************/
	@Test
	public void testCreateCustomer()
	{
		cust_DAO.create(customer);
	}
	
	@Test
	public void testCreateTurn()
	{
		turn_DAO.create(turn);
	}
	
	@Test
	public void testCreatePayment()
	{
		pay_DAO.create(payment);
	}
	/************
	 * SETTERS
	 * **************/
	@Test
	public void testUpdateCustomerBag()
	{
		customer.setBag(bag);
		updateCustomer();
	}
	
	@Test
	public void testUpdateCustomerDebt()
	{
		customer.setDebt(debt);
		updateCustomer();
	}
	/************
	 * ADD
	 * **************/	
	@Test
	public void testAddPayment()
	{
		customer.addPayment(payment);
		updateCustomer();
	}
	
	public void updateCustomer()
	{
		cust_DAO.update(customer);
	}
}