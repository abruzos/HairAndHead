package modelo;

import java.util.ArrayList;
import java.util.List;
import dto.EmployeeDTO;
import dto.ServiceDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.EmployeeJPA;
import persistencia.dao.interfaz.EmployeeDAO;

public class Employee 
{
	private EmployeeDAO _employee;
	
	public EmployeeDAO createEmployeeDAO() 
	{
		return new EmployeeJPA();
	}
	
	//Lista de todos los empleados.
	public List<EmployeeDTO> obtainEmployees() throws Exception 
	{
		return _employee.all();
	}
	
	//Lista de profesionales que realizan el servicio seleccionado ----> DESPLEGABLE PROFESIONALES.
	public List<EmployeeDTO> professionalsWithSelectService(ServiceDTO selectedService) throws Exception
	{
		List<EmployeeDTO> professionals_with_selected_service = new ArrayList<>();
		List<EmployeeDTO> employees = obtainEmployees();
			
		for(int i = 0; i<employees.size(); i++)
		{
			if(employees.get(i).getServices().contains(selectedService)) 
		{
				professionals_with_selected_service.add(employees.get(i));
		}
		}
		return professionals_with_selected_service;
	}
	
	//Lista de dias del profesional seleccionado ----> CALENDARIO.
	public List<String> daysOfSelectedProfessional(EmployeeDTO selectedProffesional) 
	{
		List<WorkdayDTO> workdays_of_selected_proffesional = selectedProffesional.getWorkdays();
		List<String> days_of_selected_proffesional = new ArrayList<>();
			
		for(int i = 0; i<workdays_of_selected_proffesional.size(); i++)
		{
			days_of_selected_proffesional.add(workdays_of_selected_proffesional.get(i).getDay());
		}
		return days_of_selected_proffesional;
	}
	
	//Lista de los horarios de entrada del profesional seleccionado ----> DESPLEGABLE HORARIOS.
	public List<String> entryTimesOfSelectedProfessional(EmployeeDTO selectedProffesional) 
	{
		List<WorkdayDTO> workdays_of_selected_proffesional = selectedProffesional.getWorkdays();
		List<String> entry_times_of_selected_proffesional = new ArrayList<>();
			
		for(int i = 0; i<workdays_of_selected_proffesional.size(); i++)
		{
			entry_times_of_selected_proffesional.add(workdays_of_selected_proffesional.get(i).getSince());
		}
		return entry_times_of_selected_proffesional;
	}
		
	//Lista de los horarios de salida del profesional seleccionado ----> DESPLEGABLE HORARIOS.
	public List<String> departureTimesOfSelectedProfessional(EmployeeDTO selectedProffesional) 
	{
		List<WorkdayDTO> workdays_of_selected_proffesional = selectedProffesional.getWorkdays();
		List<String> departure_times_of_selected_proffesional = new ArrayList<>();
			
		for(int i = 0; i<workdays_of_selected_proffesional.size(); i++)
		{
			departure_times_of_selected_proffesional.add(workdays_of_selected_proffesional.get(i).getUntil());
		}
		return departure_times_of_selected_proffesional;
	}
}
