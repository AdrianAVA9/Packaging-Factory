package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import AccesoBD.Conector;

public class MultiPinacoteca {
	
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
   	* Método para registrar una Pinacoteca en el sistema
   	* @param ppinacoteca tipo Pinacoteca para pedirle los datos y registrarlos
   	* @return Boolean para verificar si existe ese nombre
   	* @exception si se manejan Excepciones
   	*/ 
	
	public boolean agregarPinacoteca(Pinacoteca ppinacoteca)throws Exception{
		boolean existeNombre=true;
		String[] listaNombresPinacotecas;
		java.sql.ResultSet rs;
		int cantRegistros=0;
		String sql;
		
		sql ="SELECT count(IdPinacoteca) AS [cont] FROM Pinacoteca ;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			cantRegistros=rs.getInt("cont");
			
		}
		rs.close();
		
		sql = "SELECT nombre FROM Pinacoteca ;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			listaNombresPinacotecas=new String[cantRegistros];
			int i=0;
			do {
				
				listaNombresPinacotecas[i]=(rs.getString("nombre"));
				i=i+1;
			} while (rs.next());
			existeNombre=validarSiExisteElNombre(listaNombresPinacotecas,ppinacoteca.getNombre());
		} else {
			if(cantRegistros==0){existeNombre=false;}
			
		}
		rs.close();
		
		
		
		if(existeNombre!=true){
			
			sql = "INSERT INTO Pinacoteca (nombre,fecha_inauguracion,metrosCuadrados)"+
			"VALUES('"+ppinacoteca.getNombre()+"','"+ppinacoteca.getFechaInaguracion()+"','"+ppinacoteca.getmedidaPinacoteca()+"');";
			try {
				Conector.getConector().ejecutarSQL(sql);
			}
			catch (Exception e) {
				throw new Exception ("No se realizo el registro");
			}
		}
		rs.close();
		
		return existeNombre;
	}
	/**
   	* Método para validar si ya esta registrado el nombre de una Pinacoteca
   	* @param plistaNombres de tipo String[] los nombres de todas las pinacotecas registrados
   	* @param pnombre de tipo String el nombre con el que se quiere comparar
   	* @return Boolean para verificar sin existe ese nombre
   	* @exception no se manejan
   	**/
	
	private boolean validarSiExisteElNombre(String[] plistaNombres, String pnombre){
	
		for(int i=0;i<plistaNombres.length;i++){
			
			plistaNombres[i]=formtearNombre(plistaNombres[i]);
			pnombre=formtearNombre(pnombre);
			
			if((plistaNombres[i].equals(pnombre))){
				return true;
			}
		}
			
		return false;
	}
	
	//FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA FALTA
	private String  formtearNombre(String pnombre){
		String nombreFormateado="";
		pnombre=pnombre.toUpperCase();
		
		for(int i=0;i<pnombre.length();i++)
		{
			if(pnombre.charAt(i)!=(' ')){
				nombreFormateado=nombreFormateado+pnombre.charAt(i);
			}
		}
	
		return nombreFormateado;
	}

//Fin Marvin

