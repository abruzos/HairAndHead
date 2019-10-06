package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.Customer;
import dto.BagDTO;
import dto.BranchOfficeDTO;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.PaymentDTO;
import dto.ProfessionalDTO;
import dto.PromotionDTO;
import dto.ServiceDTO;
import dto.TurnDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.BagJPA;
import persistencia.dao.implementacion.BranchOfficeJPA;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.implementacion.PromotionJPA;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.implementacion.TurnJPA;
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
		
		ProfessionalDTO professional = new ProfessionalDTO("Adrian", "Lopez", "34", "adrian_lopez@gmail.com", "1145989324", "Peluquero", "Activo");
		ProfessionalJPA professional_DAO= new ProfessionalJPA();
		
		TurnDTO turn = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 2, 10, 14, 00), "Vigente");
		TurnJPA turn_DAO= new TurnJPA();
		
		PaymentDTO pay = new PaymentDTO("Efectivo", LocalDateTime.now());
		PaymentJPA pDAO = new PaymentJPA();
		
		PaymentDTO pay2 = new PaymentDTO("Efectivo", LocalDateTime.now());
		PaymentJPA pDAO2 = new PaymentJPA();
		
		PromotionDTO promotion = new PromotionDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 12, 30), 
												"Vigente", true, 20, "Solo valida los dias Martes");
		PromotionJPA proDAO = new PromotionJPA();
		
		CustomerDTO client = new CustomerDTO("Jon","Snow","25","gameOfThrones@mail.com","1301215","Vip");
		Customer.getCustomerDAO().create(client);
		CustomerDTO client2 = new CustomerDTO("Diego","Maradona","60","mundial86@mail.com","10101010","Moroso");
		Customer.getCustomerDAO().create(client2);
		
		BagDTO bag = new BagDTO(40,LocalDate.of(2019, 10, 13));
		BagJPA bagDAO = new BagJPA();
		
		bDAO.create(b1);
		bDAO.update(b1);	
		dDAO.create(d1);
		sDAO.create(s1);
		eDAO.create(e1);
		professional_DAO.create(professional);
		turn_DAO.create(turn);
		pDAO.create(pay);
		pDAO2.create(pay2);
		proDAO.create(promotion);
		bagDAO.create(bag);
		client.setBag(bag);
		Customer.getCustomerDAO().update(client);//realiza/actializa la persistencia.
				
		System.out.println(Customer.getCustomerDAO().byId(1).getMail());
		System.out.println(Customer.getCustomerDAO().byId(2).getName());
		System.out.println("Existe el mail mundial86@mail.com en BDD = "+Customer.foundMail("mundial86@mail.com"));
		
		bDAO.close();
		
		// Sale un carte con excepcion porque no encuentra el mail en BDD.
		// CustomerDTO a = Customer.getClientForMail("algo");
	}	
}