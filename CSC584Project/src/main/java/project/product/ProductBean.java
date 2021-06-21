package project.product;

public class ProductBean 
{
	private String ID;
	private String Name;
	private String Details;
	private int Stock;
	private String Price_ID;
	
	public ProductBean() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductBean(String iD, String name, String details, int stock, String price_ID) 
	{
		super();
		ID = iD;
		Name = name;
		Details = details;
		Stock = stock;
		Price_ID = price_ID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getPrice_ID() {
		return Price_ID;
	}
	public void setPrice_ID(String price_ID) {
		Price_ID = price_ID;
	}
	

}
