package main;

import modelo.BranchOffice;
import modelo.Employee;
import modelo.Service;
import modelo.Workday;
import persistencia.dao.implementacion.BranchOfficeJPA;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.implementacion.ServiceJPA;
import persistencia.dao.implementacion.WorkdayJPA;

public class Main 
{

	public static void main(String[] args) 
	{
		BranchOffice b1 = new BranchOffice("Breikin", "Mitre 123", "San miguel", "Bs As", "Argentina");
		BranchOfficeJPA bDAO= new BranchOfficeJPA();
		
		Workday d1 = new Workday("Lunes", "0800hs", "1200hs"); //lista de dias
		WorkdayJPA dDAO = new WorkdayJPA();
		
		Service s1 = new Service("Corte de pelo", 45, 300); //lista de servicios
		ServiceJPA sDAO = new ServiceJPA();
		
		Employee e1 = new Employee("Lucas", "Martin", "20", "mail@gmail.com", "46678393", "Recepcionista",
									"alta", "lmartin", "123456s");
		EmployeeJPA eDAO = new EmployeeJPA();
		
		bDAO.create(b1);
		bDAO.update(b1);	
		dDAO.create(d1);
		sDAO.create(s1);
		eDAO.create(e1);
		bDAO.close();
		
	
		
		
	}

}