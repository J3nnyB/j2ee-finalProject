/*
	Name: Jennifer Byrne
	Date: March 29, 2020
	Notes: ENTD481 Final Project - Java Bean and JDBC connection
*/
// Package statement
package finalproject;

//Import the following Java libraries
import java.io.Serializable;
import java.sql.*;

// Class declaration
public class DeptBean implements Serializable {
	
	// Default serial version UID
	private static final long serialVersionUID = 1L;
	
    // Private global variables
	private String deptNum;
	private String deptName;
	public Connection myConn;
	public Statement myStmt = null;
	public ResultSet myRS = null;
	
	// Public zero-argument constructor
    public DeptBean() {
    	// Connects to database
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Rhys1116!!");
    		myStmt = myConn.createStatement();	
		}
		// Catch block for exceptions
		catch (Exception e){			
			e.printStackTrace();
    	}
    }
    // Public full constructor
    public DeptBean(String deptNum, String deptName) {
    	this.deptName = deptNum;
    	this.deptName = deptName;
    }
    // Getter method for deptNum
	public String getDeptNum() {
		return deptNum;
	}
	// Setter method for deptNum
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}
	// Getter method for deptName
	public String getDeptName() {
		return deptName;
	}
	// Setter method for deptName
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	// Queries the database
	public void setData() {
		try {
			myRS = myStmt.executeQuery("select * from departments");
		}// Catch block
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Returns the query object
	public ResultSet getResult() {
		return myRS;
	}
}
	