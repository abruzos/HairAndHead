package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

import dto.CustomerDTO;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import dto.TurnDTO;
import dto.WorkdayDTO;
import modelo.Customer;
import modelo.Professional;
import modelo.Service;
import modelo.Turn;
import modelo.Workday;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.implementacion.ServiceJPA;
import presentacion.vista.TakeTurnWindow;

public class ControllerTakeTurn implements ActionListener
{	
	private TakeTurnWindow _view;                
	private Professional _professional_model;
	private Service _service_model;
	private Workday _workday_model;
	private Turn _turn_model;
	private Customer _customer_model;
	private List<ServiceDTO> _services;
	private List<ProfessionalDTO> _professionals_with_selected_service;
	private List<WorkdayDTO> _workdays_of_selected_proffesional;
	private LocalDateTime _service_day;
	private ProfessionalDTO selected_professional;
	private CustomerDTO customer;
	
	public ControllerTakeTurn(TakeTurnWindow view, Professional professional, Service service, Workday workday, Turn turn, Customer customer)
	{	
		_view = view;
		
		createListeners();
		
		_professional_model = professional;
		_service_model = service;
		_workday_model = workday;
		_turn_model = turn;
		_customer_model = customer;
		
		_services = null;
		_professionals_with_selected_service = new ArrayList<ProfessionalDTO>();
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
		_view.getBtnAcceptDay().addActionListener(this);
		_view.getBtnAcceptSchedule().addActionListener(this);
		_view.getBtnTakeTurn().addActionListener(this);
	}
	
	//Se rellena el desplegable con los servicios.
	public void fillServices(TakeTurnWindow window) throws Exception
	{	
		ServiceJPA s = new ServiceJPA();
		_services = s.all();
		for (ServiceDTO service : _services) 
		{
			window.getService().addItem(service);
		}	
	}
	
	//Se rellena el desplegable con los profesionales que realizan el servicio seleccionado.
	public void fillProfessionals(ServiceDTO selected_service) throws Exception
	{	
		ProfessionalJPA p = new ProfessionalJPA();
		List<ProfessionalDTO> professionals = p.all();
		
		for(int i = 0; i<professionals.size(); i++)
		{	
			for(int z = 0; z<professionals.get(i).getServices().size(); z++)
			{
				if(professionals.get(i).getServices().get(z).getName().equals(selected_service.getName())) 
				{	
					System.out.println(professionals.get(i).getServices().get(z).getName());
					System.out.println(professionals.get(i).getName());
					_professionals_with_selected_service.add(professionals.get(i));
				}
			}
		}
		
		for (ProfessionalDTO professional : _professionals_with_selected_service) 
		{
			_view.getProfessional().addItem(professional);
		}	
	}
		
	public void showDays(ProfessionalDTO selected_professional) throws Exception
	{
		_workdays_of_selected_proffesional = selected_professional.getWorkdays();
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
	
	public String convertToSpanish(String day) 
	{
		String dayToSpanish = null;
		switch (day) {
		  case "MONDAY":
			  dayToSpanish = "Lunes";
		    break;
		  case "TUESDAY":
			  dayToSpanish = "Martes";
		    break;
		  case "WEDNESDAY":
			  dayToSpanish = "Miercoles";
		    break;
		  case "THURSDAY":
			  dayToSpanish = "Jueves";
		    break;
		  case "FRIDAY":
			  dayToSpanish = "Viernes";
		    break;
		  case "SATURDAY":
			  dayToSpanish = "Sabado";
		    break;
		  case "SUNDAY":
			  dayToSpanish = "Domingo";
		    break;
		}
		return dayToSpanish;
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
			try {
				ServiceDTO selected_service = (ServiceDTO)_view.getService().getSelectedItem();
				fillProfessionals(selected_service);
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == _view.getBtnAcceptProfessional())
		{
			try {
				selected_professional = (ProfessionalDTO)_view.getProfessional().getSelectedItem();
				showDays(selected_professional);
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == _view.getBtnAcceptDay())
		{
			try {
				System.out.println(_view.getDay().toString());
				 LocalDate localDate2 = LocalDate.parse(_view.getDay().toString());
				 System.out.println(localDate2.getDayOfWeek().toString());
				 System.out.println(convertToSpanish(localDate2.getDayOfWeek().toString()));
				 
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == _view.getBtnTakeTurn() && _service_day.getHour() != 0)
		{
			try {	
				TurnDTO new_turn = _turn_model.creationOfTurn(_service_day);
				_professional_model.addTurnProfessional(selected_professional, new_turn);
				_customer_model.addTurnCustomer(customer, new_turn);
			} catch (Exception e1) 
			{
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
