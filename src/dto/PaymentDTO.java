package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PaymentDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String _state;
	private LocalDateTime _dateTimePay;
	
	@ManyToOne
	private CustomerDTO _customerPayment;
	
	@OneToMany (mappedBy = "_turnsPayment", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TurnDTO> _turns = new ArrayList<>();

	@ManyToMany
	private List<PromotionDTO> _promotions = new ArrayList<>();

	

	public PaymentDTO(String state, LocalDateTime dateTimePay) 
	{
		_state = state;
		_dateTimePay = dateTimePay;
	}

	public PaymentDTO(){}
	
	public String getState() 
	{
		return _state;
	}
	
	public LocalDateTime getDateTimePay() 
	{
		return _dateTimePay;
	}
		
	public CustomerDTO getCustomerPayment() 
	{
		return _customerPayment;
	}
		
	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setDateTimePay(LocalDateTime dateTimePay) 
	{
		_dateTimePay = dateTimePay;
	}
	
	public void setCustomerPayment(CustomerDTO customerPayment) 
	{
		_customerPayment = customerPayment;
	}
	
	public List<TurnDTO> getTurns()
	{
		return _turns;
	}
	
	public void addTurn(TurnDTO t) 
	{
		this._turns.add(t);
		t.setTurnsPayment(this);
	}
	
	public void removeTurn(TurnDTO t) 
	{
		this._turns.remove(t);
		t.setTurnsPayment(this);
	}
}