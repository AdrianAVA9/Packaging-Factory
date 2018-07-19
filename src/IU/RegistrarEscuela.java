package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Window.Type;
import java.awt.Color;

public class RegistrarEscuela extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox comboBoxPais;
	private Gestor gestor;
	private JDateChooser dateChooserFechaInicio;
	private JTextArea textAreaDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEscuela frame = new RegistrarEscuela();
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
	public RegistrarEscuela() {
		setType(Type.UTILITY);
		setResizable(false);
		gestor=new Gestor();
		setTitle("Registrar Escuela");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(12, 13, 88, 31);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(177, 13, 229, 31);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(new Color(240, 248, 255));
		textAreaDescripcion.setBounds(183, 57, 223, 96);
		JScrollPane scroll = new JScrollPane(textAreaDescripcion);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(177, 57, 229, 96);
		contentPane.add(scroll);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblDescripcion.setBounds(12, 99, 129, 26);
		contentPane.add(lblDescripcion);
		
		dateChooserFechaInicio = new JDateChooser();
		dateChooserFechaInicio.setBackground(new Color(240, 248, 255));
		dateChooserFechaInicio.setBounds(177, 184, 229, 31);
		contentPane.add(dateChooserFechaInicio);
		
		JLabel lblFechaAparecio = new JLabel("Fecha Aparecio");
		lblFechaAparecio.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaAparecio.setBounds(12, 184, 159, 31);
		contentPane.add(lblFechaAparecio);
		
		comboBoxPais = new JComboBox();
		comboBoxPais.setBackground(new Color(240, 248, 255));
		comboBoxPais.setBounds(177, 245, 229, 31);
		cargarPaises();
		contentPane.add(comboBoxPais);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(12, 252, 88, 24);
		contentPane.add(lblPais);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtras_mouseClicked(e);
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(26, 329, 129, 37);
		contentPane.add(btnAtras);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBounds(266, 329, 140, 37);
		contentPane.add(btnRegistrar);
	}
	
	private void btnRegistrar_mouseClicked(MouseEvent e){
		try {
			
			if(!(txtNombre.getText().equals("")) && validarFecha()&&!(textAreaDescripcion.getText().equals("")))
			{
				gestor.registrarEscuela(txtNombre.getText(),textAreaDescripcion.getText(),obtenerFechaEnString(),comboBoxPais.getSelectedItem().toString());
				
				JOptionPane.showMessageDialog(this,"El registro fue exitoso","Mebsaje",JOptionPane.INFORMATION_MESSAGE);
				txtNombre.setText("");
				textAreaDescripcion.setText("");
			}else{
				JOptionPane.showMessageDialog(this,"Ingrese todos los datos correctamente por favor","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			ex.printStackTrace();
		}
	}
	
	private void btnAtras_mouseClicked(MouseEvent e){
		Registrar  Registrar= new Registrar();
		Registrar.setLocationRelativeTo(null);
		Registrar.setVisible(true);
		dispose();
	}
	
	private void cargarPaises(){
		
		
		try {
			
			comboBoxPais.setModel(new DefaultComboBoxModel<>(gestor.listarNombrePaises()));
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
		if(dateChooserFechaInicio.getCalendar().before(fechaActual)){
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
	
	private String obtenerFechaEnString(){
		
		 SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
		 return mascara.format(dateChooserFechaInicio.getCalendar().getTime());
	}
}
