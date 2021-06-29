package project.staff;
import java.sql.*;
import java.util.ArrayList;
import project.DatabaseConnection;

public class StaffDAO 
{
	static Connection currentCon = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	
	
	public static StaffBean login(StaffBean bean) 
	{
		// preparing some objects for connection 		
		Statement stmt = null;
		String ID = bean.getID();
		String password = bean.getPassword();
		String searchQuery = "select * from staff where staff_ID='" 
				+ ID + "' AND staff_Password='" + password + "'";
		//------prepared statement
		//String searchQuery = "select * from staff where staff_ID=? and staff_Password=?";
		
		// used to trace the process
		System.out.println("in UserBean.login");
		System.out.println("Your ID is " + ID);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try {
			// connect to DB
			currentCon = DatabaseConnection.getConnection();
			stmt = currentCon.createStatement();
			//----prepared statement
			//PreparedStatement stmt = currentCon.prepareStatement(searchQuery);
	            //stmt.setString(1, ID);
	            //stmt.setString(2, password);
			rs = stmt.executeQuery(searchQuery);
			 boolean more = rs.next();

			// if user does not exist
			if (!more) {
				System.out.println("Sorry, you are not a registered user! " + "Please sign up first");
				bean.setValid(false);
			}
			// if user exists
			else if (more) 
			{
				System.out.println("Welcome " + rs.getString("staff_Name"));
				bean.setName(rs.getString("staff_Name"));
				bean.setPhone(rs.getString("staff_Phone"));
				bean.setOutlet_ID(rs.getString("outlet_ID"));
				bean.setValid(true);

			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) { }
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
		return bean;
	}

	public static boolean add (StaffBean Bean) {
		try {
			String queryString = "INSERT INTO staff(staff_ID, staff_Name, staff_Phone, staff_Password, outlet_ID) VALUES(?,?,?,?,?)";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getID());
			ptmt.setString(2, Bean.getName());
			ptmt.setString(3, Bean.getPhone());
			ptmt.setString(4, Bean.getPassword());
			ptmt.setString(5, Bean.getOutlet_ID());
			
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
	
	public static boolean update(StaffBean Bean) {

		try {
			String queryString = "UPDATE staff SET staff_Name=?,staff_Phone=?,staff_Password=?,outlet_ID=? WHERE staff_ID=?";
			currentCon = DatabaseConnection.getConnection();
			ptmt = currentCon.prepareStatement(queryString);
			ptmt.setString(1, Bean.getName());
			ptmt.setString(2, Bean.getPhone());
			ptmt.setString(3, Bean.getPassword());
			ptmt.setString(4, Bean.getOutlet_ID());
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
			String queryString = "DELETE FROM staff WHERE staff_ID=?";
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
	
	public static ArrayList<StaffBean> getAll(){
		// preparing some objects/variable 
		ArrayList<StaffBean> StaffList = new ArrayList<>();
        String sql = "select staff_ID,staff_name,staff_Phone,outlet_ID from staff";

        Statement stmt = null;
        
        // trace process
        System.out.println("in UserBean.getAll");
        try {        	
        	// connect to DB
        	currentCon = DatabaseConnection.getConnection();
        	stmt = currentCon.createStatement();
        	rs = stmt.executeQuery(sql);

        	// iterate over the ResultSet, add row into object and object into list
            while(rs.next()){ 
            	StaffBean S = new StaffBean();
            	S.setID(rs.getString("staff_ID"));
            	S.setName(rs.getString("staff_Name"));
				S.setPhone(rs.getString("staff_Phone"));
				S.setOutlet_ID(rs.getString("outlet_ID"));
            	StaffList.add(S);
            	System.out.println(S.getID());
            	System.out.println(S.getName());
                System.out.println(StaffList);
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
        return StaffList;
    }
	
	public static StaffBean Find(String id)
	{
		 ArrayList<StaffBean> List = new ArrayList<>();
		 StaffBean bean = new StaffBean();
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
