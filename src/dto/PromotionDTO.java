package dto;

import java.time.LocalDateTime;
import java.util.List;


public class PromotionDTO 
{
	
	private int _id;
	private LocalDateTime _dateStart;
	private LocalDateTime _dateFinish;
	private boolean _accumulate;
	private int _discount;
	private List<String> _days;
	private List<String> _paymentMethods;
	
	// @ManyToMany
	private PaymentDTO _payment;

	
	public PromotionDTO(LocalDateTime dateStart,LocalDateTime dateFinish,boolean accumulate,int discount, List<String> days,List<String> paymentMethods,PaymentDTO payment) 
	{
		_dateStart = dateStart;
		_dateFinish = dateFinish;
		_accumulate = accumulate;
		_discount = discount;
		_days = days;
		_paymentMethods = paymentMethods;
		_payment = payment;
	}

	public PromotionDTO(){}
	
	public LocalDateTime getDateStart() 
	{
		return _dateStart;
	}

	public LocalDateTime getDateFinish() 
	{
		return _dateFinish;
	}
	
	public boolean isAccumulate() 
	{
		return _accumulate;
	}
	
	public int getDiscount() 
	{
		return _discount;
	}
	
	public List<String> getDays() 
	{
		return _days;
	}
	
	public List<String> getPaymentMethods() 
	{
		return _paymentMethods;
	}
	
	public PaymentDTO getPayment() 
	{
		return _payment;
	}
	
	
	public void setDateStart(LocalDateTime dateStart)
	{
		_dateStart = dateStart;
	}

	public void set_dateFinish(LocalDateTime dateFinish) 
	{
		_dateFinish = dateFinish;
	}

	public void setAccumulate(boolean accumulate) 
	{
		_accumulate = accumulate;
	}

	public void setDiscount(int discount) 
	{
		_discount = discount;
	}

	public void setDays(List<String> days)
	{
		_days = days;
	}

	public void setPaymentMethods(List<String> paymentMethods) 
	{
		_paymentMethods = paymentMethods;
	}

	public void setPayment(PaymentDTO payment) 
	{
		_payment = payment;
	}

}