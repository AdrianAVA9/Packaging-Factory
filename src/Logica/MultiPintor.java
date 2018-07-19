package Logica;

import java.sql.SQLException;
import java.util.ArrayList;

import AccesoBD.Conector;

public class MultiPintor {

	/**
	* Una clase que hace persistencia con los datos de Pintor
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
//Danilo inicio
	
	
	/**
   	* Método que Actualiza datos de un pintor
   	* @param ppintor tipo Pintor para guardar los datos modificados
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public void actualizar(Pintor ppintor)throws java.sql.SQLException,Exception{
		
		String sql;
		
	    sql = "UPDATE Pintor SET NOMBRE='"+ppintor.getNombre()+"',"+
	    "seudonimo='"+ppintor.getPseudonimo()+"',"+
	    "nacionalidad='"+ppintor.getNacionalidad()+"',"+
	    "pais='"+ppintor.getPaisNacimiento()+"', "+
	    "ciudad='"+ppintor.getCiudadNacimiento()+"',"+
	    "fechanacimiento='"+ppintor.getFechaNacimiento()+"', "+
	    "fechafallecimiento='"+ppintor.getFechaFallecimiento()+"', "+
	    "idescuela="+ppintor.getIdEscula()+", "+
	    "idmaestro="+ppintor.getIdMaestro()+" "+
	    "WHERE [IdPintor]="+ppintor.getId()+";";
	    	         
	    try {	                     
	    	Conector.getConector().ejecutarSQL(sql);   
	    }
	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    	throw new Exception ("El cliente no está registrado.");    
	    }	
	  }
//Danilo fin

//Jose Inicio
	/**
   	* Método que elimina los datos de un pintor
   	* @param ppintor tipo Pintor para eliminar sus datos
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public void borrar(Pintor ppintor)throws Exception{
		String query;
		query="DELETE * FROM [Pintor] WHERE idPintor="+ppintor.getId()+";";
		try {			
			Conector.getConector().ejecutarSQL(query);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception ("No se pudieron eliminar los datos");
		}	
	}
//Jose Fin
	
//Marvin inicio
	
	/**
   	* Método para levantar los pintores existentes del sistema
   	* @param no
   	* @return Una lista de Pintores
   	* @exception no se manejan
   	*/ 
	public ArrayList<Pintor> getPintores()throws java.sql.SQLException,Exception{
		ArrayList<Pintor> listaPintores=new ArrayList<Pintor>();
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT IdPintor,nombre,seudonimo,nacionalidad,pais,ciudad,fechanacimiento,fechafallecimiento,idescuela,idmaestro FROM Pintor;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			do {
				Pintor pintor = new Pintor(rs.getInt("idPintor"),rs.getString("nombre"),rs.getString("seudonimo"),rs.getString("nacionalidad"),
			     rs.getString("pais"),rs.getString("ciudad"),rs.getString("fechanacimiento"),
			     rs.getString("fechafallecimiento"),rs.getInt("idescuela"),rs.getInt("idmaestro"));
				listaPintores.add(pintor);
			} while (rs.next());
		} 
		rs.close();
		return listaPintores;
	}
	/**
   	* Método para registrar un pintor en el sistema
   	* @param ppintor tipo Pintor para pedirle los datos y registrarlos
   	* @return Boolean para verificar si existe ese nombre
   	* @exception si se manejan Excepciones
   	*/ 
	public boolean agregarPintor(Pintor ppintor)throws Exception{
		boolean existeNombre=true;
		String[] listaNombrePintores;
		java.sql.ResultSet rs;
		int cantRegistros=0;
		String sql;
		
		sql ="SELECT count(Idpintor) AS [cont] FROM Pintor;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {cantRegistros=rs.getInt("cont");}
		rs.close();
		
		sql = "SELECT nombre FROM Pintor ;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			listaNombrePintores=new String[cantRegistros];
			int i=0;
			do {
				listaNombrePintores[i]=(rs.getString("nombre"));
				i=i+1;
			} while (rs.next());
			existeNombre=validarSiExisteElNombre(listaNombrePintores,ppintor.getNombre());
		} else {
			if(cantRegistros==0){existeNombre=false;}
			
		}
		
		
		
		
		if(existeNombre!=true){
			rs.close();
			sql = "INSERT INTO [Pintor](Idpintor,nombre,seudonimo,nacionalidad,pais,ciudad,fechanacimiento,fechafallecimiento,idescuela,idmaestro)"
			+ "VALUES(0,'"+ppintor.getNombre()+"','"+ppintor.getPseudonimo()+"','"+ppintor.getNacionalidad()+"',"
			+ "'"+ppintor.getPaisNacimiento()+"','"+ppintor.getCiudadNacimiento()+"','"+ppintor.getFechaNacimiento()+"',"
			+ "'"+ppintor.getFechaFallecimiento()+"',"+ppintor.getIdEscula()+","+ppintor.getIdMaestro()+");";
			try {
				Conector.getConector().ejecutarSQL(sql);
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new Exception ("No se realizo el registro");
			}
		}
		return existeNombre;
	}
	/**
   	* Método para validar si ya esta registrado el nombre de un pintor
   	* @param plistaNombres de tipo String[] los nombres de todos los pintores registrados
   	* @param pnombre de tipo String el nombre con el que se quiere comparar
   	* @return Boolean para verificar sin existe ese nombre
   	* @exception no se manejan
   	*/ 
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
	
	/**
   	* Método para validar si ya esta registrado el nombre de un pintor
   	* @param plistaNombres de tipo Strign[] los nombres de todos los pintores registrados
   	* @param pnombre de tipo String el nombre con el que se quiere comparar
   	* @return Boolean para verificar sin existe ese nombre
   	* @exception no se manejan
   	*/ 
	
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
	
