package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Window.Type;

import javax.management.loading.PrivateClassLoader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class EliminarModificarPintor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldPseudonimo;
	private JComboBox comboBoxPintor;
	private JComboBox comboBoxCiudad;
	private JComboBox comboBoxPais;
	private JDateChooser dateFechaNacimiento;
	private JDateChooser dateFechaFallecimiento;
	private JTextField txtNacionalidad;
	private String[][] listaDatosPintores;
	private String[][] listaDatosPiases;
	private String[] listaNombreCiudades;
	private ArrayList<String> listaDatosPintor;
	private JComboBox comboBoxMaestros;
	private JComboBox comboBoxEscuela;
	private String[][] listaDatosMestros;
	private String[][] listaDatosEscuelas;
	
	private Gestor gestor;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificarPintor frame = new EliminarModificarPintor();
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
	public EliminarModificarPintor() {
		setType(Type.UTILITY);
		gestor=new Gestor();
		setResizable(false);
		setForeground(new Color(255, 204, 51));
		setTitle("Eliminar Modificar Pintor");
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 655, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		comboBoxPintor = new JComboBox();
		comboBoxPintor.setBackground(new Color(240, 248, 255));
		comboBoxPintor.setBounds(284, 32, 335, 31);
		contentPane.add(comboBoxPintor);
		cargarNombrePintores();
		comboBoxPintor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				try {
				
					if(!(comboBoxPintor.getSelectedIndex()==-1)){
						cargarDatosPintorAIntefaz();
					}else{
						
					}
					
					
				} catch (Exception e2) {}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(22, 77, 128, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(22, 33, 128, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pseudonimo");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(22, 178, 152, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pais Nacimiento");
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(24, 238, 176, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad");
		lblNewLabel_4.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(22, 300, 165, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad");
		lblNewLabel_5.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(22, 349, 178, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha Nacimiento");
		lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(22, 496, 178, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha Fallecimiento");
		lblNewLabel_7.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(22, 548, 211, 25);
		contentPane.add(lblNewLabel_7);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBackground(new Color(240, 248, 255));
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(284, 82, 335, 31);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldPseudonimo = new JTextField();
		textFieldPseudonimo.setBackground(new Color(240, 248, 255));
		textFieldPseudonimo.setBounds(284, 178, 335, 31);
		contentPane.add(textFieldPseudonimo);
		textFieldPseudonimo.setColumns(10);
		
		comboBoxPais = new JComboBox();
		comboBoxPais.setBackground(new Color(240, 248, 255));
		comboBoxPais.setBounds(284, 232, 335, 31);
		comboBoxPais.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				int idPias=puscaridPorNombre(listaDatosPiases,""+comboBoxPais.getSelectedItem());
				cargarCiudades(idPias);
				for(int i=0;i<listaDatosPiases.length;i++){
					if(comboBoxPais.getSelectedItem().toString().equals(listaDatosPiases[i][1])){
						txtNacionalidad.setText(listaDatosPiases[i][2]);
						break;
					}
				}
			}
		});
		contentPane.add(comboBoxPais);
		
		comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setBackground(new Color(240, 248, 255));
		comboBoxCiudad.setBounds(284, 290, 335, 31);
		contentPane.add(comboBoxCiudad);
		
		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBackground(new Color(240, 248, 255));
		dateFechaNacimiento.setBounds(284, 495, 335, 31);
		contentPane.add(dateFechaNacimiento);
		
		dateFechaFallecimiento = new JDateChooser();
		dateFechaFallecimiento.setBackground(new Color(240, 248, 255));
		dateFechaFallecimiento.setBounds(284, 548, 335, 31);
		contentPane.add(dateFechaFallecimiento);
		
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
		botonAtras.setBounds(12, 655, 119, 40);
		contentPane.add(botonAtras);
		
		JButton botonVerMecenas = new JButton("Modificar Mecenazgo");
		botonVerMecenas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarMecenazgo ventanaAsingnarRemoverMecenasAPintor= new RegistrarMecenazgo();
				ventanaAsingnarRemoverMecenasAPintor.setLocationRelativeTo(null);
				ventanaAsingnarRemoverMecenasAPintor.setVisible(true);
			}
		});
		botonVerMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonVerMecenas.setBounds(284, 604, 335, 38);
		contentPane.add(botonVerMecenas);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonModificar_mouseClicked(e);
			}
		});
		botonModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonModificar.setBounds(284, 655, 165, 40);
		contentPane.add(botonModificar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonEliminar_mouseClicked(e);
			}
		});
		botonEliminar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonEliminar.setBounds(467, 655, 152, 40);
		contentPane.add(botonEliminar);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBackground(new Color(240, 248, 255));
		txtNacionalidad.setBounds(284, 351, 335, 31);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(22, 127, 109, 25);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(284, 129, 335, 31);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEscuela = new JLabel("Escuela");
		lblEscuela.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblEscuela.setBounds(22, 404, 194, 25);
		contentPane.add(lblEscuela);
		
		comboBoxEscuela = new JComboBox();
		comboBoxEscuela.setBackground(new Color(240, 248, 255));
		comboBoxEscuela.setBounds(284, 399, 335, 31);
		contentPane.add(comboBoxEscuela);
		
		JLabel lblMaestro = new JLabel("Maestro");
		lblMaestro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMaestro.setBounds(22, 442, 178, 31);
		contentPane.add(lblMaestro);
		
		comboBoxMaestros = new JComboBox();
		comboBoxMaestros.setBackground(new Color(240, 248, 255));
		comboBoxMaestros.setBounds(284, 447, 335, 31);
		contentPane.add(comboBoxMaestros);
	}
	
	private void botonEliminar_mouseClicked(MouseEvent e){
		
		String[][] listaCuadrosPintor;
		   
		  try {
		   listaCuadrosPintor = gestor.buscarCuadrosPorPintor(Integer.parseInt(textFieldCodigo.getText().toString()));
		   if(listaCuadrosPintor.length==0){    
		    gestor.eliminarPintor(Integer.parseInt(textFieldCodigo.getText()));
		    cargarNombrePintores();
		    comboBoxPintor.setSelectedIndex(0);
		   }else{
		    
		    JOptionPane.showMessageDialog(null, "Hay cuadros asociados al pintor \nprimero debe eliminarlos ","Error",JOptionPane.ERROR_MESSAGE);   
		   }
		   
		  } catch (Exception e1) {
		   limpiarDatos();
		   JOptionPane.showMessageDialog(null,"No hay Pintor para Eliminar");
		  }
//		try {
//			gestor.eliminarPintor(Integer.parseInt(textFieldCodigo.getText()));
//			cargarNombrePintores();
//			comboBoxPintor.setSelectedIndex(0);
//		} catch (Exception e1) {
//			limpiarDatos();
//			JOptionPane.showMessageDialog(null,"No hay Pintor para Eliminar");
//		}
	}
	
	private void botonModificar_mouseClicked(MouseEvent e){
		if(!(textFieldPseudonimo.getText().equals(""))&&validarFecha()
		&&!(txtNacionalidad.getText().equals(""))&&!(txtNombre.getText().equals(""))&&
		!(comboBoxPintor.getSelectedItem().toString().equals("")))
		{	try {
			
				gestor.actualizarPintor(Integer.parseInt(textFieldCodigo.getText()),txtNombre.getText(),
				textFieldPseudonimo.getText(), txtNacionalidad.getText(), comboBoxPais.getSelectedItem().toString(),
				comboBoxCiudad.getSelectedItem().toString(),obtenerFechaEnString(dateFechaNacimiento),
				obtenerFechaEnString(dateFechaFallecimiento),
				puscaridPorNombre(listaDatosMestros,""+comboBoxMaestros.getSelectedItem()),
				puscaridPorNombre(listaDatosEscuelas,""+comboBoxEscuela.getSelectedItem()));
				cargarNombrePintores();
				comboBoxPintor.setSelectedIndex(0);
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null,"No se pudo realizar la actualizacion");
			}
		}else{
			JOptionPane.showMessageDialog(null,"Ingrese todos los campos por favor");
		}
	}
	
	private void limpiarDatos(){
		txtNombre.setText("");
		txtNacionalidad.setText("");
		textFieldCodigo.setText("");
		textFieldPseudonimo.setText("");
		comboBoxPintor.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxPais.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxMaestros.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxEscuela.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxCiudad.setModel(new DefaultComboBoxModel(new String[]{""}));
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/mm/yyyy");
		java.util.Date fechaDate;
		try {
			fechaDate = formato.parse("1/1/1");
			dateFechaNacimiento.setDate(fechaDate);
			fechaDate = formato.parse("1/1/1");
			dateFechaFallecimiento.setDate(fechaDate);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	private void cargarDatosPintorAIntefaz(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
		
		try {
			listaDatosPintor=new ArrayList<String>();
			listaDatosPintor=gestor.buscarPintor(puscarIdPintorPorNombre(comboBoxPintor.getSelectedItem().toString()));
			txtNombre.setText(listaDatosPintor.get(0));
			textFieldCodigo.setText(listaDatosPintor.get(1));
			textFieldPseudonimo.setText(listaDatosPintor.get(2));
			txtNacionalidad.setText(listaDatosPintor.get(3));
			comboBoxPais.setSelectedItem(listaDatosPintor.get(4));
			cargarPaises();
			cargarMaestros();
			cargarEscuelas();
			buscarIndexComboBox(comboBoxPais,listaDatosPintor.get(4));
			buscarIndexComboBox(comboBoxMaestros,puscarNombrePorId(listaDatosMestros,listaDatosPintor.get(9)));
			buscarIndexComboBox(comboBoxEscuela,puscarNombrePorId(listaDatosEscuelas,listaDatosPintor.get(8)));
			java.util.Date fechaDate = formato.parse(listaDatosPintor.get(7));
			dateFechaNacimiento.setDate(fechaDate);
			fechaDate = formato.parse(listaDatosPintor.get(6));
			dateFechaFallecimiento.setDate(fechaDate);
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
	private int puscarIdPintorPorNombre(String pnombre)
	{
		for(int i=0;i<listaDatosPintores.length;i++){
			if(pnombre.equals(listaDatosPintores[i][1])){
				
				return Integer.parseInt(listaDatosPintores[i][0]);
				
			}
		}
		return 0;
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
		catch (Exception ex) {}
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
	
	private int puscaridPorNombre(String[][] lista,String pnombre)
	{
		for(int i=0;i<lista.length;i++){
			if(pnombre.equals(lista[i][1])){
				
				return Integer.parseInt(lista[i][0]);
			}
		}
		return -1;
	}
	
	private boolean validarFecha()
	{	
		
		try{
		if(dateFechaNacimiento.getCalendar().before(dateFechaFallecimiento.getCalendar())){
			
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
			;
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
	
	
}
