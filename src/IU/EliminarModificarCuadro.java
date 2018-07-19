package IU;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Window.Type;
import java.awt.Color;

public class EliminarModificarCuadro extends JFrame {

	protected static final String SwingUtilities = null;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDimensiones;
	private JTextField textFieldTecnicaPintado;
	private JTextField textFieldCostoAdquisicion;
	private String[][] listaDatoCuadros;
	private ArrayList<String> listaDatosCuadro;
	private JDateChooser datefechaPintado ;
	private JDateChooser dateFechaAdquisicion;
	private Gestor gestor;
	private String[][] listaDatosCondicione;
	private String[][] listaDatosPintores;
	private String[][] listaDatosPinacotecas;
	private JComboBox comboBoxPintor;
	private JComboBox comboBoxCuadro;
	private JComboBox comboBoxCondicionLlegada;
	private JComboBox comboBoxCondicionActual;
	private JComboBox comboBoxPinacoteca ;
	private String rutaImagen;
	private JLabel lblimgcuadro ;
	private String fil;
	private String filName;
	private FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivo de imagen", "jpg");
	private Path FROM;
    private Path TO ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificarCuadro frame = new EliminarModificarCuadro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EliminarModificarCuadro() {
		fil="";
		rutaImagen="";
		filName="";
		setType(Type.UTILITY);
		setTitle("Eliminar Modificar Cuadro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 594, 797);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		gestor=new Gestor();
		
		JLabel lblSeleccioneElCuadro = new JLabel("Seleccione el cuadro");
		lblSeleccioneElCuadro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSeleccioneElCuadro.setBounds(12, 26, 241, 25);
		contentPane.add(lblSeleccioneElCuadro);
		
		comboBoxCuadro = new JComboBox();
		comboBoxCuadro.setBackground(new Color(240, 248, 255));
		cargarCuadros();
		comboBoxCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!(comboBoxCuadro.getSelectedIndex()==-1)){
						cargarDatosCuadroAIntefaz();
					}else{
						
					}
					
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		comboBoxCuadro.setBounds(265, 26, 311, 31);
		contentPane.add(comboBoxCuadro);
		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(12, 120, 107, 21);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(new Color(240, 248, 255));
		textFieldNombre.setBounds(265, 118, 311, 31);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDimensiones = new JLabel("Dimensiones");
		lblDimensiones.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblDimensiones.setBounds(12, 167, 142, 25);
		contentPane.add(lblDimensiones);
		
		textFieldDimensiones = new JTextField();
		textFieldDimensiones.setBackground(new Color(240, 248, 255));
		textFieldDimensiones.setBounds(265, 167, 311, 31);
		textFieldDimensiones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
				
				
			}
		});
		contentPane.add(textFieldDimensiones);
		textFieldDimensiones.setColumns(10);
		
		JLabel lblTecnicaPintado = new JLabel("Tecnica Pintado");
		lblTecnicaPintado.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblTecnicaPintado.setBounds(12, 217, 196, 25);
		contentPane.add(lblTecnicaPintado);
		
		textFieldTecnicaPintado = new JTextField();
		textFieldTecnicaPintado.setBackground(new Color(240, 248, 255));
		textFieldTecnicaPintado.setBounds(265, 217, 311, 31);
		contentPane.add(textFieldTecnicaPintado);
		textFieldTecnicaPintado.setColumns(10);
		
		JLabel lblFechaAdquisicon = new JLabel("Fecha adquisicion");
		lblFechaAdquisicon.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaAdquisicon.setBounds(12, 265, 196, 25);
		contentPane.add(lblFechaAdquisicon);
		
		dateFechaAdquisicion = new JDateChooser();
		dateFechaAdquisicion.setBackground(new Color(240, 248, 255));
		dateFechaAdquisicion.setBounds(265, 264, 311, 31);
		contentPane.add(dateFechaAdquisicion);
		
		JLabel lblCondicionLlegada = new JLabel("Condicion llegada");
		lblCondicionLlegada.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionLlegada.setBounds(12, 314, 220, 25);
		contentPane.add(lblCondicionLlegada);
		
		JLabel lblCondicionActual = new JLabel("Condicion Actual");
		lblCondicionActual.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionActual.setBounds(12, 364, 220, 25);
		contentPane.add(lblCondicionActual);
		
		JLabel lblCostoAdquisicion = new JLabel("Costo adquisicion");
		lblCostoAdquisicion.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCostoAdquisicion.setBounds(12, 460, 196, 25);
		contentPane.add(lblCostoAdquisicion);
		
		textFieldCostoAdquisicion = new JTextField();
		textFieldCostoAdquisicion.setBackground(new Color(240, 248, 255));
		textFieldCostoAdquisicion.setBounds(265, 460, 311, 31);
		textFieldCostoAdquisicion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
				
				
			}
		});
		contentPane.add(textFieldCostoAdquisicion);
		textFieldCostoAdquisicion.setColumns(10);
		
		JLabel lblFechaPintado = new JLabel("Fecha Pintado");
		lblFechaPintado.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaPintado.setBounds(12, 511, 196, 25);
		contentPane.add(lblFechaPintado);
		
		datefechaPintado = new JDateChooser();
		datefechaPintado.setBackground(new Color(240, 248, 255));
		datefechaPintado.setBounds(265, 510, 311, 31);
		contentPane.add(datefechaPintado);
		
		JButton botonAtras = new JButton("< Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificar ventanaEliminarModificar= new EliminarModificar();
				ventanaEliminarModificar.setLocationRelativeTo(null);
				ventanaEliminarModificar.setVisible(true);
				dispose();
			}
		});
		botonAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonAtras.setBounds(12, 712, 120, 43);
		contentPane.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonEliminar_mouseClicked(e);
			}
		});
		botonEliminar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonEliminar.setBounds(162, 712, 120, 43);
		contentPane.add(botonEliminar);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonModificar_mouseClicked(e);
			}
		});
		botonModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonModificar.setBounds(303, 712, 120, 43);
		contentPane.add(botonModificar);
		
		JLabel lblSeleccioneElPintor = new JLabel("Seleccione el pintor");
		lblSeleccioneElPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSeleccioneElPintor.setBounds(12, 73, 252, 24);
		contentPane.add(lblSeleccioneElPintor);
		
		comboBoxPintor = new JComboBox();
		comboBoxPintor.setBackground(new Color(240, 248, 255));
		comboBoxPintor.setBounds(265, 73, 311, 31);
		contentPane.add(comboBoxPintor);
		
		comboBoxCondicionLlegada = new JComboBox();
		comboBoxCondicionLlegada.setBackground(new Color(240, 248, 255));
		comboBoxCondicionLlegada.setBounds(265, 315, 311, 31);
		contentPane.add(comboBoxCondicionLlegada);
		
		comboBoxCondicionActual = new JComboBox();
		comboBoxCondicionActual.setBackground(new Color(240, 248, 255));
		comboBoxCondicionActual.setBounds(265, 365, 311, 31);
		contentPane.add(comboBoxCondicionActual);
		
		JLabel lblPinacoteca = new JLabel("Pinacoteca");
		lblPinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPinacoteca.setBounds(12, 409, 142, 25);
		contentPane.add(lblPinacoteca);
		
		comboBoxPinacoteca = new JComboBox();
		comboBoxPinacoteca.setBackground(new Color(240, 248, 255));
		comboBoxPinacoteca.setBounds(265, 410, 311, 31);
		contentPane.add(comboBoxPinacoteca);
		
		JButton btnCambiarimagen = new JButton("CambiarI magen");
		btnCambiarimagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser dig=new JFileChooser();
				dig.setBackground(new Color(112, 128, 144));
				dig.setBorder(new EmptyBorder(5, 5, 5, 5));
				dig.setFileFilter(filter);
				int option=dig.showDialog(contentPane, "Seleccionar Imagen");
				if(option==JFileChooser.APPROVE_OPTION){
					fil=dig.getSelectedFile().getPath();
					filName=dig.getSelectedFile().getName();
					String file=dig.getSelectedFile().toString();
					lblimgcuadro.setIcon(new ImageIcon(fil));
					ImageIcon icon= new ImageIcon(fil);
					Image img = icon.getImage();
					Image newImg=img.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH); 
					ImageIcon newIcom=new ImageIcon(newImg);
					lblimgcuadro.setIcon(newIcom);
					lblimgcuadro.setSize(259, 136);
					filName="..//PrPinturaMCalvo//Imgs//"+filName;
					FROM = Paths.get(fil);
				    TO = Paths.get(filName);
				
				    
				}
			}
		});
		btnCambiarimagen.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnCambiarimagen.setBounds(12, 603, 196, 31);
		contentPane.add(btnCambiarimagen);
		
		lblimgcuadro = new JLabel("");
		lblimgcuadro.setBounds(265, 554, 259, 136);
		contentPane.add(lblimgcuadro);
	}
	
	
	private void cargarCuadros(){	
		
		
		try {
			String[] listaNombreCuadros;
			listaDatoCuadros=gestor.listarCuadros();
			listaNombreCuadros=new String[listaDatoCuadros.length];
			for(int i=0; i<listaDatoCuadros.length;i++){
				
				listaNombreCuadros[i]=listaDatoCuadros[i][1];
				System.out.println(listaDatoCuadros[i][0]);
				System.out.println(listaDatoCuadros[i][0]);
			}
			comboBoxCuadro.setModel(new DefaultComboBoxModel(listaNombreCuadros));
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
	}
	private void botonModificar_mouseClicked(MouseEvent e){
			if(!(textFieldNombre.getText().equals(""))&&!(textFieldDimensiones.getText().equals(""))&&!(textFieldTecnicaPintado.getText().equals(""))
					&&!(textFieldCostoAdquisicion.getText().equals(""))&&validarFecha()){
			if(fil.equals("")){
					filName=listaDatosCuadro.get(10);
			}
				try {
					gestor.actualizarCuadro(puscaridCuadroPorNombre(comboBoxCuadro.getSelectedItem().toString()),textFieldNombre.getText(),textFieldDimensiones.getText()
					,obtenerFechaEnString(datefechaPintado),obtenerFechaEnString(dateFechaAdquisicion),puscaridCondicionPorNombre(comboBoxCondicionLlegada.getSelectedItem().toString()),
					puscaridCondicionPorNombre(comboBoxCondicionActual.getSelectedItem().toString()),Double.parseDouble(textFieldCostoAdquisicion.getText()),
					textFieldTecnicaPintado.getText(),puscaridPintorPorNombre(comboBoxPintor.getSelectedItem().toString()),
					puscaridPinacotecaPorNombre(comboBoxPinacoteca.getSelectedItem().toString()),filName);
					cargarCuadros();
					comboBoxCuadro.setSelectedIndex(0);
					Files.move(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e1) {
					
					if(!fil.equals("")){
						
						JOptionPane.showMessageDialog(null,"Ingrese los datos correctamente por favor");
					}
					
				}
			}
	}
	
	private void botonEliminar_mouseClicked(MouseEvent e){
		try {
			
			if(!(comboBoxCuadro.getSelectedIndex()==-1)){
				
				gestor.eliminarCuadro(puscaridCuadroPorNombre(comboBoxCuadro.getSelectedItem().toString()));
				cargarCuadros();
			}else{
				limpiarDatos();
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	private void limpiarDatos(){
		textFieldNombre.setText("");
		textFieldDimensiones.setText("");
		textFieldTecnicaPintado.setText("");
		textFieldCostoAdquisicion.setText("");
		comboBoxPintor.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxCondicionActual.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxCondicionLlegada.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxPinacoteca.setModel(new DefaultComboBoxModel(new String[]{""}));
		
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/mm/yyyy");
		java.util.Date fechaDate;
		try {
			fechaDate = formato.parse("1/1/1");
			dateFechaAdquisicion.setDate(fechaDate);
			fechaDate = formato.parse("1/1/1");
			datefechaPintado.setDate(fechaDate);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		
	}
	private void cargarDatosCuadroAIntefaz(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
		listaDatosCuadro=new ArrayList<String>();
		try {
			listaDatosCuadro=gestor.buscarCuadro(puscaridPorNombre(comboBoxCuadro.getSelectedItem().toString()));
			textFieldNombre.setText(listaDatosCuadro.get(0));
			textFieldDimensiones.setText(listaDatosCuadro.get(1));
			textFieldTecnicaPintado.setText(listaDatosCuadro.get(3));
			textFieldCostoAdquisicion.setText(listaDatosCuadro.get(7));
			cargarCondiciones();
			cargarNombrePintores();
			cargarPinacotecas();
			buscarIndexComboBox(comboBoxCondicionLlegada,puscarnombreCondicionPorid(listaDatosCuadro.get(5)));
			buscarIndexComboBox(comboBoxCondicionActual,puscarnombreCondicionPorid(listaDatosCuadro.get(6)));
			buscarIndexComboBox(comboBoxPintor,puscarNombrePorId(listaDatosPintores,listaDatosCuadro.get(8)));
			buscarIndexComboBox(comboBoxPinacoteca,puscarNombrePorId(listaDatosPinacotecas,listaDatosCuadro.get(9)));
			java.util.Date fechaDate = formato.parse(listaDatosCuadro.get(4));
			dateFechaAdquisicion.setDate(fechaDate);
			fechaDate = formato.parse(listaDatosCuadro.get(2));
			datefechaPintado.setDate(fechaDate);
			
			ImageIcon icon= new ImageIcon(listaDatosCuadro.get(10));
			Image img = icon.getImage();
			Image newImg=img.getScaledInstance(259, 136, java.awt.Image.SCALE_SMOOTH); 
			ImageIcon newIcom=new ImageIcon(newImg);
			lblimgcuadro.setIcon(newIcom);
			lblimgcuadro.setSize(259, 136);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
 
		 
		
	}
	
	private void buscarIndexComboBox(JComboBox comboBox,String pitem){
		for (int i = 0; i < comboBox.getItemCount(); i++)
        {	
			comboBox.setSelectedIndex(i);
            String item = comboBox.getSelectedItem().toString();
            if (item.equalsIgnoreCase(pitem))
            {
            	comboBox.setSelectedIndex(i);
                break;
            }
        }
		
		
	}
	
	private int puscaridPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatoCuadros.length;i++){
			if(pnombre.equals(listaDatoCuadros[i][1])){
				
				return Integer.parseInt(listaDatoCuadros[i][0]);
			}
		}
		return -1;
	}
	
	private int puscaridPintorPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPintores.length;i++){
			if(pnombre.equals(listaDatosPintores[i][1])){
				
				return Integer.parseInt(listaDatosPintores[i][0]);
			}
		}
		return 0;
	}
	private int puscaridPinacotecaPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPinacotecas.length;i++){
			if(pnombre.equals(listaDatosPinacotecas[i][1])){
				
				return Integer.parseInt(listaDatosPinacotecas[i][0]);
			}
		}
		return 0;
	}
	
	private int puscaridCuadroPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatoCuadros.length;i++){
			if(pnombre.equals(listaDatoCuadros[i][1])){
				System.out.println(listaDatoCuadros[i][0]+"yo");
				return Integer.parseInt(listaDatoCuadros[i][0]);
			}
		}
		return 0;
	}
	
	private String puscarnombreCondicionPorid(String id)
	{
		for(int i=0;i<listaDatosCondicione.length;i++){
			if(id.equals(listaDatosCondicione[i][0])){
				
				return listaDatosCondicione[i][1];
			}
		}
		return "";
	}
	private void cargarCondiciones()
	{	
		try {
			listaDatosCondicione=gestor.listarDatosCondicion();
			String[] listaComdiciones=new String[listaDatosCondicione.length];
			for(int i=0; i<listaDatosCondicione.length;i++){
				listaComdiciones[i]=listaDatosCondicione[i][1];
			}
			comboBoxCondicionLlegada.setModel(new DefaultComboBoxModel<>(listaComdiciones));
			comboBoxCondicionActual.setModel(new DefaultComboBoxModel<>(listaComdiciones));
		}catch (Exception ex) {}
	}
	private int puscaridCondicionPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosCondicione.length;i++){
			if(pnombre.equals(listaDatosCondicione[i][1])){
				
				return Integer.parseInt(listaDatosCondicione[i][0]);
			}
		}
		return -1;
	}
	private void cargarNombrePintores(){	
		
		try {
			listaDatosPintores=gestor.listarPintores();
			String[] listaNombrePintores=new String[listaDatosPintores.length];
			
			for(int i=0; i<listaDatosPintores.length;i++){
				listaNombrePintores[i]=listaDatosPintores[i][1];
				
			}
			comboBoxPintor.setModel(new DefaultComboBoxModel(listaNombrePintores));
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}
	private String puscarNombrePorId(String[][] plista,String pid)
	{
		for(int i=0;i<plista.length;i++){
			if(pid.equals(plista[i][0])){
				
				return plista[i][1];
			}
		}
		return "";
	}
	private void cargarPinacotecas()
	{	
		try {
			listaDatosPinacotecas=gestor.listarPinacotecas();
			String[] listaNombrePinacoteca=new String[listaDatosPinacotecas.length];
			for(int i=0; i<listaDatosPinacotecas.length;i++){
				listaNombrePinacoteca[i]=listaDatosPinacotecas[i][1];
			}
			comboBoxPinacoteca.setModel(new DefaultComboBoxModel<>(listaNombrePinacoteca));
			
		}catch (Exception ex) {}
	}
	private boolean validarFecha()
	{	
		
		try{
		if(datefechaPintado.getCalendar().before(dateFechaAdquisicion.getCalendar())){
			
			//La fecha  es anterior.
			
			return true;
		}else{
			//La fecha  no es anterior.
			JOptionPane.showMessageDialog(this,(String) "La fecha es mayor a la fecha actual","Error",JOptionPane.WARNING_MESSAGE);	
			return false;
		}
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(this,"Ingrese la fecha Por favor","Error",JOptionPane.WARNING_MESSAGE);	
			return false;
		}
	}
	
	private String obtenerFechaEnString(JDateChooser pfecha){
		
		 SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
		 return mascara.format(pfecha.getCalendar().getTime());
	}
	
}
