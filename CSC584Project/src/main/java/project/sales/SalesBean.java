package project.sales;

import java.util.ArrayList;

public class SalesBean 
{
	private int ID ;
	private String staff_ID;
	private double sales_Total;
	private String date;
	private ArrayList<SalesProductBean> ProductList = new ArrayList<>();
	
	public SalesBean(int iD, String staff_ID, double sales_Total, String date, ArrayList<SalesProductBean> productList) {
		super();
		ID = iD;
		this.staff_ID = staff_ID;
		this.sales_Total = sales_Total;
		this.date = date;
		ProductList = productList;
	}

	public SalesBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStaff_ID() {
		return staff_ID;
	}

	public void setStaff_ID(String staff_ID) {
		this.staff_ID = staff_ID;
	}

	public double getSales_Total() {
		return sales_Total;
	}

	public void setSales_Total(double sales_Total) {
		this.sales_Total = sales_Total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<SalesProductBean> getProductList() {
		return ProductList;
	}

	public void setProductList(ArrayList<SalesProductBean> productList) {
		ProductList = productList;
	}
	
	

}
