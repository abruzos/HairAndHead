package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PromotionDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private LocalDateTime _dateStart;
	private LocalDateTime _dateFinish;
	private String _state;
	private boolean _accumulate;
	private int _porcentageDiscount;
//	private List<String> _days;
//	private List<String> _paymentMethods;
	private String _description;
	
	@ManyToMany
	private List<PaymentDTO> _payments = new ArrayList<>();

	
	public PromotionDTO(LocalDateTime dateStart,LocalDateTime dateFinish, String state, boolean accumulate,int porcentageDiscount,
						List<String> days,List<String> paymentMethods, String description) 
	{
		_dateStart = dateStart;
		_dateFinish = dateFinish;
		_state = state;
		_accumulate = accumulate;
		_porcentageDiscount = porcentageDiscount;
//		_days = days;
//		_paymentMethods = paymentMethods;
		_description = description;
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
	
	public String getState() 
	{
		return _state;
	}
	
	public boolean isAccumulate() 
	{
		return _accumulate;
	}
	
	public int getPorcentageDiscount() 
	{
		return _porcentageDiscount;
	}
	
//	public List<String> getDays() 
//	{
//		return _days;
//	}
//	
//	public List<String> getPaymentMethods() 
//	{
//		return _paymentMethods;
//	}
	
	public String geDescription() 
	{
		return _description;
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

	public void setDiscount(int porcentageDiscount) 
	{
		_porcentageDiscount = porcentageDiscount;
	}

//	public void setDays(List<String> days)
//	{
//		_days = days;
//	}
//
//	public void setPaymentMethods(List<String> paymentMethods) 
//	{
//		_paymentMethods = paymentMethods;
//	}

	public void setDescription(String description)
	{
		_description = description;
	}

	public void setState(String state) 
	{
		_state = state;
	}
}