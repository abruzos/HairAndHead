package dto;

import java.time.LocalDateTime;


public class PaymentDTO 
{
	
	private int _id;
	private String _state;
	private LocalDateTime _dateTimePay;
	
	// @OneToOne
	private CustomerDTO _client; // tiene lista de turnos para el pago.
	
	// @ManyToMany
	private PromotionDTO _promotion;

	
	public PaymentDTO(String state, LocalDateTime dateTimePay, CustomerDTO client, PromotionDTO promotion) 
	{
		_state = state;
		_dateTimePay = dateTimePay;
		_client = client;
		_promotion = promotion;
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

	public CustomerDTO getClient() 
	{
		return _client;
	}
	
	public PromotionDTO getPromotion() 
	{
		return _promotion;
	}

	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setDateTimePay(LocalDateTime dateTimePay) 
	{
		_dateTimePay = dateTimePay;
	}
	
	public void setClient(CustomerDTO client) 
	{
		_client = client;
	}
	
	public void setPromotion(PromotionDTO promotion) 
	{
		_promotion = promotion;
	}

}