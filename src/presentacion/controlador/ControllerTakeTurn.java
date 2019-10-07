package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import dto.WorkdayDTO;
import modelo.Professional;
import modelo.Service;
import modelo.Turn;
import modelo.Workday;
import presentacion.vista.TakeTurnWindow;

public class ControllerTakeTurn implements ActionListener // VERSION SIN VENTANAS.
{	
	private TakeTurnWindow _view;                
	private Professional _professional_model;
	private Service _service_model;
	private Workday _workday_model;
	private Turn _turnl_model;
	private List<ServiceDTO> _services;
	private List<ProfessionalDTO> _professionals_with_selected_service;
	private List<WorkdayDTO> _workdays_of_selected_proffesional;
	private LocalDateTime _service_day;
	
	public ControllerTakeTurn(TakeTurnWindow view, Professional professional, Service service, Workday workday, Turn turn)
	{	
		_view = view;
		
		createListeners();
		
		_professional_model = professional;
		_service_model = service;
		_workday_model = workday;
		_turnl_model = turn;
		
		_services = null;
		_professionals_with_selected_service = null;
		_workdays_of_selected_proffesional = null;
		
		_service_day = LocalDateTime.of(0, 0, 0, 0, 0);
		
	}
	
	private void createListeners() 
	{
		this.view.getBtnTakeTurn().addActionListener(this); // FALTA CREAR BtnTakeTurn.
	}
	
	//Se rellena el desplegable con los servicios.
	public void fillServices(TakeTurnWindow window) throws Exception
	{
		_services = _service_model.obtainServices();
		for (ServiceDTO service : _services) 
		{
			window.getService().addItem(service);
		}	
	}
	
	//Se rellena el desplegable con los profesionales que realizan el servicio seleccionado.
	public void fillProfessionals(TakeTurnWindow window, ServiceDTO selected_service) throws Exception
	{
		_professionals_with_selected_service = _professional_model.professionalsWithSelectedService(selected_service);
		for (ProfessionalDTO professional : _professionals_with_selected_service) 
		{
			window.getProfessional().addItem(professional);
		}	
	}
	
	public void showDays(ProfessionalDTO selected_professional) throws Exception // FALTA QUITAR DUPLICADOS // USAR SET
	{
		_workdays_of_selected_proffesional = _workday_model.workdaysOfSelectedProfessional(selected_professional);
		String message =  selected_professional.getName().toString() + "trabaja los dias:";
		HashSet<String> workdays_of_selected_proffesional_set = new HashSet<String>();
		for(int i=0; i<_workdays_of_selected_proffesional.size(); i++)
		{	
			if(!workdays_of_selected_proffesional_set.contains( _workdays_of_selected_proffesional.get(i).getDay())) 
			{
				message += "," + _workdays_of_selected_proffesional.get(i).getDay().toString();
				workdays_of_selected_proffesional_set.add(_workdays_of_selected_proffesional.get(i).getDay());
			}
			
		}
		JOptionPane.showMessageDialog(                               
			  	null, message, 
	             "Dias", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void fillSchedules(TakeTurnWindow window, WorkdayDTO selected_day) throws Exception  // FALTA DEFINIR FUNCIONAMIENTO.
	{
		LocalTime start_time = LocalTime.of(Integer.parseInt(selected_day.getSince().substring(0, 2)), Integer.parseInt(selected_day.getSince().substring(2, 4)));
		LocalTime finish_time = LocalTime.of(Integer.parseInt(selected_day.getUntil().substring(0,2)),Integer.parseInt(selected_day.getUntil().substring(2,4)) );
		while(!start_time.equals(finish_time)) 
		{	
			ArrayList<String> Schedule = new ArrayList<String>();
			Schedule.add(start_time.toString());
			Schedule.add("-");
			
			start_time.plusMinutes(30);
			
			Schedule.add(start_time.toString());
			
			window.getSchedules().addItem(Schedule);
		}	
	}

	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getSource() == this.view.getBtnTakeTurn() || _service_day.getHour() != 0)
		{
			_turnl_model.creationOfTurn(_service_day);
		}
		else
		{
			JOptionPane.showMessageDialog(           
				  	null, "Hay campos sin seleccionar.", 
		             "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
