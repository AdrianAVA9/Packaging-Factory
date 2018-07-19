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

public class EliminarModificar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarModificar frame = new EliminarModificar();
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
	public EliminarModificar() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Eliminar o Modificar");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 597, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminaroModificarPintor = new JButton("Eliminar o Modificar Pintores");
		btnEliminaroModificarPintor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificarPintor  ventanaEliminarModificarPintor= new EliminarModificarPintor();
				ventanaEliminarModificarPintor.setLocationRelativeTo(null);
				ventanaEliminarModificarPintor.setVisible(true);
				dispose();
			}
		});
		btnEliminaroModificarPintor.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminaroModificarPintor.setBounds(42, 46, 493, 45);
		contentPane.add(btnEliminaroModificarPintor);
		
		JButton btnEliminaroModificarCuadros = new JButton("Eliminar o Modificar Cuadros");
		btnEliminaroModificarCuadros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificarCuadro  ventanaEliminarModificarCuadro= new EliminarModificarCuadro();
				ventanaEliminarModificarCuadro.setLocationRelativeTo(null);
				ventanaEliminarModificarCuadro.setVisible(true);
				dispose();
			}
		});
		btnEliminaroModificarCuadros.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminaroModificarCuadros.setBounds(42, 124, 493, 45);
		contentPane.add(btnEliminaroModificarCuadros);
		
		JButton btnEliminaroModificarPinacoteca = new JButton("Eliminar o Modificar Pinacotecas");
		btnEliminaroModificarPinacoteca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificarPinacoteca ventanaEliminarModificarPinacoteca= new EliminarModificarPinacoteca();
				ventanaEliminarModificarPinacoteca.setLocationRelativeTo(null);
				ventanaEliminarModificarPinacoteca.setVisible(true);
				dispose();
			}
		});
		btnEliminaroModificarPinacoteca.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminaroModificarPinacoteca.setBounds(42, 202, 493, 45);
		contentPane.add(btnEliminaroModificarPinacoteca);
		
		JButton btnEliminaroModificarMecenas = new JButton("Eliminar o Modificar Mecenas");
		btnEliminaroModificarMecenas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificarMecena ventanaEliminarModificarMecena= new EliminarModificarMecena();
				ventanaEliminarModificarMecena.setLocationRelativeTo(null);
				ventanaEliminarModificarMecena.setVisible(true);
				dispose();
			}
		});
		btnEliminaroModificarMecenas.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminaroModificarMecenas.setBounds(42, 282, 493, 45);
		contentPane.add(btnEliminaroModificarMecenas);
		
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
		btnAtras.setBounds(42, 444, 165, 41);
		contentPane.add(btnAtras);
		
		JButton btnEliminarOModificar = new JButton("Eliminar o Modificar Escuela");
		btnEliminarOModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarModificarEscuela  ventanaEliminarModificarEscuela= new EliminarModificarEscuela();
				ventanaEliminarModificarEscuela.setLocationRelativeTo(null);
				ventanaEliminarModificarEscuela.setVisible(true);
				dispose();
			}
		});
		btnEliminarOModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminarOModificar.setBounds(42, 357, 493, 45);
		contentPane.add(btnEliminarOModificar);
	}
}
