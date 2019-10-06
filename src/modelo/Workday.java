package modelo;

import java.util.List;
import dto.ProfessionalDTO;
import dto.WorkdayDTO;
import persistencia.dao.implementacion.WorkdayJPA;
import persistencia.dao.interfaz.WorkdayDAO;

public class Workday 
{
	private WorkdayDAO _workday;
	
	public WorkdayDAO createWorkdayDAO() 
	{
		return new WorkdayJPA();
	}
	
	//Creacion de una jornada de trabajo.
	public void createWorkday(WorkdayDTO new_workday) throws Exception 
	{
		_workday.create(new_workday);
	}
	
	//Eliminacion de una jornada de trabajo.
	public void deleteWorkday(WorkdayDTO workday_to_delete) throws Exception 
	{
		_workday.delete(workday_to_delete);
	}
	
	//Modificacion de una jornada de trabajo.
	public void updateWorkday(WorkdayDTO workday_to_update) throws Exception 
	{
		_workday.update(workday_to_update);
	}
	
	//Retorno de una jornada de trabajo por ID.
	public void getWorkdayID(int workday_id) throws Exception 
	{
		_workday.byId(workday_id);
	}
	
	//Lista de todas las jornadas de trabajo.
	public List<WorkdayDTO> obtainWorkdays() throws Exception 
	{
		return _workday.all();
	}	
	
	//Lista de las jornadas de trabajo del profesional seleccionado ----> CALENDARIO / DESPLEGABLE HORARIOS.
	public List<WorkdayDTO> workdaysOfSelectedProfessional(ProfessionalDTO selected_professional) throws Exception 
	{
		List<WorkdayDTO> workdays_of_selected_proffesional = selected_professional.getWorkdays();
			
		return workdays_of_selected_proffesional;
	}
}
