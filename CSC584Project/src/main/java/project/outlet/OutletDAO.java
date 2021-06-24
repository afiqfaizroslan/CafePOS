package project.outlet;

import java.sql.*;
import java.util.ArrayList;
import project.DatabaseConnection;

public class OutletDAO 
{
	static Connection currentCon = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	
	

	public static boolean add (OutletBean Bean) {
		try {
			String queryString = "INSERT INTO outlet(outlet_ID, outlet_Name, outlet_Details) VALUES(?,?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getID());
			ptmt.setString(2, Bean.getName());
			ptmt.setString(3, Bean.getDetails());
		
			
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
	
	public static boolean update(OutletBean Bean) {

		try {
			String queryString = "UPDATE outlet SET outlet_Name=?,outlet_Details=? WHERE outlet_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getName());
			ptmt.setString(2, Bean.getDetails());
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
			String queryString = "DELETE outlet,staff FROM outlet INNER JOIN staff ON staff.outlet_ID = outlet.outlet_ID WHERE outlet.outlet_ID=?";
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
	
	public static ArrayList<OutletBean> getAll(){
		// preparing some objects/variable 
		ArrayList<OutletBean> OutletList = new ArrayList<>();
        String sql = "select * from outlet";

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
            	OutletBean S = new OutletBean();
            	S.setID(rs.getString("outlet_ID"));
            	S.setName(rs.getString("outlet_Name"));
				S.setDetails(rs.getString("outlet_Details"));
            	OutletList.add(S);
            	System.out.println(S.getID());
            	System.out.println(S.getName());
                System.out.println(OutletList);
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
        return OutletList;
    }
	
	
	public static OutletBean Find(String id)
	{
		 ArrayList<OutletBean> List = new ArrayList<>();
		 OutletBean bean = new OutletBean();
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
