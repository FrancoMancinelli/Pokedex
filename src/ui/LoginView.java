package ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utils.Almacen;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frame;
	private JFrame frmPokedexMen;
	private JLabel lblNomUsuario;
	private JTextField textNomUsuario;
	private JLabel lblPassword;
	private JPasswordField pfilePassword;
	private JButton btnEntrar;
	private Component lblNewLabel;
	private JButton btnRegistrarse;
	private JLabel imgLineaRoja;
	private JLabel lblPokedex;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frmPokedexMen.setVisible(true);	
		}
	

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setUIComponents();
		setListeners();
	}
	
	//Métodos
	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frmPokedexMen = new JFrame();
		frmPokedexMen.setTitle("Pokedex - Inicio");
		frmPokedexMen.setBounds(100, 100, 665, 495);
		frmPokedexMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedexMen.getContentPane().setLayout(null);
		
		lblNomUsuario = new JLabel("Usuario:");
		lblNomUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNomUsuario.setBounds(185, 204, 110, 28);
		frmPokedexMen.getContentPane().add(lblNomUsuario);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(305, 197, 144, 35);
		frmPokedexMen.getContentPane().add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblPassword.setBounds(147, 243, 151, 35);
		frmPokedexMen.getContentPane().add(lblPassword);
		
		pfilePassword = new JPasswordField();
		pfilePassword.setBounds(305, 243, 144, 35);
		frmPokedexMen.getContentPane().add(pfilePassword);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnEntrar.setBackground(new Color(72, 61, 139));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBounds(261, 305, 96, 28);
		frmPokedexMen.getContentPane().add(btnEntrar);
		
		btnRegistrarse = new JButton("Registrate");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRegistrarse.setBackground(new Color(72, 61, 139));
		btnRegistrarse.setBounds(236, 339, 144, 28);
		frmPokedexMen.getContentPane().add(btnRegistrarse);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 649, 78);
		frmPokedexMen.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 73, 55, 325);
		frmPokedexMen.getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(594, 73, 55, 325);
		frmPokedexMen.getContentPane().add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(0, 378, 649, 78);
		frmPokedexMen.getContentPane().add(panel_2);
		
		lblPokedex = new JLabel("");
		lblPokedex.setBounds(176, 89, 256, 104);
		lblPokedex.setIcon(new ImageIcon(LoginView.class.getResource("/img/pokemon.png")));
		frmPokedexMen.getContentPane().add(lblPokedex);
	}
	
	/**
	 * Configura las acciones al presionar un botón
	 */
	private void setListeners() {
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analizarDatosAcceso();			
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedexMen.setVisible(false);
				new RegistroView(frmPokedexMen);
			}
		});
		
		pfilePassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					analizarDatosAcceso();
				}
			}
		});
	}
	
	/**
	 * Verifica los datos introducidos para acceder a la pokedex
	 */
	private void analizarDatosAcceso() {
		String username = textNomUsuario.getText();
		String password = new String (pfilePassword.getPassword());
		boolean foundIt = false;
		
		for(int i = 0; i < Almacen.usuarios.size(); i++) { //Recorro mi array de usuarios
			if(Almacen.usuarios.get(i).getUsername().equals(username) && Almacen.usuarios.get(i).getPassword().equals(password)) { //Si el usuario y contraseña coinciden con un usuario y su contraseña del array...
				JOptionPane.showMessageDialog(btnEntrar, "Login Correcto. Bienvenid@ "+username);
				new PokedexView(username, frmPokedexMen, 0);
				frmPokedexMen.setVisible(false);
				foundIt = true;
			}
		}
		
		if (!foundIt) { //Si no se ha encontrado el usuario y/o la contraseña
			JOptionPane.showMessageDialog(btnEntrar, "                                ERR0R 203 - Login Incorrecto.\nAsegurate de haber introducido correctamente el usuario y contraseña");
		}  
	}
} //CIERRE CLASE
