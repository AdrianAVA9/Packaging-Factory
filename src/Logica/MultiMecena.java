package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import AccesoBD.Conector;

public class MultiMecena {
	
	/**
	* Una clase que hace persistencia con los datos de Mecena
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
//Inicia Marvin	
	
	/**
   	* Método para registrar una Mecena en el sistema
   	* @param pmecena tipo Mecena para pedirle los datos y registrarlos
   	* @return no
   	* @exception si se manejan Excepciones
   	*/
	
	public void crearMecena(Mecena pmecena)throws Exception{
		java.sql.ResultSet rs;
		String sql;
		
		sql = "INSERT INTO Mecena (nombre,pais,ciudad_nacimiento,fecha_fallecimiento)"+
		"VALUES('"+pmecena.getNombre()+"','"+pmecena.getPaisNacimiento()+"','"+pmecena.getCiudadNacimiento()+"','"+pmecena.getFechaFallecimiento()+"');";
		
		try{
			
			Conector.getConector().ejecutarSQL(sql);
			
		}catch(Exception e){
			
			throw new Exception ("No se realizo el registro");
			
		}
		
	}
	
	/**
   	* Método para buscar y levantar una Mecena por el ID
   	* @param pidMecena tipo Int ID de la Mecena
   	* @return Un objeto Mecena 
   	* @exception no
   	*/ 
	
	public Mecena buscarMecena(int pidMecena) throws SQLException, Exception{
		
		Mecena unaMecena = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Mecena]"
			+ "WHERE [IdMecena] = "+pidMecena+";";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if(rs.next()){
			 
			 unaMecena = new Mecena(rs.getInt("IdMecena"),
					 			rs.getString("nombre"),
					 			rs.getString("fecha_fallecimiento"),
					 			rs.getString("pais"),
					 			rs.getString("ciudad_nacimiento"));
	 	 }
		 
	
		return unaMecena;
	}
	
	/**
   	* Método para levantar las Mecena existentes del sistema
   	* @param no
   	* @return Una lista de Mecenas
   	* @exception no se manejan
   	*/
	
	public ArrayList<Mecena> getMecenas()throws java.sql.SQLException,Exception{
		
		   ArrayList<Mecena> listaCuadros=new ArrayList<Mecena>();
		   java.sql.ResultSet rs;
		   String sql;
		   Mecena unaMecena = null;
		   
		   sql = "SELECT * FROM [Mecena];";
		   
		   rs = Conector.getConector().ejecutarSQL(sql,true);
		   
		   if (rs.next()) {
			   
			    do {
			     
			    	unaMecena = new Mecena(rs.getInt("IdMecena"),
				 			rs.getString("nombre"),
				 			rs.getString("fecha_fallecimiento"),
				 			rs.getString("pais"),
				 			rs.getString("ciudad_nacimiento"));
	
			       
			     listaCuadros.add(unaMecena);
			     
		    } while (rs.next());
			    
		   } 
		   
		   rs.close();
		   
		   return listaCuadros;
	}
	
//Fin Marvin
//Inicia Jose
	
	/**
   	* Método que Actualiza datos de una Mecena
   	* @param pmecena tipo Mecena para guardar los datos modificados
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	

	public void actualizarMecena(Mecena pmecena)throws java.sql.SQLException,Exception{
	  
	  String sql;
	         sql="UPDATE Mecena SET NOMBRE='"+pmecena.getNombre()+"',"+
	            "pais='"+pmecena.getPaisNacimiento()+"',"+
	            "ciudad_nacimiento='"+pmecena.getCiudadNacimiento()+"',"+
	          "fecha_fallecimiento='"+pmecena.getFechaFallecimiento()+"' "+
	             "WHERE [IdMecena]="+pmecena.getId()+";";
	      try {
	    	  
	       Conector.getConector().ejecutarSQL(sql);
	       
	      }
	      
	      catch (Exception e) { 
	       
	       throw new Exception ("La mecena no está registrado.");
	       
	      }   
	 }
	

	/**
   	* Método que elimina los datos de una Mecena
   	* @param pmecena tipo Mecena para eliminar sus datos
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 

	public void borrar(Mecena pmecena){
		String query;
		
		query="Delete * FROM [Mecena]"
				+ "WHERE idMecena="+pmecena.getId()+";";
		
		try {
			
			Conector.getConector().ejecutarSQL(query);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
	
//Fin Jose
//Inicia Adria
	//Ya se Implemento
//Fin Adrian

}
