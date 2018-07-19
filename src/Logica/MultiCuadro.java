package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import AccesoBD.Conector;

public class MultiCuadro {
	
//Marvin Inicio
	
	/**
   	* Método para registrar una Cuadro en el sistema
   	* @param pcuadro tipo Cuadro para pedirle los datos y registrarlos
   	* @return Boolean para verificar si existe ese nombre
   	* @exception si se manejan Excepciones
   	*/
	
	public boolean agregarCuadro(Cuadro pcuadro)throws Exception{
		
		boolean existeNombre=true;
		String[] listaNombreCuadro;
		java.sql.ResultSet rs;
		int cantRegistros=0;
		String sql;
		
		sql ="SELECT count(Id) AS [cont] FROM Cuadros;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			cantRegistros=rs.getInt("cont");
			
		}
		rs.close();
		
		sql = "SELECT nombre FROM Cuadros ;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			listaNombreCuadro=new String[cantRegistros];
			
			int i=0;
			
			do {
				
				listaNombreCuadro[i]=(rs.getString("nombre"));
				
				i=i+1;
				
			} while (rs.next());
			
			existeNombre=validarSiExisteElNombre(listaNombreCuadro,pcuadro.getNombre());
			
		} else {
			
			if(cantRegistros==0){existeNombre=false;}
			
		}
		
	
		if(existeNombre!=true){
			
			rs.close();
			
			sql = "INSERT INTO [Cuadros](Id,nombre,dimenciones,fechapintado,tecnicautilizada,fechaingreso,idcondicioningreso,idcondicionactual,costoobtenido,idpintor,idpinacoteca,imagen)"
			+ "VALUES(0,'"+pcuadro.getNombre()+"','"+pcuadro.getDimension()+"','"+pcuadro.getFechaCreado()+"','"+pcuadro.getTecnicaUtlizado()+"','"+pcuadro.getFechaIngreso()+"','"+pcuadro.getIdCondicionIngreso()+"','"+pcuadro.getIdCondicionActual()+"','"+pcuadro.getCostoObtenido()+"',"+pcuadro.getIdPintor()+","+pcuadro.getIdPinacoteca()+",'"+pcuadro.getImagen()+"');";
	
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
   	* Método para validar si ya esta registrado el nombre de una Cuadro
   	* @param plistaNombres de tipo String[] los nombres de todas las Cuadro registrados
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
	
	private String  formtearNombre(String pnombre){
		
		String nombreFormateado="";
		
		pnombre=pnombre.toUpperCase();
		
		for(int i=0;i<pnombre.length();i++){
			
			if(pnombre.charAt(i)!=(' ')){
				
				nombreFormateado=nombreFormateado+pnombre.charAt(i);
			}
		}
	
		return nombreFormateado;
	}
	
//Marvin fin
//Danilo Inicio
	
	/**
   	* Método para buscar y levantar un Cuadro por el ID
   	* @param pidCuadro tipo Int ID de la Mecena
   	* @return Un objeto Cuadro 
   	* @exception no
   	*/ 
	
	public Cuadro buscarCuadroPorId(int pdiCuadro) throws Exception{
		  
		  ResultSet rs;
		  Cuadro cuadro=null;
		  String query;
		   
		  query="SELECT * "
		    + "FROM [Cuadros]"
		    + "WHERE Id="+pdiCuadro+";";
		    
		  rs=Conector.getConector().ejecutarSQL(query,true);
		  
		  if(rs.next()){
		   
			   cuadro=new Cuadro (
					   			rs.getInt("id"),
					   			rs.getString("nombre"),
					   			rs.getString("dimenciones"),
					   			rs.getString("fechapintado"),
					   			rs.getString("tecnicautilizada"),
					   			rs.getString("fechaingreso"),
					   			rs.getInt("idcondicioningreso"),
					   			rs.getInt("idcondicionactual"),
					   			rs.getDouble("costoobtenido"),
					   			rs.getInt("idpintor"),
					   			rs.getInt("idpinacoteca"),
			   					rs.getString("imagen"));
			     
		  }
		   
		  return cuadro;  
	}
	
	/**
   	* Método para levantar los Cuadros existentes del sistema
   	* @param no
   	* @return Una lista de Cuadros
   	* @exception no se manejan
   	*/
	
	public ArrayList<Cuadro> getCuadros()throws java.sql.SQLException,Exception{
		
		   ArrayList<Cuadro> listaCuadros=new ArrayList<Cuadro>();
		   java.sql.ResultSet rs;
		   String sql;
		   
		   sql = "SELECT * FROM Cuadros;";
		   
		   rs = Conector.getConector().ejecutarSQL(sql,true);
		   
		   if (rs.next()) {
			   
			    do {
			     
				     Cuadro cuadro = new Cuadro(rs.getInt("Id"),
									   			rs.getString("nombre"),
									   			rs.getString("dimenciones"),
									   			rs.getString("fechapintado"),
									   			rs.getString("tecnicautilizada"),
									   			rs.getString("fechaingreso"),
									   			rs.getInt("idcondicioningreso"),
									   			rs.getInt("idcondicionactual"),
									   			rs.getDouble("costoobtenido"),
									   			rs.getInt("idpintor"),
									   			rs.getInt("idpinacoteca"));
				       
				     listaCuadros.add(cuadro);
			     
			    } while (rs.next());
		   }
		   
		   rs.close();
		   
		   return listaCuadros;
	}
	
	
	/**
   	* Método que Actualiza datos de un Cuadro
   	* @param pcuadro tipo Cuadro para guardar los datos modificados
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/
	
	 public void actualizarCuadro(Cuadro pcuadro)throws java.sql.SQLException,Exception{
		   
		   String sql;
		   
		   			System.out.println(pcuadro.getCodigo());
		      sql = "UPDATE Cuadros SET NOMBRE='"+pcuadro.getNombre()+"',"+
		             "dimenciones='"+pcuadro.getDimension()+"',"+
		             "fechapintado='"+pcuadro.getFechaCreado()+"',"+
		             "tecnicautilizada='"+pcuadro.getTecnicaUtlizado()+"',"+
		             "fechaingreso='"+pcuadro.getFechaIngreso()+"',"+
		             "idcondicioningreso="+pcuadro.getIdCondicionIngreso()+","+
		             "idcondicionactual="+pcuadro.getIdCondicionActual()+","+
		             "costoobtenido="+pcuadro.getCostoObtenido()+","+
		             "idpintor="+pcuadro.getIdPintor()+","+
		             "idpinacoteca="+pcuadro.getIdPinacoteca()+","+
		             "imagen='"+pcuadro.getImagen()+"'"
		             + "WHERE [Id]="+pcuadro.getCodigo()+";";
		                
		      try {
		    	  
		       Conector.getConector().ejecutarSQL(sql);   
		      }
		      
		      catch (Exception e) {
		    	  e.printStackTrace();
		       throw new Exception ("El Cuadro no está registrado.");
		      
		      }  
	}
//Danilo Fin
//Jose Inicio
	 
	 /**
	   	* Método que elimina los datos de un Cuadro
	   	* @param pcuadro tipo Cuadro para eliminar sus datos
	   	* @return no 
	   	* @exception no se manejan excepciones
	   	*/
	 
	 public void borrarCuadro(Cuadro pcuadro)throws Exception{
			
			String query;
			
			query="DELETE * FROM [Cuadros]"
					+ "WHERE id="+pcuadro.getCodigo()+";";
			
			try {
				Conector.getConector().ejecutarSQL(query);
			} catch (Exception e) {
				  e.printStackTrace();
			}	
	}
//Jose Fin

//Adrian Inicia

	 /**
	   	* Método que levanta una lista de Cuadros de una Pinacoteca
	   	* @param pidPinacoteca tipo Int ID de la pinacoteca
	   	* @return lista de cuadros
	   	* @exception no se manejan excepciones
	   	*/
	 
	 public ArrayList<Cuadro> listarCuadrosPinacoteca(int pidPinacoteca) throws SQLException, Exception{
		
			Cuadro unCuadro = null;
			ArrayList<Cuadro>listaCuadro = new ArrayList<Cuadro>();
			java.sql.ResultSet rs;
			String sql;
			
			sql = "SELECT * "
				+ "FROM [Cuadros]"
				+ "WHERE [idpinacoteca] = '"+pidPinacoteca+"';";
			
			 rs = Conector.getConector().ejecutarSQL(sql,true);
			 
			 if(rs.next()){
				 
				 do{
					 
					 unCuadro = new Cuadro(rs.getInt("id"),
					 			rs.getString("nombre"),
					 			rs.getString("dimenciones"),
					 			rs.getString("fechapintado") ,
					 			rs.getString("tecnicautilizada"),
					 			rs.getString("fechaingreso"),
					 			rs.getInt("idcondicioningreso"),
					 			rs.getInt("idcondicionactual"),
					 			rs.getDouble("costoobtenido"),
					 			rs.getInt("idpintor"),
					 			rs.getInt("idpinacoteca"));
					 
					 listaCuadro.add(unCuadro);
					 
				 }while(rs.next());
						 
			 }
				 
		
		return listaCuadro;
	}
	 
	 /**
	   	* Método que levanta una lista de Cuadros de un Pintor
	   	* @param pidPintor tipo Int ID del Pintor
	   	* @return lista de cuadros
	   	* @exception no se manejan excepciones
	   	*/
	
	public ArrayList<Cuadro> listarCuadrosPintor(int pidPintor) throws SQLException, Exception{
		
			Cuadro unCuadro = null;
			ArrayList<Cuadro>listaCuadro = new ArrayList<Cuadro>();
			java.sql.ResultSet rs;
			String sql;
			
			sql = "SELECT * "
				+ "FROM [Cuadros]"
				+ "WHERE [idpintor] = '"+pidPintor+"';";
			
			 rs = Conector.getConector().ejecutarSQL(sql,true);
			 
			 while(rs.next()){
				 
					unCuadro = new Cuadro(rs.getInt("id"),
				 			rs.getString("nombre"),
				 			rs.getString("dimenciones"),
				 			rs.getString("fechapintado") ,
				 			rs.getString("tecnicautilizada"),
				 			rs.getString("fechaingreso"),
				 			rs.getInt("idcondicioningreso"),
				 			rs.getInt("idcondicionactual"),
				 			rs.getDouble("costoobtenido"),
				 			rs.getInt("idpintor"),
				 			rs.getInt("idpinacoteca"));
		 
					listaCuadro.add(unCuadro);
						
			 };	 
				 
		
		return listaCuadro;
	}
	
	/**
   	* Método para buscar y levantar un Cuadro por el Nombre
   	* @param pnombreCuadro tipo String nombre de la Cuadro
   	* @return Un objeto Cuadro 
   	* @exception Se manejan Excepciones
   	*/ 
	
	public Cuadro buscarCuadro(String pnombreCuadro) throws SQLException, Exception{
		
		Cuadro unCuadro = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Cuadros]"
			+ "WHERE [nombre] = '"+pnombreCuadro+"';";
		
		 rs = Conector.getConector().ejecutarSQL(sql,true);
		
			if(rs.next()){
				 
				 unCuadro = new Cuadro(rs.getInt("id"),
							 			rs.getString("nombre"),
							 			rs.getString("dimenciones"),
							 			rs.getString("fechapintado") ,
							 			rs.getString("tecnicautilizada"),
							 			rs.getString("fechaingreso"),
							 			rs.getInt("idcondicioningreso"),
							 			rs.getInt("idcondicionactual"),
							 			rs.getDouble("costoobtenido"),
							 			rs.getInt("idpintor"),
							 			rs.getInt("idpinacoteca"));
					 
			 }else{
				 
				 throw new Exception("No hay cuadro registrado con ese nombre");
				 
			 }
			 
		
		return unCuadro;
	}

}

//Adrian Fin
