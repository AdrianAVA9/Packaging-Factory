package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.JComboBox;
import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Color;

public class RegistrarPintor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPseudonimo;
	private JComboBox comboBoxCiudad;
	private JComboBox comboBoxMaestros;
	private JComboBox comboBoxPais;
	private JComboBox comboBoxEscuela;
	private String[][] listaDatosPiases;
	private String[][] listaDatosMestros;
	private String[][] listaDatosEscuelas;
	private String[] listaNombreCiudades;
	private JDateChooser fechaNacimiento;
	private JDateChooser fechaFallecimiento;
	private Gestor gestor;
	private static RegistrarPintor frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegistrarPintor();
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
	public RegistrarPintor() {
		setResizable(false);
		setType(Type.UTILITY);
		gestor=new Gestor();
		setTitle("Registrar Pintor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 604, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre Completo");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(12, 25, 239, 34);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(252, 27, 325, 32);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaNacimiento.setBounds(12, 83, 191, 32);
		contentPane.add(lblFechaNacimiento);
		
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBackground(new Color(240, 248, 255));
		fechaNacimiento.setBounds(252, 82, 325, 33);
		contentPane.add(fechaNacimiento);
		
		JLabel lblFechafallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechafallecimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechafallecimiento.setBounds(12, 145, 217, 24);
		contentPane.add(lblFechafallecimiento);
		
		fechaFallecimiento = new JDateChooser();
		fechaFallecimiento.setBackground(new Color(240, 248, 255));
		fechaFallecimiento.setBounds(252, 135, 325, 34);
		contentPane.add(fechaFallecimiento);
		
		JLabel lblPseudonimo = new JLabel("Pseudonimo");
		lblPseudonimo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPseudonimo.setBounds(12, 196, 172, 24);
		contentPane.add(lblPseudonimo);
		
		txtPseudonimo = new JTextField();
		txtPseudonimo.setBackground(new Color(240, 248, 255));
		txtPseudonimo.setBounds(252, 190, 325, 30);
		contentPane.add(txtPseudonimo);
		txtPseudonimo.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais de Nacimiento");
		lblPais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(12, 251, 191, 24);
		contentPane.add(lblPais);
		
		comboBoxPais = new JComboBox();
		comboBoxPais.setBackground(new Color(240, 248, 255));
		comboBoxPais.setMaximumRowCount(100);
		comboBoxPais.setBounds(252, 241, 325, 34);
		comboBoxPais.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				int idPias=puscaridPaisPorNombre(""+comboBoxPais.getSelectedItem());
				cargarCiudades(idPias);
			}
		});
		cargarPaises();
		contentPane.add(comboBoxPais);
		
		JLabel lblCiudad = new JLabel("Ciudad de Nacimiento");
		lblCiudad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCiudad.setBounds(12, 306, 204, 24);
		contentPane.add(lblCiudad);
		
		comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setBackground(new Color(240, 248, 255));
		comboBoxCiudad.setMaximumRowCount(100);
		comboBoxCiudad.setBounds(252, 302, 325, 34);
		contentPane.add(comboBoxCiudad);
		
		JLabel lblMaestros = new JLabel("Maestros");
		lblMaestros.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMaestros.setBounds(12, 359, 191, 34);
		contentPane.add(lblMaestros);
		
		comboBoxMaestros = new JComboBox();
		comboBoxMaestros.setBackground(new Color(240, 248, 255));
		comboBoxMaestros.setMaximumRowCount(100);
		comboBoxMaestros.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxMaestros.setBounds(252, 360, 325, 34);
		contentPane.add(comboBoxMaestros);
		cargarMaestros();
		
		JLabel lblNewLabel = new JLabel("Escuela Donde Estudio");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(12, 421, 245, 32);
		contentPane.add(lblNewLabel);
		
		comboBoxEscuela = new JComboBox();
		comboBoxEscuela.setBackground(new Color(240, 248, 255));
		comboBoxEscuela.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxEscuela.setMaximumRowCount(100);
		comboBoxEscuela.setBounds(252, 421, 325, 32);
		contentPane.add(comboBoxEscuela);
		cargarEscuelas();
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtras_mouseClicked(e);
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(12, 513, 113, 41);
		contentPane.add(btnAtras);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBounds(436, 513, 128, 41);
		contentPane.add(btnRegistrar);
		
		JButton btnAgregarmecenaAUn = new JButton("Agregar Mecenas");
		btnAgregarmecenaAUn.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAgregarmecenaAUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarMecenazgo ventanaAsingnarRemoverMecenasAPintor= new RegistrarMecenazgo();
				ventanaAsingnarRemoverMecenasAPintor.setLocationRelativeTo(null);
				ventanaAsingnarRemoverMecenasAPintor.setVisible(true);
				
			}
		});
		btnAgregarmecenaAUn.setBounds(207, 513, 217, 41);
		contentPane.add(btnAgregarmecenaAUn);
	}
	private void btnRegistrar_mouseClicked(MouseEvent e){
		boolean existeNombre=false;
		try {
			if(!(txtNombre.getText().equals(""))&&validarFecha()&&!(txtPseudonimo.getText().equals("")))
			{	
				existeNombre=gestor.registrarPintor(txtNombre.getText().toString(),txtPseudonimo.getText().toString(),
				puscarNacionalidadPorNombrePais(comboBoxPais.getSelectedItem().toString()),
				comboBoxPais.getSelectedItem().toString(),comboBoxCiudad.getSelectedItem().toString(),
				obtenerFechaEnString(fechaNacimiento),obtenerFechaEnString(fechaFallecimiento),
				puscaridEscuelaPorNombre(comboBoxEscuela.getSelectedItem().toString()),puscaridMaestroPorNombre(comboBoxMaestros.getSelectedItem().toString()));
				if(!existeNombre==true){
					txtNombre.setText("");
					txtPseudonimo.setText("");
					JOptionPane.showMessageDialog(this,"El resgitro fue exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(this,"Ingrese todos los datos correctamente por favor","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			ex.printStackTrace();
		}
		if(existeNombre){
			
			JOptionPane.showMessageDialog(this,"El nombre del pintor ya existe en el sistema","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	private void btnAtras_mouseClicked(MouseEvent e){
		Registrar  Registrar= new Registrar();
		Registrar.setLocationRelativeTo(null);
		Registrar.setVisible(true);
		dispose();
	}
	
	private void cargarPaises()
	{	
		
		
		try {
			listaDatosPiases=gestor.listarPaises();
			String pais[]=new String[listaDatosPiases.length];
			
			for(int i=0; i<listaDatosPiases.length;i++){
				pais[i]=listaDatosPiases[i][1];
			}
			comboBoxPais.setModel(new DefaultComboBoxModel<>(pais));
		}
		catch (Exception ex) {
			
			
		}
	}
	
	private void cargarCiudades(int idPais){
		
		
		try {
			listaNombreCiudades=gestor.listarNombreCiudades(idPais);
			comboBoxCiudad.setModel(new DefaultComboBoxModel<>(listaNombreCiudades));
		}
		catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			ex.printStackTrace();
		}
	}
	
	private boolean validarFecha()
	{	
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
		if(fechaNacimiento.getCalendar().before(fechaFallecimiento.getCalendar())&&fechaNacimiento.getCalendar().before(fechaActual)){
			
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
	
	private int puscaridPaisPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPiases.length;i++){
			if(pnombre.equals(listaDatosPiases[i][1])){
				
				return Integer.parseInt(listaDatosPiases[i][0]);
			}
		}
		return -1;
	}
	
	private int puscaridEscuelaPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosEscuelas.length;i++){
			if(pnombre.equals(listaDatosEscuelas[i][1])){
				
				return Integer.parseInt(listaDatosEscuelas[i][0]);
			}
		}
		return 0;
	}
	
	private int puscaridMaestroPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosMestros.length;i++){
			if(pnombre.equals(listaDatosMestros[i][1])){
				
				return Integer.parseInt(listaDatosMestros[i][0]);
			}
		}
		return 0;
	}
	
	
	
	
	private void cargarMaestros(){	
		
		
		try {
			listaDatosMestros=gestor.listarPintores();
			
			for(int i=0; i<listaDatosMestros.length;i++){
				
				comboBoxMaestros.addItem(listaDatosMestros[i][1]);
			}
			
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
	}
	private void cargarEscuelas(){	
		
		
		try {
			listaDatosEscuelas=gestor.listarEscuelas();
			String escuela[]=new String[listaDatosEscuelas.length];
			
			for(int i=0; i<listaDatosEscuelas.length;i++){
				escuela[i]=listaDatosEscuelas[i][1];
				comboBoxEscuela.addItem(escuela[i]);
			}
			
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
	}
	private String  puscarNacionalidadPorNombrePais(String pnombre)
	{
		for(int i=0;i<listaDatosPiases.length;i++){
			if(pnombre.equals(listaDatosPiases[i][1])){
				
				return listaDatosPiases[i][2];
			}
		}
		return "";
	}
}
