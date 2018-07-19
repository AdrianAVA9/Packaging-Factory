package IU;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import Logica.Gestor;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Color;

public class RegistrarMecena extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnAtras;
	private JButton btnRegistrar;
	private JComboBox comboBoxPais;
	private JComboBox comboBoxCiudad;
	private String[][] listaDatosPiases;
	private String[] listaNombreCiudades;
	private JDateChooser fechaFallecimiento;
	private Gestor gestor;
	private JButton btnAgregarMecenazgo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarMecena frame = new RegistrarMecena();
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
	public RegistrarMecena() {
		setType(Type.UTILITY);
		setResizable(false);
		gestor=new Gestor();
		
		setTitle("Registrar Mecena");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 570, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre Completo");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(27, 45, 165, 32);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(283, 45, 264, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		fechaFallecimiento = new JDateChooser();
		fechaFallecimiento.setBackground(new Color(240, 248, 255));
		fechaFallecimiento.setBounds(283, 86, 264, 28);
		contentPane.add(fechaFallecimiento);
		
		JLabel lblFechafallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechafallecimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechafallecimiento.setBounds(27, 86, 206, 28);
		contentPane.add(lblFechafallecimiento);
		
		
		
		comboBoxPais = new JComboBox();
		comboBoxPais.setBackground(new Color(240, 248, 255));
		comboBoxPais.setMaximumRowCount(100);
		comboBoxPais.setBounds(283, 135, 264, 28);
		comboBoxPais.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				int idPias=puscaridPaisPorNombre(""+comboBoxPais.getSelectedItem());
				cargarCiudades(idPias);
			}
		});
		cargarPaises();
		contentPane.add(comboBoxPais);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(27, 141, 165, 22);
		contentPane.add(lblPais);
		
		comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setBackground(new Color(240, 248, 255));
		comboBoxCiudad.setBounds(283, 190, 264, 28);
		contentPane.add(comboBoxCiudad);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCiudad.setBounds(27, 196, 143, 22);
		contentPane.add(lblCiudad);
		
		btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtras_mouseClicked(e);
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(22, 252, 130, 37);
		contentPane.add(btnAtras);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBounds(404, 252, 143, 37);
		contentPane.add(btnRegistrar);
		
		btnAgregarMecenazgo = new JButton("Agregar Mecenazgo");
		btnAgregarMecenazgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrarMecenazgo ventanaAsingnarRemoverMecenasAPintor= new RegistrarMecenazgo();
				ventanaAsingnarRemoverMecenasAPintor.setLocationRelativeTo(null);
				ventanaAsingnarRemoverMecenasAPintor.setVisible(true);
			}
		});
		btnAgregarMecenazgo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAgregarMecenazgo.setBounds(164, 252, 228, 37);
		contentPane.add(btnAgregarMecenazgo);
		
	    
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
	private void btnRegistrar_mouseClicked(MouseEvent e){
		
		try {
			
			if(!(txtNombre.getText().equals(""))&&validarFecha()&&!(comboBoxCiudad.getSelectedItem().toString().equals("")))
			{
				gestor.agregarMecena(txtNombre.getText(),obtenerFechaEnString(),comboBoxPais.getSelectedItem().toString(),comboBoxCiudad.getSelectedItem().toString());
				txtNombre.setText("");
			}else{
				JOptionPane.showMessageDialog(this,"Ingrese todos los datos por favor","Error",JOptionPane.ERROR_MESSAGE);
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
	
	private boolean validarFecha()
	{	
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
		if(fechaFallecimiento.getCalendar().before(fechaActual)){
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
		 return mascara.format(fechaFallecimiento.getCalendar().getTime());
	}
	 
}
