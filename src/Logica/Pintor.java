package Logica;

import java.sql.Date;
import java.util.ArrayList;
import AccesoBD.Conector;



/**
 * 
 * @author Danilo Calderon
 * @author Marvin Calvo
 * @author Adrian Vega
 * @author Jose Madrigal
 *
 */
public class Pintor {
    //Atributos del objecto
	private int id;
    private String nombre;
    private String seudonimo;
    private String nacionalidad;
    private String fechaNacimiento;
    private String fechaFallecimiento;
    private String paisNacimiento;
    private String ciudadNacimiento;
    private ArrayList<Pintor> alumnos;
    private int idMaestro;
    private int idEscula;
    private Pintor maestro;
    private Escuela objEscuela;
    private ArrayList<Cuadro>listaCuadro;
    	/**
    	 *  Constructor del objecto Pintor
    	 * @param pnombre :nombre del pintor
    	 * @param pseudonimo :pseudinimo del pintor
    	 * @param pnacionalidad: nacionalidad del pinto
    	 * @param ppaisNacimiento: pais de nacimiento del pintor
    	 * @param pciudadNacimiento:ciudad de nacimiento del pintor
    	 * @param pfechaNacimiento: fecha de nacimiento del pintor
    	 * @param pfechaFallecimiento:fecha de fallecimiento del pintor
    	 * @param pidMaestro: identificacion del maestro del pintor
    	 * @param pidEscuela: identificacion de la escuela a la que pertenci
    	 * @exception no se maneja excepciones
    	 */

