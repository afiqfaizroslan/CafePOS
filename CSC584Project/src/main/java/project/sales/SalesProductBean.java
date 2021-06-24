package project.sales;

public class SalesProductBean 
{
	private int id;
	private String product_ID;
	private String sales_ID;
	
	public SalesProductBean(int id, String product_ID, String sales_ID) {
		super();
		this.id = id;
		this.product_ID = product_ID;
		this.sales_ID = sales_ID;
	}

	public SalesProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public String getSales_ID() {
		return sales_ID;
	}

	public void setSales_ID(String sales_ID) {
		this.sales_ID = sales_ID;
	}
	
	

}
