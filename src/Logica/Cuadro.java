package Logica;

/**
 * Una clase que simula a un cuadro de un pintor
 *@author Adrian Vega
 *@author Marvin Calvo
 *@author Jose Madrigal
 *@author Danilo Calderon
 *@version v1.0
*/

public class Cuadro{
	
	//Atributos privado de la clase Cuadro
	
    private int codigo;
    private String nombre;
    private String dimension;
    private String fechaCreado;
    private String fechaIngreso;
    private int idCondicionIngreso;
    private int idCondicionActual;
    private String tipoCondiciones;
    private double costoObtenido;
    private String tecnicaUtlizado;
    private int idPintor;
    private int idPinacoteca;
    private Pintor miPintor;
    private String imagen;
    
    /**
     *Metodo que inicializa en estado valido los atributos del objeto
     *@param pcodigo: valor int que registra el id del cuadro
     *@param pnombre: valor String que registra el nombre
     *@param pdimension: valor String que registra las dimensiones
     *@param pfehaCreado: valor String que registra la fecha de creacion
     *@param ptecnicaUtilizado: valor String que registra la tecnica de pintado
     *@param pfechaIngreso: valor String que registra la fecha de ingreso a la pinacoteca
     *@param pidCondicionIngre: valor int que registra el id de la condicion de ingreso
     *@param pCondicionActual: valor int que registra el id de la condicion actual
     *@param pcostoObtenido: valor Double que registra el costo de adquisicion
     *@param pidPintor: valor int que registra el id del pintor
     *@param pidPinacoteca: valor int que registra el id de la pinacoteca
     *@return no retorna ningun valor
     *@exception no
     */ 

	public Cuadro(int pcodigo,String pnombre,String pdimension,String pfechaCreado,String ptecnicaUtlizado,String pfechaIngreso,int pidCondicionIngre
			,int pCondicionActual,double pcostoObtenido,int pidPintor,int pidPinacoteca){
		setCodigo(pcodigo);
		setNombre(pnombre);
		setDimension(pdimension);
		setFechaCreado(pfechaCreado);
		setTecnicaUtlizado(ptecnicaUtlizado);
		setFechaIngreso(pfechaIngreso);
		setIdCondicionIngreso(pidCondicionIngre);
		setIdCondicionActual(pCondicionActual);
		setCostoObtenido(pcostoObtenido);
		setIdPintor(pidPintor);
		setIdPinacoteca(pidPinacoteca);
		miPintor = null;	
	}
	
	/**
     *Metodo que inicializa en estado valido los atributos del objeto
     *@param pnombre: valor String que registra el nombre
     *@param pdimension: valor String que registra las dimensiones
     *@param pfehaCreado: valor String que registra la fecha de creacion
     *@param ptecnicaUtilizado: valor String que registra la tecnica de pintado
     *@param pfechaIngreso: valor String que registra la fecha de ingreso a la pinacoteca
     *@param pidCondicionIngre: valor int que registra el id de la condicion de ingreso
     *@param pCondicionActual: valor int que registra el id de la condicion actual
     *@param pcostoObtenido: valor Double que registra el costo de adquisicion
     *@param pidPintor: valor int que registra el id del pintor
     *@param pidPinacoteca: valor int que registra el id de la pinacoteca
     *@return no retorna ningun valor
     *@exception no
     */ 

	 public Cuadro(String pnombre,String pdimension,String pfechaCreado,String ptecnicaUtlizado,String pfechaIngreso,int pidCondicionIngre
			   ,int pCondicionActual,double pcostoObtenido,int pidPintor,int pidPinacoteca){
		 this(0,pnombre,pdimension,pfechaCreado,ptecnicaUtlizado,pfechaIngreso,pidCondicionIngre,
		pCondicionActual,pcostoObtenido,pidPintor,pidPinacoteca);
	}
	 
