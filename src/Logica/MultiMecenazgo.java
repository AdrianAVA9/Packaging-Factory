package Logica;

import java.util.*;
import java.sql.SQLException;
import AccesoBD.Conector;

public class MultiMecenazgo {
	
	/**
	* Una clase que hace persistencia con los datos de Pinacoteca
	* @author Marvin Cedeño
	* @author Adrian Vega
	* @author Jose Madrigal
	* @author Danilo Calderon
	* @version v1.0
	*/
	
//Inicia Adrian 
	
	/**
   	* Método para busca las relaciones de un pintor con las mecenas
   	* @param idPintor tipo Int ID del pintor
   	* @return lista de las relaciones del pintor con las mecenas
   	* @exception no se manejan excepciones
   	*/ 
	
	public ArrayList<Mecenazgo> buscarMecenasPorPintor(int pidPintor) throws SQLException, Exception{
		
		ArrayList<Mecenazgo>listaMecenazgo = new ArrayList<Mecenazgo>();
		Mecenazgo unMecenazgo = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT [id_pintor],[id_mecena],[fechainiciamecenazgo],[fechafinalizamecenazgo] "
			+ "FROM [Mecenazgo]"
			+ "WHERE [id_pintor] = '"+pidPintor+"';";
		
		 rs = Conector.getConector().ejecutarSQL(sql,true);
		 
		
			 if(rs.next()){
				 
				 do{
					 
					 unMecenazgo = new Mecenazgo(rs.getInt("id_pintor"),
			 							rs.getInt("id_mecena"),
							 			rs.getString("fechainiciamecenazgo"),
							 			rs.getString("fechafinalizamecenazgo"));
					 
					 listaMecenazgo.add(unMecenazgo);
						 
				}while(rs.next());
				 
			 }
			 
		
		return listaMecenazgo;
	}
//Finaliza Adrian
//Inicia Marvin
	
	/**
   	* Método para registrar la relacion de un pintor con una mecena
   	* @param pmecenazgo tipo Mecenazgo para pedirle los datos y registrarlos
   	* @return no
   	* @exception si se manejan Excepciones
   	*/ 
	
	public void agragarMecenazgo(Mecenazgo pmecenazgo)throws Exception{
		java.sql.ResultSet rs;
		String sql;
		sql = "INSERT INTO Mecenazgo (fechainiciamecenazgo,fechafinalizamecenazgo,id_mecena,id_pintor)"+
		"VALUES('"+pmecenazgo.getFechaInicioMecenazgo()+"','"+pmecenazgo.getFechaConcluidaMecenazgo()+"',"+pmecenazgo.getIdMecena()+","+pmecenazgo.getIdPintor()+");";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("No se realizo el registro");
		}
		
	}
	
	/**
   	* Método que elimina la relacion de un pintor con una mecena
   	* @param pmecena tipo Mecena pedirle el ID
   	* @param ppintor tipo Pintor pedirle el ID 
   	* @return no 
   	* @exception Se manejan Excepciones
   	*/
	
	public void eliminarMecenazgo(Mecena pmecena,Pintor ppintor)throws Exception{
		String query;
		query="DELETE * FROM [Mecenazgo] WHERE id_mecena="+pmecena.getId()+" AND id_pintor="+ppintor.getId()+";";
		try {			
			Conector.getConector().ejecutarSQL(query);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception ("No se pudieron eliminar los datos");
		}	
	}
//Finaliza Marvin
}
