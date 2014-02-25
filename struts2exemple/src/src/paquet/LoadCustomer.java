package src.paquet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoadCustomer extends ActionSupport {

	
	private static Connection conn;
	private String sql;
    private String namec;
    private Integer agec;
    private String emailc;
    private String telephonec;
    

    public String execute()
    {
    	init();
    	
    	try {
    			Statement stmt = conn.createStatement();
    			sql = "SELECT nom,edat,email,telefon FROM client WHERE nom='" + this.namec
					+ "'";
    			ResultSet aux = stmt.executeQuery(sql);
    			aux.beforeFirst();
    			aux.next();
    			this.namec = aux.getString("nom");
    			this.agec = aux.getInt("edat");
    			this.emailc = aux.getString("email");
    			this.telephonec = aux.getString("telefon");
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
    
    public String getNamec() {
        return namec;
    }
    
    public void setNamec(String name) {
        this.namec = name;
    }
    
    public Integer getAgec() {
        return agec;
    }
    
    public void setAgec(Integer age) {
        this.agec = age;
    }
    
    public String getEmailc() {
        return emailc;
    }
    
    public void setEmailc(String email) {
        this.emailc = email;
    }
    
    public String getTelephonec() {
        return telephonec;
    }
    
    public void setTelephonec(String telephone) {
        this.telephonec = telephone;
    }
    
}
