package modelo;

import java.util.ArrayList;
import java.util.List;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.interfaz.ProfessionalDAO;

public class Professional 
{
	private ProfessionalDAO _professional;
	
	public ProfessionalDAO createProfessionalDAO() 
	{
		return new ProfessionalJPA();
	}
	
	//Lista de todos los profesionales.
	public List<ProfessionalDTO> obtainProfessionals() throws Exception 
	{
		return _professional.all();
	}
	
	//Lista de profesionales que realizan el servicio seleccionado ----> DESPLEGABLE PROFESIONALES.
	public List<ProfessionalDTO> professionalsWithSelectService(ServiceDTO selectedService) throws Exception
	{
		List<ProfessionalDTO> professionals_with_selected_service = new ArrayList<>();
		List<ProfessionalDTO> professionals = obtainProfessionals();
			
		for(int i = 0; i<professionals.size(); i++)
		{
			if(professionals.get(i).getServices().contains(selectedService)) 
		{
				professionals_with_selected_service.add(professionals.get(i));
		}
		}
		return professionals_with_selected_service;
	}
	
	//Lista de dias de trabajo del profesional seleccionado ----> CALENDARIO.
	public List<String> daysOfSelectedProfessional(ProfessionalDTO selectedProffesional) 
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
	public List<String> entryTimesOfSelectedProfessional(ProfessionalDTO selectedProffesional) 
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
	public List<String> departureTimesOfSelectedProfessional(ProfessionalDTO selectedProffesional) 
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
