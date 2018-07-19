package Logica;

import java.sql.ResultSet;
import java.util.*;

import javax.swing.DefaultComboBoxModel;

import AccesoBD.Conector;

public class Gestor {
//Inicio Danilo
	public ArrayList<String>buscarPintor(int pid) throws Exception{
		ArrayList<String> listaDatospintor=new ArrayList<String>();
        Pintor pintor;
        pintor = (new MultiPintor()).buscarPintorPorId(pid);
        listaDatospintor.add(pintor.getNombre());//0
        listaDatospintor.add(""+pintor.getId());//1
        listaDatospintor.add(pintor.getPseudonimo());//2
        listaDatospintor.add(pintor.getNacionalidad());//3
        listaDatospintor.add(pintor.getPaisNacimiento());//4
        listaDatospintor.add(pintor.getCiudadNacimiento());//5
        listaDatospintor.add(pintor.getFechaFallecimiento());//6
        listaDatospintor.add(pintor.getFechaNacimiento());//7
        listaDatospintor.add(""+pintor.getIdMaestro());//8
        listaDatospintor.add(""+pintor.getIdEscula());//9
        
	return listaDatospintor;
	}
	 public  void actualizarCuadro(int pcodigo, String pnombre,String pdimension
	 ,String pfechaCreado,String pfechaIngreso,int pidCondicionIngreso,int pidCondicionActual, double pcostoObtenido,String ptecnicaUtlizado
	 ,int pidPintor,int idPinacoteca,String pimagen)throws Exception{
		 
		  Cuadro cuadro;
		  cuadro = (new MultiCuadro()).buscarCuadroPorId(pcodigo);
		  cuadro.setCodigo(pcodigo);
	      cuadro.setNombre(pnombre);
	      cuadro.setDimension(pdimension);
	      cuadro.setFechaCreado(pfechaCreado);
	      cuadro.setFechaIngreso(pfechaIngreso);
	      cuadro.setIdCondicionIngreso(pidCondicionIngreso);
	      cuadro.setIdCondicionActual(pidCondicionActual);
	      cuadro.setCostoObtenido(pcostoObtenido);
	      cuadro.setTecnicaUtlizado(ptecnicaUtlizado);
	      cuadro.setIdPintor(pidPintor);
	      cuadro.setIdPinacoteca(idPinacoteca);
	      cuadro.setImagen(pimagen);
		   try {
		     (new MultiCuadro()).actualizarCuadro(cuadro);
		   } catch (Exception e) {
		   e.printStackTrace();
		  }
	}
	public void actualizarPintor(int pid, String pnombre, String pseudonimo, String pnacionalidad,String ppaisNacimiento, String pciudadNacimiento,
			String pfechaNacimiento, String pfechaFallecimiento, int pidMaestro, int pidEscula)throws Exception{
		
	   Pintor pintor;
		
       pintor = (new MultiPintor()).buscarPintorPorId(pid);
       pintor.setNombre(pnombre);
       pintor.setSeudonimo(pseudonimo);
       pintor.setNacionalidad(pnacionalidad);
       pintor.setPaisNacimiento(ppaisNacimiento);
       pintor.setCiudadNacimiento(pciudadNacimiento);
       pintor.setFechaNacimiento(pfechaNacimiento);
       pintor.setFechaFallecimiento(pfechaFallecimiento);
       pintor.setIdEscula(pidEscula);
       pintor.setIdMaestro(pidMaestro);
       
       try {
    	   
      	 (new MultiPintor()).actualizar(pintor);
      	 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<String>buscarCuadro(int pcodigo)throws Exception{
		  ArrayList<String> listaDatoscuadro=new ArrayList<String>();
		  Cuadro cuadro;
		  cuadro=new MultiCuadro().buscarCuadroPorId(pcodigo);
		  listaDatoscuadro.add(cuadro.getNombre());//0
		  listaDatoscuadro.add(cuadro.getDimension());//1
		  listaDatoscuadro.add(cuadro.getFechaCreado());//2
		  listaDatoscuadro.add(cuadro.getTecnicaUtlizado());//3
		  listaDatoscuadro.add(cuadro.getFechaIngreso());//4
		  listaDatoscuadro.add(""+cuadro.getIdCondicionIngreso());//5
		  listaDatoscuadro.add(""+cuadro.getIdCondicionActual());//6
		  listaDatoscuadro.add(""+cuadro.getCostoObtenido());//7
		  listaDatoscuadro.add(""+cuadro.getIdPintor());//8
		  listaDatoscuadro.add(""+cuadro.getIdPinacoteca());//9
		  listaDatoscuadro.add(""+cuadro.getImagen());//10
		  
		  return listaDatoscuadro;
	 }
	
	public String[][] listarCuadros()throws Exception{ 
		
		  ArrayList<Cuadro>listaCuadros=new ArrayList<Cuadro>();
		  MultiCuadro multiCuadro=new MultiCuadro();
		  listaCuadros=multiCuadro.getCuadros();
		  String[][]listaDatosCuadros=new String[listaCuadros.size()][2];
		  for(int i=0;i<listaCuadros.size();i++){
		   listaDatosCuadros[i][0]=""+listaCuadros.get(i).getCodigo( );
		   listaDatosCuadros[i][1]=listaCuadros.get(i).getNombre();
		  }
		  return listaDatosCuadros;
	}
	public ArrayList<String>buscarEscuela(int pidEscuela) throws Exception{
		  ArrayList<String> listaDatoEscuelas=new ArrayList<String>();
		        Escuela escuela;
		        escuela=(new MultiEscuela().buscarEscuela(pidEscuela));
		       listaDatoEscuelas.add(""+escuela.getIdEscuela());//0
		       listaDatoEscuelas.add(escuela.getNombre());//1
		       listaDatoEscuelas.add(escuela.getPais());//2
		       listaDatoEscuelas.add(escuela.getDescripcion());//3
		       listaDatoEscuelas.add(escuela.getFechaAparicion());//4
		 return listaDatoEscuelas;
	}
	
	public void actualizarEscuela(int pidEscuela,String pnombre,String ppais, String pfechaAparicion,String pdescripcion)throws Exception{
		  
		  Escuela escuela;
		  escuela=(new MultiEscuela().buscarEscuela(pidEscuela));
	      escuela.setNombre(pnombre);
	      escuela.setPais(ppais);
	      escuela.setFechaAparicion(pfechaAparicion);
	      escuela.setDescripcion(pdescripcion);
	      
		 try {
			(new MultiEscuela()).actualizarEscuela(escuela);
			        
		} catch (Exception e) {
			  
		} 
	 }
	
	public ArrayList<String>buscarPinacotecas(int pidPinacoteca)throws Exception{
	    ArrayList<String> listaDatosPinacotecas=new ArrayList<String>();
	   Pinacoteca pinacoteca;
	   pinacoteca=(new MultiPinacoteca().buscarPinacotecaPorId(pidPinacoteca));
	   listaDatosPinacotecas.add(""+pinacoteca.getIdPinacoteca());//0
	   listaDatosPinacotecas.add(pinacoteca.getFechaInaguracion());//1
	   listaDatosPinacotecas.add(pinacoteca.getmedidaPinacoteca());//2
	   listaDatosPinacotecas.add(pinacoteca.getNombre());//3
	   
	    
	    
	    return listaDatosPinacotecas;
	  }
	
	public void actualizarPinacoteca(int pidPinacoteca,String pnombre,String PmedidaPinacoteca,String pfechainaguracion ) throws Exception{
		Pinacoteca pinacoteca;
		pinacoteca=(new MultiPinacoteca().buscarPinacotecaPorId(pidPinacoteca));
	    pinacoteca.setNombre(pnombre);
	    pinacoteca.setFechaInaguracion(pfechainaguracion);
	    pinacoteca.setmedidaPinacoteca(PmedidaPinacoteca);
		
	    
	    try {
			(new MultiPinacoteca()).actualizarPinacoteca(pinacoteca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
//Fin Danilo 
	
//Inicio Jose
	public void eliminarPintor(int pidPntor)throws Exception{
		
		Pintor pintor;
		pintor=new MultiPintor().buscarPintorPorId(pidPntor);
		(new MultiPintor()).borrar(pintor);
		  
	}
	
	 public void eliminarCuadro(int piCuatro)throws Exception{
			
			Cuadro cuadro;
			
			cuadro=new MultiCuadro().buscarCuadroPorId(piCuatro);
			new MultiCuadro().borrarCuadro(cuadro);
	}
	 
	 public void eliminarEsuela(int pidEscuela)throws Exception{
			
			Escuela escuela;
			
			escuela=new MultiEscuela().buscarEscuela(pidEscuela);
			new MultiEscuela().borrar(escuela);
	}
	 public void eliminarPinacoteca(int pidPinacoteca)throws Exception{
		 
		 Pinacoteca pinacoteca;
		 
		 pinacoteca=new MultiPinacoteca().buscarPinacotecaPorId(pidPinacoteca);
		 new MultiPinacoteca().borrar(pinacoteca);  
	}
	 
	 public String[][] listarMecenas()throws Exception
	{	 
		ArrayList<Mecena>listaMecena=new ArrayList<Mecena>();
		MultiMecena multimecena=new MultiMecena();
		listaMecena=multimecena.getMecenas();
		String[][]listaDatosMecena=new String[listaMecena.size()][2];
		for(int i=0;i<listaMecena.size();i++){
			listaDatosMecena[i][0]=""+listaMecena.get(i).getId( );
			listaDatosMecena[i][1]=listaMecena.get(i).getNombre();
			
			
		}
		
		return listaDatosMecena;
	}
	 

	 public void eliminarMecena(int pidMecena)throws Exception{
		 
		 Mecena mecena=null;
		 
		 mecena=new MultiMecena().buscarMecena(pidMecena);
		 new MultiMecena().borrar(mecena);
	}
	 public void actualizarMecena(int pid,String pnombre,String ppaisNacimiento,String pciudadNacimiento,String  pfechaFallecimiento ){
		    Mecena mecena=null;
		    
		    try {
		  mecena=(new MultiMecena()).buscarMecena(pid);
		 } catch (Exception e1) {
		 
		  e1.printStackTrace();
		 }
		    mecena.setNombre(pnombre);
		    mecena.setPaisNacimiento(ppaisNacimiento);
		    mecena.setCiudadNacimiento(pciudadNacimiento);
		    mecena.setFechaFallecimiento(pfechaFallecimiento);
		    
		    try {
		           
		           (new MultiMecena()).actualizarMecena(mecena);
		           
		     } catch (Exception e) {
		      e.printStackTrace();
		     }
	}
	 public ArrayList<String> solicitarInfoMecena(int pidMecena){
		 ArrayList<String> listaDatoMecena=new ArrayList<String>();
	    try {
			 Mecena mecena;
			
			mecena = (new MultiMecena().buscarMecena(pidMecena));
			 listaDatoMecena.add(""+mecena.getId());//0
		        listaDatoMecena.add(mecena.getNombre());//1
		       listaDatoMecena.add(mecena.getFechaFallecimiento());//2
		       listaDatoMecena.add(mecena.getPaisNacimiento());//3
		       listaDatoMecena.add(mecena.getCiudadNacimiento());//4
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	       
	 return listaDatoMecena;  
	}
	 
	 public String[][] listarCuadrosPorPintor(int pid)throws Exception{ 
		  
		    ArrayList<Cuadro>listaCuadros=new ArrayList<Cuadro>();
		    MultiCuadro multiCuadro=new MultiCuadro();
		    listaCuadros=multiCuadro.listarCuadrosPintor(pid);
		    String[][]listaDatosCuadros=new String[listaCuadros.size()][2];
		    for(int i=0;i<listaCuadros.size();i++){
		     listaDatosCuadros[i][0]=""+listaCuadros.get(i).getCodigo( );
		     listaDatosCuadros[i][1]=listaCuadros.get(i).getNombre();
		    }
		    return listaDatosCuadros;
	}
	 
	 
//Fin Jose
	
//Inicio Marvin
	 public void removerMecenazgoAlPintor(int pidMecena,int pidPintor){
		 
		 
		try {
			Pintor pintor = (new MultiPintor()).buscarPintorPorId(pidPintor);
			Mecena mecena = (new MultiMecena().buscarMecena(pidMecena));
			MultiMecenazgo multiMecenazgo=new MultiMecenazgo();
			multiMecenazgo.eliminarMecenazgo(mecena,pintor);
		} catch (Exception e1) {
			
		}
		
	 }
	 public void crearMecenazgo(int pidPintor,int pidMecena,String pfechaInicioMecenazgo, String pfechaConcluidaMecenazgo){
		 Mecenazgo mecenazgo=new Mecenazgo(pidPintor,pidMecena,pfechaInicioMecenazgo,pfechaConcluidaMecenazgo);
		 MultiMecenazgo multiMecenazgo=new MultiMecenazgo();
		 try {
			multiMecenazgo.agragarMecenazgo(mecenazgo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 }
	 public boolean registrarPinacoteca(String pnombre,String pfechainguracion,String pmetrosCuadrados)throws Exception{
			MultiPinacoteca multiPinacoteca=new MultiPinacoteca();
			Pinacoteca pinacoteca =new Pinacoteca(pnombre,pfechainguracion,pmetrosCuadrados);
			return multiPinacoteca.agregarPinacoteca(pinacoteca);
	 }
	 
	 public void agregarMecena(String pnombre,String pfechaFallecimiento,String ppais,String pciudad)throws Exception{
			MultiMecena multiMecena=new MultiMecena();
			Mecena mecena=new Mecena(pnombre, pfechaFallecimiento, ppais, pciudad);
			multiMecena.crearMecena(mecena);
	 }
	 
	 public boolean registrarPintor(String pnombre,String ppsudonimo,String pnacionalidad,String ppais,String pciudad,
		String pfechaNacimiento,String pfechaFallecimiento,int pidEscuela,int pidMaestro)throws Exception{
			boolean existeNombre=true;
			try {
				MultiPintor multiPintor=new MultiPintor();
				Pintor pintor =new Pintor(pnombre,ppsudonimo,pnacionalidad,ppais,pciudad,pfechaNacimiento,pfechaFallecimiento,pidMaestro,pidEscuela);
				existeNombre=multiPintor.agregarPintor(pintor);
			} catch (Exception e) {}
			return existeNombre;
	}
	 
	 public boolean registrarCuadro(String pnombre,String pdimenciones,String pfechaPintado,String ptecnica,String ppfechaIngreso,
	 int pcondicionIngreso,int pcondicionActual,double pcosto,int pidPintor,int pidPinacoteca,String pimagen)throws Exception{
		boolean existeNombre=true;
		try {
			MultiCuadro multiCuadro=new MultiCuadro();
		Cuadro cuadro =new Cuadro(0,pnombre,pdimenciones,pfechaPintado,ptecnica,ppfechaIngreso,pcondicionIngreso,pcondicionActual,pcosto,pidPintor,pidPinacoteca,pimagen);
			existeNombre=multiCuadro.agregarCuadro(cuadro);
		} catch (Exception e) {}
		return existeNombre;
	}
	
	public void registrarEscuela(String pnombre,String pdescripcion,String pfechaAparicion,String ppais)throws Exception{
		MultiEscuela multiEscuela=new MultiEscuela();
		Escuela escuela=new Escuela(pnombre,pdescripcion,pfechaAparicion,ppais);
		multiEscuela.agregarEscuela(escuela);
		
	}
	public String[] listarNombreCiudades(int pidPais)throws Exception{
		 MultiCiudad multiCiudad =new MultiCiudad();
			return multiCiudad.getNombreCiudades(pidPais);
	}
	public String[][] listarPaises()throws Exception
	{	 MultiPais multiPais=new MultiPais();
		return multiPais.getDatosPaises();
	}
	
	public String [] listarNombrePaises()throws Exception{
		MultiPais multiPais=new MultiPais();
		return multiPais.getNombrePaises();
	}
	
	public String [][] listarDatosCondicion()throws Exception{
		MultiCondicion multiCondicion=new MultiCondicion();
		return multiCondicion.getDatosCondicione();
	}
	
	public String[][] listarPintores()throws Exception
	{	
		ArrayList<Pintor>listaMaestros=new ArrayList<Pintor>();
		MultiPintor multiPintor=new MultiPintor();
		listaMaestros=multiPintor.getPintores();
		String[][]listaDatosMaestros=new String[listaMaestros.size()][2];
		for(int i=0;i<listaMaestros.size();i++){
			listaDatosMaestros[i][0]=""+listaMaestros.get(i).getId();
			listaDatosMaestros[i][1]=listaMaestros.get(i).getNombre();
		}
		return listaDatosMaestros;
	}

	public String[][] listarEscuelas()throws Exception
	{	
		ArrayList<Escuela>listaEscuelas=new ArrayList<Escuela>();
		MultiEscuela multiEscuelas=new MultiEscuela();
		listaEscuelas=multiEscuelas.getEscuelas();
		String[][]listaDatosEscuelas=new String[listaEscuelas.size()][2];
		for(int i=0;i<listaEscuelas.size();i++){
			listaDatosEscuelas[i][0]=""+listaEscuelas.get(i).getIdEscuela();
			listaDatosEscuelas[i][1]=listaEscuelas.get(i).getNombre();
		}
		return listaDatosEscuelas;
	}
	
	public String[][] listarPinacotecas()throws Exception
	{	
		ArrayList<Pinacoteca>listaPinacoteca=new ArrayList<Pinacoteca>();
		MultiPinacoteca multiPinacoteca=new MultiPinacoteca();
		listaPinacoteca=multiPinacoteca.listarPinacotecas();
		String[][]listaDatosPinacoteca=new String[listaPinacoteca.size()][2];
		for(int i=0;i<listaPinacoteca.size();i++){
			listaDatosPinacoteca[i][0]=""+listaPinacoteca.get(i).getIdPinacoteca( );
			listaDatosPinacoteca[i][1]=listaPinacoteca.get(i).getNombre();
		}
		return listaDatosPinacoteca;
	}
	
	public String[][] buscarDatosMecenaPorPintor(int pidPintor) throws Exception{
		
		
		String[][]listaDatosMecena = null;
		ArrayList<Mecenazgo>listaMecenazgoPorPintor = null;
		Mecena unaMecena = null;
		
		listaMecenazgoPorPintor  = (new MultiMecenazgo()).buscarMecenasPorPintor(pidPintor);
		listaDatosMecena = new String[listaMecenazgoPorPintor.size()][2];
		
		
		for(int i=0;i < listaMecenazgoPorPintor.size();i++){
			
			
			unaMecena = listaMecenazgoPorPintor.get(i).getObjMecena();
			listaDatosMecena[i][0] = ""+unaMecena.getId();
			listaDatosMecena[i][1] = unaMecena.getNombre();
			
		}
		
		
		return listaDatosMecena;
	}
//Fin Marvin
	
//Inicia Adrian
	public String[][] buscarCuadrosPorPintor(int pidPintor) throws Exception{
			
			String[][]cuadrosPintor = null;
			ArrayList<Cuadro>listaCuadroPintor = new ArrayList<Cuadro>();
			Pintor objPintor = null;
			
			objPintor = (new MultiPintor()).buscarPintorPorId(pidPintor);
			
			listaCuadroPintor = objPintor.getListaCuadro();
			
			cuadrosPintor = new String[listaCuadroPintor.size()][2];
			
			for(int i=0;i<listaCuadroPintor.size();i++){
				
				cuadrosPintor[i][0] = listaCuadroPintor.get(i).getNombre();
				cuadrosPintor[i][1] = listaCuadroPintor.get(i).getFechaCreado();
			}
			return cuadrosPintor;
		}
		
	public String[][] buscarPintorPorNombre(String pnombre) throws Exception{
			
			String[][]nombrePintores;
			ArrayList<Pintor>listaPintores;
			
			listaPintores = (new MultiPintor()).buscarPintorPorNombre(pnombre);
			
			nombrePintores = new String[listaPintores.size()][2];
			
			for(int i=0; i < nombrePintores.length;i++){
				
				nombrePintores[i][0] = listaPintores.get(i).getNombre();
				nombrePintores[i][1] = String.valueOf(listaPintores.get(i).getId());
				
			}
			
			return nombrePintores;
		}
		
		public String[] listarNombreCuadros() throws Exception{
			
			String[]nombreCuadros = null;
			ArrayList<Pinacoteca>listaPinacoteca = null;
			ArrayList<Cuadro>listaCuadroPinacoteca = null;
			ArrayList<Cuadro>listaTotalCuadrosPorPinacoteca = new ArrayList<Cuadro>();
			
			listaPinacoteca = (new MultiPinacoteca()).listarPinacotecas();
			
			for(int i=0;i < listaPinacoteca.size();i++){
				
				listaCuadroPinacoteca = listaPinacoteca.get(i).getListaCuadros();
				
				for(int j=0; j < listaCuadroPinacoteca.size();j++){
					
					listaTotalCuadrosPorPinacoteca.add(listaCuadroPinacoteca.get(j));
					
				}
			}
			
			nombreCuadros = new String[listaTotalCuadrosPorPinacoteca.size()];
			
			for(int i = 0; i < nombreCuadros.length;i++){
				
				nombreCuadros[i] = listaTotalCuadrosPorPinacoteca.get(i).getNombre();
			}
			
			
			return nombreCuadros;
		}
		
	
		public String[] buscarPinacoteca(int pidPinacoteca) throws Exception{
			
			String[]infoPinacoteca = new String[3];
			Pinacoteca objPinacoteca = null;
			
			objPinacoteca = (new MultiPinacoteca()).buscarPinacotecaPorId(pidPinacoteca);
			
			infoPinacoteca[0] = objPinacoteca.getNombre();
			infoPinacoteca[1] = objPinacoteca.getmedidaPinacoteca();
			infoPinacoteca[2] = objPinacoteca.getFechaInaguracion();
			
			return infoPinacoteca;
		}
		
		public String[] listarNombrePinacoteca() throws Exception{
			
			String[]nombresPinacotecas = null;
			ArrayList<Pinacoteca>listaPinacoteca = null;
			
			listaPinacoteca = (new MultiPinacoteca().listarPinacotecas());
			
			nombresPinacotecas = new String[listaPinacoteca.size()];
			
			for(int i=0; i < nombresPinacotecas.length; i++){
				
				nombresPinacotecas[i] = listaPinacoteca.get(i).getNombre();
			}
			
			
			return nombresPinacotecas;
		}
		
		public String[] listarCuadrosPinacoteca(String pnombrePinacoteca) throws Exception{
				
				String[]nombreCuadro = null;
				Pinacoteca objPinacoteca = null;
				ArrayList<Cuadro>listaCuadro = null;
				
				objPinacoteca = (new MultiPinacoteca().buscarPinacotecaPorNombre(pnombrePinacoteca));
					
				listaCuadro = objPinacoteca.getListaCuadros();
				
				nombreCuadro = new String[listaCuadro.size()];
				
				for(int i=0; i < nombreCuadro.length;i++){
					
					nombreCuadro[i] = listaCuadro.get(i).getNombre();
					
				}
				
				return nombreCuadro;
			}
		
		
		public String[] buscarInfoCuadro(String pnombreCuadro) throws Exception{
			
			String[]infoCuadro = new String[10];
			Cuadro unCuadro;
			
			unCuadro = (new MultiCuadro()).buscarCuadro(pnombreCuadro);
			
			infoCuadro[0] = String.valueOf(unCuadro.getCodigo());
			infoCuadro[1] = unCuadro.getFechaCreado();
			infoCuadro[2] = unCuadro.getDimension();
			infoCuadro[3] = String.valueOf(unCuadro.getCostoObtenido());
			infoCuadro[4] = unCuadro.getFechaIngreso();
			infoCuadro[5] = unCuadro.getCondicionActual();
			infoCuadro[6] = unCuadro.getCondicionIngreso();
			infoCuadro[7] = unCuadro.getTecnicaUtlizado();
			infoCuadro[8] = String.valueOf(unCuadro.getIdPintor());
			infoCuadro[9] = String.valueOf(unCuadro.getIdPinacoteca());
			
			return infoCuadro;
		}
		
		public String[] buscarInfoPintor(int pidPintor) throws Exception{
			
			String[]infoPintor = new String[10];
			Pintor unPintor;
			
			unPintor = (new MultiPintor()).buscarPintorPorId(pidPintor);
			
			infoPintor[0] = unPintor.getNombre();
			infoPintor[1] = unPintor.getPseudonimo();
			infoPintor[2] = unPintor.getNacionalidad();
			infoPintor[3] = unPintor.getCiudadNacimiento();
			infoPintor[4] = unPintor.getPaisNacimiento();
			infoPintor[5] = unPintor.getFechaNacimiento();
			infoPintor[6] = unPintor.getFechaFallecimiento();
			infoPintor[7] = String.valueOf(unPintor.getId());
			
			if(unPintor.getMaestro() != null){
				infoPintor[8] = String.valueOf(unPintor.getMaestro().getNombre());
			}
			
			if(unPintor.getObjEscuela() != null){
				infoPintor[9]= String.valueOf(unPintor.getObjEscuela().getNombre());
			}
			
			return infoPintor;
		}
		
		public String[] buscarMecenaPorPintor(int pidPintor) throws Exception{
			
			
			String[]nombreMecena = null;
			ArrayList<Mecenazgo>listaMecenazgoPorPintor = null;
			Mecena unaMecena = null;
			
			listaMecenazgoPorPintor  = (new MultiMecenazgo()).buscarMecenasPorPintor(pidPintor);
			nombreMecena = new String[listaMecenazgoPorPintor.size()];
			
			
			for(int i=0;i < listaMecenazgoPorPintor.size();i++){
				
				
				unaMecena = listaMecenazgoPorPintor.get(i).getObjMecena();
				
				nombreMecena[i] = unaMecena.getNombre();
				
			}
			
			
			return nombreMecena;
		}
		
		public String buscarEscuelaPintor(int pidEscuela) throws Exception{
			
			String escuelaPintor = "";
			Escuela objEscuela = null;
			
			objEscuela = (new MultiEscuela()).buscarEscuela(pidEscuela); 
			
			escuelaPintor = objEscuela.getNombre();
			
			return escuelaPintor;
		}
		
		public String buscarMaestroPintor(int pidPintor) throws Exception{
			
			String nombreMaestro = "";
			Pintor objPintor = null;
			
			objPintor = (new MultiPintor()).buscarPintorPorId(pidPintor).getMaestro(); 
			
			nombreMaestro = objPintor.getNombre();
			
			return nombreMaestro;
		}
		
//Fin Adrian
}