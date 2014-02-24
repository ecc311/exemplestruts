package src.paquet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport {

		private static Connection conn;
		private String sql;
	    private String name;
	    private Integer age;
	    private String email;
	    private String telephone;
	 
	    public String execute() {
	    	
	    	init();
			try {
				Statement stmt = conn.createStatement();
				System.out.println(this.name+","+this.email+","+this.age+","+this.telephone);
				sql = "INSERT INTO client SET nom='" + this.name
						+ "',edat='" + this.age + "',email='"
						+ this.email + "',Telefon='"
						+ this.telephone + "'";
				stmt.executeUpdate(sql);
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return INPUT;
			}
			return SUCCESS;
	    }
	    
	    public void init() {

			conn=null;
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String servidor="jdbc:mysql://localhost/client";
				String usuarioDB="root";
				String passwordDB="";
				conn=DriverManager.getConnection(servidor,usuarioDB,passwordDB);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				conn=null;
			}catch (Exception e){
				
				e.printStackTrace();
				conn=null;
			}
		}
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public Integer getAge() {
	        return age;
	    }
	    
	    public void setAge(Integer age) {
	        this.age = age;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getTelephone() {
	        return telephone;
	    }
	    
	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }
	}
	
