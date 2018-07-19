package IU;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Window.Type;

public class EliminarModificarPinacoteca extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldAreaCobertura;
	private Gestor gestor ;
	private JComboBox comboBoxPinacoteca;
	private String[][] listaInfoPinacotecas;
	private ArrayList<String> listaDatosPinacoteca;
	private JDateChooser dateFechaInauguracion ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificarPinacoteca frame = new EliminarModificarPinacoteca();
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
	public EliminarModificarPinacoteca() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setType(Type.UTILITY);
		gestor=new Gestor();
		setResizable(false);
		setTitle("Eliminar Modificar Pinacoteca");
		setBounds(100, 100, 624, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblSeleccione = new JLabel("Seleccione la pinacoteca");
		lblSeleccione.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSeleccione.setBounds(23, 27, 263, 24);
		contentPane.add(lblSeleccione);
		
		comboBoxPinacoteca = new JComboBox();
		comboBoxPinacoteca.setForeground(Color.BLACK);
		comboBoxPinacoteca.setBounds(298, 28, 308, 32);
		cargarPinacoteca();
		contentPane.add(comboBoxPinacoteca);
		comboBoxPinacoteca.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				try {
					cargarDatosPinacotecaAIntefaz();
					if(!(comboBoxPinacoteca.getSelectedIndex()==-1)){
						cargarDatosPinacotecaAIntefaz();
					}else{
						
					}
				} catch (Exception e2) {}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(23, 76, 170, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.BLACK);
		textFieldNombre.setBounds(298, 72, 308, 32);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inauguracion");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(23, 128, 206, 19);
		contentPane.add(lblNewLabel_1);
		
		dateFechaInauguracion = new JDateChooser();
		dateFechaInauguracion.setForeground(Color.BLACK);
		dateFechaInauguracion.setBounds(298, 122, 308, 32);
		contentPane.add(dateFechaInauguracion);
		
		JLabel lblAreaCoberturam = new JLabel("Area cobertura");
		lblAreaCoberturam.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblAreaCoberturam.setBounds(23, 185, 226, 24);
		contentPane.add(lblAreaCoberturam);
		
		textFieldAreaCobertura = new JTextField();
		textFieldAreaCobertura.setForeground(Color.BLACK);
		textFieldAreaCobertura.setBounds(298, 179, 308, 32);
		contentPane.add(textFieldAreaCobertura);
		textFieldAreaCobertura.setColumns(10);
		
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
		botonAtras.setBounds(23, 246, 105, 45);
		contentPane.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				botonEliminar_mouseClicked(e);
			}
		});
		botonEliminar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonEliminar.setBounds(346, 246, 125, 45);
		contentPane.add(botonEliminar);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonModificar_mouseClicked(e);
			}
		});
		botonModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonModificar.setBounds(483, 246, 123, 45);
		contentPane.add(botonModificar);
	}
	private void botonModificar_mouseClicked(MouseEvent e){
		
		if(!(textFieldNombre.getText().equals(""))&&!(textFieldAreaCobertura.getText().equals(""))){
			try {
				gestor.actualizarPinacoteca(buscaridPorNombre(listaInfoPinacotecas,comboBoxPinacoteca.getSelectedItem().toString()),
				textFieldNombre.getText(),textFieldAreaCobertura.getText(),obtenerFechaEnString(dateFechaInauguracion));
				cargarPinacoteca();
				comboBoxPinacoteca.setSelectedIndex(0);
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null,"Ingrese los datos correctamente por favor");
			}
		}
	}
	
	private void botonEliminar_mouseClicked(MouseEvent e){
		try {
			gestor.eliminarPinacoteca(buscaridPorNombre(listaInfoPinacotecas,comboBoxPinacoteca.getSelectedItem().toString()));
			cargarPinacoteca();
		} catch (Exception e1) {
			limpiarDatos();
			JOptionPane.showMessageDialog(null,"No hay Pinacoteca para Eliminar");
		}
	}
		
	

	private void limpiarDatos(){
		textFieldNombre.setText("");
		textFieldAreaCobertura.setText("");
		
		
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/mm/yyyy");
		java.util.Date fechaDate;
		try {
			fechaDate = formato.parse("1/1/1");
			dateFechaInauguracion.setDate(fechaDate);
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		
	}
	private void cargarPinacoteca(){	
		
		
		try {
			listaInfoPinacotecas=gestor.listarPinacotecas();
			String pinacoteca[]=new String[listaInfoPinacotecas.length];
			
			for(int i=0; i<listaInfoPinacotecas.length;i++){
				pinacoteca[i]=listaInfoPinacotecas[i][1];
				
			}
			comboBoxPinacoteca.setModel(new DefaultComboBoxModel(pinacoteca));
		}
		catch (Exception ex) {}
	}
	private void cargarDatosPinacotecaAIntefaz(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
	
		try {
			listaDatosPinacoteca=new ArrayList<String>();
			listaDatosPinacoteca=gestor.buscarPinacotecas(buscaridPorNombre(listaInfoPinacotecas,comboBoxPinacoteca.getSelectedItem().toString()));
			textFieldNombre.setText(listaDatosPinacoteca.get(3));
			textFieldAreaCobertura.setText(listaDatosPinacoteca.get(2));
			java.util.Date fechaDate = formato.parse(listaDatosPinacoteca.get(1));
			dateFechaInauguracion.setDate(fechaDate);
		} catch (Exception e1) {}
	}
	private int buscaridPorNombre(String[][] lista,String pnombre)
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
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
			if(dateFechaInauguracion.getCalendar().before(fechaActual)){
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
