package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import dto.WorkdayDTO;
import modelo.Professional;
import modelo.Service;
import modelo.Turn;
import modelo.Workday;

public class ControllerTakeTurn implements ActionListener // VERSION SIN VENTANAS
{	
	private Professional _professional_model;
	private Service _service_model;
	private Workday _workday_model;
	private Turn _turnl_model;
	private List<ServiceDTO> _services;
	private List<ProfessionalDTO> _professionals_with_selected_service;
	private List<WorkdayDTO> _workdays_of_selected_proffesional;
	
	public ControllerTakeTurn(Professional professional, Service service, Workday workday, Turn turn) // FALTA MAIN WINDOW
	{
		_professional_model = professional;
		_service_model = service;
		_workday_model = workday;
		_turnl_model = turn;
		
		_services = null;
		_professionals_with_selected_service = null;
		_workdays_of_selected_proffesional = null;
	}
	
	public void fillServices() 
	{
		
	}
	
	public void fillProfessionals() 
	{
		
	}
	
	public void fillDays() 
	{
		
	}
	
	public void fillSchedules() 
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
