package org.apache.struts.login.action;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts.login.model.User;


public class Login extends ActionSupport{
	
	private User user = new User();
	private String password;
	private String errorMessage;
	String DBurl = "jdbc:mysql://localhost:3306/ASEASSIGNMENT2?useLegacyDatetimeCode=false&serverTimezone=UTC";
	Connection connection = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	
	public String index() {  
        return SUCCESS;
    }
	public void validate(){
        if (user.getUsername().length() == 0) {
            addFieldError("user.username", "Username is required.");
        }
        if (user.getPassword().length() == 0) {
            addFieldError("user.password", "Password is required.");
        }

    }
	public String login(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(DBurl, "root", "password");
            PreparedStatement statement = connection.prepareStatement("SELECT password FROM ASEASSIGNMENT2.USER WHERE username = ?");
            statement.setString(1, user.getUsername());
            
            ResultSet rs = statement.executeQuery();
            rs.next();
            this.password = rs.getString(1);
            System.out.println(this.password);
            if (this.password.equals(this.user.getPassword())) {
                return SUCCESS;
            } else {
            	errorMessage = "Wrong password is entered";
            	return ERROR;
            }

        } catch (Exception e) {
        	errorMessage = "Database is not connected.";
            return ERROR;
            
        } 
    }
	public User getUser() {
        return this.user;
    }
	public void setPerson(User user) {
        this.user = user;
    }
	public String getErrorMessage(){
		return this.errorMessage;
	}
	
}

