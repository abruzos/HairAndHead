package modelo;

public class Person 
{
	private String _name;
	private String _surname;
	private String _age;
	private String _mail;
	private String _numberPhone;
	
	public Person(String name, String surname, String age,String mail, String numberPhone) 
	{
		_name = name;
		_surname = surname;
		_age = age;
		_mail = mail;
		_numberPhone = numberPhone;
	}
	
	public Person() {}

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