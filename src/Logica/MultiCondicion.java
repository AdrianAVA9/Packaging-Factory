package Logica;

import AccesoBD.Conector;

public class MultiCondicion {
	
	/**
	* Una clase que hace persistencia con los datos de las condiciones
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
	
	/**
   	* Método para obtener los datos de las condiciones
   	* @param no
   	* @return los datos de las condiciones
   	* @exception si se manejan Excepciones
   	*/
	public String[][] getDatosCondicione() throws java.sql.SQLException,Exception{
		
		String[][] listaDatosCondicion;
		java.sql.ResultSet rs;
		int cantRegistros=0;
		String sql;
		
		sql = "SELECT count(Id) AS [cont] FROM Condicion;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if(rs.next()){
			
			cantRegistros=rs.getInt("cont");
		}
		
		rs.close();
		
		sql = "SELECT Id,nombre FROM Condicion;";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if(rs.next()){
			
			int cantColumnas=rs.getMetaData().getColumnCount();
			
			listaDatosCondicion=new String[cantRegistros][cantColumnas];
			
			int i=0;
			
			do {
				
				listaDatosCondicion[i][0]=""+rs.getInt("Id");
				listaDatosCondicion[i][1]=rs.getString("nombre");
				
				i=i+1;
				
			}while(rs.next());
			
		}else{
			
			throw new Exception ("No se pudieron obtener las condiciones");
		}
		
		rs.close();
		
		return listaDatosCondicion;
	
	}
}
