package project.price;

public class PriceBean 
{
	private String ID;
	private double value;
	private double discount;
	
	public PriceBean(String iD, double value, double discount) {
		super();
		ID = iD;
		this.value = value;
		this.discount = discount;
	}

	public PriceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

}
