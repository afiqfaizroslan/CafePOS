package project.product;
import java.sql.*;
import java.util.ArrayList;
import project.DatabaseConnection;


public class ProductDAO
{
	static Connection currentCon = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	
	

	public static boolean add (ProductBean Bean) {
		try {
			String queryString = "INSERT INTO product(product_ID, product_Name, product_Details, product_Stocks, price_ID) VALUES(?,?,?,?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getID());
			ptmt.setString(2, Bean.getName());
			ptmt.setString(3, Bean.getDetails());
			ptmt.setInt(4, Bean.getStock());
			ptmt.setString(5, Bean.getPrice_ID());
		
			
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
	
	public static boolean update(ProductBean Bean) {

		try {
			String queryString = "UPDATE product SET product_Name=?,product_Details=?,product_Stocks=?,price_ID=? WHERE product_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getName());
			ptmt.setString(2, Bean.getDetails());
			ptmt.setInt(3, Bean.getStock());
			ptmt.setString(4, Bean.getPrice_ID());
			ptmt.setString(5, Bean.getID());
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
	
	
	public static void Delete (String ID)
	{
		try {
			String queryString = "DELETE FROM product WHERE product_ID=?";
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
	
	public static ArrayList<ProductBean> getAll(){
		// preparing some objects/variable 
		ArrayList<ProductBean> ProductList = new ArrayList<>();
        String sql = "select * from product";

        Statement stmt = null;
        
        // trace process
        System.out.println("in getAll");
        try {        	
        	// connect to DB
        	currentCon = DatabaseConnection.getConnection();
        	stmt = currentCon.createStatement();
        	rs = stmt.executeQuery(sql);

        	// iterate over the ResultSet, add row into object and object into list
            while(rs.next()){ 
            	ProductBean S = new ProductBean();
            	S.setID(rs.getString("product_ID"));
            	S.setName(rs.getString("product_Name"));
				S.setDetails(rs.getString("product_Details"));
				S.setStock(rs.getInt("product_Stocks"));
				S.setPrice_ID(rs.getString("price_ID"));
            	ProductList.add(S);
            	System.out.println(S.getID());
            	System.out.println(S.getName());
                System.out.println(ProductList);
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
        return ProductList;
    }
	
	
	public static ProductBean Find(String id)
	{
		 ArrayList<ProductBean> List = new ArrayList<>();
		 ProductBean bean = new ProductBean();
		 List = getAll();
		 for (int i = 0; i < List.size(); i++) 
		 { 
			 if(List.get(i).getID().equals(id))
			 {
				 bean = List.get(i);
			 }

		 } 
		 return bean;
	
	}


}
