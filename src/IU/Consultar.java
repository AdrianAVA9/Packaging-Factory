package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.Color;

public class Consultar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar frame = new Consultar();
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
	public Consultar() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Consultar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 599, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultaPintor = new JButton("Consulta Pintores");
		btnConsultaPintor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsultarPintor ventanaConsultarPintor;
				ventanaConsultarPintor = new ConsultarPintor();
				ventanaConsultarPintor.setLocationRelativeTo(null);
				ventanaConsultarPintor.setVisible(true);
				dispose();
			}
		});
		btnConsultaPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnConsultaPintor.setBounds(47, 25, 484, 47);
		contentPane.add(btnConsultaPintor);
		
		JButton btnComsultaCuadro = new JButton("Consultar Cuadros");
		btnComsultaCuadro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ConsultarCuadro ventanaConsultarCuadro;
					ventanaConsultarCuadro = new ConsultarCuadro();
					ventanaConsultarCuadro.setLocationRelativeTo(null);
					ventanaConsultarCuadro.setVisible(true);
					dispose();
				} catch (Exception e1) {
					
				}
				
			}
		});
		btnComsultaCuadro.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnComsultaCuadro.setBounds(47, 94, 484, 47);
		contentPane.add(btnComsultaCuadro);
		
		JButton btnConsultarPinacotecas = new JButton("Consultar Pinacotecas");
		btnConsultarPinacotecas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ConsultarPinacoteca ventanaConsultarPinacoteca;
					ventanaConsultarPinacoteca = new ConsultarPinacoteca();
					ventanaConsultarPinacoteca.setLocationRelativeTo(null);
					ventanaConsultarPinacoteca.setVisible(true);
					dispose();
				} catch (Exception e1) {
				
				}
				
			}
		});
		btnConsultarPinacotecas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnConsultarPinacotecas.setBounds(47, 169, 484, 47);
		contentPane.add(btnConsultarPinacotecas);
		
		JButton btnConsultarMecenas = new JButton("Consultar Mecenas");
		btnConsultarMecenas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnConsultarMecenas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultarMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnConsultarMecenas.setBounds(47, 239, 484, 47);
		contentPane.add(btnConsultarMecenas);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Inicio  ventanaInicior= new Inicio();
				ventanaInicior.setLocationRelativeTo(null);
				ventanaInicior.setVisible(true);
				dispose();
			}
		});
		btnAtras.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnAtras.setBounds(47, 313, 134, 47);
		contentPane.add(btnAtras);
	}

}
