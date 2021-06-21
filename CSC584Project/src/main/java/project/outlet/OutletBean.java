package project.outlet;

public class OutletBean 
{
	private String ID;
	private String name;
	private String details;
	
	public OutletBean() 
	{
		super();
	}
	
	
	public OutletBean(String iD, String name, String details) 
	{
		super();
		ID = iD;
		this.name = name;
		this.details = details;
	}


	public String getID() 
	{
		return ID;
	}
	public void setID(String iD) 
	{
		ID = iD;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) 
	{
		this.details = details;
	}


}
