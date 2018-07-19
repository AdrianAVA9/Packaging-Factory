package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
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
	
	public Registrar() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 599, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarPintor = new JButton("Registrar Pintores");
		btnRegistrarPintor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarPintor ventanaRegistrarPintor= new RegistrarPintor();
				ventanaRegistrarPintor.setLocationRelativeTo(null);
				ventanaRegistrarPintor.setVisible(true);
				dispose();
			}
		});
		btnRegistrarPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrarPintor.setBounds(70, 28, 451, 46);
		contentPane.add(btnRegistrarPintor);
		
		JButton btnRegistrarcuadros = new JButton("Registrar Cuadros");
		btnRegistrarcuadros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarCuadro ventanaRegistrarCuadro= new RegistrarCuadro();
				ventanaRegistrarCuadro.setLocationRelativeTo(null);
				ventanaRegistrarCuadro.setVisible(true);
				dispose();
			}
		});
		btnRegistrarcuadros.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrarcuadros.setBounds(70, 100, 451, 46);
		contentPane.add(btnRegistrarcuadros);
		
		JButton btnRegistrarPinacotecas = new JButton("Registrar Pinacotecas");
		btnRegistrarPinacotecas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarPinacoteca ventanaRegistrarPinacoteca= new RegistrarPinacoteca();
				ventanaRegistrarPinacoteca.setLocationRelativeTo(null);
				ventanaRegistrarPinacoteca.setVisible(true);
				dispose();
			}
		});
		btnRegistrarPinacotecas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrarPinacotecas.setBounds(70, 177, 451, 46);
		contentPane.add(btnRegistrarPinacotecas);
		
		JButton btnRegistrarMecenas = new JButton("Registrar Mecenas");
		btnRegistrarMecenas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarMecena ventanaRegistrarMecena= new RegistrarMecena();
				ventanaRegistrarMecena.setLocationRelativeTo(null);
				ventanaRegistrarMecena.setVisible(true);
				dispose();
			}
		});
		btnRegistrarMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrarMecenas.setBounds(70, 254, 451, 46);
		contentPane.add(btnRegistrarMecenas);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio  ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnAtras.setBounds(70, 400, 133, 46);
		contentPane.add(btnAtras);
		
		JButton btnRegistrarEscuela = new JButton("Registrar Escuela");
		btnRegistrarEscuela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEscuela ventanaRegistrarEscuela= new RegistrarEscuela();
				ventanaRegistrarEscuela.setLocationRelativeTo(null);
				ventanaRegistrarEscuela.setVisible(true);
				dispose();
			}
		});
		btnRegistrarEscuela.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrarEscuela.setBounds(70, 330, 451, 46);
		contentPane.add(btnRegistrarEscuela);
	}
}
