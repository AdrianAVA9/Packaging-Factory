package Logica;

import AccesoBD.Conector;
import java.sql.*;

public class MultiPais {
	
	/**
   	* Método para obtener los datos de los paises
   	* @param no
   	* @return datos de los paises
   	* @exception no se manejan excepciones
   	*/
	
	public String[][] getDatosPaises() throws java.sql.SQLException,Exception{
		
			String[][] listaDatos;
			java.sql.ResultSet rs;
			int cantRegistros=0;
			String sql;
			
			sql = "SELECT count(IdPais) AS [cont] FROM Pais;";
			
			rs = Conector.getConector().ejecutarSQL(sql,true);
			
			if (rs.next()) {
				
				cantRegistros=rs.getInt("cont");
			}
			
			rs.close();
			
			sql = "SELECT IdPais,nombre,gentilicio FROM Pais;";
			
			rs = Conector.getConector().ejecutarSQL(sql,true);
			
			if(rs.next()){
				
				int cantColumnas=rs.getMetaData().getColumnCount();
				listaDatos=new String[cantRegistros][cantColumnas];
				int i=0;
				
				do {
					
					listaDatos[i][0]=""+rs.getInt("IdPais");
					listaDatos[i][1]=rs.getString("nombre");
					listaDatos[i][2]=rs.getString("gentilicio");
					i=i+1;
					
				}while (rs.next());
				
			}else{
				
				throw new Exception ("No se pudieron obtener los paises");
			}
			rs.close();
			return listaDatos;
		
	}
	
	/**
   	* Método para obtener los nombres de los paises
   	* @param no
   	* @return los nombres de los paises
   	* @exception si se manejan excepciones
   	*/
	
	public String[]	getNombrePaises()throws Exception{
		
		String[] listaNombrePaises;
		java.sql.ResultSet rs;
		int cantRegistros=0;
		String sql;
		
		sql ="SELECT count(IdPais) AS [cont] FROM Pais ;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			cantRegistros=rs.getInt("cont");
			
		}
		
		rs.close();
		
		sql = "SELECT nombre FROM Pais ;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if(rs.next()){
			
			listaNombrePaises=new String[cantRegistros];
			int i=0;
			
			do {
				
				listaNombrePaises[i]=rs.getString("nombre");
				i=i+1;
				
			}while(rs.next());
			
		}else{
			
			throw new Exception ("No se pudieron obtener los paises");
			
		}
		
		rs.close();
		
		return listaNombrePaises;
	}
}
