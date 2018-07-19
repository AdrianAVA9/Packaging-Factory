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
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setResizable(false);
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 599, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrar ventanaRegistrar= new Registrar();
				ventanaRegistrar.setLocationRelativeTo(null);
				ventanaRegistrar.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnRegistrar.setBounds(138, 41, 322, 46);
		contentPane.add(btnRegistrar);
		
		JButton btnEliminarModificar = new JButton("Eliminar o Modificar");
		btnEliminarModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EliminarModificar ventanaEliminarModificar= new EliminarModificar();
				ventanaEliminarModificar.setLocationRelativeTo(null);
				ventanaEliminarModificar.setVisible(true);
				dispose();
			}
		});
		btnEliminarModificar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnEliminarModificar.setBounds(138, 122, 322, 46);
		contentPane.add(btnEliminarModificar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar  ventanaConsultar= new Consultar();
				ventanaConsultar.setLocationRelativeTo(null);
				ventanaConsultar.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnConsultar.setBounds(138, 205, 322, 46);
		contentPane.add(btnConsultar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 26));
		btnSalir.setBounds(12, 278, 131, 46);
		contentPane.add(btnSalir);
	}
}
