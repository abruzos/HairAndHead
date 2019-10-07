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

public class ControllerTakeTurn implements ActionListener
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
		
		_service_day = LocalDateTime.of(1, 1, 1, 0, 0);
		
	}
	
	public void initialize() throws Exception                                     
	{
		_view.show();
		fillServices(_view);
	}  
	
	private void createListeners() 
	{
		_view.getBtnAcceptService().addActionListener(this);
		_view.getBtnAcceptProfessional().addActionListener(this);
		_view.getBtnAcceptSchedule().addActionListener(this);
		_view.getBtnTakeTurn().addActionListener(this);
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
	public void fillProfessionals(ServiceDTO selected_service) throws Exception
	{
		_professionals_with_selected_service = _professional_model.professionalsWithSelectedService(selected_service);
		for (ProfessionalDTO professional : _professionals_with_selected_service) 
		{
			_view.getProfessional().addItem(professional);
		}	
	}
	
	public void showDays(ProfessionalDTO selected_professional) throws Exception
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
	
	public void fillSchedules(WorkdayDTO selected_day) throws Exception
	{
		LocalTime start_time = LocalTime.of(Integer.parseInt(selected_day.getSince().substring(0, 2)), Integer.parseInt(selected_day.getSince().substring(2, 4)));
		LocalTime finish_time = LocalTime.of(Integer.parseInt(selected_day.getUntil().substring(0,2)),Integer.parseInt(selected_day.getUntil().substring(2,4)));
		while(!start_time.equals(finish_time)) 
		{	
			ArrayList<String> Schedule = new ArrayList<String>();
			Schedule.add(start_time.toString());
			Schedule.add("-");
			
			start_time.plusMinutes(30);
			
			Schedule.add(start_time.toString());
			
			_view.getSchedule().addItem(Schedule);
		}	
	}

	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource() == _view.getBtnAcceptService()) 
		{
			ServiceDTO selected_service = (ServiceDTO)_view.getService().getSelectedItem();
			try {
				fillProfessionals(selected_service);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == _view.getBtnAcceptProfessional())
		{
			ProfessionalDTO selected_professional = (ProfessionalDTO)_view.getService().getSelectedItem();
			try {
				showDays(selected_professional);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == _view.getBtnTakeTurn() || _service_day.getHour() != 0)
		{
			try {
				_turnl_model.creationOfTurn(_service_day);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(           
				  	null, "Hay campos sin seleccionar.", 
		             "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
