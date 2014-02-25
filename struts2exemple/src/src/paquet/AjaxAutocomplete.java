package src.paquet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.sql.Statement;
 

import com.opensymphony.xwork2.ActionSupport;
 
@SuppressWarnings("serial")
public class AjaxAutocomplete extends ActionSupport {
    
	private static Connection conn;
	private String sql;
	private String data;
    private List<String> countries;

     
    public String execute() {
    	String datas="";
    	ArrayList<String> noms=new ArrayList<String>();
    	noms=carregardata();
    	for( int i = 0 ; i < noms.size() ; i++ ){
    		  datas=datas+( noms.get( i )+"," );
    	}
    	data = datas.substring(0, datas.length()-1); 
        countries = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(data, ",");
 
        while (st.hasMoreTokens()) {
            countries.add(st.nextToken().trim());
        }
        return SUCCESS;
    }
    public ArrayList<String> carregardata()
    {
    	init();
    	
    	
    	ArrayList<String> llista=new ArrayList<String>();
    	
    	try {
    			Statement stmt = conn.createStatement();
    			sql = "SELECT nom FROM client";
    			ResultSet aux = stmt.executeQuery(sql);
    			while(aux.next())
    			{
    			String ida = aux.getString("nom");
    			llista.add(ida);
    			
    			}
    			conn.close();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		return llista;
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
    

 
    public List<String> getCountries() {
        return countries;
    }
 
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

}