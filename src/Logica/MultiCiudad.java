package Logica;

import AccesoBD.Conector;

public class MultiCiudad {
	
	/**
	* Una clase que hace persistencia con los datos de una Ciudad
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
	
	/**
   	* Método para obtener los datos de las ciudades
   	* @param pidPais tipo int id del pais
   	* @return lista de ciudades
   	* @exception si se manejan Excepciones
   	*/
	
	public String[] getNombreCiudades(int pidPias)throws java.sql.SQLException,Exception{
		
		String[] listaNombreCiudades;
		java.sql.ResultSet rs;
		int cantConlumnas=0;
		String sql;
		
		sql ="SELECT count(IdCiudad) AS [cont] FROM Ciudad WHERE idpais="+pidPias+";";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			cantConlumnas=rs.getInt("cont");
			
		}
		
		rs.close();
		
		sql = "SELECT nombre FROM Ciudad WHERE idpais="+pidPias+";";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			listaNombreCiudades=new String[cantConlumnas];
			
			int i=0;
			
			do {
				
				listaNombreCiudades[i]=rs.getString("nombre");
				
				i=i+1;
				
			} while (rs.next());
			
		} else {
			
			throw new Exception ("No se pudieron obtener los paises");
		}
		
		rs.close();
		
		return listaNombreCiudades;
		
	}
}
