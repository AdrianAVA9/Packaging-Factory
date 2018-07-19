package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;
import Logica.Gestor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class ConsultarPinacoteca extends JFrame {

	private static final ListSelectionListener ListSelectionListener = null;
	private JPanel contentPane;
	private JTextField textfield_condicionIngreso;
	private JTextField textField_CodigoC;
	private JTextField textField_dimensionC;
	private JTextField textField_fechaCreado;
	private JTextField textField_tecnicaC;
	private JTextField textField_fechaIngresoC;
	private JTextField textField_condicionActual;
	private JTextField textField_fechaFallecimineto;
	private JTextField textField_fechaNacimiento;
	private JTextField textField_ciudad;
	private JTextField textField_pais;
	private JTextField textField_nacionalidad;
	private JTextField textField_seudonimo;
	private JTextField textField_nombre;
	private JTextField textField_maestro;
	private JTextArea textArea;
	private DefaultListModel listModel;
	private JList<String>listaCuadro;
	private Gestor objGestor;
	private JComboBox comboBox_listaPinacoteca;
	private String[]infoCuadro;
	private String[]infoPintor;
	private String[]infoMecena;
	private String[]listaCuadroPinacoteca;
	private String[]listaPinacoteca;
	private JTextField textField_CostCuadro;
	private JTextField textField_Escuela;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPinacoteca frame = new ConsultarPinacoteca();
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
	public ConsultarPinacoteca() throws Exception {
		setResizable(false);
		setType(Type.UTILITY);
		objGestor = new Gestor();
		setTitle("Cosultar Pinacoteca");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 750, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(112, 128, 144));
		setBackground(Color.ORANGE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_selctPinacoteca = new JLabel("Seleccione una Pinacoteca");
		lblNewLabel_selctPinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_selctPinacoteca.setBounds(12, 38, 268, 14);
		contentPane.add(lblNewLabel_selctPinacoteca);
		
		comboBox_listaPinacoteca = new JComboBox();
		comboBox_listaPinacoteca.setBackground(new Color(240, 248, 255));
		comboBox_listaPinacoteca.setBounds(274, 36, 182, 20);
		contentPane.add(comboBox_listaPinacoteca);
		cargarPinacotecas();
		comboBox_listaPinacoteca.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				try {
					
					cargarCuadrosPinacotecas();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		listModel = new DefaultListModel<>();
		listaCuadro = new JList<>(listModel);
		listaCuadro.setBackground(new Color(240, 248, 255));
		listaCuadro.setBounds(201, 38, 205, 99);
		listaCuadro.setVisible(true);
		contentPane.add(listaCuadro);
		JScrollPane scroll = new JScrollPane(listaCuadro);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(468, 36, 251, 109);
		contentPane.add(scroll);
		
		JLabel lblNewLabel_cuadrosPinacoteca = new JLabel("Cuadros");
		lblNewLabel_cuadrosPinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_cuadrosPinacoteca.setBounds(555, 8, 130, 20);
		contentPane.add(lblNewLabel_cuadrosPinacoteca);
		
		JLabel lblNewLabel_CodigoC = new JLabel("Codigo");
		lblNewLabel_CodigoC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_CodigoC.setBounds(26, 228, 172, 14);
		contentPane.add(lblNewLabel_CodigoC);
		
		JLabel lblNewLabel_DimensionC = new JLabel("Dimension");
		lblNewLabel_DimensionC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_DimensionC.setBounds(26, 262, 172, 14);
		contentPane.add(lblNewLabel_DimensionC);
		
		JLabel lblNewLabel_fechaCreadoC = new JLabel("Fecha Creado");
		lblNewLabel_fechaCreadoC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_fechaCreadoC.setBounds(26, 297, 172, 14);
		contentPane.add(lblNewLabel_fechaCreadoC);
		
		JLabel lblNewLabel_TecnicaC = new JLabel("Tecnica");
		lblNewLabel_TecnicaC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_TecnicaC.setBounds(26, 332, 172, 14);
		contentPane.add(lblNewLabel_TecnicaC);
		
		JLabel JLabelwn_FechaIngreso = new JLabel("Fecha Ingreso");
		JLabelwn_FechaIngreso.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		JLabelwn_FechaIngreso.setBounds(26, 367, 172, 14);
		contentPane.add(JLabelwn_FechaIngreso);
		
		JLabel lblCondicionIngreso = new JLabel("Condicion Ingreso");
		lblCondicionIngreso.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionIngreso.setBounds(26, 404, 172, 14);
		contentPane.add(lblCondicionIngreso);
		
		JLabel lblCondicionActual = new JLabel("Condicion Actual");
		lblCondicionActual.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCondicionActual.setBounds(26, 444, 172, 14);
		contentPane.add(lblCondicionActual);
		
		textfield_condicionIngreso = new JTextField();
		textfield_condicionIngreso.setBackground(new Color(240, 248, 255));
		textfield_condicionIngreso.setEditable(false);
		textfield_condicionIngreso.setBounds(208, 404, 130, 20);
		contentPane.add(textfield_condicionIngreso);
		textfield_condicionIngreso.setColumns(10);
		
		textField_CodigoC = new JTextField();
		textField_CodigoC.setBackground(new Color(240, 248, 255));
		textField_CodigoC.setEditable(false);
		textField_CodigoC.setBounds(208, 228, 130, 20);
		contentPane.add(textField_CodigoC);
		textField_CodigoC.setColumns(10);
		
		textField_dimensionC = new JTextField();
		textField_dimensionC.setBackground(new Color(240, 248, 255));
		textField_dimensionC.setEditable(false);
		textField_dimensionC.setBounds(208, 262, 130, 20);
		contentPane.add(textField_dimensionC);
		textField_dimensionC.setColumns(10);
		
		textField_fechaCreado = new JTextField();
		textField_fechaCreado.setBackground(new Color(240, 248, 255));
		textField_fechaCreado.setEditable(false);
		textField_fechaCreado.setBounds(208, 297, 130, 20);
		contentPane.add(textField_fechaCreado);
		textField_fechaCreado.setColumns(10);
		
		textField_tecnicaC = new JTextField();
		textField_tecnicaC.setBackground(new Color(240, 248, 255));
		textField_tecnicaC.setEditable(false);
		textField_tecnicaC.setBounds(208, 332, 130, 20);
		contentPane.add(textField_tecnicaC);
		textField_tecnicaC.setColumns(10);
		
		textField_fechaIngresoC = new JTextField();
		textField_fechaIngresoC.setBackground(new Color(240, 248, 255));
		textField_fechaIngresoC.setEditable(false);
		textField_fechaIngresoC.setBounds(208, 367, 130, 20);
		contentPane.add(textField_fechaIngresoC);
		textField_fechaIngresoC.setColumns(10);
		
		textField_condicionActual = new JTextField();
		textField_condicionActual.setBackground(new Color(240, 248, 255));
		textField_condicionActual.setEditable(false);
		textField_condicionActual.setBounds(208, 440, 130, 20);
		contentPane.add(textField_condicionActual);
		textField_condicionActual.setColumns(10);
		
		JLabel lblNewLabel_DatosPintor = new JLabel("Datos Pintor");
		lblNewLabel_DatosPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_DatosPintor.setBounds(440, 192, 145, 14);
		contentPane.add(lblNewLabel_DatosPintor);
		
		JLabel lblNewLabel_nombrePintor = new JLabel("Nombre");
		lblNewLabel_nombrePintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_nombrePintor.setBounds(358, 231, 193, 14);
		contentPane.add(lblNewLabel_nombrePintor);
		
		JLabel lblNewLabel_Pseudonimo = new JLabel("Pseudonimo");
		lblNewLabel_Pseudonimo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_Pseudonimo.setBounds(358, 264, 193, 14);
		contentPane.add(lblNewLabel_Pseudonimo);
		
		JLabel lblNewLabel_nacionalidad = new JLabel("Nacionalidad");
		lblNewLabel_nacionalidad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_nacionalidad.setBounds(358, 299, 193, 14);
		contentPane.add(lblNewLabel_nacionalidad);
		
		JLabel lblNewLabel_Pais = new JLabel("Pais");
		lblNewLabel_Pais.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_Pais.setBounds(358, 335, 193, 14);
		contentPane.add(lblNewLabel_Pais);
		
		JLabel lblNewLabel_Ciudad = new JLabel("Ciudad");
		lblNewLabel_Ciudad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_Ciudad.setBounds(358, 370, 193, 14);
		contentPane.add(lblNewLabel_Ciudad);
		
		JLabel lblNewLabel_fechaNacimiento = new JLabel("Fecha Nacimiento");
		lblNewLabel_fechaNacimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_fechaNacimiento.setBounds(358, 407, 193, 14);
		contentPane.add(lblNewLabel_fechaNacimiento);
		
		JLabel lblNewLabel_fechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblNewLabel_fechaFallecimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_fechaFallecimiento.setBounds(358, 446, 193, 14);
		contentPane.add(lblNewLabel_fechaFallecimiento);
		
		JLabel lblMaestro = new JLabel("Maestro");
		lblMaestro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMaestro.setBounds(358, 478, 193, 14);
		contentPane.add(lblMaestro);
		
		JLabel lblMecena = new JLabel("Mecena");
		lblMecena.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMecena.setBounds(358, 561, 153, 14);
		contentPane.add(lblMecena);
		
		textField_fechaFallecimineto = new JTextField();
		textField_fechaFallecimineto.setBackground(new Color(240, 248, 255));
		textField_fechaFallecimineto.setEditable(false);
		textField_fechaFallecimineto.setBounds(555, 442, 163, 20);
		contentPane.add(textField_fechaFallecimineto);
		textField_fechaFallecimineto.setColumns(10);
		
		textField_fechaNacimiento = new JTextField();
		textField_fechaNacimiento.setBackground(new Color(240, 248, 255));
		textField_fechaNacimiento.setEditable(false);
		textField_fechaNacimiento.setText("");
		textField_fechaNacimiento.setBounds(555, 404, 163, 20);
		contentPane.add(textField_fechaNacimiento);
		textField_fechaNacimiento.setColumns(10);
		
		textField_ciudad = new JTextField();
		textField_ciudad.setBackground(new Color(240, 248, 255));
		textField_ciudad.setEditable(false);
		textField_ciudad.setBounds(555, 367, 163, 20);
		contentPane.add(textField_ciudad);
		textField_ciudad.setColumns(10);
		
		textField_pais = new JTextField();
		textField_pais.setBackground(new Color(240, 248, 255));
		textField_pais.setEditable(false);
		textField_pais.setBounds(555, 332, 163, 20);
		contentPane.add(textField_pais);
		textField_pais.setColumns(10);
		
		textField_nacionalidad = new JTextField();
		textField_nacionalidad.setBackground(new Color(240, 248, 255));
		textField_nacionalidad.setEditable(false);
		textField_nacionalidad.setBounds(555, 297, 163, 20);
		contentPane.add(textField_nacionalidad);
		textField_nacionalidad.setColumns(10);
		
		textField_seudonimo = new JTextField();
		textField_seudonimo.setBackground(new Color(240, 248, 255));
		textField_seudonimo.setEditable(false);
		textField_seudonimo.setBounds(555, 262, 163, 20);
		contentPane.add(textField_seudonimo);
		textField_seudonimo.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBackground(new Color(240, 248, 255));
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(555, 228, 163, 20);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_maestro = new JTextField();
		textField_maestro.setBackground(new Color(240, 248, 255));
		textField_maestro.setEditable(false);
		textField_maestro.setBounds(555, 476, 163, 20);
		contentPane.add(textField_maestro);
		textField_maestro.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setEditable(false);
		textArea.setBounds(555, 546, 163, 61);
		contentPane.add(textArea);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCosto.setBounds(26, 477, 172, 14);
		contentPane.add(lblCosto);
		
		textField_CostCuadro = new JTextField();
		textField_CostCuadro.setBackground(new Color(240, 248, 255));
		textField_CostCuadro.setEditable(false);
		textField_CostCuadro.setBounds(208, 476, 130, 20);
		contentPane.add(textField_CostCuadro);
		textField_CostCuadro.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(533, 156, 108, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblEscuela = new JLabel("Escuela");
		lblEscuela.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblEscuela.setBounds(358, 515, 193, 14);
		contentPane.add(lblEscuela);
		
		textField_Escuela = new JTextField();
		textField_Escuela.setBackground(new Color(240, 248, 255));
		textField_Escuela.setEditable(false);
		textField_Escuela.setBounds(555, 513, 163, 20);
		contentPane.add(textField_Escuela);
		textField_Escuela.setColumns(10);
		
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
		btnAtras.setBounds(26, 576, 108, 31);
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel_DatosCuadro = new JLabel("Datos Cuadro");
		lblNewLabel_DatosCuadro.setBackground(new Color(255, 255, 255));
		lblNewLabel_DatosCuadro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_DatosCuadro.setBounds(92, 188, 172, 22);
		contentPane.add(lblNewLabel_DatosCuadro);
		
		btnConsultar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				
				int posicion = listaCuadro.getSelectedIndex();
				
				try {
					
					infoCuadro = objGestor.buscarInfoCuadro(listaCuadroPinacoteca[posicion]);
					textfield_condicionIngreso.setText(infoCuadro[6]);
					textField_CodigoC.setText(infoCuadro[0]);
					textField_dimensionC.setText(infoCuadro[2]);
					textField_fechaCreado.setText(infoCuadro[1]);
					textField_tecnicaC.setText(infoCuadro[7]);
					textField_fechaIngresoC.setText(infoCuadro[4]);
					textField_condicionActual.setText(infoCuadro[5]);
					textField_CostCuadro.setText(infoCuadro[3]);
					
					infoPintor = objGestor.buscarInfoPintor(Integer.parseInt(infoCuadro[8]));
					textField_fechaFallecimineto.setText(infoPintor[6]);
					textField_fechaNacimiento.setText(infoPintor[5]);
					textField_ciudad.setText(infoPintor[3]);
					textField_pais.setText(infoPintor[4]);
					textField_nacionalidad.setText(infoPintor[2]);
					textField_seudonimo.setText(infoPintor[1]);
					textField_nombre.setText(infoPintor[0]);
					textField_maestro.setText(infoPintor[8]);
					textField_Escuela.setText(infoPintor[9]);
					
					
					infoMecena = objGestor.buscarMecenaPorPintor(Integer.parseInt(infoPintor[7]));
					cargarMecena();
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Seleccione un cuadro de la lista por favor");
				}
				
			}
		});
	}
	
	public void cargarPinacotecas() throws Exception{
		
		listaPinacoteca = objGestor.listarNombrePinacoteca();
		
		for(int i=0; i<listaPinacoteca.length;i++){
			
			comboBox_listaPinacoteca.addItem(listaPinacoteca[i]);
			
		}
	}
	
	public void cargarCuadrosPinacotecas() throws Exception{
		
		listaCuadroPinacoteca = objGestor.listarCuadrosPinacoteca(comboBox_listaPinacoteca.getSelectedItem().toString());
		
		listModel.clear();
		for(int i=0; i < listaCuadroPinacoteca.length;i++){
			
			listModel.addElement(listaCuadroPinacoteca[i]);
		}
		
	}
	
	public void cargarMecena(){
		
		String nombres = "";
		
		textArea.setText(" ");
		
		for(int i=0;i<infoMecena.length;i++){
			
			nombres += infoMecena[i] + "\n";
			
		}
		
		textArea.setText(nombres);
	}
}
