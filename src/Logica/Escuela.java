package Logica;

import java.sql.Date;

/**
 * Una clase que simula  una escuela de pintores
 *@author Adrian Vega
 *@author Marvin Calvo
 *@author Jose Madrigal
 *@author Danilo Calderon
 *@version v1.0
*/
public class Escuela {
	private int idEscuela;
	private String nombre;
    private	String pais;
    private String fechaAparicion;
    private String descripcion;
    /***
     * 
     * @param pid identificador unico de la escuela
     * @param pnombre nombre de la escuela
     * @param pdescripcion descripcion de la escuela
     * @param pfechaAparicion fecha de aparición de la escuela
     * @param ppais pais que pertenece la escuela
     */
    public Escuela(int pid, String pnombre,String pdescripcion,String pfechaAparicion,String ppais) {
		setIdEscuela(pid);
    	setNombre(pnombre);
		setDescripcion(pdescripcion);
		setFechaAparicion(pfechaAparicion);
		setPais(ppais);
    }
    /***
     * 
     * @param pnombre nombre de la escuela
     * @param pdescripcion descripcion de la escuela
     * @param pfechaAparicion fecha de aparición de la escuela
     * @param ppais pais que pertenece la escuela
     */
	public Escuela(String pnombre,String pdescripcion,String pfechaAparicion,String ppais) {
			setNombre(pnombre);
			setDescripcion(pdescripcion);
			setFechaAparicion(pfechaAparicion);
			setPais(ppais);
	}
	/**
	 *Metodo para obtener el id del la escuela
	 *@param no requiere parametros
	 *@return un entero que es  el id de la escuela 
	 *@exception no
	 */
	public int getIdEscuela() {
		return idEscuela;
	}
	/**
	 *Metodo para obtener el nombre del la escuela
	 *@param no requiere parametros
	 *@return una cadera de caracteres  que es  el nombre de la escuela 
	 *@exception no
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *Metodo para obtener el pais  que pertenece la escuela
	 *@param no requiere parametros
	 *@return una cadera de caracteres  que es  el nombre del pais que pertenece la escuela 
	 *@exception no
	 */
	public String getPais() {
		return pais;
	}
	/**
	 *Metodo para obtener la fecha en que aparecio  la escuela
	 *@param no requiere parametros
	 *@return una cadera de caracteres  que es la fecha en que aparecio la escuela escuela 
	 *@exception no
	 */
	public String getFechaAparicion() {
		return fechaAparicion;
	}
	/**
	 *Metodo para obtener la descripcion de  la escuela
	 *@param no requiere parametros
	 *@return una cadera de caracteres  con la descripcion de la escuela escuela 
	 *@exception no
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 *Metodo para modiifcar el id de la escuela
	 *@param pidEscuela: valor entero que modifica el id de la escuela
	 *@return no retorna ningun valor 
	 *@exception no
	 */
	public void setIdEscuela(int pidEscuela) {
		idEscuela = pidEscuela;
	}
	/**
	 *Metodo para modiifcar el nombre  de la escuela
	 *@param pnombre: valor String que modifica el nombre de la escuela
	 *@return no retorna ningun valor 
	 *@exception no
	 */
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	/**
	 *Metodo para modiifcar el nombre  del pais que pertenece  la escuela
	 *@param ppais: valor String que modifica el nombre del pais que pertenece la escuela
	 *@return no retorna ningun valor 
	 *@exception no
	 */
	public void setPais(String ppais) {
		pais =ppais;
	}
	/**
	 *Metodo para modiifcar la fecha  en que aparecio la escuela 
	 *@param pfechaAparicion: valor String que modifica la fecha en que aparecio la escuela
	 *@return no retorna ningun valor 
	 *@exception no
	 */
	public void setFechaAparicion(String pfechaAparicion) {
		fechaAparicion = pfechaAparicion;
	}
	/**
	 *Metodo para modiifcar la descripcion de  la escuela  
	 *@param descripcion: valor String que modifica la  descripcion de  la escuela
	 *@return no retorna ningun valor 
	 *@exception no
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 *Metodo para obtener el estado de la escuela 
	 *@param no requiere parametros
	 *@return mjs: Un String con el estado de la escuela 
	 *@exception no
	 */
	public String toString(){
	      String msj="";
		return msj;
		
	}

}
