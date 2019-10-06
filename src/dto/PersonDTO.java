package dto;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersonDTO 
{
	@Column
	private String _name;
	@Column
	private String _surname;
	@Column
	private String _age;
	@Column
	private String _mail;
	@Column
	private String _numberPhone;
	
	public PersonDTO(String name, String surname, String age,String mail, String numberPhone) 
	{
		_name = name;
		_surname = surname;
		_age = age;
		_mail = mail;
		_numberPhone = numberPhone;
	}
	
	public PersonDTO() {}

	public String getName() 
	{
		return _name;
	}

	public String getSurname() 
	{
		return _surname;
	}

	public String getAge() 
	{
		return _age;
	}

	public String getMail() 
	{
		return _mail;
	}

	public String getNumberPhone() 
	{
		return _numberPhone;
	}

	public void setName(String name) 
	{
		_name = name;
	}

	public void setSurname(String surname) 
	{
		_surname = surname;
	}

	public void setAge(String age)
	{
		_age = age;
	}

	public void setMail(String mail) 
	{
		_mail = mail;
	}

	public void set_numberPhone(String numberPhone) 
	{
		_numberPhone = numberPhone;
	}
}