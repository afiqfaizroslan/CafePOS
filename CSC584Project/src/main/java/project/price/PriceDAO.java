package project.price;
import java.sql.*;
import java.util.ArrayList;
import project.DatabaseConnection;


public class PriceDAO
{
	static Connection currentCon = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	
	

	public static boolean add (PriceBean Bean) {
		try {
			String queryString = "INSERT INTO price(price_ID, price_Value, price_Discount) VALUES(?,?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getID());
			ptmt.setDouble(2, Bean.getValue());
			ptmt.setDouble(3, Bean.getDiscount());
		
			
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
	
	public static boolean update(PriceBean Bean) {

		try {
			String queryString = "UPDATE price SET price_Value=?,price_Discount=? WHERE price_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setDouble(1, Bean.getValue());
			ptmt.setDouble(2, Bean.getDiscount());
			ptmt.setString(3, Bean.getID());
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
			String queryString = "DELETE FROM price WHERE price_ID=?";
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
	
	public static ArrayList<PriceBean> getAll(){
		// preparing some objects/variable 
		ArrayList<PriceBean> ProductList = new ArrayList<>();
        String sql = "select * from price";

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
            	PriceBean S = new PriceBean();
            	S.setID(rs.getString("price_ID"));
            	S.setValue(rs.getDouble("price_Value"));
				S.setDiscount(rs.getDouble("price_Discount"));
            	ProductList.add(S);
            	System.out.println(S.getID());
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
	
	
	public static PriceBean Find(String id)
	{
		 ArrayList<PriceBean> List = new ArrayList<>();
		 PriceBean bean = new PriceBean();
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

