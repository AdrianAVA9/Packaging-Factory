package IU;

import java.awt.EventQueue;
import Logica.Gestor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Window.Type;
import java.awt.Color;

public class EliminarModificarMecena extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCodigo;
	private Gestor gestor;
	private JDateChooser dateFechaNacimiento;
	private JComboBox<String> comboBoxPais;
	private JComboBox<String> comboBoxCiudad;
	private JComboBox<String> comboBoxMecena;
	private ArrayList<String> datosMecena;
	private String[] listaNombreCiudades;
	private String[][] listaDatosPaises;
	private String[][] listaDatosMecena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificarMecena frame = new EliminarModificarMecena();
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
	public EliminarModificarMecena() {
		setTitle("Eliminar Modificar Mecena");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 517, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		gestor=new Gestor();
		
		JLabel lblSeleccioneLaMecena = new JLabel("Seleccione el mecena");
		lblSeleccioneLaMecena.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblSeleccioneLaMecena.setBounds(10, 11, 206, 14);
		contentPane.add(lblSeleccioneLaMecena);
		
		comboBoxMecena = new JComboBox<String>();
		comboBoxMecena.setBackground(new Color(240, 248, 255));
		
		comboBoxMecena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					cargarDatosMecenaAIntefaz();
				
			}
		});
		comboBoxMecena.setBounds(228, 13, 259, 32);
		contentPane.add(comboBoxMecena);
		cargarNombreMecenas();
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo");
		lblNombreCompleto.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblNombreCompleto.setBounds(10, 65, 206, 24);
		contentPane.add(lblNombreCompleto);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBackground(new Color(240, 248, 255));
		textFieldNombre.setBounds(228, 67, 259, 32);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCodigo.setBounds(10, 119, 206, 25);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBackground(new Color(240, 248, 255));
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(228, 126, 259, 32);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblPaisNacimiento = new JLabel("Pais nacimiento");
		lblPaisNacimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblPaisNacimiento.setBounds(10, 178, 219, 14);
		contentPane.add(lblPaisNacimiento);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBackground(new Color(112, 128, 144));
		lblCiudad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblCiudad.setBounds(10, 236, 190, 14);
		contentPane.add(lblCiudad);
		
		comboBoxPais = new JComboBox<String>();
		comboBoxPais.setBackground(new Color(240, 248, 255));
		comboBoxPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCiudades(buscaridPorNombre(listaDatosPaises,comboBoxPais.getSelectedItem().toString()));
			}
		});
		comboBoxPais.setBounds(228, 180, 259, 32);
		contentPane.add(comboBoxPais);
		cargarPaises();
		comboBoxCiudad = new JComboBox<String>();
		comboBoxCiudad.setBackground(new Color(240, 248, 255));
		comboBoxCiudad.setBounds(228, 238, 259, 32);
		contentPane.add(comboBoxCiudad);
		
		JLabel lblFechaFallecimiento = new JLabel("Fecha fallecimiento");
		lblFechaFallecimiento.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		lblFechaFallecimiento.setBounds(10, 291, 206, 14);
		contentPane.add(lblFechaFallecimiento);
		
		dateFechaNacimiento = new JDateChooser();
		dateFechaNacimiento.setBackground(new Color(240, 248, 255));
		dateFechaNacimiento.setBounds(228, 294, 259, 32);
		contentPane.add(dateFechaNacimiento);
		
		JButton botonAtras = new JButton("< Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				EliminarModificar ventanaEliminarModificar= new EliminarModificar();
				ventanaEliminarModificar.setLocationRelativeTo(null);
				ventanaEliminarModificar.setVisible(true);
				dispose();
			}
		});
		botonAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonAtras.setBounds(10, 352, 121, 44);
		contentPane.add(botonAtras);
		
		JButton botonEliminar = new JButton("Eliminar");

		botonEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					gestor.eliminarMecena(buscaridPorNombre(listaDatosMecena,comboBoxMecena.getSelectedItem().toString()));
					cargarNombreMecenas();
					cargarDatosMecenaAIntefaz();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No hay registros para eliminar");
				}
			}
		});
		botonEliminar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonEliminar.setBounds(243, 352, 121, 44);
		contentPane.add(botonEliminar);
		
		JButton botonModificar = new JButton("Modificar");
		
		

		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				try {
					String fecha=obtenerFechaEnString(dateFechaNacimiento);
					gestor.actualizarMecena(Integer.parseInt(textFieldCodigo.getText()), textFieldNombre.getText().toString(), comboBoxPais.getSelectedItem().toString(),
							comboBoxCiudad.getSelectedItem().toString(),fecha);
					cargarNombreMecenas();
					cargarDatosMecenaAIntefaz();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No hay registros para modificar");
				}		
			}
		});
		
		botonModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 18));
		botonModificar.setBounds(376, 352, 123, 44);
		contentPane.add(botonModificar);
		setLocationRelativeTo(null);				
	}
	
	private void cargarDatosMecenaAIntefaz(){
		try {
			datosMecena=new ArrayList<String>();
			System.out.println(buscaridPorNombre(listaDatosMecena,comboBoxMecena.getSelectedItem().toString()));
			datosMecena=gestor.solicitarInfoMecena(buscaridPorNombre(listaDatosMecena,comboBoxMecena.getSelectedItem().toString()));
			java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
			textFieldCodigo.setText( datosMecena.get(0));
			textFieldNombre.setText( datosMecena.get(1));
			buscarIndexComboBox(comboBoxPais, datosMecena.get(3));
			java.util.Date fechaDate = formato.parse(datosMecena.get(2));
			dateFechaNacimiento.setDate(fechaDate);
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}	
	}
		
	private void cargarPaises()
	{	
		
		
		try {
			listaDatosPaises=gestor.listarPaises();
			String pais[]=new String[listaDatosPaises.length];
			
			for(int i=0; i<listaDatosPaises.length;i++){
				pais[i]=listaDatosPaises[i][1];
			}
			comboBoxPais.setModel(new DefaultComboBoxModel<>(pais));
		}
		catch (Exception ex) {}
	}
	
	private void cargarNombreMecenas(){	
		
		try {
			listaDatosMecena=gestor.listarMecenas();
			String[] listaNombreMecenas=new String[listaDatosMecena.length];
			
			for(int i=0; i<listaDatosMecena.length;i++){
				listaNombreMecenas[i]=listaDatosMecena[i][1];
				System.out.println(listaNombreMecenas[i]);
				System.out.println(listaDatosMecena[i][0]);
			}
			comboBoxMecena.setModel(new DefaultComboBoxModel(listaNombreMecenas));
		}
		catch (Exception ex) {
			
			ex.printStackTrace();
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
	
	private String obtenerFechaEnString(JDateChooser pfecha){
		
		 SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
		 return mascara.format(pfecha.getCalendar().getTime());
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
	
	private int buscaridPorNombre(String[][] lista,String pnombre)
	{
		for(int i=0;i<lista.length;i++){
			if(pnombre.equals(lista[i][1])){
				
				return Integer.parseInt(lista[i][0]);
			}
		}
		return 0;
	}

}
