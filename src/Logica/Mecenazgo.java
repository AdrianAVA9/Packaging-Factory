package Logica;

/**
* Una clase que simula una relacion de Pintor y Mecena
* @author Marvin Cede�o
* @author Adrian Vega
* @author Jose Madrigal
* @author Danilo Calderon
* @version v1.0
*/

public class Mecenazgo {
	
	//Atributos privados de la clase

	private int idPintor;
	private int idMecena;
	private String fechaInicioMecenazgo;
	private String fechaConcluidaMecenazgo;
	private Pintor objPintor;
	private Mecena objMecena;
	

	/**
	* M�todo que crea el obeto de tipo Mecenazgo
	* @param pidPintor: valor Entero para registrar el id del pintor
	* @param pidMecena: valor Entero para registrar el id de la Mecena
	* @param pfechaInicioMecenazgo: valor String para registrar la fecha de Inicio del mecenazgo
	* @param pfechaConcluidaMecenazgo: valor String para registrar la fecha que concluye el mecenazgo
	* @return no retorna ningun valor
	* @exception no se manejan excepciones
	*/
	
	public Mecenazgo(int pidPintor, int pidMecena,String pfechaInicioMecenazgo, String pfechaConcluidaMecenazgo) {
		
		setIdPintor(pidPintor);
		setIdMecena(pidMecena);
		setFechaInicioMecenazgo(pfechaInicioMecenazgo);
		setFechaConcluidaMecenazgo(pfechaConcluidaMecenazgo);
		this.objPintor = null;
		this.objMecena = null;
	}
	
	/**
	* M�todo para obtener la fecha que inicio el mecenazgo
	* @param no requiere parametros
	* @return la fecha de inicio que se encuentra almacenado
	* @exception no se manejan excepciones
	*/ 
	
	public String getFechaInicioMecenazgo() {
		return fechaInicioMecenazgo;
	}
	
	/**
   	* M�todo para establecer la fecha de inicio el mecenazgo
   	* @param  pfechaInicioMecenazgo: valor String para configurar la fecha de Inicio del mecenazgo
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/ 
	public void setFechaInicioMecenazgo(String pfechaInicioMecenazgo) {
		fechaInicioMecenazgo = pfechaInicioMecenazgo;
	}
	
	/**
	* M�todo para obtener la fecha que Cocluyo el mecenazgo
	* @param no requiere parametros
	* @return la fecha que termino que se encuentra almacenado
	* @exception no se manejan excepciones
	*/ 
	
	public String getFechaConcluidaMecenazgo() {
		return fechaConcluidaMecenazgo;
	}
	/**
   	* M�todo para establecer la fecha de conclusion del mecenazgo
   	* @param  pfechaConcluidaMecenazgo: valor String para configurar la fecha de Inicio del mecenazgo
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/ 
	public void setFechaConcluidaMecenazgo(String pfechaConcluidaMecenazgo) {
		fechaConcluidaMecenazgo = pfechaConcluidaMecenazgo;
	}
	
	
	/**
	* M�todo para obtener el objeto Pintor de esta relacion
	* @param no requiere parametros
	* @return El objeto que relaciona con una mecena
	* @exception no se manejan excepciones
	*/
	
	public Pintor getObjPintor() throws Exception {
		
		if(objPintor == null){
			
			setObjPintor(new MultiPintor().buscarPintorPorId(getIdPintor()));
		}
		return objPintor;
	}
	
	/**
   	* M�todo para establecer el objeto Pintor
   	* @param  pobjPintor: Tipo Pintor para configurar el objeto Pintor
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setObjPintor(Pintor pobjPintor) {
		objPintor = pobjPintor;
	}
	
	/**
	* M�todo para obtener el objeto Mecena de esta relacion
	* @param no requiere parametros
	* @return El objeto que relaciona con un Pintor
	* @exception no se manejan excepciones
	*/
	public Mecena getObjMecena() throws Exception {
		
		if(objPintor == null){
			
			setObjMecena(new MultiMecena().buscarMecena(getIdMecena()));
		}

		return objMecena;
	}
	
	/**
   	* M�todo para establecer el objeto Mecena
   	* @param  pobjMecena: Tipo Mecena para configurar el objeto Mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/
	public void setObjMecena(Mecena pobjMecena) {
		objMecena = pobjMecena;
	}
	
	/**
	* M�todo para obtener el id del pintor
	* @param no requiere parametros
	* @return El Id que se encuentra almacenado
	* @exception no se manejan excepciones
	*/ 
		
	public int getIdPintor() {
		return idPintor;
	}
	
	/**
   	* M�todo para establecer el id del pintor
   	* @param  pidPintor: valor entero para configurar el id del pintor
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/ 
	public void setIdPintor(int pidPintor) {
		idPintor = pidPintor;
	}
	
	
	/**
	* M�todo para obtener el id de la mecena
	* @param no requiere parametros
	* @return El Id que se encuentra almacenado
	* @exception no se manejan excepciones
	*/
	
	public int getIdMecena() {
		return idMecena;
	}
	
	/**
   	* M�todo para establecer el id de la Mecena
   	* @param  pidMecena: valor entero para configurar el id de la mecena
   	* @return no retorna ningun valor
   	* @exception no se manejan excepciones
   	*/ 
	public void setIdMecena(int pidMecena) {
		idMecena = pidMecena;
	}
	
//Termina Adrian
	
}
