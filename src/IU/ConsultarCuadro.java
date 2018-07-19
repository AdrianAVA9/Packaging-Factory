package IU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Gestor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class ConsultarCuadro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NombrePinacoteca;
	private JTextField textField_NombrePintor;
	private Gestor objGestor;
	private String[]nombreCuadros;
	private String[]infoCuadro;
	private String[]infoPinacoteca;
	private String[]infoPintor;
	private JComboBox comboBox_listarCuadro;
	private JTextField textField_fechaInagurcion;
	private JTextField textField_Tamano;
	private JTextField textField_pseudonimo;
	private JTextField textField;
	private JTextField textField_Pais;
	private JTextField textField_Ciudad;
	private JTextField textField_1;
	private JTextField textField_fechaFallecimiento;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCuadro frame = new ConsultarCuadro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ConsultarCuadro() throws Exception {
		setResizable(false);
		setType(Type.UTILITY);
		objGestor = new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 445, 697);
		setTitle("Consultar Cuadro");
		setBackground(Color.ORANGE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLabel_ConsultarCuadro = new JLabel("Seleccione un Cuadro");
		JLabel_ConsultarCuadro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		JLabel_ConsultarCuadro.setBounds(12, 25, 231, 20);
		contentPane.add(JLabel_ConsultarCuadro);
		
		comboBox_listarCuadro = new JComboBox();
		comboBox_listarCuadro.setBackground(new Color(240, 248, 255));
		comboBox_listarCuadro.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_listarCuadro.setBounds(240, 26, 178, 20);
		contentPane.add(comboBox_listarCuadro);
		cargarCuadro();
		comboBox_listarCuadro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				int idPintor;
				
				try {
					
					infoCuadro = objGestor.buscarInfoCuadro(comboBox_listarCuadro.getSelectedItem().toString());
					idPintor = Integer.parseInt(infoCuadro[8]);
					System.out.println(idPintor);
					infoPintor = objGestor.buscarInfoPintor(idPintor);
					System.out.println(infoPintor[0]);
					textField_NombrePintor.setText(infoPintor[0]);
					textField_pseudonimo.setText(infoPintor[1]);
					textField.setText(infoPintor[2]);
					textField_Pais.setText(infoPintor[4]);
					textField_Ciudad.setText(infoPintor[3]);
					textField_1.setText(infoPintor[5]);
					textField_fechaFallecimiento.setText(infoPintor[6]);
					
					infoPinacoteca = objGestor.buscarPinacoteca(Integer.parseInt(infoCuadro[9]));
					textField_NombrePinacoteca.setText(infoPinacoteca[0]);
					textField_fechaInagurcion.setText(infoPinacoteca[2]);
					textField_Tamano.setText(infoPinacoteca[1]);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			private String[] buscarInfoPintor(int idPintor) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		JLabel lblNewLabel_Pinacoteca = new JLabel("Pinacoteca");
		lblNewLabel_Pinacoteca.setBackground(new Color(0, 0, 0));
		lblNewLabel_Pinacoteca.setForeground(new Color(0, 0, 0));
		lblNewLabel_Pinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_Pinacoteca.setBounds(124, 120, 127, 31);
		contentPane.add(lblNewLabel_Pinacoteca);
		
		JLabel lblNewLabel_nombrePinacoteca = new JLabel("Nombre");
		lblNewLabel_nombrePinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_nombrePinacoteca.setBounds(14, 164, 178, 20);
		contentPane.add(lblNewLabel_nombrePinacoteca);
		
		textField_NombrePinacoteca = new JTextField();
		textField_NombrePinacoteca.setBackground(new Color(240, 248, 255));
		textField_NombrePinacoteca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NombrePinacoteca.setEditable(false);
		textField_NombrePinacoteca.setBounds(204, 164, 214, 20);
		contentPane.add(textField_NombrePinacoteca);
		textField_NombrePinacoteca.setColumns(10);
		
		JLabel lblPintor = new JLabel("Pintor");
		lblPintor.setForeground(new Color(0, 0, 0));
		lblPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 21));
		lblPintor.setBounds(124, 315, 178, 20);
		contentPane.add(lblPintor);
		
		JLabel lblNewLabel_nombrePintor = new JLabel("Nombre");
		lblNewLabel_nombrePintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_nombrePintor.setBounds(14, 344, 198, 14);
		contentPane.add(lblNewLabel_nombrePintor);
		
		textField_NombrePintor = new JTextField();
		textField_NombrePintor.setBackground(new Color(240, 248, 255));
		textField_NombrePintor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_NombrePintor.setEditable(false);
		textField_NombrePintor.setBounds(204, 343, 214, 20);
		contentPane.add(textField_NombrePintor);
		textField_NombrePintor.setColumns(10);
		
		textField_fechaInagurcion = new JTextField();
		textField_fechaInagurcion.setBackground(new Color(240, 248, 255));
		textField_fechaInagurcion.setEditable(false);
		textField_fechaInagurcion.setBounds(204, 199, 214, 20);
		contentPane.add(textField_fechaInagurcion);
		textField_fechaInagurcion.setColumns(10);
		
		JLabel lblFechainaguracion = new JLabel("Fecha Inaguracion");
		lblFechainaguracion.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechainaguracion.setBounds(14, 202, 182, 14);
		contentPane.add(lblFechainaguracion);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblTamao.setBounds(14, 240, 178, 14);
		contentPane.add(lblTamao);
		
		textField_Tamano = new JTextField();
		textField_Tamano.setBackground(new Color(240, 248, 255));
		textField_Tamano.setEditable(false);
		textField_Tamano.setBounds(204, 237, 214, 20);
		contentPane.add(textField_Tamano);
		textField_Tamano.setColumns(10);
		
		JLabel lblPseudonimo = new JLabel("Pseudonimo");
		lblPseudonimo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPseudonimo.setBounds(14, 378, 198, 14);
		contentPane.add(lblPseudonimo);
		
		textField_pseudonimo = new JTextField();
		textField_pseudonimo.setBackground(new Color(240, 248, 255));
		textField_pseudonimo.setEditable(false);
		textField_pseudonimo.setBounds(204, 378, 214, 20);
		contentPane.add(textField_pseudonimo);
		textField_pseudonimo.setColumns(10);
		
		JLabel lblNewLabel_Nacionalidad = new JLabel("Nacionalidad");
		lblNewLabel_Nacionalidad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_Nacionalidad.setBounds(16, 416, 196, 14);
		contentPane.add(lblNewLabel_Nacionalidad);
		
		textField = new JTextField();
		textField.setBackground(new Color(240, 248, 255));
		textField.setEditable(false);
		textField.setBounds(204, 416, 214, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPais.setBounds(14, 452, 198, 14);
		contentPane.add(lblPais);
		
		textField_Pais = new JTextField();
		textField_Pais.setBackground(new Color(240, 248, 255));
		textField_Pais.setEditable(false);
		textField_Pais.setBounds(204, 452, 214, 20);
		contentPane.add(textField_Pais);
		textField_Pais.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCiudad.setBounds(14, 490, 198, 14);
		contentPane.add(lblCiudad);
		
		textField_Ciudad = new JTextField();
		textField_Ciudad.setBackground(new Color(240, 248, 255));
		textField_Ciudad.setEditable(false);
		textField_Ciudad.setBounds(204, 490, 214, 20);
		contentPane.add(textField_Ciudad);
		textField_Ciudad.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaNacimiento.setBounds(13, 525, 199, 14);
		contentPane.add(lblFechaNacimiento);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(240, 248, 255));
		textField_1.setEditable(false);
		textField_1.setBounds(204, 525, 214, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechaFallecimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaFallecimiento.setBounds(12, 557, 200, 18);
		contentPane.add(lblFechaFallecimiento);
		
		textField_fechaFallecimiento = new JTextField();
		textField_fechaFallecimiento.setBackground(new Color(240, 248, 255));
		textField_fechaFallecimiento.setEditable(false);
		textField_fechaFallecimiento.setBounds(204, 559, 214, 20);
		contentPane.add(textField_fechaFallecimiento);
		textField_fechaFallecimiento.setColumns(10);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar ventanaConsultar= new Consultar();
				ventanaConsultar.setLocationRelativeTo(null);
				ventanaConsultar.setVisible(true);
				dispose();
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnAtras.setBounds(12, 607, 109, 31);
		contentPane.add(btnAtras);
	}
	
	public void cargarCuadro() throws Exception{
		
		nombreCuadros = objGestor.listarNombreCuadros();
		
		for(int i=0; i<nombreCuadros.length;i++){
			
			comboBox_listarCuadro.addItem(nombreCuadros[i]);
			
		}
	}
}
