package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("");

		generarVentana();

	}

	public void generarVentana() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(102, 204, 255));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnUsuario = new JButton("");
		btnUsuario.setBackground(new Color(102, 204, 255));
		btnUsuario.setIcon(new ImageIcon("C:\\Users\\Intel\\Desktop\\Icono1.JPG"));
		panelNorte.add(btnUsuario);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JButton btnGestionarFactura = new JButton("Gestionar Facutra");
		btnGestionarFactura.setBackground(Color.WHITE);
		btnGestionarFactura.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarFactura.setBounds(324, 340, 250, 80);
		panelCentral.add(btnGestionarFactura);

		JButton btnGestionarPasajero = new JButton("Gestionar Pasajero");
		btnGestionarPasajero.setBackground(Color.WHITE);
		btnGestionarPasajero.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarPasajero.setBounds(324, 164, 250, 80);
		panelCentral.add(btnGestionarPasajero);

		JButton btnGestionarListado = new JButton("Gestionar Listado");
		btnGestionarListado.setBackground(Color.WHITE);
		btnGestionarListado.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarListado.setBounds(666, 164, 250, 80);
		panelCentral.add(btnGestionarListado);

		JButton btnGestionarHabitacion = new JButton("Gestionar Habitacion");
		btnGestionarHabitacion.setBackground(Color.WHITE);
		btnGestionarHabitacion.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarHabitacion.setBounds(666, 340, 250, 80);
		panelCentral.add(btnGestionarHabitacion);

		final GestionarPasajero gp = new GestionarPasajero();

		btnGestionarPasajero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gp.setVisible(true);
				dispose();
			}
		});

		btnGestionarListado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnGestionarHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnGestionarFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

}