//Inicio Danilo
	
	/**
   	* Método para buscar y levantar una Pinacoteca por el ID
   	* @param pidPinacoteca tipo Int ID de la Pinacoteca
   	* @return Un objeto Pinacoteca 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public Pinacoteca buscarPinacotecaPorId(int pidPinacoteca)throws Exception{
		
		Pinacoteca pinacoteca=null;
		String query;
		ResultSet rs;
		
		query="SELECT *"
				+ "FROM [Pinacoteca]"
				+ "WHERE IdPinacoteca="+pidPinacoteca+";";
		
		rs=Conector.getConector().ejecutarSQL(query, true);
		
		if(rs.next()){
			
			pinacoteca=new Pinacoteca(					
					rs.getInt("IdPinacoteca"),
					rs.getString("nombre"),
					rs.getString("metrosCuadrados"),
					rs.getString("fecha_inauguracion")				
			);		
		}
		
		
		return pinacoteca;			
	}
	
	/**
   	* Método que Actualiza datos de una Pinacoteca
   	* @param ppinacoteca tipo Pinacoteca para guardar los datos modificados
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public void actualizarPinacoteca( Pinacoteca ppinacoteca) throws Exception{
		String sql;
          
		System.out.println(ppinacoteca.getNombre());
		System.out.println(ppinacoteca.getIdPinacoteca());
		
       sql="UPDATE Pinacoteca SET NOMBRE='"+ppinacoteca.getNombre()+"',"+
       "metrosCuadrados='"+ppinacoteca.getmedidaPinacoteca()+"',"+
      "fecha_inauguracion='"+ppinacoteca.getFechaInaguracion()+"' "+
       "WHERE [IdPinacoteca]="+ppinacoteca.getIdPinacoteca()+";";
        
       try {	                     
	    	Conector.getConector().ejecutarSQL(sql);   
	    }
	    
	    catch (Exception e) { 
	    	throw new Exception ("El cliente no está registrado.");    
	    }		
		
		
	}

	
//Fin Danilo

//Inicio Jose
	
	/**
   	* Método que elimina los datos de una Pinacoteca
   	* @param ppinacoteca tipo Pinacoteca para eliminar sus datos
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 

	public void borrar(Pinacoteca ppinacoteca){
		   
	   String query;
	   
	   query="DELETE * FROM [Pinacoteca]"
	     + "WHERE idPinacoteca="+ppinacoteca.getIdPinacoteca()+";";
	   
	   try {
	    
	    Conector.getConector().ejecutarSQL(query);
	    
	    } catch (Exception e) {}  
	   
		}
//Fin Jose
//Inicio Adrian
	
	
	/**
   	* Método para buscar y levantar una Pinacoteca por el Nombre
   	* @param pnombrePinacoteca tipo String nombre de la Pinacoteca
   	* @return Un objeto Pinacoteca 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public Pinacoteca buscarPinacotecaPorNombre(String pnombrePinacoteca) throws SQLException, Exception{
		
		Pinacoteca unaPinacoteca = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Pinacoteca]"
			+ "WHERE [nombre] = '"+pnombrePinacoteca+"';";
		
		 rs = Conector.getConector().ejecutarSQL(sql,true);
			 
			 if(rs.next()){
					 
				 unaPinacoteca = new Pinacoteca(rs.getInt("IdPinacoteca"),
							rs.getString("nombre"),
				 			rs.getString("metrosCuadrados"),
				 			rs.getString("fecha_inauguracion"));
					 
			}else{
				
				throw new Exception("No hay Pinacotecas con ese nombre");
			}
			 
		return unaPinacoteca;
		
	}
	/**
   	* Método para levantar las Pinacotecas existentes del sistema
   	* @param no
   	* @return Una lista de Pinacotecas
   	* @exception no se manejan
   	*/ 
	public ArrayList<Pinacoteca> listarPinacotecas() throws SQLException, Exception{
		
		ArrayList<Pinacoteca>listaPinacoteca = new ArrayList<Pinacoteca>();
		Pinacoteca unaPinacoteca = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM Pinacoteca;";
		
		 rs = Conector.getConector().ejecutarSQL(sql,true);
		 
		 try{
			 
			 while(rs.next()){
					 
				 unaPinacoteca = new Pinacoteca(rs.getInt("IdPinacoteca"),
		 							rs.getString("nombre"),
						 			rs.getString("metrosCuadrados"),
						 			rs.getString("fecha_inauguracion"));
				 
				 listaPinacoteca.add(unaPinacoteca);
					 
			}
			 
		 }catch(Exception e){
			 
			 throw new Exception("No hay Pinacotecas en el sistema");
		 }
		return listaPinacoteca;
		
	}
	
//Fin Adrian
}
