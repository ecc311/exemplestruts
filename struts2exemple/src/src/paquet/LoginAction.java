package src.paquet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private static Connection conn;
	private String sql;
	private String username;
    private String password;
 
    public String execute() {
    	
    	String clau;
    	ArrayList<String> usuaris=new ArrayList<String>();
    	usuaris=CarregarNomsUsuaris();
    	int ok1=0;
    	int ok2=0;
    	for(int i=0;i<usuaris.size();i++)
    	{
    		if (this.username.equals(usuaris.get(i))){
    			
    			ok1=1;
    		}
    	}
    	if(ok1==1)
    	{
    		clau=CarregarPassword(this.username);
    		System.out.println(this.password);
    		if(this.password.equals(clau))
    		{
    			ok2=1;
    		}
    	}
    	if(ok2==1)
    	{
    		return SUCCESS;
    	}else{
    		addActionError(getText("error.login"));
    		return ERROR;
    	}	
    }
 
    public ArrayList<String> CarregarNomsUsuaris(){
    	
    	ArrayList<String> llista=new ArrayList<String>();
    	
    	init();
    	
    	try {
			Statement stmt = conn.createStatement();
			sql = "SELECT nick FROM usuaris";
			ResultSet aux = stmt.executeQuery(sql);
			while(aux.next())
			{
			String ida = aux.getString("nick");
			llista.add(ida);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return llista;
    }
    
    public String CarregarPassword(String nom)
    {
    	String pass=new String();
    	init();
    	
    	try {
			Statement stmt = conn.createStatement();
			sql = "SELECT pass FROM usuaris WHERE nick='"+nom+"'";
			ResultSet aux = stmt.executeQuery(sql);
			aux.beforeFirst();
			aux.next();
			pass = aux.getString("pass");
			System.out.println(pass);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pass;
    }
    
    public void init() {

		conn=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String servidor="jdbc:mysql://localhost/botiga";
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
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

}
