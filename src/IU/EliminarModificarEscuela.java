package IU;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.JTextArea;
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

public class EliminarModificarEscuela extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private Gestor gestor;
	private String[][] listaDatosEscuelas;
	private JComboBox comboBoxEscuela;
	private JComboBox comoboBoxPais ;
	private JTextArea textAreaCaracteristias;
	private ArrayList<String> listaDatosEscuela;
	private String[][] listaDatosPiases;
	private JDateChooser dateFechaAdquisicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificarEscuela frame = new EliminarModificarEscuela();
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
	public EliminarModificarEscuela() {
		setType(Type.UTILITY);
		gestor=new Gestor();
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("Eliminar Modificar Escuela");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setForeground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 574, 0);
		contentPane.add(label);
		
		JLabel lblSeleccioneLaEscuela = new JLabel("Seleccione la escuela");
		lblSeleccioneLaEscuela.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSeleccioneLaEscuela.setBounds(30, 37, 234, 25);
		contentPane.add(lblSeleccioneLaEscuela);
		
		comboBoxEscuela = new JComboBox();
		comboBoxEscuela.setBackground(new Color(240, 248, 255));
		comboBoxEscuela.setBounds(283, 31, 296, 31);
		cargarEscuelas();
		contentPane.add(comboBoxEscuela);
		comboBoxEscuela.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				try {
					if(!(comboBoxEscuela.getSelectedIndex()==-1)){
						cargarDatosEscuelaAIntefaz();
					}
					
				} catch (Exception e2) {}
				
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(30, 91, 153, 21);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(new Color(240, 248, 255));
		textFieldNombre.setBounds(283, 91, 296, 31);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha Aparicion");
		lblFecha.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFecha.setBounds(30, 150, 234, 23);
		contentPane.add(lblFecha);
		
		dateFechaAdquisicion = new JDateChooser();
		dateFechaAdquisicion.setBackground(new Color(240, 248, 255));
		dateFechaAdquisicion.setBounds(283, 152, 296, 31);
		contentPane.add(dateFechaAdquisicion);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(30, 200, 93, 23);
		contentPane.add(lblPais);
		
		comoboBoxPais = new JComboBox();
		comoboBoxPais.setBackground(new Color(240, 248, 255));
		comoboBoxPais.setBounds(283, 204, 296, 31);
		contentPane.add(comoboBoxPais);
		
		JLabel lblCaracteristicas = new JLabel("Caracteristicas");
		lblCaracteristicas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCaracteristicas.setBounds(30, 303, 183, 23);
		contentPane.add(lblCaracteristicas);
		
		textAreaCaracteristias = new JTextArea();
		textAreaCaracteristias.setBackground(new Color(240, 248, 255));
		textAreaCaracteristias.setBounds(187, 259, 337, 275);
		contentPane.add(textAreaCaracteristias);
		JScrollPane scroll = new JScrollPane(textAreaCaracteristias);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(283, 258, 296, 141);
	    contentPane.add(scroll);
		
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
		botonAtras.setBounds(12, 465, 140, 47);
		contentPane.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonEliminar_mouseClicked(e);
			}
		});
		botonEliminar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonEliminar.setBounds(296, 465, 135, 47);
		contentPane.add(botonEliminar);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonModificar_mouseClicked(e);
			}
		});
		botonModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonModificar.setBounds(443, 465, 127, 47);
		contentPane.add(botonModificar);
	}
	
	private void botonEliminar_mouseClicked(MouseEvent e){
		
		try {
			gestor.eliminarEsuela(buscaridPorNombre(listaDatosEscuelas,comboBoxEscuela.getSelectedItem().toString()));
			cargarEscuelas();
		} catch (Exception e1) {
			limpiarDatos();
			JOptionPane.showMessageDialog(null,"No hay Escuela para Eliminar");
		}
	}
	
	private void limpiarDatos(){
		textFieldNombre.setText("");
		textAreaCaracteristias.setText("");
		comoboBoxPais.setModel(new DefaultComboBoxModel(new String[]{""}));
		comboBoxEscuela.setModel(new DefaultComboBoxModel(new String[]{""}));
		
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/mm/yyyy");
		java.util.Date fechaDate;
		try {
			fechaDate = formato.parse("1/1/1");
			dateFechaAdquisicion.setDate(fechaDate);
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		
	}
	private void botonModificar_mouseClicked(MouseEvent e){
		
		if(!(textFieldNombre.getText().equals(""))&&validarFecha()
		&&!(textAreaCaracteristias.getText().equals(""))&&
		!(comoboBoxPais.getSelectedItem().toString().equals("")))
		{	
			try {
				gestor.actualizarEscuela(buscaridPorNombre(listaDatosEscuelas,comboBoxEscuela.getSelectedItem().toString()), textFieldNombre.getText(),
				comoboBoxPais.getSelectedItem().toString(), obtenerFechaEnString(dateFechaAdquisicion),
				textAreaCaracteristias.getText());
				cargarEscuelas();
				comboBoxEscuela.setSelectedIndex(0);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"No se pudo realizar la actualizacion ");
			}
					
		 }else{
			 JOptionPane.showMessageDialog(null,"Por favor ingrese todos los campos");
		 }
		
	}
	
	private void cargarDatosEscuelaAIntefaz(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/mm/yyyy");
		String caracteristicas="";
		int contCaracter=0;
		try {
			listaDatosEscuela=new ArrayList<String>();
			listaDatosEscuela=gestor.buscarEscuela(buscaridPorNombre(listaDatosEscuelas,comboBoxEscuela.getSelectedItem().toString()));
			textFieldNombre.setText(listaDatosEscuela.get(1));
			
			for(int i=0;i<listaDatosEscuela.get(3).length();i++){
				caracteristicas+=listaDatosEscuela.get(3).charAt(i);
				if(contCaracter>=35){
					caracteristicas+="-\n";
					contCaracter=0;
				}
				contCaracter++;
			}
			
			textAreaCaracteristias.setText(caracteristicas);
			cargarPaises();
			buscarIndexComboBox(comoboBoxPais,listaDatosEscuela.get(2));
			java.util.Date fechaDate = formato.parse(listaDatosEscuela.get(4));
			dateFechaAdquisicion.setDate(fechaDate);
		} catch (Exception e1) {}
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
	
	private boolean validarFecha()
	{	
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
			if(dateFechaAdquisicion.getCalendar().before(fechaActual)){
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
	
	private void cargarPaises()
	{	
		try {
			listaDatosPiases=gestor.listarPaises();
			String pais[]=new String[listaDatosPiases.length];
			
			for(int i=0; i<listaDatosPiases.length;i++){
				pais[i]=listaDatosPiases[i][1];
			}
			comoboBoxPais.setModel(new DefaultComboBoxModel<>(pais));
		}
		catch (Exception ex) {}
	}
	private void cargarEscuelas(){	
		
		
		try {
			listaDatosEscuelas=gestor.listarEscuelas();
			String escuela[]=new String[listaDatosEscuelas.length];
			
			for(int i=0; i<listaDatosEscuelas.length;i++){
				escuela[i]=listaDatosEscuelas[i][1];
				
			}
			comboBoxEscuela.setModel(new DefaultComboBoxModel(escuela));
		}
		catch (Exception ex) {}
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
}
