package modelo;

import java.util.List;
import dto.EmployeeDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.EmployeeDAO;

public class Employee 
{
	private EmployeeDAO employee;
	
	public Employee(DAOAbstractFactory metod_persistence) 
	{
		this.employee = metod_persistence.createEmployeeDAO();             
	}
	
	public void addEmployee(EmployeeDTO employee) throws Exception 
	{
		this.employee.create(employee);
	}

	public void deleteEmployee(EmployeeDTO employee_to_delete) throws Exception 
	{
		this.employee.delete(employee_to_delete);
	}
	
	public List<EmployeeDTO> obtainEmployee() throws Exception 
	{
		return this.employee.all();		
	}
	
	public void editEmployee(EmployeeDTO employee_to_edit) throws Exception 
	{
		this.employee.update(employee_to_edit);
	}
}