		public Cuadro(int pcodigo ,String pnombre,String pdimension,String pfechaCreado,String ptecnicaUtlizado,String pfechaIngreso,int pidCondicionIngre
				,int pCondicionActual,double pcostoObtenido,int pidPintor,int pidPinacoteca,String pimagen){
			setCodigo(pcodigo);
			setNombre(pnombre);
			setDimension(pdimension);
			setFechaCreado(pfechaCreado);
			setTecnicaUtlizado(ptecnicaUtlizado);
			setFechaIngreso(pfechaIngreso);
			setIdCondicionIngreso(pidCondicionIngre);
			setIdCondicionActual(pCondicionActual);
			setCostoObtenido(pcostoObtenido);
			setIdPintor(pidPintor);
			setIdPinacoteca(pidPinacoteca);
			setImagen(pimagen);;
			miPintor = null;	
		}
	    
	/**
	 *Metodo para almacenar el id del cuadro
	 *@param pidPintor: valor int que modifica el id de un cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	 
	public void setIdPintor(int pidPintor){
		idPintor=pidPintor;
	}
	
	/**
	 *Metodo para almacenar el id de la pinacoteca
	 *@param pidPinacoteca: valor int que modifica el id de una pinacoteca
	 *@return no retorna ningun valor
	 *@exception no
	 */
	public void setCodigo(int pcodigo){
		codigo=pcodigo;
	}
	public void setIdPinacoteca(int pidPinacoteca){
		idPinacoteca=pidPinacoteca;
	}
	public void setImagen(String pimagen){
		imagen=pimagen;
	}
	/**
	 *Metodo para almacenar el nombre del cuadro
	 *@param pnombre: valor String que modifica el nombre de un cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	
	/**
	 *Metodo para almacenar las dimensiones del cuadro
	 *@param pdimension: valor String que modifica las dimensiones de un cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setDimension(String pdimension) {
		dimension = pdimension;
	}
	
	/**
	 *Metodo para almacenar la fecha de creacion del cuadro
	 *@param pfechaCreado: valor String que modifica la fecha de creacion de un cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setFechaCreado(String pfechaCreado) {
		fechaCreado = pfechaCreado;
	}
	
	/**
	 *Metodo para almacenar la fecha de ingreso a una pinacoteca del cuadro
	 *@param pfechaIngreso: valor String que modifica la fecha de ingreso de un cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setFechaIngreso(String pfechaIngreso) {
		fechaIngreso = pfechaIngreso;
	}
	
	/**
	 *Metodo para almacenar el id de la condicion de ingreso del cuadro a la pinacoteca
	 *@param pidCondicionIngreso: valor int que modifica el id de la condicion de ingreso del cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setIdCondicionIngreso(int pidCondicionIngreso) {
		idCondicionIngreso = pidCondicionIngreso;
	}
	
	/**
	 *Metodo para almacenar el id de la condicion actual del cuadro
	 *@param pidCondicionActual: valor int que modifica el id de la condicion actual del cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setIdCondicionActual(int pidCondicionActual) {
		idCondicionActual = pidCondicionActual;
	}
	
	/**
	 *Metodo para almacenar el tipo de condiciones que pueden tener los cuadros
	 *@param ptipoCondiciones: valor String que modifica la condicion de los cuadros
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setTipoCondiciones(String ptipoCondiciones) {
		tipoCondiciones = ptipoCondiciones;
	}
	
	/**
	 *Metodo para almacenar el costo de obtencion del cuadro
	 *@param pcostoObtenido: valor double que modifica el costo de obtencion de los cuadros
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setCostoObtenido(double pcostoObtenido) {
		costoObtenido = pcostoObtenido;
	}
	
	/**
	 *Metodo para almacenar el tipo el tipo de tecnica de pintado del cuadro
	 *@param ptecnicaUtilizado: valor String que modifica la tecnica de pintado del cuadro
	 *@return no retorna ningun valor
	 *@exception no
	 */
	
	public void setTecnicaUtlizado(String ptecnicaUtlizado) {
		tecnicaUtlizado = ptecnicaUtlizado;
	}
	
	/****
	 * metodo para obtener el id del cuadro
	 * @param no requiere parametros
	 * @return codigo que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	 
	public int getCodigo(){
		return codigo;		
	}
	public String getImagen(){
		return imagen;
	}
	/****
	 * metodo para obtener el id del pintor del cuadro
	 * @param no requiere parametros
	 * @return idPintor que se encuetra almacenado
     * @exception no se manejan excepciones
     */
	
