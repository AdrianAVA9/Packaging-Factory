package Logica;

/****
 * Una clase que simulula una pinacoteca donde se almacenan cuadros.
 * @author Marvin Calvo A
 * @author Danilo Calderon
 * @author Adrian Vega
 * @author Jose Madrigal
 * @version version v1.0
 */


import java.sql.Date;
import java.util.ArrayList;



public class Pinacoteca {
   private String nombre;
   private String fechaInaguracion;
   private String medidaPinacoteca;
   private int idPinacoteca;
   private ArrayList<Cuadro>listaCuadros;

   /****
    * Metodo constructor del objeto Pinacoteca
    * @param pnombre nombre de la pinacoteca 
    * @param pfechaInguracion fecha en que se inaguro la pinacoteca
    * @param pmetrosCuadrados metros  que cubre la pinacoteca 
    */
	public Pinacoteca(String pnombre,String pfechaInguracion,String pmetrosCuadrados) {
		setNombre(pnombre);
		setFechaInaguracion(pfechaInguracion);
		setmedidaPinacoteca(pmetrosCuadrados);
	}
	 /****
	    * Metodo constructor del objeto Pinacoteca
	    * @param pid identificador unico  de la pinacoteca 
	    * @param pnombre nombre de la pinacoteca 
	    * @param pfechaInguracion fecha en que se inaguro la pinacoteca
	    * @param pmetrosCuadrados metros  que cubre la pinacoteca 
	    */
	public Pinacoteca(int pid,String pnombre,String pareaCobertura,String pfecha_inauguracion){
		setId(pid);
		setNombre(pnombre);
		setmedidaPinacoteca(pareaCobertura);
		setFechaInaguracion(pfecha_inauguracion);			
	}
    /****
     * Metodo para obtener el id de la pinacoteca 
     * @param no se requieren parametros
     * @exception no se manejan excepciones
     * @return un entero id de la pinacoteca
     */
	public int getIdPinacoteca(){
		return idPinacoteca;
		
	}
	/****
     * Metodo para obtener el nombre de la pinacoteca
     * @param no se requieren parametros
     * @exception no se manejan excepciones
     * @return Cadena de caracteres el nombre de la pinacoteca
     */
	public String getNombre() {
		return nombre;
	}
	/****
     * Metodo para obtener la fecha en que se inaguro la pinacoteca
     * @param no se requieren parametros
     * @exception no se manejan excepciones
     * @return Cadena de caracteres fecha que se inaguro la  pinacoteca
     */
	public String getFechaInaguracion() {
		return fechaInaguracion;
	}
	/****
     * Metodo para obtener las dimenciones de la pinacoteca
     * @param no se requieren parametros
     * @exception no se manejan excepciones
     * @return Cadena de caracteres con la dimencione de la  pinacoteca
     */
	public String getmedidaPinacoteca() {
		return medidaPinacoteca;
	}
	  /****
     * Metodo para modificar el id de la pinacoteca
     * @param pid valor entero para modificar el id de la pinacoteca
     * @exception no se manejan excepciones
     * @return no se retorna valor 
     */
    
	private void setId(int pid){
		idPinacoteca=pid;			
	}
	  /****
     * Metodo para modificar el nombre de la pinacoteca
     * @param Cadena de caracteres para modificar el nombre de lapinacoteca
     * @exception no se manejan excepciones
     * @return no se retorna valor 
     */
	
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	 /****
     * Metodo para modificar la fecha de inaguración de la pinacoteca
     * @param Cadena de caracteres para la fecha de inaguración de la pinacoteca
     * @exception no se manejan excepciones
     * @return no se retorna valor 
     */
	public void setFechaInaguracion(String pfechaInaguracion) {
		fechaInaguracion = pfechaInaguracion;
	}
	 /****
     * Metodo para modificar las dimenciones de la pinacoteca
     * @param Cadena de caracteres con la medidas de la pinacoteca
     * @exception no se manejan excepciones
     * @return no se retorna valor 
     */
	public void setmedidaPinacoteca(String pmedidaPinacoteca) {
		medidaPinacoteca=pmedidaPinacoteca;
	}
	 /****
     * Metodo para obtener el estado de la pinacoteca
     * @param no se requieren parametros
     * @exception no se manejan excepciones
     * @return Cadena de caracteres con el estado de la pinacoteca 
     */
	public String toString(){
	      String msj="";
		return msj;
	}
	 /****
     * Metodo para modificar la lista de cuadros que pertenecen a esa pinacoteca
     * @param Una lista con los cuadros que pertenecen a la pinacoteca
     * @exception no se manejan excepciones
     * @return no se retorna valor  
     */
	public void setListaCuadros(ArrayList<Cuadro>plistaCuadro){
    	
    	listaCuadros = plistaCuadro;
    	
    }
	   public ArrayList<Cuadro> getListaCuadros() throws Exception{
	    	
	    	if(listaCuadros == null){
	    		
	    		setListaCuadros((new MultiCuadro()).listarCuadrosPinacoteca(getIdPinacoteca()));
	    		
	    	}
	    	
	    	return listaCuadros;
	    }
}
