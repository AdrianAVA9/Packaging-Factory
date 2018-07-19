package Logica;

/**
* Una clase que simula una Mecena
* @author Marvin Cedeño
* @author Adrian Vega
* @author Jose Madrigal
* @author Danilo Calderon
* @version v1.0
*/
import java.sql.Date;

public class Mecena {
	
	//Atributos privados de la clase
	
	private int id;
	private String nombre;
	private String paisNacimiento;
	private String ciudadNacimiento;
	private String fechaFallecimiento;
	
	/**
	* Método que crea el objeto de tipo Mecena
	* @param pnombre: valor String para registrar el nombre de la mecena
	* @param pfechaFallecimiento: valor String para registrar la fechaFallecimiento
	* @param ppaisNacimiento: valor String para registrar el pais de nacimiento
	* @param pciudadNacimiento: valor String para registrar la ciudad de nacimiento
	* @return no retorna ningun valor
	* @exception no se manejan excepciones
	*/

	public Mecena(String pnombre,String pfechaFallecimiento,String ppaisNacimiento,String pciudadNacimiento){
		this(0,pnombre,pfechaFallecimiento,ppaisNacimiento,pciudadNacimiento);
		
		
	}
		/**
	* Método que crea el objeto de tipo Mecena
	* @param pid: valor entero para registrar el ID de la Mecena
	* @param pnombre: valor String para registrar el nombre de la mecena
	* @param pfechaFallecimiento: valor String para registrar la fechaFallecimiento
	* @param ppaisNacimiento: valor String para registrar el pais de nacimiento
	* @param pciudadNacimiento: valor String para registrar la ciudad de nacimiento
	* @return no retorna ningun valor
	* @exception no se manejan excepciones
	*/
	public Mecena(int pid,String pnombre,String pfechaFallecimiento,String ppaisNacimiento,String pciudadNacimiento){
		setId(pid);
		setNombre(pnombre);
		setFechaFallecimiento(pfechaFallecimiento);
		setPaisNacimiento(ppaisNacimiento);
		setCiudadNacimiento(pciudadNacimiento);
		
	}
	
	/**
	* Método para obtener el id de la mecena
	* @param no requiere parametros
	* @return El Id que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	public int getId() {
		return id;
	}
	
	/**
	* Método para obtener el nombre de la mecena
	* @param no requiere parametros
	* @return El nombre que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	public String getNombre() {
		return nombre;
	}
	
	/**
	* Método para obtener el pais de nacimiento de una mecena
	* @param no requiere parametros
	* @return El pais de nacimiento que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	public String getPaisNacimiento() {
		return paisNacimiento;
	}
	
	/**
	* Método para obtener la ciudad de nacimiento de una mecena
	* @param no requiere parametros
	* @return La ciudad de nacimiento que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}
	
	/**
	* Método para obtener la fecha de fallecimiento de una mecena
	* @param no requiere parametros
	* @return La ciudad de nacimiento que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	public String getFechaFallecimiento() {
		return fechaFallecimiento;
	}
	
	/**
   	* Método para establecer el id de la Mecena
   	* @param  pidMecena: valor entero para configurar el id de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setId(int pid) {
		id = pid;
	}
	
	/**
   	* Método para establecer el nombre de la Mecena
   	* @param  pnombre: valor String para configurar el nombre de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	
	/**
   	* Método para establecer el Pais Nacimiento de la Mecena
   	* @param  pnombre: valor String para configurar el pais nacimiento de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setPaisNacimiento(String ppaisNacimiento) {
		paisNacimiento = ppaisNacimiento;
	}
	
	/**
   	* Método para establecer la Ciudad Nacimiento de la Mecena
   	* @param  pnombre: valor String para configurar la Ciudad nacimiento de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setCiudadNacimiento(String pciudadNacimiento) {
		ciudadNacimiento = pciudadNacimiento;
	}
	
	/**
   	* Método para establecer la fecha de fallecimiento de la Mecena
   	* @param  pnombre: valor String para configurar la fecha de fallecimiento de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setFechaFallecimiento(String pfechaFallecimiento) {
		fechaFallecimiento = pfechaFallecimiento;
	}
}
