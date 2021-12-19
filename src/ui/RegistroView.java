package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.Usuario;
import utils.Almacen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RegistroView {

	private JFrame frmRegistro;
	private JTextField textUsuarioReg;
	private JLabel lblUsuarioReg;
	private JLabel lblContraseña1;
	private JLabel lblContraseña2;
	private JButton btnRegistrarseReg;
	private JPasswordField pFldContraseña1;
	private JPasswordField pFldContraseña2;
	private JButton btnVolver;
	private JFrame loginView;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_1_1;
	private JLabel lblPokedex;
	

	/**
	 * Create the application.
	 */
	public RegistroView(JFrame loginView) {
		initialize();
		this.loginView = loginView;
		frmRegistro.setVisible(true);
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		setUIComponents();
		setListeners();
	}

	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frmRegistro.setTitle("Pokedex - Registro");
		frmRegistro.setBounds(100, 100, 655, 495);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		frmRegistro.setVisible(true);
		
		lblUsuarioReg = new JLabel("Usuario:");
		lblUsuarioReg.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblUsuarioReg.setBounds(260, 200, 100, 30);
		frmRegistro.getContentPane().add(lblUsuarioReg);
		
		textUsuarioReg = new JTextField();
		textUsuarioReg.setBounds(370, 204, 120, 30);
		frmRegistro.getContentPane().add(textUsuarioReg);
		textUsuarioReg.setColumns(10);
		
		lblContraseña1 = new JLabel("Contrase\u00F1a:");
		lblContraseña1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContraseña1.setBounds(224, 237, 136, 30);
		frmRegistro.getContentPane().add(lblContraseña1);
		
		lblContraseña2 = new JLabel("Repite Contrase\u00F1a:");
		lblContraseña2.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContraseña2.setBounds(150, 278, 210, 30);
		frmRegistro.getContentPane().add(lblContraseña2);
		
		btnRegistrarseReg = new JButton("Registrarse");
		btnRegistrarseReg.setForeground(new Color(255, 255, 255));
		btnRegistrarseReg.setBackground(new Color(72, 61, 139));
		btnRegistrarseReg.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRegistrarseReg.setBounds(245, 319, 144, 36);
		frmRegistro.getContentPane().add(btnRegistrarseReg);
		
		pFldContraseña1 = new JPasswordField();
		pFldContraseña1.setBounds(370, 241, 120, 30);
		frmRegistro.getContentPane().add(pFldContraseña1);
		
		pFldContraseña2 = new JPasswordField();
		pFldContraseña2.setBounds(370, 278, 120, 30);
		frmRegistro.getContentPane().add(pFldContraseña2);
		
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 649, 78);
		frmRegistro.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnVolver.setBounds(32, 23, 97, 23);
		panel.add(btnVolver);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 73, 55, 325);
		frmRegistro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(0, 378, 649, 78);
		frmRegistro.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(594, 73, 55, 325);
		frmRegistro.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(RegistroView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(171, 89, 256, 104);
		frmRegistro.getContentPane().add(lblPokedex);
	}
	
	/**
	 * Configura las acciones al presionar un botón
	 */
	private void setListeners() {
		btnRegistrarseReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textUsuarioReg.getText();
				String passwd1 = new String (pFldContraseña1.getPassword());
				String passwd2 = new String (pFldContraseña2.getPassword());
				boolean userRepetido = false;
				
				for(int i = 0; i < Almacen.usuarios.size(); i++) { //Recorro mi array de usuarios
					if (Almacen.usuarios.get(i).getUsername().equals(usuario)) { //Si el nombre de usuario ya existe
						JOptionPane.showMessageDialog(btnRegistrarseReg, "El usuario "+usuario+" no se encuentra disponible\nElige otro y vuelve a intentarlo");
						userRepetido = true;
					}
				}
				
				if(!userRepetido) { //Si no hay usuario repetido
					if(passwd1.equals(passwd2)) { //Comprueba que la clave introducida sea la misma
						JOptionPane.showMessageDialog(btnRegistrarseReg, "Te has registrado con éxito");
						Usuario u = new Usuario(usuario, passwd1);
						Almacen.usuarios.add(u);
						frmRegistro.dispose();
						new LoginView();
					} else {
						JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  Las contraseñas no coinciden");
					}
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginView.setVisible(true);
				frmRegistro.dispose();
			}
		});
	}
} //CIERRE CLASE
