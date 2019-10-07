package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.Customer;
import modelo.Professional;
import modelo.Service;
import modelo.Turn;
import modelo.Workday;
import dto.BagDTO;
import dto.BranchOfficeDTO;
import dto.CustomerDTO;
import dto.DebtDTO;
import dto.EmployeeDTO;
import dto.PaymentDTO;
import dto.ProfessionalDTO;
import dto.PromotionDTO;
import dto.ServiceDTO;
import dto.TurnDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.BranchOfficeJPA;
import persistencia.dao.implementacion.CustomerJPA;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.implementacion.PromotionJPA;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.implementacion.TurnJPA;
import persistencia.dao.implementacion.WorkdayJPA;
import presentacion.controlador.ControllerManagePayment;
import presentacion.controlador.ControllerTakeTurn;
import presentacion.vista.ManagePaymentWindow;
import presentacion.vista.TakeTurnWindow;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
			/*BRANCH OFFICES*/
		BranchOfficeDTO br1 = new BranchOfficeDTO("Breikin", "Mitre 123", "San miguel", "Bs As", "Argentina");
		BranchOfficeDTO br2 = new BranchOfficeDTO("Ciwe", "San jose 790", "Muniz", "C.A.B.A", "Argentina");
		BranchOfficeJPA br_DAO= new BranchOfficeJPA();		
		/*DAYS*/
		WorkdayDTO day1 = new WorkdayDTO("Lunes", "08:00hs", "12:00hs");
		WorkdayDTO day2 = new WorkdayDTO("Martes", "08:00hs", "12:00hs");
		WorkdayDTO day3 = new WorkdayDTO("Miercoles", "08:00hs", "12:00hs");		
		WorkdayDTO day4 = new WorkdayDTO("Jueves", "08:00hs", "12:00hs");
		WorkdayDTO day5 = new WorkdayDTO("Viernes", "08:00hs", "12:00hs");
		WorkdayJPA day_DAO = new WorkdayJPA();
		/*SERVICES*/
		ServiceDTO serv1 = new ServiceDTO("Corte de Pelo", 45, 300); 
		ServiceDTO serv2 = new ServiceDTO("Tintura y Alizado", 60, 800); 
		ServiceDTO serv3 = new ServiceDTO("Corte de Barba", 45, 600); 		
		ServiceJPA serv_DAO = new ServiceJPA();
		/*EMPLOYEES*/
		EmployeeDTO emp1 = new EmployeeDTO("Lucas", "Martin", "20", "mail@gmail.com", "46678393", "Recepcionista","alta", "lmartin", "123456");
		EmployeeDTO emp2 = new EmployeeDTO("Michael", "Hooper", "25", "michael@gmail.com", "1159873221", "Recepcionista","alta", "mchHooper23", "hoopWin");
		EmployeeJPA emp_DAO = new EmployeeJPA();
		/*PROFESSIONALS*/
		ProfessionalDTO prof1 = new ProfessionalDTO("Mauricio", "Macri", "55", "mauri@gob.ar", "1133557799", "peluquero", "Activo");
		ProfessionalDTO prof2 = new ProfessionalDTO("Gabriela", "Michetti", "40", "gabi@gob.ar", "034872921", "peluquera", "Activo");
		ProfessionalDTO prof3 = new ProfessionalDTO("Eugenia", "Vidal", "38", "euge@gob.ar", "1176397629", "Alizado", "Activo");
		ProfessionalDTO prof4 = new ProfessionalDTO("Miguel", "Pichetto", "65", "migue@gob.ar", "4466 9284", "Barbero", "Activo");
		ProfessionalJPA prof_DAO = new ProfessionalJPA();
		/*CUSTOMERS*/
		CustomerDTO cust1 = new CustomerDTO("Lionel", "Messi", "30", "messi@barca.es", "10101010", "Vip");
		CustomerDTO cust2 = new CustomerDTO("Neymar", "Jr", "28", "neymarJR@brasil.br", "1111111", "Normal");
		CustomerDTO cust3 = new CustomerDTO("Victor", "Valdes", "38", "vvaldes@barca.es", "398247215", "Normal");
		CustomerDTO cust4 = new CustomerDTO("Pep", "Guardiola", "48", "pguardiola@gmail.com", "63061284", "Deudor");
		CustomerJPA cust_DAO = new CustomerJPA();
		/*TURNS*/
		TurnDTO turn1 = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 10, 10, 12, 00), "Vigente");
		TurnDTO turn2 = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 10, 10, 8, 00), "Vigente");
		TurnDTO turn3 = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 10, 00), "Vigente");
		TurnDTO turn4 = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 9, 00), "Vigente");
		TurnJPA turn_DAO= new TurnJPA();
		
