package main;

import java.time.LocalDateTime;
import dto.BranchOfficeDTO;
import dto.EmployeeDTO;
import dto.PaymentDTO;
import dto.PromotionDTO;
import dto.ServiceDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.BranchOfficeJPA;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.implementacion.PromotionJPA;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.implementacion.WorkdayJPA;

public class Main 
{
	public static void main(String[] args) 
	{
		BranchOfficeDTO b1 = new BranchOfficeDTO("Breikin", "Mitre 123", "San miguel", "Bs As", "Argentina");
		BranchOfficeJPA bDAO= new BranchOfficeJPA();
		
		WorkdayDTO d1 = new WorkdayDTO("Lunes", "0800hs", "1200hs"); //lista de dias
		WorkdayJPA dDAO = new WorkdayJPA();
		
		ServiceDTO s1 = new ServiceDTO("Corte de pelo", 45, 300); //lista de servicios
		ServiceJPA sDAO = new ServiceJPA();
		
		EmployeeDTO e1 = new EmployeeDTO("Lucas", "Martin", "20", "mail@gmail.com", "46678393", "Recepcionista",
									"alta", "lmartin", "123456s");
		EmployeeJPA eDAO = new EmployeeJPA();
		
		PaymentDTO pay = new PaymentDTO("Efectivo",LocalDateTime.now());
		PaymentJPA pDAO = new PaymentJPA();
		
		PromotionDTO promotion = new PromotionDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 12, 30), 
												"Vigente", true, 20, "Solo valida los dias Martes");
		PromotionJPA proDAO = new PromotionJPA();
		
		bDAO.create(b1);
		bDAO.update(b1);	
		dDAO.create(d1);
		sDAO.create(s1);
		eDAO.create(e1);
		pDAO.create(pay);
		proDAO.create(promotion);
		
		bDAO.close();			
	}	
}