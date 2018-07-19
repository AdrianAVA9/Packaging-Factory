package IU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;
import Logica.Gestor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

public class ConsultarPintor extends JFrame {
	
	private static final ListSelectionListener ListSelectionListener = null;
	private JPanel contentPane;
	private JTextField textField_EscribirNombre;
	private String[][]nombrePintores;
	private String[][]cuadrosPintor;
	private DefaultListModel listModel;
	private JList<String>listaPintores;
	private String[]infoPintor;
	private String[]infoMecena;
	private Gestor objGestor;
	private JTextArea textArea_InfoCuadro;
	private JTextArea txtrInfomecena;
	private JTextArea txtrInfomaestro;
	private JTextArea txtrInfoescuela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPintor frame = new ConsultarPintor();
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
	public ConsultarPintor() {
		setType(Type.UTILITY);
		objGestor = new Gestor();
		setTitle("Cosultar Pintor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 607, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setLayout(null);
		
		JLabel lblConsultarPintor = new JLabel("Consultar Pintor");
		lblConsultarPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblConsultarPintor.setBounds(46, 13, 404, 14);
		contentPane.add(lblConsultarPintor);
		
		textField_EscribirNombre = new JTextField();
		textField_EscribirNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		textField_EscribirNombre.setBackground(new Color(240, 248, 255));
		textField_EscribirNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				consultar();
			}
		});
		textField_EscribirNombre.setBounds(10, 38, 440, 28);
		contentPane.add(textField_EscribirNombre);
		textField_EscribirNombre.setColumns(10);
		
		textArea_InfoCuadro = new JTextArea();
		textArea_InfoCuadro.setBackground(new Color(240, 248, 255));
		textArea_InfoCuadro.setEditable(false);
		textArea_InfoCuadro.setBounds(208, 10, 149, 84);
		contentPane.add(textArea_InfoCuadro);
		JScrollPane scroll = new JScrollPane(textArea_InfoCuadro);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(17, 300, 232, 101);
		contentPane.add(scroll);
		
		JLabel lblCuadros = new JLabel("Cuadros");
		lblCuadros.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCuadros.setBounds(89, 279, 116, 14);
		contentPane.add(lblCuadros);
		
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
		btnAtras.setBounds(26, 580, 159, 31);
		contentPane.add(btnAtras);
		
		listModel = new DefaultListModel<>();
		listaPintores = new JList(listModel);
		listaPintores.setBackground(new Color(240, 248, 255));
		listaPintores.setBounds(17, 118, 208, 86);
		contentPane.add(listaPintores);
		JScrollPane scrollPintor = new JScrollPane(listaPintores);
		scrollPintor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPintor.setBounds(17, 118, 208, 86);
		contentPane.add(scrollPintor);
		
		
		JLabel lblPintor = new JLabel("Pintor");
		lblPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPintor.setBounds(91, 91, 94, 14);
		contentPane.add(lblPintor);
		
		JLabel lblMecenas = new JLabel("Mecenas");
		lblMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMecenas.setBounds(394, 279, 116, 14);
		contentPane.add(lblMecenas);
		
		txtrInfomecena = new JTextArea();
		txtrInfomecena.setBackground(new Color(240, 248, 255));
		txtrInfomecena.setEditable(false);
		txtrInfomecena.setBounds(330, 300, 211, 101);
		contentPane.add(txtrInfomecena);
		
		JLabel lblMaestro = new JLabel("Maestro");
		lblMaestro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblMaestro.setBounds(89, 439, 96, 14);
		contentPane.add(lblMaestro);
		
		txtrInfomaestro = new JTextArea();
		txtrInfomaestro.setBackground(new Color(240, 248, 255));
		txtrInfomaestro.setEditable(false);
		txtrInfomaestro.setBounds(17, 460, 232, 60);
		contentPane.add(txtrInfomaestro);
		
		JLabel lblEscuela = new JLabel("Escuela");
		lblEscuela.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblEscuela.setBounds(394, 439, 116, 14);
		contentPane.add(lblEscuela);
		
		txtrInfoescuela = new JTextArea();
		txtrInfoescuela.setBackground(new Color(240, 248, 255));
		txtrInfoescuela.setEditable(false);
		txtrInfoescuela.setBounds(335, 460, 206, 60);
		contentPane.add(txtrInfoescuela);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int posicion = listaPintores.getSelectedIndex();
				
				try {
					
					cuadrosPintor = objGestor.buscarCuadrosPorPintor(Integer.parseInt(nombrePintores[posicion][1]));
					infoPintor = objGestor.buscarInfoPintor(Integer.parseInt(nombrePintores[posicion][1]));
					infoMecena = objGestor.buscarMecenaPorPintor(Integer.parseInt(nombrePintores[posicion][1]));
					cargarCuadrosPintor();
					cargarMecena();
					cargarEscuelaMaestro();
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Seleccione un Pintor de la lista ");
				}
			}
		});
		btnConsultar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		btnConsultar.setBounds(235, 118, 166, 23);
		contentPane.add(btnConsultar);
	
	}
	private void consultar(){

		int posicion = listaPintores.getSelectedIndex();
		
		try {
			
			cargarNombrePintores();
			
		} catch (Exception e1) {
			
		}
	}
	public void cargarNombrePintores(){
		try {
			nombrePintores = objGestor.buscarPintorPorNombre(textField_EscribirNombre.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listModel.clear();
		
		for(int i=0; i < nombrePintores.length;i++){
			
			listModel.addElement(nombrePintores[i][0]);
		}
		
	}
	
	public void cargarCuadrosPintor(){
		
		String nombreCuadros = "";
		
		textArea_InfoCuadro.setText(" ");
		
		for(int i=0;i < cuadrosPintor.length;i++){
			
			nombreCuadros += cuadrosPintor[i][0] + "  " + cuadrosPintor[i][1] + "\n";
		}
		
		
		textArea_InfoCuadro.setText(nombreCuadros);
		
	}
	
	public void cargarMecena(){
		
		String nombreMecena = "";
		
		txtrInfomecena.setText(" ");
		
		for(int i=0;i < infoMecena.length;i++){
			
			nombreMecena += infoMecena[i] + "\n";
		}
		
		
		txtrInfomecena.setText(nombreMecena);
	}
	
public void cargarEscuelaMaestro(){
		
		
		txtrInfomaestro.setText(" ");
		txtrInfoescuela.setText(" ");
		txtrInfomaestro.setText(infoPintor[8]);
		txtrInfoescuela.setText(infoPintor[9]);
	}
}