//		BranchOfficeDTO b1 = new BranchOfficeDTO("Breikin", "Mitre 123", "San miguel", "Bs As", "Argentina");
//		BranchOfficeJPA bDAO= new BranchOfficeJPA();
//		
//		WorkdayDTO d1 = new WorkdayDTO("Lunes", "0800hs", "1200hs"); //lista de dias
//		WorkdayJPA dDAO = new WorkdayJPA();
//		
//		ServiceDTO s1 = new ServiceDTO("Corte de pelo", 45, 300); //lista de servicios
//		ServiceJPA sDAO = new ServiceJPA();
//		
//		EmployeeDTO e1 = new EmployeeDTO("Lucas", "Martin", "20", "mail@gmail.com", "46678393", "Recepcionista",
//									"alta", "lmartin", "123456s");
//		EmployeeJPA eDAO = new EmployeeJPA();
//		
//		ProfessionalDTO professional = new ProfessionalDTO("Adrian", "Lopez", "34", "adrian_lopez@gmail.com", "1145989324", "Peluquero", "Activo");
//		ProfessionalJPA professional_DAO= new ProfessionalJPA();
//		
//		TurnDTO turn = new TurnDTO(LocalDateTime.now(), LocalDateTime.of(2019, 2, 10, 14, 00), "Vigente");
//
//		TurnJPA turn_DAO= new TurnJPA();
//		/*PAYMENTS*/
		PaymentDTO pay1 = new PaymentDTO("Efectivo", LocalDateTime.now());
		PaymentJPA pay_DAO = new PaymentJPA();		
		PaymentDTO pay2 = new PaymentDTO("Efectivo", LocalDateTime.now());
		PaymentJPA pDAO2 = new PaymentJPA();
//		/*PROMOTIONS*/
//		PromotionDTO prom1 = new PromotionDTO(LocalDateTime.now(), LocalDateTime.of(2019, 12, 10, 12, 30), "Vigente", true, 20, "Solo valida los dias Martes");
//		PromotionJPA prom_DAO = new PromotionJPA();
//		
		BagDTO bag1 = new BagDTO(20, LocalDate.now());
		DebtDTO debt1 = new DebtDTO(100, LocalDate.now());	

		/* 
		 * CREATES
		 * */
		br_DAO.create(br1);		
		emp_DAO.create(emp1);		
		prof_DAO.create(prof1);
		cust_DAO.create(cust1);		
		turn_DAO.create(turn1);
		pay_DAO.create(pay1);
		day_DAO.create(day1);
		serv_DAO.create(serv1);
		serv_DAO.create(serv2);
//		/* 
//		 * SETTERS 
//		 * */
		cust1.setBag(bag1);
		cust1.setDebt(debt1);
//		
//		/* 
//		 * ADD
//		 * */
		br1.addEmployee(emp1);
		br1.addProfessional(prof1);
		cust1.addTurn(turn1);
		cust1.addPayment(pay1);
		emp1.addWorkday(day1);
		prof1.addTurn(turn1);
		prof1.addWorkday(day1);
		prof1.addService(serv1);
//		/* 
//		 * UPDATES
//		 * */
		cust_DAO.update(cust1);
		br_DAO.update(br1);
		prof_DAO.update(prof1);
		emp_DAO.update(emp1);
		serv_DAO.update(serv1);
		serv_DAO.update(serv2);
//		
//		System.out.println("SERVICIOOS  "+ serv_DAO.AllServices());
//		System.out.println(Customer.getCustomerDAO().byId(1).getMail());
//		System.out.println(Customer.getCustomerDAO().byId(2).getName());
//		System.out.println("Existe el mail mundial86@mail.com en BDD = "+Customer.foundMail("mundial86@mail.com"));
		
		// CONTROLADOR DE SACAR TURNO
		TakeTurnWindow view = new TakeTurnWindow();
//		CustomerDTO customer = new CustomerDTO();		
		ControllerTakeTurn controller = new ControllerTakeTurn(view, cust1);
		controller.initialize();

		
		// VISTA DE GENTION DE PAGO.
//		ManagePaymentWindow viewPay = new ManagePaymentWindow();
		//PaymentCashWindow view2 = new PaymentCashWindow();
		//PaymentPointsWindow view3 = new PaymentPointsWindow();
//		serv_DAO.create(serv1);
//		serv_DAO.update(serv1);
//		turn1.setService(serv1);
//		turn_DAO.update(turn1);
//		cust1.addTurn(turn1);
//		cust_DAO.update(cust1);
//		@SuppressWarnings("unused")
//		ControllerManagePayment ControllerPay = new ControllerManagePayment(viewPay,cust1);
	}	
}