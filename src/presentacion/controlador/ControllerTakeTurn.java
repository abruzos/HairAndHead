package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
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

public class ControllerTakeTurn implements ActionListener // VERSION SIN VENTANAS.
{	
	private turnWindow _view;                 // FALTA CREAR turnWindow.
	private Professional _professional_model;
	private Service _service_model;
	private Workday _workday_model;
	private Turn _turnl_model;
	private List<ServiceDTO> _services;
	private List<ProfessionalDTO> _professionals_with_selected_service;
	private List<WorkdayDTO> _workdays_of_selected_proffesional;
	private LocalDateTime _service_day;
	
	public ControllerTakeTurn(turnWindow view, Professional professional, Service service, Workday workday, Turn turn)
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
	public void fillServices(turnWindow window) throws Exception
	{
		_services = _service_model.obtainServices();
		for (ServiceDTO service : _services) 
		{
			window.getService().addItem(service);
		}	
	}
	
	//Se rellena el desplegable con los profesionales que realizan el servicio seleccionado.
	public void fillProfessionals(turnWindow window, ServiceDTO selected_service) throws Exception
	{
		_professionals_with_selected_service = _professional_model.professionalsWithSelectedService(selected_service);
		for (ProfessionalDTO professional : _professionals_with_selected_service) 
		{
			window.getProfessional().addItem(professional);
		}	
	}
	
	public void showDays(ProfessionalDTO selected_professional) // FALTA QUITAR DUPLICADOS
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
	
	public void fillSchedules(turnWindow window, WorkdayDTO selected_day) throws Exception  // FALTA DEFINIR FUNCIONAMIENTO.
	{
		
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