//Marvin fin

//Adrian Inicio
	
	
	/**
   	* Método para buscar y levantar un pintor por ID
   	* @param pidPintor tipo Int ID del pintor
   	* @return Un objeto Pintor 
   	* @exception Se manejan Excepciones
   	*/ 
public Pintor buscarPintorPorId(int pidPintor) throws SQLException, Exception{
		
		Pintor unPintor = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Pintor]"
			+ "WHERE [idPintor] = '"+pidPintor+"';";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
			
			if(rs.next()){
				 
				unPintor = new Pintor(rs.getInt("IdPintor"),
						 			rs.getString("nombre"),
						 			rs.getString("seudonimo"),
						 			rs.getString("nacionalidad") ,
						 			rs.getString("pais"),
						 			rs.getString("ciudad"),
						 			rs.getString("fechanacimiento"),
						 			rs.getString("fechafallecimiento"),
						 			rs.getInt("idmaestro"),
						 			rs.getInt("idescuela"));
					 
			 }else{
				 
				 throw new Exception("No hay Pintor registrado con ese ID");
				 
			 }
		
		rs.close();
		return unPintor;
	}
	
	/**
	* Método para buscar un pintor por el nombre
	* @param pnombre tipo String para buscar los datos del los pintor relacionado con el nombre
	* @return Un objeto Pintor 
	* @exception Se manejan Excepciones
	*/
	public ArrayList<Pintor> buscarPintorPorNombre(String pnombre) throws SQLException, Exception{
		
		Pintor unPintor = null;
		ArrayList<Pintor>listaPintor = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Pintor]"
			+ "WHERE nombre LIKE'%"+pnombre+"%';";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
			
		listaPintor = new ArrayList<Pintor>();
			
		if (rs.next()) {
				
			do {
					
					unPintor = new Pintor(rs.getInt("IdPintor"),
				 			rs.getString("nombre"),
				 			rs.getString("seudonimo"),
				 			rs.getString("nacionalidad") ,
				 			rs.getString("pais"),
				 			rs.getString("ciudad"),
				 			rs.getString("fechanacimiento"),
				 			rs.getString("fechafallecimiento"),
				 			rs.getInt("idescuela"),
				 			rs.getInt("idmaestro"));
			 
					listaPintor.add(unPintor);
					
			} while (rs.next());
				
		} else {
				
				
		}
			
		rs.close();
		return listaPintor;
	}
//Adrian Fin

}
