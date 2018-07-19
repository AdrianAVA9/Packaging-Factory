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

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Window.Type;
import java.awt.Color;

public class RegistrarPinacoteca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMetroscuadrados;
	private JDateChooser fechaInaguracion ;
	private Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPinacoteca frame = new RegistrarPinacoteca();
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
	public RegistrarPinacoteca() {
		setType(Type.UTILITY);
		setResizable(false);
		gestor=new Gestor();
		setTitle("Registrar Pinacoteca");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombre.setBounds(12, 13, 121, 22);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(195, 14, 225, 32);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFechainaguracion = new JLabel("FechaInaguracion");
		lblFechainaguracion.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechainaguracion.setBounds(12, 67, 183, 32);
		contentPane.add(lblFechainaguracion);
		
		fechaInaguracion = new JDateChooser();
		fechaInaguracion.setBackground(new Color(240, 248, 255));
		fechaInaguracion.setBounds(195, 67, 225, 32);
		contentPane.add(fechaInaguracion);
		
		JLabel lblMetrocuadrados = new JLabel("Metro Cuadrados");
		lblMetrocuadrados.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMetrocuadrados.setBounds(12, 123, 157, 27);
		contentPane.add(lblMetrocuadrados);
		
		txtMetroscuadrados = new JTextField();
		txtMetroscuadrados.setForeground(Color.BLACK);
		txtMetroscuadrados.setBackground(new Color(240, 248, 255));
		txtMetroscuadrados.setBounds(195, 116, 225, 32);
		txtMetroscuadrados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
				
				
			}
		});
		contentPane.add(txtMetroscuadrados);
		txtMetroscuadrados.setColumns(10);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAtras_mouseClicked(e);
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(26, 190, 136, 38);
		contentPane.add(btnAtras);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBounds(268, 190, 136, 38);
		contentPane.add(btnRegistrar);
	}
	private void btnRegistrar_mouseClicked(MouseEvent e){
		boolean existeNombre=false;
		try {
			if(!(txtNombre.getText().equals(""))&&validarFecha()&&!(txtMetroscuadrados.getText().equals("")))
			{	
				existeNombre=gestor.registrarPinacoteca(txtNombre.getText(),obtenerFechaEnString(),txtMetroscuadrados.getText());
				if(!existeNombre==true){
					JOptionPane.showMessageDialog(this,"El resgitro fue exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
					txtNombre.setText("");
					txtMetroscuadrados.setText("");
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
			JOptionPane.showMessageDialog(this,"Ingrese otro nombre para la pinacoteca."+"\n Este ya existe en el sistema.","Mensaje",JOptionPane.INFORMATION_MESSAGE);
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
		if(fechaInaguracion.getCalendar().before(fechaActual)){
			//La fecha  es anterior.
			
			return true;
		}else{
			//La fecha  no es anterior.
			JOptionPane.showMessageDialog(this,(String) "La fecha es mayor a la fecha actual","Mensaje",JOptionPane.INFORMATION_MESSAGE);	
			return false;
		}
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(this,"Ingrese la fecha Por favor","Mensaje",JOptionPane.INFORMATION_MESSAGE);	
			return false;
		}
	}
	
	private String obtenerFechaEnString(){
		
		 SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
		 return mascara.format(fechaInaguracion .getCalendar().getTime());
	}
}