    public Pintor(String pnombre, String pseudonimo, String pnacionalidad,String ppaisNacimiento, String pciudadNacimiento,
  		   String pfechaNacimiento, String pfechaFallecimiento, int pidMaestro, int pidEscuela) {
  		  
  		 this(0,pnombre,pseudonimo,pnacionalidad,ppaisNacimiento,pciudadNacimiento,pfechaNacimiento,pfechaFallecimiento,pidMaestro,pidEscuela);
  		  
  		  
  		  
    }
	/**
	 *  Constructor del objecto Pintor
	 * @param  pid:identificaion del pintor
	 * @param pnombre :nombre del pintor
	 * @param pseudonimo :pseudinimo del pintor
	 * @param pnacionalidad: nacionalidad del pinto
	 * @param ppaisNacimiento: pais de nacimiento del pintor
	 * @param pciudadNacimiento:ciudad de nacimiento del pintor
	 * @param pfechaNacimiento: fecha de nacimiento del pintor
	 * @param pfechaFallecimiento:fecha de fallecimiento del pintor
	 * @param pidMaestro: identificacion del maestro del pintor
	 * @param pidEscuela: identificacion de la escuela a la que pertenci
	 * @exception no se maneja excepciones
	 */

     
     public Pintor(int pid, String pnombre, String pseudonimo, String pnacionalidad,String ppaisNacimiento, String pciudadNacimiento,
     		   String pfechaNacimiento, String pfechaFallecimiento, int pidMaestro, int pidEscula) {
     	
     		  setId(pid);
     		  setNombre(pnombre);
     		  setSeudonimo(pseudonimo);
     		  setNacionalidad(pnacionalidad);
     		  setFechaNacimiento(pfechaNacimiento);
     		  setFechaFallecimiento(pfechaFallecimiento);
     		  setPaisNacimiento(ppaisNacimiento);
     		  setCiudadNacimiento(pciudadNacimiento);
     		  setIdMaestro(pidMaestro);
     		  setIdEscula(pidEscula);
     		  maestro = null;
     		  
     		  
    }
	/**
	 * metodo para obtener la identificacion del pintor
	 * @return id del pintor
	 * @exception no maneja excepciones
	 */
	public int getId() {
		return id;
	}
	/**
	 * metodo para obtener el nombre del pintor
	 * @return nombre del pintor
	 * @exception no maneja excepciones
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * metodo para obtener el pseudonimo del pintor
	 * @return  seudonimo del pintor
	 * @exception no maneja excepciones
	 */
	public String getPseudonimo() {
		return seudonimo;
	}
	/**
	 * metodo para obtener la identificacion del pintor
	 * @return id del pintor
	 * @exception no maneja excepciones
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * metodo para obtener la fecha de nacimiento del pintor
	 * @return fecha de nacimiento del pintor
	 * @exception no maneja excepciones
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * metodo para obtener la fecha de fallecimiento del pintor
	 * @return fecha den fallecimento
	 * @exception no maneja excepciones
	 */
	public String getFechaFallecimiento() {
		return fechaFallecimiento;
	}
	/**
	 * metodo para obtener el pais de nacimiento del pintor
	 * @return pais de nacimeinto del pais
	 * @exception no maneja excepciones
	 */
	public String getPaisNacimiento() {
		return paisNacimiento;
	}
	/**
	 * metodo para obtener la ciudad de naciminento
	 * @return  ciudad de nacimern
	 * @exception no maneja excepciones
	 */
	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}
	/**
	 * metodo para obtener la los alumnos del pintor
	 * @return alumos del pintor
	 * @exception no maneja excepciones
	 */
	public ArrayList<Pintor> getAlumnos() {
		return alumnos;
	}
	/**
	 * metodo para obtener la identificacion del maestro del pintoe
	 * @return id del maestro del pintor
	 * @exception no maneja excepciones
	 */

	public int getIdMaestro() {
		return idMaestro;
	}
	/**
	 * metodo para obtener la identificacion de la escuela del pintor
	 * @return id de laidentificacion de la escuela  
	 * @exception no maneja excepciones
	 */
	public int getIdEscula() {
		return idEscula;
	}
	/**
	 * metodo para modificar la identificacion del pintor
	 * @return no retorna parametro
	 * @param pid modifica variable de tipo int que la identificacion del pintpr
	 * @exception no maneja excepciones
	 */
	public void setId(int pid) {
		id = pid;
	}
	/**
	 * metodo para modificar el nombre del pintor
	 * @return no retorna parametro
	 * @param pnombre  variable de tipo String que modifica el nombre del pintor
	 * @exception no maneja excepciones
	 */
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	/**
	 * metodo para modificar el pseudonimo  del pintor
	 * @return no retorna parametro
	 * @param ppseudonimo  variable de tipo String que modifica el pseudonimo del pintor
	 * @exception no maneja excepciones
	 */
	public void setSeudonimo(String ppseudonimo) {
		seudonimo = ppseudonimo;
	}
	/**
	 * metodo para modificar la identificacion del pintor
	 * @return no retorna parametro
	 * @param pnacionalidad  variable de tipo String que modifica la nacionalidad del pintor
	 * @exception no maneja excepciones
	 */
	public void setNacionalidad(String pnacionalidad) {
		nacionalidad = pnacionalidad;
	}
	/**
	 * metodo para modificar la fecha de nacimiento del pintor
	 * @return no retorna parametro
	 * @param pfechaNacimiento variable de tipo String que  modifica la fecha de nacimiento del pintor
	 * @exception no maneja excepciones
	 */
	public void setFechaNacimiento(String pfechaNacimiento) {
		fechaNacimiento = pfechaNacimiento;
	}
	/**
	 * metodo para modificar la fecha de fallecimiento del pintor
	 * @return no retorna parametro
	 * @param pfechaNacimiento variable de tipo String que  modifica la fecha de fallecimiento del pintor
	 * @exception no maneja excepciones
	 */
	public void setFechaFallecimiento(String pfechaFallecimiento) {
		fechaFallecimiento = pfechaFallecimiento;
	}
	/**
	 * metodo para modificar el pais de nacimiento del pintor
	 * @return no retorna parametro
	 * @param ppaisNacimiento variable de tipo String que  modifica el pais de nacimiento del pintor
	 * @exception no maneja excepciones
	 */
	public void setPaisNacimiento(String ppaisNacimiento) {
		paisNacimiento = ppaisNacimiento;
	}
	/**
	 * metodo para modificar el pais de nacimiento del pintor
	 * @return no retorna parametro
	 * @param pciudadNacimiento variable de tipo String que modifica  la ciudad de  nacimiento del pintor
	 * @exception no maneja excepciones
	 */
	public void setCiudadNacimiento(String pciudadNacimiento) {
		ciudadNacimiento = pciudadNacimiento;
	}
	/**
	 * metodo para modificar el pais de nacimiento del pintor
	 * @return no retorna parametro
	 * @param pciudadNacimiento variable de tipo String que modifica  la ciudad de  nacimiento del pintor
	 * @exception no maneja excepciones
	 */
	public void setAlumnos(ArrayList<Pintor> palumnos) {
		alumnos = palumnos;
	}
	/**
	 * metodo para modificar el pais de nacimiento del pintor
	 * @return no retorna parametro
	 * @param pidMaestro variable de tipo int  que modifica el id del maestro del pintor
	 * @exception no maneja excepciones
	 */
	public void setIdMaestro(int pidMaestro) {
		idMaestro = pidMaestro;
	}
	/**
	 * metodo que retorna un maestro
	 * @return  retorna un objecto de tipo pintor
	 * @exception no maneja excepciones
	 */
	public Pintor getMaestro() throws Exception {
		
		if(maestro == null){
			
			setMaestro((new MultiPintor()).buscarPintorPorId(getIdMaestro()));
		}
		return maestro;
	}
	/**
	 * metodo para modificar el maestro del pintor
	 * @return no retorna parametro
	 * @param pmaestro variable de tipo pintor  
	 * @exception no maneja excepciones
	 */
	public void setMaestro(Pintor pmaestro) {
		
		maestro = pmaestro;
	}
	/**
	 * metodo que retorna una lista con los cuadros del pintor
	 * @return una lista  de tipo cuadro
	 * @exception si tiene excepciones
	 */
	public ArrayList<Cuadro> getListaCuadro() throws Exception {
		
		if(listaCuadro == null){
			
			setListaCuadro((new MultiCuadro()).listarCuadrosPintor(getId()));
		}
		return listaCuadro;
	}
	/**
	 * metodo que retorna la escuela del pintor
	 * @return retorna un objecto de tipo pintor
	 * @exception si tiene excepciones
	 */
	public Escuela getObjEscuela() throws Exception {
		
		if(objEscuela == null){
			
			setObjEscuela((new MultiEscuela()).buscarEscuela(getIdEscula()));
			
		}
		
		return objEscuela;
	}

	/**
	 * metodo que modifica el objecto de tipo Escuela
	 * @return no retorna ningun valor
	 * @exception si tiene excepciones
	 */

	public void setObjEscuela(Escuela pobjEscuela) {
		
		objEscuela = pobjEscuela;
		
	}
	/**
	 * metodo que modifica  la lista de de cuadros del pintor
	 * @return no retorna ningun valor
	 * @param  plistaCuadro recibe una lista de tipo cuadro
	 * @exception no tiene excepciones
	 */
	public void setListaCuadro(ArrayList<Cuadro>plistaCuadro) {
		
		listaCuadro = plistaCuadro;
	}
	/**
	 * metodo que modifica  el id de la escuela del pintor
	 * @return no retorna ningun valor
	 * @param pidEscula valor de tipo int
	 * @exception no tiene excepciones
	 */
	public void setIdEscula(int pidEscula) {
		idEscula = pidEscula;
	}
	/**
	 * metodo que retorna el estado del objecto
	 * @return un valor de tipo String
	 * @exception no tiene excepciones
	 */
	public String toString(){
	      String msj="";
		return msj;
		
	}

}
