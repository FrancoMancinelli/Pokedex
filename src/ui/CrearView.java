package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import enums.TipoPokemons;
import models.Pokemon;
import utils.Almacen;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CrearView {

	private JFrame frame;
	private JTextField textFldSetNombre;
	private JTextField textFldSetNumero;
	private JTextField textFldSetTipo;
	private JTextField textFldSetAltura;
	private JTextField textFldSetPeso;
	private JTextField textFldSetCategoria;
	private JTextField textFldSetHabilidad;
	private JLabel lblSetNombre;
	private JLabel lblSetNumero;
	private JLabel lblSetTipo;
	private JLabel lblSetAltura;
	private JLabel lblSetPeso;
	private JLabel lblSetCategoria;
	private JLabel lblSetHabilidad;
	private JButton btnConfirmarCrear;
	private JButton btnVolverPkx;
	private JFrame PokedexView;
	private TipoPokemons EnumSetTipo;
	private String username;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_1_1;
	private JLabel lblPokedex;

	
	/**
	 * Create the application.
	 */
	public CrearView(JFrame PokedexView, String username) {
		initialize();
		this.PokedexView = PokedexView;
		this.username = username;
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
	}
	
	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		textFldSetNombre = new JTextField();
		textFldSetNombre.setBounds(163, 153, 120, 24);
		frame.getContentPane().add(textFldSetNombre);
		textFldSetNombre.setColumns(10);
		
		lblSetNombre = new JLabel("Nombre:");
		lblSetNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetNombre.setBounds(80, 155, 100, 22);
		frame.getContentPane().add(lblSetNombre);
		
		lblSetNumero = new JLabel("N\u00FAmero:");
		lblSetNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetNumero.setBounds(80, 185, 100, 22);
		frame.getContentPane().add(lblSetNumero);
		
		textFldSetNumero = new JTextField();
		textFldSetNumero.setBounds(163, 184, 120, 24);
		frame.getContentPane().add(textFldSetNumero);
		textFldSetNumero.setColumns(10);
		
		textFldSetTipo = new JTextField();
		textFldSetTipo.setBounds(163, 215, 120, 24);
		frame.getContentPane().add(textFldSetTipo);
		textFldSetTipo.setColumns(10);
		
		lblSetTipo = new JLabel("Tipo:");
		lblSetTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetTipo.setBounds(80, 216, 100, 22);
		frame.getContentPane().add(lblSetTipo);
		
		lblSetAltura = new JLabel("Altura:");
		lblSetAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetAltura.setBounds(362, 183, 76, 22);
		frame.getContentPane().add(lblSetAltura);
		
		textFldSetAltura = new JTextField();
		textFldSetAltura.setBounds(438, 184, 120, 24);
		frame.getContentPane().add(textFldSetAltura);
		textFldSetAltura.setColumns(10);
		
		lblSetPeso = new JLabel("Peso:");
		lblSetPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetPeso.setBounds(80, 245, 100, 22);
		frame.getContentPane().add(lblSetPeso);
		
		textFldSetPeso = new JTextField();
		textFldSetPeso.setColumns(10);
		textFldSetPeso.setBounds(163, 244, 120, 24);
		frame.getContentPane().add(textFldSetPeso);
		
		lblSetCategoria = new JLabel("Categoria:");
		lblSetCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetCategoria.setBounds(336, 215, 102, 22);
		frame.getContentPane().add(lblSetCategoria);
		
		textFldSetCategoria = new JTextField();
		textFldSetCategoria.setBounds(438, 215, 120, 24);
		frame.getContentPane().add(textFldSetCategoria);
		textFldSetCategoria.setColumns(10);
		
		lblSetHabilidad = new JLabel("Habilidad:");
		lblSetHabilidad.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetHabilidad.setBounds(336, 245, 100, 24);
		frame.getContentPane().add(lblSetHabilidad);
		
		textFldSetHabilidad = new JTextField();
		textFldSetHabilidad.setBounds(438, 244, 120, 24);
		frame.getContentPane().add(textFldSetHabilidad);
		textFldSetHabilidad.setColumns(10);
		
		btnConfirmarCrear = new JButton("Crear");
		btnConfirmarCrear.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnConfirmarCrear.setForeground(new Color(255, 255, 255));
		btnConfirmarCrear.setBackground(new Color(72, 61, 139));
		btnConfirmarCrear.setBounds(253, 303, 113, 48);
		frame.getContentPane().add(btnConfirmarCrear);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 649, 78);
		frame.getContentPane().add(panel);
		
		btnVolverPkx = new JButton("Volver");
		btnVolverPkx.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnVolverPkx.setBackground(new Color(255, 255, 255));
		btnVolverPkx.setBounds(25, 26, 95, 23);
		panel.add(btnVolverPkx);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 73, 55, 325);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(0, 378, 649, 78);
		frame.getContentPane().add(panel_2);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(594, 73, 55, 325);
		frame.getContentPane().add(panel_1_1);
		
		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(CrearView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(312, 86, 256, 104);
		frame.getContentPane().add(lblPokedex);
	}
	
	/**
	 * Configura las acciones al presionar un botón
	 */
	public void setListeners() {
		btnVolverPkx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PokedexView.setVisible(true);
				frame.dispose();
			}
		});
		
		btnConfirmarCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarCreacion();
			}
		});
	}
	
	/**
	 * Verifica que los datos introducidos sean correctos previo a crear un Pokemon
	 */
	public void verificarCreacion() {
		boolean nombreRepetido = false;
		boolean numeroRepetido = false;
		boolean tipoExistente = true;
		int num = Integer.parseInt(textFldSetNumero.getText());
		double alt = Double.parseDouble(textFldSetAltura.getText());
		double pes = Double.parseDouble(textFldSetPeso.getText());
		String tip = textFldSetTipo.getText().toUpperCase();
		
		for(int i = 0; i < Almacen.pokemones.size(); i++) {
			if((Almacen.pokemones.get(i).getNombre()).equals(textFldSetNombre.getText())) {
				nombreRepetido = true;
			}
			
			if((Almacen.pokemones.get(i).getNumero()) == num) {
				numeroRepetido = true;
			}
		}
		
		switch (tip) {
		
		case "FUEGO":
			EnumSetTipo = enums.TipoPokemons.Fuego;
			break;
	
		case "AGUA":
			EnumSetTipo = enums.TipoPokemons.Agua;
			break;
			
		case "PLANTA":
			EnumSetTipo = enums.TipoPokemons.Planta;
			break;
			
		case "NORMAL":
			EnumSetTipo = enums.TipoPokemons.Normal;
			break;
			
		case "ELECTRICO":
			EnumSetTipo = enums.TipoPokemons.Eléctrico;
			break;
		
		case "PSIQUICO":
			EnumSetTipo = enums.TipoPokemons.Psíquico;
			break;
			
		case "LUCHA":
			EnumSetTipo = enums.TipoPokemons.Lucha;
			break;
			
		case "ROCA":
			EnumSetTipo = enums.TipoPokemons.Roca;
			break;
			
		case "TIERRA":
			EnumSetTipo = enums.TipoPokemons.Tierra;
			break;
			
		case "VOLADOR":
			EnumSetTipo = enums.TipoPokemons.Volador;
			break;
			
		case "BICHO":
			EnumSetTipo = enums.TipoPokemons.Bicho;
			break;
			
		case "SINIESTRO":
			EnumSetTipo = enums.TipoPokemons.Siniestro;
			break;
			
		case "FANTASMA":
			EnumSetTipo = enums.TipoPokemons.Fantasma;
			break;
			
		case "HIELO":
			EnumSetTipo = enums.TipoPokemons.Hielo;
			break;
			
		case "ACERO":
			EnumSetTipo = enums.TipoPokemons.Acero;
			break;
			
		case "HADA":
			EnumSetTipo = enums.TipoPokemons.Hada;
			break;
			
		case "DRAGON":
			EnumSetTipo = enums.TipoPokemons.Dragón;
			break;
			
		default:
			tipoExistente = false;
		}
		
		if (!nombreRepetido && !numeroRepetido && tipoExistente) {
			Pokemon p = new Pokemon(num, textFldSetNombre.getText(), EnumSetTipo, alt, pes, textFldSetCategoria.getText(), textFldSetHabilidad.getText());
			Almacen.pokemones.add(p);
			JOptionPane.showMessageDialog(btnConfirmarCrear, "Pokemon añadido con éxito");
			new PokedexView(username, PokedexView, 0);
			PokedexView.dispose();
			frame.dispose();
		} else {
			if(nombreRepetido)
				JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - El nombre del Pokemon ya existe");
			if(numeroRepetido)
				JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - El numero del Pokemon ya existe");
			if(!tipoExistente)
				JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - El tipo de pokemon no existe");
		}
	}
}
