package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import dto.BranchOfficeDTO;
import dto.EmployeeDTO;
import dto.PaymentDTO;
import dto.ProfessionalDTO;
import dto.PromotionDTO;
import dto.ServiceDTO;
import dto.TurnDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.BranchOfficeJPA;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.implementacion.PromotionJPA;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.implementacion.TurnJPA;
import persistencia.dao.implementacion.WorkdayJPA;
import receipts.ReservationReceipt;

public class Main 
{
	public static void main(String[] args) 
	{
		EmployeeDTO e1 = new EmployeeDTO("Lucas", "Martin", "20", "mail@gmail.com", "46678393", "Recepcionista",
									"alta", "lmartin", "123456s");
		EmployeeJPA eDAO = new EmployeeJPA();
		
		ProfessionalDTO professional = new ProfessionalDTO("Adrian", "Lopez", "34", "adrian_lopez@gmail.com", "1145989324", "Peluquero", "Activo");
		ProfessionalJPA professional_DAO= new ProfessionalJPA();
		
		TurnDTO turn = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 2, 10, 14, 00), "Vigente");
		TurnJPA turn_DAO= new TurnJPA();
		
		PaymentDTO pay = new PaymentDTO("Efectivo", LocalDateTime.now());
		PaymentJPA pDAO = new PaymentJPA();
		
		PromotionDTO promotion = new PromotionDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 12, 30), 
												"Vigente", true, 20, "Solo valida los dias Martes");
		PromotionJPA proDAO = new PromotionJPA();
		
		bDAO.create(b1);
		bDAO.update(b1);	
		dDAO.create(d1);
		sDAO.create(s1);
		eDAO.create(e1);
		professional_DAO.create(professional);
		turn_DAO.create(turn);
		pDAO.create(pay);
		proDAO.create(promotion);

		
		bDAO.close();			
	}	
}