package project.sales;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import project.DatabaseConnection;
import project.price.*;
import project.product.*;

public class SalesDAO 
{
	static Connection currentCon = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	
	

	public static boolean New (SalesBean Bean) {
		try {
			String queryString = "INSERT INTO sales(staff_ID,Sales_date) VALUES(?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getStaff_ID());
			ptmt.setString(2, Bean.getDate());

		
			
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();return false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (currentCon != null)
					currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public static boolean updateTotal(SalesBean Bean) {

		try {
			String queryString = "UPDATE sales SET sales_Total=? WHERE sales_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setDouble(1, Bean.getSales_Total());
			ptmt.setInt(2, Bean.getID());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace(); return false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (currentCon != null)
					currentCon.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	public static SalesBean getLast()
	{
		SalesBean Bean = new SalesBean();
        String sql = "select * from sales ORDER BY sales_ID DESC LIMIT 1";

        Statement stmt = null;
        
        // trace process
        System.out.println("in getLast");
        try {        	
        	// connect to DB
        	currentCon = DatabaseConnection.getConnection();
        	stmt = currentCon.createStatement();
        	rs = stmt.executeQuery(sql);
        	while(rs.next())
        	{
        		 Bean.setStaff_ID(rs.getString("staff_ID"));
        		 Bean.setID(rs.getInt("sales_ID"));
        		 Bean.setDate(rs.getString("sales_date"));
            	System.out.println(Bean.getID());
        	}
    
           
        } catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) { }
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) { }
				currentCon = null;
			}
		}
		return Bean;       
 
    }
	
