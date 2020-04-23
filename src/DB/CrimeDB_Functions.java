package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrimeDB_Functions {
	public static Connection con = null;

	//database connection initialization
	public CrimeDB_Functions() throws ClassNotFoundException, SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrimeInvestigations?useSSL=false","root","root"); //dbname , mysqlaccname, mysqlpass
		Class.forName("com.mysql.jdbc.Driver");  //lib name
	}
	
	//get Profile name
	public String getProfileName(String username) throws SQLException {
		String valid = null;
		
		PreparedStatement login = con.prepareStatement("Select name from police_station where username = ?");
		login.setString(1, username);

		ResultSet rs=login.executeQuery();
		if(rs.next())
			valid = rs.getString("name");
		
		return valid;
	}
	
	
	//police station login
	public boolean police_station_login(String username,
										String password) throws SQLException {
		boolean valid = false; //always to be false
		
		PreparedStatement login = con.prepareStatement("Select password from police_station where username = ?");
		login.setString(1, username);
		
		ResultSet rs=login.executeQuery();
		if(rs.next()) {
			String pass=rs.getString("password"); //fetching password from the database
			if(pass.equals(password)) //checking for equality
				valid = true; 	//allow the user to login
		}
		
		return valid; //return login status
	}
	
	//police officer login
	public boolean police_officer_login(String username,
										String password) throws SQLException {
		boolean valid = false; //always to be false
		
		PreparedStatement login = con.prepareStatement("Select password from police_officer where username = ?");
		login.setString(1, username);
		
		ResultSet rs=login.executeQuery();
		if(rs.next()) {
			String pass=rs.getString("password"); //fetching password from the database
			if(pass.equals(password)) //checking for equality
				valid = true; 	//allow the user to login
		}
		
		return valid; //return login status
	}
	
	//register police officer
	public String police_officer_register( String police_stationID,
										   String name,
										   String post,
										   String mobile,
										   String address,
										   String username,
										   String password) throws SQLException {
		String valid = "";
		
		//see if the username already exists in the system
		PreparedStatement checkUser = con.prepareStatement("Select * from police_officer where username = ?");
		checkUser.setString(1, username);
		
		ResultSet rs=checkUser.executeQuery();
		if(rs.next()) {
			valid = "User already exists."; //could not register
		}
		else {
			//insert all the registration values
			PreparedStatement register = con.prepareStatement("INSERT INTO police_officer(police_stationId, name, post, mobile, address, username, password)"
															+ "values(?,?,?,?,?,?,?)");
			register.setString(1, police_stationID);
			register.setString(2, name);
			register.setString(3, post);
			register.setString(4, mobile);
			register.setString(5, address);
			register.setString(6, username);
			register.setString(7, password);
			
			register.execute();  //execute the query, result will assure the outcome
			valid = "Registeration Successful";
			
		}
		return valid;  //return final message
	}
	
	//create fir 
	public boolean create_fir(  String firId,
								String policeStationName,
								String title,
								String act,
								String name,
								String address,
								String dateAdded,
								String city,
								String mobile,
								String email,
								String details ) throws SQLException {
		boolean status = false;   //check the query execution
		
		//Insert query
		PreparedStatement create = con.prepareStatement("INSERT INTO fir values(?,?,?,?,?,?,?,?,?,?,?)	");
		create.setString(1, firId);
		create.setString(2, policeStationName);
		create.setString(3, title);
		create.setString(4, act);
		create.setString(5, name);
		create.setString(6, address);
		create.setString(7, dateAdded);
		create.setString(8, city);
		create.setString(9, mobile);
		create.setString(10, email);
		create.setString(11, details);
		
		create.execute();
		status = true;
		
		return status;
	}
	
	//search if fir exists
	public ResultSet search_fir(String firID) throws SQLException {
		
		//query to select the record
		PreparedStatement search = con.prepareStatement("SELECT * FROM fir WHERE firId = ?");
		search.setString(1, firID);
		
		ResultSet rs = search.executeQuery();
		
		//if exists returns true else false
		if(rs.next())
			return rs;
		return null;
	}
	

	//search fir and return ResultSet
	public ResultSet search_all_fir(String act) throws SQLException{
		//search query
		PreparedStatement search = con.prepareStatement("SELECT * FROM fir WHERE act = ?");
		search.setString(1,	 act);
		ResultSet rs = search.executeQuery();
		
		//return all data
		if(rs.next())
			return rs;
		return null;
	}
	
	//delete fir
	public boolean delete_fir(String firId) throws SQLException {
		
		PreparedStatement delete = con.prepareStatement("DELETE FROM fir WHERE firId = ?");
		delete.setString(1, firId);
		delete.execute();
		
		return true;
		
	}
	
	//create case
	public boolean create_case(String caseId,
							   String firId,
							   String dateEnter,
							   String place,
							   String objects,
							   String typeOfCrime,
							   String details) throws SQLException {
		boolean status = true;
		
		PreparedStatement create = con.prepareStatement("INSERT INTO cases(caseId, firId, dateEnter, place, objects, typeOfCrime, details)"
														+ "values(?,?,?,?,?,?,?)");
		create.setString(1, caseId);
		create.setString(2, firId);
		create.setString(3, dateEnter);
		create.setString(4, place);
		create.setString(5, objects);
		create.setString(6, typeOfCrime);
		create.setString(7, details);
		create.execute();
		
		return status;
	}
	
	//search case
	public ResultSet search_case(String caseId) throws SQLException {
		
		PreparedStatement search = con.prepareStatement("SELECT * FROM cases WHERE caseId = ?");
		search.setString(1, caseId);
		ResultSet rs = search.executeQuery();
		
		return rs;
	}
	
	//delete case
	public boolean delete_case(String caseId) throws SQLException {
		
		PreparedStatement delete = con.prepareStatement("DELETE FROM cases WHERE caseId = ?");
		delete.setString(1, caseId);
		delete.execute();
		
		return true;
		
	}
	
	//create criminal
	public boolean create_criminal(	String criminalId,
									String name,
									String address,
									String city,
									String mstatus,
									String gender,
									String weight,
									String height,
									String dateArrest,
									String dateRelease,
									String dateBirth,
									String bplace,
									String occupation,
									String act) throws SQLException {
		
		//Insert query
		PreparedStatement create = con.prepareStatement("INSERT INTO criminal VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		create.setString(1, criminalId);
		create.setString(2, name);
		create.setString(3, address);
		create.setString(4, city);
		create.setString(5, mstatus);
		create.setString(6, gender);
		create.setString(7, weight);
		create.setString(8, height);
		create.setString(9, dateArrest);
		create.setString(10, dateRelease);
		create.setString(11, dateBirth);
		create.setString(12, bplace);
		create.setString(13, occupation);
		create.setString(14, act);
		
		create.execute();		
		return true;
	}
	
	//search criminal
	public ResultSet search_criminal(String criminalId) throws SQLException {
		
		PreparedStatement search = con.prepareStatement("SELECT * FROM criminal WHERE criminalId = ?");
		search.setString(1, criminalId);
		ResultSet rs = search.executeQuery();
		
		return rs;
	}
		
	//delete criminal
	public boolean delete_criminal(String criminalId) throws SQLException {
		
		PreparedStatement delete = con.prepareStatement("DELETE FROM criminal WHERE criminalId = ?");
		delete.setString(1, criminalId);
		delete.execute();
		
		return true;
		
	}
}


