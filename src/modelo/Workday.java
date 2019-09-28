package modelo;

public class Workday 
{
	private String _day;
	private String _since;
	private String _until;
	
	public Workday(String day, String since, String until) 
	{
		_day = day;
		_since = since;
		_until = until;
	}
	
	public Workday() {}

	public String getDay() 
	{
		return _day;
	}

	public String getSince()
	{
		return _since;
	}

	public String getUntil() 
	{
		return _until;
	}

	public void setDay(String day)
	{
		_day = day;
	}

	public void setSince(String since) 
	{
		_since = since;
	}

	public void setUntil(String until)
	{
		_until = until;
	}
}