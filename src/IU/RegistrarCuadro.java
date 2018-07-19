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

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCuadro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDimenciones;
	private JTextField txtTecnica;
	private JTextField txtCosto;
	private Gestor gestor;
	private JDateChooser fechaQPinto;
	private JDateChooser fechaLlego;
	private JComboBox comboBoxCondicionActual;
	private JComboBox comboBoxCondicionLlegada;
	private JComboBox comboBoxPinacoteca;
	private JComboBox comboBoxPintor;
	private String[][] listaDatosPintores;
	private String[][] listaDatosPinacotecas;
	private String[][] listaDatosCondicione;
	private FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivo de imagen", "jpg");
	private String rutaImagen;
	private JLabel lblimgcuadro ;
	private String fil;
	private String filName="";
	private Path FROM ;
    private Path TO ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCuadro frame = new RegistrarCuadro();
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
	public RegistrarCuadro() {
		setResizable(false);
		setType(Type.UTILITY);
		gestor=new Gestor();
		setTitle("Registrar Cuadro");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 618, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(24, 29, 99, 23);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(278, 26, 310, 31);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDimenciones = new JLabel("Dimenciones");
		lblDimenciones.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblDimenciones.setBounds(24, 65, 148, 23);
		contentPane.add(lblDimenciones);
		
		txtDimenciones = new JTextField();
		txtDimenciones.setBackground(new Color(240, 248, 255));
		txtDimenciones.setBounds(278, 73, 310, 31);
		txtDimenciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		contentPane.add(txtDimenciones);
		txtDimenciones.setColumns(10);
		
		JLabel lblFechapinto = new JLabel("Fecha que se Pinto");
		lblFechapinto.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechapinto.setBounds(24, 114, 178, 31);
		contentPane.add(lblFechapinto);
		
		fechaQPinto = new JDateChooser();
		fechaQPinto.setBackground(new Color(240, 248, 255));
		fechaQPinto.setBounds(280, 117, 308, 31);
		contentPane.add(fechaQPinto);
		
		JLabel lblTecnica = new JLabel("Tecnica Utilizada");
		lblTecnica.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblTecnica.setBounds(24, 204, 217, 31);
		contentPane.add(lblTecnica);
		
		txtTecnica = new JTextField();
		txtTecnica.setBackground(new Color(240, 248, 255));
		txtTecnica.setBounds(278, 205, 310, 31);
		contentPane.add(txtTecnica);
		txtTecnica.setColumns(10);
		
		JLabel lblCondicionactual = new JLabel("Condicion Actual");
		lblCondicionactual.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionactual.setBounds(24, 248, 206, 31);
		contentPane.add(lblCondicionactual);
		
		comboBoxCondicionActual = new JComboBox();
		comboBoxCondicionActual.setBackground(new Color(240, 248, 255));
		comboBoxCondicionActual.setBounds(278, 249, 310, 31);
		contentPane.add(comboBoxCondicionActual);
		
		JLabel lblCondicionllegada = new JLabel("Condicion de Llegada");
		lblCondicionllegada.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionllegada.setBounds(24, 292, 217, 31);
		contentPane.add(lblCondicionllegada);
		
		comboBoxCondicionLlegada = new JComboBox();
		comboBoxCondicionLlegada.setBackground(new Color(240, 248, 255));
		comboBoxCondicionLlegada.setBounds(280, 293, 308, 31);
		contentPane.add(comboBoxCondicionLlegada);
		cargarCondiciones();
		
		JLabel lblPinacoteca = new JLabel("Pinacoteca");
		lblPinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPinacoteca.setBounds(24, 336, 195, 31);
		contentPane.add(lblPinacoteca);
		
		comboBoxPinacoteca = new JComboBox();
		comboBoxPinacoteca.setBackground(new Color(240, 248, 255));
		comboBoxPinacoteca.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxPinacoteca.setBounds(278, 337, 310, 31);
		contentPane.add(comboBoxPinacoteca);
		cargarPinacotecas();
		
		JLabel lblPintor = new JLabel("Pintor");
		lblPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPintor.setBounds(24, 380, 178, 23);
		contentPane.add(lblPintor);
		
		comboBoxPintor = new JComboBox();
		comboBoxPintor.setBackground(new Color(240, 248, 255));
		comboBoxPintor.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxPintor.setBounds(278, 381, 310, 31);
		contentPane.add(comboBoxPintor);
		cargarPaises();
		
		JLabel lblCostodelcuadro = new JLabel("CostoDelCuadro");
		lblCostodelcuadro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCostodelcuadro.setBounds(24, 428, 217, 23);
		contentPane.add(lblCostodelcuadro);
		
		txtCosto = new JTextField();
		txtCosto.setBackground(new Color(240, 248, 255));
		txtCosto.setBounds(278, 425, 310, 33);
		txtCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
				
				
			}
		});
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		JButton btnAtra = new JButton("< Atra");
		btnAtra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtra_mouseClicked(e);
			}
		});
		btnAtra.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtra.setBounds(12, 648, 99, 31);
		contentPane.add(btnAtra);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBounds(118, 648, 123, 31);
		contentPane.add(btnRegistrar);
		
		JLabel lblFechallego = new JLabel("Fecha en que Llego");
		lblFechallego.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechallego.setBounds(24, 161, 206, 31);
		contentPane.add(lblFechallego);
		
		fechaLlego = new JDateChooser();
		fechaLlego.setBackground(new Color(240, 248, 255));
		fechaLlego.setBounds(278, 161, 310, 31);
		contentPane.add(fechaLlego);
		
		JButton btnCargarImagenDel = new JButton("Seleccionar Imagen");
		btnCargarImagenDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser dig=new JFileChooser();
				dig.setFileFilter(filter);
				int option=dig.showDialog(contentPane, "Seleccionar Imagen");
				if(option==JFileChooser.APPROVE_OPTION){
					fil=dig.getSelectedFile().getPath();
					filName=dig.getSelectedFile().getName();
					String file=dig.getSelectedFile().toString();
					lblimgcuadro.setIcon(new ImageIcon(fil));
					ImageIcon icon= new ImageIcon(fil);
					Image img = icon.getImage();
					Image newImg=img.getScaledInstance(310, 200, java.awt.Image.SCALE_SMOOTH); 
					ImageIcon newIcom=new ImageIcon(newImg);
					lblimgcuadro.setIcon(newIcom);
					lblimgcuadro.setSize(310, 200);
					filName="..//PrPinturaMCalvo//Imgs//"+filName;
					FROM = Paths.get(fil);
				    TO = Paths.get(filName);
				    
				}
			}
		});
		btnCargarImagenDel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnCargarImagenDel.setBounds(24, 523, 206, 31);
		contentPane.add(btnCargarImagenDel);
		
		lblimgcuadro = new JLabel("");
		lblimgcuadro.setBounds(278, 471, 246, 166);
		contentPane.add(lblimgcuadro);
		
		rutaImagen="";
	}
	
	private void btnRegistrar_mouseClicked(MouseEvent e){
		boolean existeNombre=false;
		boolean registrar=true;
		if(comboBoxPinacoteca.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione una pinacoteca por favor","Mensaje",JOptionPane.INFORMATION_MESSAGE);
			registrar=false;
		}
		if(comboBoxPintor.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione una pintor por favor","Mensaje",JOptionPane.INFORMATION_MESSAGE);
			registrar=false;
		}
		try {
			if(!(txtNombre.getText().equals(""))&&!(txtDimenciones.getText().equals(""))&&
			validarFecha()&&!(txtTecnica.getText().equals(""))&&!(txtCosto.getText().equals(""))&&registrar)
			{	
				existeNombre=gestor.registrarCuadro(txtNombre.getText().toString(),
				txtDimenciones.getText().toString(),obtenerFechaEnString(fechaQPinto),
				txtTecnica.getText().toString(),obtenerFechaEnString(fechaLlego),
				puscaridCondicionPorNombre(comboBoxCondicionLlegada.getSelectedItem().toString()),
				puscaridCondicionPorNombre(comboBoxCondicionActual.getSelectedItem().toString()),
				Double.parseDouble(txtCosto.getText()),puscaridPintorPorNombre(comboBoxPintor.getSelectedItem().toString()),
				puscaridPinacotecaPorNombre(comboBoxPinacoteca.getSelectedItem().toString()),filName);
				if(!existeNombre==true){
				
				    try {
				    	if(!(filName.equals(""))){

					    	Files.move(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
				    	}
					} catch (IOException e1) {
						
						
					}
					txtNombre.setText("");
					txtTecnica.setText("");
					txtCosto.setText("");
					txtDimenciones.setText("");
					JOptionPane.showMessageDialog(this,"El resgitro fue exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
				}
			
			}else{
				JOptionPane.showMessageDialog(this,"Ingrese todos los datos por favor","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			ex.printStackTrace();
		}
		if(existeNombre){
			
			JOptionPane.showMessageDialog(this,"El nombre del cuadro ya existe en el sistema","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnAtra_mouseClicked(MouseEvent e){
		Registrar  Registrar= new Registrar();
		Registrar.setLocationRelativeTo(null);
		Registrar.setVisible(true);
		dispose();
	}
	
	private void cargarPaises()
	{	
		try {
			listaDatosPintores=gestor.listarPintores();
			for(int i=0; i<listaDatosPintores.length;i++){
				comboBoxPintor.addItem(listaDatosPintores[i][1]);
			}
			
		}catch (Exception ex) {}
	}
	
	private void cargarPinacotecas()
	{	
		try {
			listaDatosPinacotecas=gestor.listarPinacotecas();
			for(int i=0; i<listaDatosPinacotecas.length;i++){
				comboBoxPinacoteca.addItem(listaDatosPinacotecas[i][1]);
			}
		}catch (Exception ex) {}
	}
	
	private void cargarCondiciones()
	{	
		try {
			listaDatosCondicione=gestor.listarDatosCondicion();
			for(int i=0; i<listaDatosCondicione.length;i++){
				comboBoxCondicionLlegada.addItem(listaDatosCondicione[i][1]);
				comboBoxCondicionActual.addItem(listaDatosCondicione[i][1]);
			}
		}catch (Exception ex) {}
	}
	private int puscaridPintorPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPintores.length;i++){
			if(pnombre.equals(listaDatosPintores[i][1])){
				
				return Integer.parseInt(listaDatosPintores[i][0]);
			}
		}
		return -1;
	}
	private int puscaridPinacotecaPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPinacotecas.length;i++){
			if(pnombre.equals(listaDatosPinacotecas[i][1])){
				
				return Integer.parseInt(listaDatosPinacotecas[i][0]);
			}
		}
		return -1;
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
	private boolean validarFecha()
	{	
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
		if(fechaQPinto.getCalendar().before(fechaLlego.getCalendar())&&fechaQPinto.getCalendar().before(fechaActual)){
			
			//La fecha  es anterior.
			
			return true;
		}else{
			//La fecha  no es anterior.
			JOptionPane.showMessageDialog(this,"Ingrese la fecha correctamente."+"\nLa fecha presenta una condicion no valida.","Error",JOptionPane.WARNING_MESSAGE);	
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
