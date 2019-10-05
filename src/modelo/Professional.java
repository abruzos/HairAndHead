package modelo;

import java.util.ArrayList;
import java.util.List;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import persistencia.dao.implementacion.ProfessionalJPA;
import persistencia.dao.interfaz.ProfessionalDAO;

public class Professional 
{
	private ProfessionalDAO _professional;
	
	public ProfessionalDAO createProfessionalDAO() 
	{
		return new ProfessionalJPA();
	}
	
	//Creacion de un profesional.
	public void createProfessional(ProfessionalDTO new_professional) throws Exception 
	{
		_professional.create(new_professional);
	}
	
	//Eliminacion de un profesional.
	public void deleteProfessional(ProfessionalDTO professional_to_delete) throws Exception 
	{
		_professional.delete(professional_to_delete);
	}
	
	//Modificacion de un profesional.
	public void updateProfessional(ProfessionalDTO professional_to_update) throws Exception 
	{
		_professional.update(professional_to_update);
	}
	
	//Retorno de un profesional por ID.
	public void getProfessionalID(int professional_id) throws Exception 
	{
		_professional.byId(professional_id);
	}
	
	//Lista de todos los profesionales.
	public List<ProfessionalDTO> obtainProfessionals() throws Exception 
	{
		return _professional.all();
	}
	
	//Lista de profesionales que realizan el servicio seleccionado ----> DESPLEGABLE PROFESIONALES.
	public List<ProfessionalDTO> professionalsWithSelectedService(ServiceDTO selected_service) throws Exception
	{
		List<ProfessionalDTO> professionals_with_selected_service = new ArrayList<>();
		List<ProfessionalDTO> professionals = obtainProfessionals();
			
		for(int i = 0; i<professionals.size(); i++)
		{
			if(professionals.get(i).getServices().contains(selected_service)) 
		{
				professionals_with_selected_service.add(professionals.get(i));
		}
		}
		return professionals_with_selected_service;
	}
}
