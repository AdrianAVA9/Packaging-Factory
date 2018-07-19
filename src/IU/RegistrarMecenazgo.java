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
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Window.Type;

public class RegistrarMecenazgo extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxMecenas;
	private JComboBox comboBoxPintores;
	private JComboBox comboBoxMecenasDePintor;
	private Gestor gestor;
	private String[][] listaInfoMecenas;
	private String[][] listaDatosMecenasDelPintor;
	private String[][] listaDatosPintores;
	private JDateChooser fechaTerminaElMecenazgo ;
	private JDateChooser fechaIniciaMecenazgo ;
	private JFrame emisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarMecenazgo frame = new RegistrarMecenazgo();
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
	public RegistrarMecenazgo() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Ingresar Mecenazgo");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 637, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMecenas = new JLabel("Mecenas");
		lblMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMecenas.setBounds(60, 13, 104, 27);
		contentPane.add(lblMecenas);
		
		comboBoxMecenas = new JComboBox();
		comboBoxMecenas.setBackground(new Color(240, 248, 255));
		comboBoxMecenas.setBounds(31, 56, 133, 27);
		contentPane.add(comboBoxMecenas);
		cargarMecenas();
		
		JLabel lblPintores = new JLabel("Pintores");
		lblPintores.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPintores.setBounds(263, 15, 104, 22);
		contentPane.add(lblPintores);
		
		comboBoxPintores = new JComboBox();
		comboBoxPintores.setBackground(new Color(240, 248, 255));
		comboBoxPintores.setBounds(239, 56, 141, 27);
		contentPane.add(comboBoxPintores);
		comboBoxPintores.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				try {
					cargarMecenasDelPintor();
					
				} catch (Exception e2) {}
				
			}
		});
		cargarNombrePintores();
		
		JLabel lblMecenasdelpintor = new JLabel("Mecenas Del Pintor");
		lblMecenasdelpintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMecenasdelpintor.setBounds(434, 18, 221, 16);
		contentPane.add(lblMecenasdelpintor);
		
		comboBoxMecenasDePintor = new JComboBox();
		comboBoxMecenasDePintor.setBackground(new Color(240, 248, 255));
		comboBoxMecenasDePintor.setBounds(444, 56, 141, 27);
		contentPane.add(comboBoxMecenasDePintor);
		
		JLabel lblFechaIniciaMecenazgo = new JLabel("Fecha Inicia Mecenazgo");
		lblFechaIniciaMecenazgo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaIniciaMecenazgo.setBounds(31, 148, 237, 27);
		contentPane.add(lblFechaIniciaMecenazgo);
		
		fechaIniciaMecenazgo = new JDateChooser();
		fechaIniciaMecenazgo.setBackground(new Color(240, 248, 255));
		fechaIniciaMecenazgo.setBounds(385, 143, 215, 27);
		contentPane.add(fechaIniciaMecenazgo);
		
		JLabel lblFechaEnQue = new JLabel("Fecha en que Termina El Mecenazgo");
		lblFechaEnQue.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaEnQue.setBounds(31, 222, 349, 16);
		contentPane.add(lblFechaEnQue);
		
		fechaTerminaElMecenazgo = new JDateChooser();
		fechaTerminaElMecenazgo.setBackground(new Color(240, 248, 255));
		fechaTerminaElMecenazgo.setBounds(385, 211, 215, 27);
		contentPane.add(fechaTerminaElMecenazgo);
		
		JButton btnAtras = new JButton("Salir");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(31, 312, 104, 27);
		contentPane.add(btnAtras);
		
		JButton btnAgregarmecena = new JButton("Agregar Mecena al Pintor");
		btnAgregarmecena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AgregarMecenaAPintor();
			}
		});
		btnAgregarmecena.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAgregarmecena.setBounds(285, 269, 322, 27);
		contentPane.add(btnAgregarmecena);
		
		JButton btnRemovermecenadelpintor = new JButton("Remover Mecena Del Pintor");
		btnRemovermecenadelpintor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removerMecenazgoDelPintor();
			}
		});
		btnRemovermecenadelpintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRemovermecenadelpintor.setBounds(285, 312, 322, 27);
		contentPane.add(btnRemovermecenadelpintor);
	}
	public void setEmisor(JFrame pemisor)
	{
		emisor=pemisor;
	}
	private void cargarMecenas(){
		try {
			listaInfoMecenas=gestor.listarMecenas();
			String mecenas[]=new String[listaInfoMecenas.length];
			for(int i=0; i<listaInfoMecenas.length;i++){
				mecenas[i]=listaInfoMecenas[i][1];
			}
			comboBoxMecenas.setModel(new DefaultComboBoxModel<>(mecenas));
		} catch (Exception e) {
			
		}
	}
	private void cargarMecenasDelPintor(){
		try {
			listaDatosMecenasDelPintor=gestor.buscarDatosMecenaPorPintor(buscaridPorNombre(listaDatosPintores,comboBoxPintores.getSelectedItem().toString()));
			String mecenas[]=new String[listaInfoMecenas.length];
			for(int i=0; i<listaDatosMecenasDelPintor.length;i++){
				mecenas[i]=listaDatosMecenasDelPintor[i][1];
			}
			comboBoxMecenasDePintor.setModel(new DefaultComboBoxModel<>(mecenas));
		} catch (Exception e) {
			
		}
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
	private void cargarNombrePintores(){	
		
		try {
			listaDatosPintores=gestor.listarPintores();
			String[] listaNombrePintores=new String[listaDatosPintores.length];
			
			for(int i=0; i<listaDatosPintores.length;i++){
				listaNombrePintores[i]=listaDatosPintores[i][1];
				
			}
			comboBoxPintores.setModel(new DefaultComboBoxModel(listaNombrePintores));
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}
	private void AgregarMecenaAPintor(){
		try {
			if(verSiMecenaYaProtegeAPintor()!=true&&validarFecha()){
				gestor.crearMecenazgo(buscaridPorNombre(listaDatosPintores,comboBoxPintores.getSelectedItem().toString())
				,buscaridPorNombre(listaInfoMecenas,comboBoxMecenas.getSelectedItem().toString()),
				obtenerFechaEnString(fechaIniciaMecenazgo),obtenerFechaEnString(fechaTerminaElMecenazgo));
				cargarMecenasDelPintor();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No hay mecena para agregar");
		}
	
	}
	private boolean verSiMecenaYaProtegeAPintor(){
		boolean siProtege=false;
		try {
			for(int i=0;i<listaDatosMecenasDelPintor.length;i++){
				if(Integer.parseInt(listaDatosMecenasDelPintor[i][0])==buscaridPorNombre(listaInfoMecenas,comboBoxMecenas.getSelectedItem().toString())){
					siProtege=true;
					JOptionPane.showMessageDialog(null,"La mecena ya protege al Pintor");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Selecione los Datos","Error",JOptionPane.ERROR_MESSAGE);	
		}
			
		return 	siProtege;
	}
	private void removerMecenazgoDelPintor(){
		try {
			gestor.removerMecenazgoAlPintor(buscaridPorNombre(listaDatosMecenasDelPintor,comboBoxMecenasDePintor.getSelectedItem().toString()),
			buscaridPorNombre(listaDatosPintores,comboBoxPintores.getSelectedItem().toString()));
			cargarMecenasDelPintor();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No hay mecena relacionada al pintor para eliminar");
		}
	}
	private boolean validarFecha()
	{	
		
		try{
		if(fechaIniciaMecenazgo.getCalendar().before(fechaTerminaElMecenazgo.getCalendar())){
			
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