	public static boolean Add (SalesProductBean Bean) {
		try {
			String queryString = "INSERT INTO product_sale(product_ID,sales_ID) VALUES(?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getProduct_ID());
			ptmt.setString(2, Bean.getSales_ID());

		
			
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();return false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (currentCon != null)
					currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	
	public static void DeleteSales (String ID)
	{
		try {
			String queryString = "DELETE sales FROM sales WHERE sales_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, ID);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (currentCon != null)
					currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public static void DeleteProduct (String ID)
	{
		System.out.println("Delete"+ID);
		try {
			String queryString = "DELETE product_sale FROM product_sale WHERE id=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, ID);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (currentCon != null)
					currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public static ArrayList<SalesBean> getAll(){
		// preparing some objects/variable 
		ArrayList<SalesBean> SalesList = new ArrayList<>();
        String sql = "SELECT * from sales";
        ResultSet rs2 = null;
        Statement stmt = null;
        
        // trace process
        System.out.println("in getAll");
        try {        	
        	// connect to DB
        	currentCon = DatabaseConnection.getConnection();
        	stmt = currentCon.createStatement();
        	rs2 = stmt.executeQuery(sql);

        	// iterate over the ResultSet, add row into object and object into list
            while(rs2.next()){ 
            	SalesBean S = new SalesBean();
            	S.setID(rs2.getInt("sales_ID"));
            	S.setStaff_ID(rs2.getString("staff_ID"));
				S.setSales_Total(rs2.getDouble("sales_Total"));
				S.setDate(rs2.getString("sales_date"));
				S.setProductList(getProduct(S.getID()));
            	SalesList.add(S);
            	System.out.println(S.getID());
                System.out.println(SalesList);
            }
        } catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		} // some exception handling
        finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) { }
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) { }
				currentCon = null;
			}
		}       
        return SalesList;
    }
	
	
	public static SalesBean Find(int id)
	{
		 ArrayList<SalesBean> List = new ArrayList<>();
		 SalesBean bean = new SalesBean();
		 List = getAll();
		 
		 for (int i = 0; i < List.size(); i++) 
		 { 
			 if(List.get(i).getID() == id)
			 {
				 bean = List.get(i);
			 }

		 } 
		 System.out.println("To find = "+id);
		 System.out.println("List size"+List.size());
		 System.out.println("Found = "+bean.getID());
		 return bean;
	
	}
	
	public static  ArrayList<SalesProductBean> getProduct(int id)
	{
		// preparing some objects/variable 
				ArrayList<SalesProductBean> ProductList = new ArrayList<>();
 
		        // trace process
		        System.out.println("in getAll");
		        try {        	
		        	// connect to DB
		        	String queryString = "Select * FROM product_sale WHERE sales_ID=?";
					currentCon = DatabaseConnection.getConnection();
					ptmt = currentCon.prepareStatement(queryString);
					ptmt.setInt(1, id);
					rs = ptmt.executeQuery();

		        	// iterate over the ResultSet, add row into object and object into list
		            while(rs.next()){ 
		            	SalesProductBean S = new SalesProductBean();
		            	S.setId(rs.getInt("id"));
		            	S.setProduct_ID(rs.getString("product_ID"));
						S.setSales_ID(rs.getString("sales_ID"));
		            	ProductList.add(S);
		            	System.out.println(S.getId());
		                System.out.println(ProductList);
		            }
		    	} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
						if (currentCon != null)
							currentCon.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		        return ProductList;
	
	}
	
	public static  Double getTotalPrice(int id)
	{
		Double Total = 0.0;
		DecimalFormat df2 = new DecimalFormat("#.###");
		        // trace process
		        System.out.println("in getAll");
		        try {        	
		        	// connect to DB
		        	String queryString = "Select * FROM product_sale WHERE sales_ID=?";
					currentCon = DatabaseConnection.getConnection();
					ptmt = currentCon.prepareStatement(queryString);
					ptmt.setInt(1, id);
					rs = ptmt.executeQuery();

		        	// iterate over the ResultSet, add row into object and object into list
		            while(rs.next())
		            {
		            	ProductBean S = new ProductBean();
		            	PriceBean P = new PriceBean();
		            	S = ProductDAO.Find((rs.getString("product_ID")));
						P = PriceDAO.Find(S.getPrice_ID());
						Double price = P.getValue() - (P.getValue()*P.getDiscount()/100);
						Total = Total + price;
		            }
		    	} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
						if (currentCon != null)
							currentCon.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
		        Total = Double.parseDouble(df2.format(Total));

		        return Total;
	
	}
	
	public static  ArrayList<SalesBean> getByStaff()
	{
		DecimalFormat df2 = new DecimalFormat("#.###");
		ArrayList<SalesBean> List = new ArrayList<>();
		        // trace process
		        System.out.println("in getsalebyStaff");
		        try {        	
		        	// connect to DB
		        	String queryString = "Select SUM(sales_Total)as Total,staff_ID FROM sales GROUP BY staff_ID";
					currentCon = DatabaseConnection.getConnection();
					ptmt = currentCon.prepareStatement(queryString);

					rs = ptmt.executeQuery();

		        	// iterate over the ResultSet, add row into object and object into list
		            while(rs.next())
		            {
		            	SalesBean S = new SalesBean();
		            	S.setStaff_ID(rs.getString("staff_ID"));
		            	S.setSales_Total(Double.parseDouble(df2.format(rs.getDouble("Total"))));
		            	List.add(S);
		            
		            }
		    	} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
						if (currentCon != null)
							currentCon.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		        return List;
	
	}
	
	public static  ArrayList<HashMap<String, String>> getByProduct()
	{
		DecimalFormat df2 = new DecimalFormat("#.###");
		ArrayList<HashMap<String, String>> List = new ArrayList<>();
		        // trace process
		        System.out.println("in getsalebyStaff");
		        try {        	
		        	// connect to DB
		        	String queryString = "Select Count(product_ID)as Total,product_ID,staff_ID FROM product_sale JOIN sales ON product_sale.sales_ID = sales.sales_ID GROUP BY staff_ID,product_ID";
					currentCon = DatabaseConnection.getConnection();
					ptmt = currentCon.prepareStatement(queryString);

					rs = ptmt.executeQuery();

		        	// iterate over the ResultSet, add row into object and object into list
		            while(rs.next())
		            {
		            	HashMap<String, String> sale = new HashMap<String, String>();
		            	sale.put("Total", df2.format(rs.getDouble("Total")));
		            	sale.put("Staff", rs.getString("staff_ID"));
		            	sale.put("Product", rs.getString("product_ID"));
		            	List.add(sale);
		            	System.out.println(sale.get("Sales"));
		            	System.out.println("List size"+List.size());
		            	
		            
		            }
		    	} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
						if (currentCon != null)
							currentCon.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		        return List;
	
	}
	
	public static  ArrayList<HashMap<String, String>> getProductlist()
	{
		DecimalFormat df2 = new DecimalFormat("#.###");
		ArrayList<HashMap<String, String>> List = new ArrayList<>();
		        // trace process
		        System.out.println("in getsalebyStaff");
		        try {        	
		        	// connect to DB
		        	String queryString = "Select Count(product_ID)as Total,product_ID FROM product_sale GROUP BY product_ID";
					currentCon = DatabaseConnection.getConnection();
					ptmt = currentCon.prepareStatement(queryString);

					rs = ptmt.executeQuery();

		        	// iterate over the ResultSet, add row into object and object into list
		            while(rs.next())
		            {
		            	HashMap<String, String> sale = new HashMap<String, String>();
		            	sale.put("Total", df2.format(rs.getDouble("Total")));
		            	sale.put("Product", rs.getString("product_ID"));
		            	List.add(sale);
		            	System.out.println(sale.get("Product"));
		            	System.out.println("List size"+List.size());
		            	
		            
		            }
		    	} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
						if (currentCon != null)
							currentCon.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		        return List;
	
	}
	
	
}
