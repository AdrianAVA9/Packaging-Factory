package Logica;

import java.sql.SQLException;
import java.util.ArrayList;

import AccesoBD.Conector;

public class MultiEscuela {
		
	
	/**
	* Una clase que hace persistencia con los datos de Pinacoteca
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
	//Inicio Marvin
	
	/**
   	* Método para registrar una Escuela en el sistema
   	* @param pescuela tipo Escuela para pedirle los datos y registrarlos
   	* @return no
   	* @exception si se manejan Excepciones
   	*/
	
	public void agregarEscuela(Escuela pescuela)throws Exception{
		
		java.sql.ResultSet rs;
		String sql;
		
		sql = "INSERT INTO Escuela (nombre,pais,fechaaparecio,descripcion)"+
		"VALUES('"+pescuela.getNombre()+"','"+pescuela.getPais()+"','"+pescuela.getFechaAparicion()+"','"+pescuela.getDescripcion()+"');";
		
		try {
			
			Conector.getConector().ejecutarSQL(sql);
			
		}catch (Exception e) {
			
			throw new Exception ("No se realizo el registro");
			
		}
		
	}
	
	/**
   	* Método para levantar las Escuela existentes del sistema
   	* @param no
   	* @return Una lista de Escuelas
   	* @exception no se manejan
   	*/
	
	public ArrayList<Escuela> getEscuelas()throws java.sql.SQLException,Exception{
		
		ArrayList<Escuela> listaEscuelas=new ArrayList<Escuela>();
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT IdEscuela,nombre,pais,fechaaparecio,descripcion FROM Escuela;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			do {
				
					Escuela escuela= new Escuela(rs.getInt("IdEscuela"),
												rs.getString("nombre"),
												rs.getString("descripcion"),
												rs.getString("fechaaparecio"),
												rs.getString("pais"));
					listaEscuelas.add(escuela);
					
			 }while (rs.next());
			
		}
		
		rs.close();
		
		return listaEscuelas;
	}
	
//Fin Marvin
//Inicio Danilo 
	
	/**
   	* Método que Actualiza datos de una Escuela
   	* @param pescuela tipo Escuela para guardar los datos modificados
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public void actualizarEscuela(Escuela pescuela)throws java.sql.SQLException,Exception{
		
	  String sql;
	  
	  sql="UPDATE Escuela SET NOMBRE='"+pescuela.getNombre()+"',"+
	     "pais='"+pescuela.getPais()+"',"+
	      "fechaaparecio='"+pescuela.getFechaAparicion()+"',"+
	     "descripcion='"+pescuela.getDescripcion()+"' "+
	      "WHERE [IdEscuela]="+pescuela.getIdEscuela()+";";
	  
      try {
    	  
	    Conector.getConector().ejecutarSQL(sql);
	    
	   }
	   
	   catch (Exception e) { 
	    
		   throw new Exception ("La escuela no está registrada.");
	    
	   } 
    } 
	
	
	/**
   	* Método para buscar y levantar una Mecena por el ID
   	* @param pidMecena tipo Int ID de la Mecena
   	* @return Un objeto Mecena 
   	* @exception no
   	*/ 
	
	public Escuela buscarEscuela(int pid)throws java.sql.SQLException,Exception{
		  
		  Escuela escuela;
		  java.sql.ResultSet rs;
		  String sql;
		  
		  sql = "SELECT *"+
		  "FROM Escuela "+
		  "WHERE IdEscuela="+ pid +";";
		  
		  rs = Conector.getConector().ejecutarSQL(sql,true);
		  
		  if (rs.next()) {
			  
			   escuela =new Escuela( rs.getInt("IdEscuela"),
								     rs.getString("nombre"),
								     rs.getString("descripcion"),
								     rs.getString("fechaaparecio"),
								     rs.getString("pais"));
		   
		  }else{
			  
		   throw new Exception ("La escuela no esta registrada.");
		   
		  }
		  
		  rs.close();
		  
		  return escuela;  
		}
	
//Fin Danilo
//Inicio Jose
	
	/**
   	* Método que elimina los datos de una Escuela
   	* @param pescuela tipo Escuela para eliminar sus datos
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public void borrar(Escuela pescuela){
		
		String query;
		
		query="DELETE * FROM [Escuela]"
				+ "WHERE idEscuela="+pescuela.getIdEscuela()+";";
		
		try {
			
			Conector.getConector().ejecutarSQL(query);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}	
		
	}


//Fin Jose

//Inicia Adrian
	//Ya se Implemento
//Fin Adrian
}