	public int getIdPintor(){
		 return idPintor;
	}	
	
	/****
	 * metodo para obtener el id de la pinacoteca a la que pertencene el cuadro
	 * @param no requiere parametros
	 * @return idPinacoteca que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public int getIdPinacoteca(){
		return idPinacoteca;
	}
	
	/****
	 * metodo para obtener el nombre del pintor del cuadro
	 * @param no requiere parametros
	 * @return nombre que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public String getNombre() {
		return nombre;
	}
	
	/****
	 * metodo para obtener las dimensiones del cuadro
	 * @param no requiere parametros
	 * @return dimension que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public String getDimension() {
		return dimension;
	}
	
	/****
	 * metodo para obtener la fecha de creacion del cuadro
	 * @param no requiere parametros
	 * @return fechaCreado que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public String getFechaCreado() {
		return fechaCreado;
	}
	
	/****
	 * metodo para obtener la fecha de ingreso a la pinacoteca del cuadro
	 * @param no requiere parametros
	 * @return fechaIngreso que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	
	/****
	 * metodo para obtener el id de condicion de ingreso del cuadro al pinacoteca
	 * @param no requiere parametros
	 * @return idCondicionIngreso que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public int getIdCondicionIngreso() {
		return idCondicionIngreso;
	}
	
	/****
	 * metodo para obtener el id de la condicion actual del cuadro
	 * @param no requiere parametros
	 * @return idCondicionActual que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public int getIdCondicionActual() {
		return idCondicionActual;
	}
	
	/****
	 * metodo para obtener la condicion actual del cuadro
	 * @param no requiere parametros
	 * @return condicion que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public String getCondicionActual() {
		
		String condicion;
		
		condicion = getTipoPorCondicion(idCondicionActual);
		
		return condicion;
	}
	
	/****
	 * metodo para obtener la condicion de ingreso del cuadro
	 * @param no requiere parametros
	 * @return condicion que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public String getCondicionIngreso() {
		
		String condicion;
		
		condicion = getTipoPorCondicion(idCondicionIngreso);
		
		return condicion;
	}
	
	/****
	 * metodo para obtener la condicion del cuadro
	 * @param no requiere parametros
	 * @return condicion que se encuentra almacenada
     * @exception no se manejan excepciones
     */
	
	public String getTipoPorCondicion(int ptipo) {
		
		String condicion = " ";
		
		switch(ptipo){
		
		case 1:
			condicion = "Excelente";
			break;
		case 2:
			condicion = "Buena";
			break;
		case 3:
			condicion = "Regular";
			break;
		case 4:
			condicion = "Mala";
			break;
		}
		return condicion;
	}
	
	/****
	 * metodo para obtener las condiciones que pueden tener los cuadros
	 * @param no requiere parametros
	 * @return tipoCondiciones que se encuentran almacenadas
     * @exception no se manejan excepciones
     */
	
	public String getTipoCondiciones() {
		return tipoCondiciones;
	}
	
	/****
	 * metodo para obtener el costo de obtencion del cuadro
	 * @param no requiere parametros
	 * @return costoObtenido que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public double getCostoObtenido() {
		return costoObtenido;
	}
	
	/****
	 * metodo para obtener la tecnica de pintado del cuadro
	 * @param no requiere parametros
	 * @return tecnicaUtilizado que se encuentra almacenado
     * @exception no se manejan excepciones
     */
		
	public String getTecnicaUtlizado() {
		return tecnicaUtlizado;
	}
	
	/****
	 * metodo para obtener el estado del cuadro
	 * @param no requiere parametros
	 * @return msj que se encuentra almacenado
     * @exception no se manejan excepciones
     */
	
	public String toString(){
		
	    String msj;
	    
	    msj="Nombre: " + getNombre();
	    msj+="Dimensiones: " +getDimension();
	    msj+="Condicion Actual: " + getCondicionActual();
	    msj+="Costo obtencion: " + getCostoObtenido();
	    
		return msj;
	}
}
