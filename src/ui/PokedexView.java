package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import utils.Almacen;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PokedexView {

	private JFrame frmPokedex;
	private JPanel panelRojoSuperior;
	private JLabel lblTituloPokedex;
	private JButton btnSalir;
	private JLabel lblNombreUser;
	private JLabel lblPokemonName;
	private JPanel panelFondoPokemon;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblPokemonNumber;
	private JLabel lblImagenPokemon;
	private JLabel lblPokemonImg;
	private JPanel panelOpciones;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnCrear;
	private JLabel lblPokemonType;
	private JPanel panelFondoTipoPokemon;
	private JSeparator separator;
	private JLabel lbltxtAltura;
	private JLabel lblDatoDeAltura;
	private JLabel lbltxtPeso;
	private JLabel lblDatoDePeso;
	private JLabel lbltxtCategoria;
	private JLabel lblDatoDeCategoria;
	private JLabel lbltxtHabilidad;
	private JLabel lblDatoDeHabilidad;
	private JLabel lblUserImg;
	private JFrame frmLoginView;
	private String username;
	private int pagina;
	

	
	/**
	 * Create the application.
	 */
	public PokedexView(String username, JFrame LoginView, int pagina) {	
		this.frmLoginView = LoginView;
		this.username = username;
		this.pagina = pagina;
		initialize();
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	public void initialize() {
		setUIComponents();
		setListeners();
	}
	
	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frmPokedex = new JFrame();
		frmPokedex.getContentPane().setBackground(Color.DARK_GRAY);
		frmPokedex.setTitle("Pokedex - Men\u00FA");
		frmPokedex.setBounds(100, 100, 665, 495);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);
		
		panelRojoSuperior = new JPanel();
		panelRojoSuperior.setBackground(Color.RED);
		panelRojoSuperior.setBounds(0, 0, 652, 56);
		frmPokedex.getContentPane().add(panelRojoSuperior);
		panelRojoSuperior.setLayout(null);
		
		lblTituloPokedex = new JLabel("Pokedex");
		lblTituloPokedex.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblTituloPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPokedex.setBounds(230, 10, 187, 34);
		lblTituloPokedex.setForeground(Color.WHITE);
		panelRojoSuperior.add(lblTituloPokedex);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(10, 17, 89, 23);
		panelRojoSuperior.add(btnSalir);
		
		lblNombreUser = new JLabel(username);
		lblNombreUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUser.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNombreUser.setForeground(new Color(255, 255, 255));
		lblNombreUser.setBounds(441, 11, 156, 33);
		panelRojoSuperior.add(lblNombreUser);
		
		lblUserImg = new JLabel("");
		lblUserImg.setBounds(606, 17, 22, 22);
		lblUserImg.setIcon(new ImageIcon(PokedexView.class.getResource("/img/user.png")));
		panelRojoSuperior.add(lblUserImg);
		
		panelFondoPokemon = new JPanel();
		panelFondoPokemon.setBackground(Color.WHITE);
		panelFondoPokemon.setBounds(68, 67, 515, 282);
		frmPokedex.getContentPane().add(panelFondoPokemon);
		panelFondoPokemon.setLayout(null);
		
		lblPokemonName = new JLabel(Almacen.pokemones.get(pagina).getNombre());
		lblPokemonName.setFont(new Font("Verdana", Font.BOLD, 24));
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(35, 12, 208, 28);
		panelFondoPokemon.add(lblPokemonName);
		
		lblPokemonNumber = new JLabel("N°"+Almacen.pokemones.get(pagina).getNumero());
		lblPokemonNumber.setForeground(new Color(128, 128, 128));
		lblPokemonNumber.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPokemonNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonNumber.setBounds(331, 15, 89, 27);
		panelFondoPokemon.add(lblPokemonNumber);
		
		lblPokemonImg = new JLabel("");
		lblPokemonImg.setBounds(75, 65, 128, 128);
		lblPokemonImg.setIcon(Almacen.pokemones.get(pagina).getImagen());
		panelFondoPokemon.add(lblPokemonImg);
		
		panelFondoTipoPokemon = new JPanel();
		panelFondoTipoPokemon.setBackground(new Color(255, 204, 204));
		panelFondoTipoPokemon.setBounds(75, 204, 128, 21);
		panelFondoPokemon.add(panelFondoTipoPokemon);
		panelFondoTipoPokemon.setLayout(null);
		
		lblPokemonType = new JLabel(""+Almacen.pokemones.get(pagina).getTipo());
		lblPokemonType.setBounds(0, 0, 128, 21);
		panelFondoTipoPokemon.add(lblPokemonType);
		lblPokemonType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPokemonType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonType.setForeground(Color.BLACK);
		lblPokemonType.setBackground(new Color(255, 204, 204));
		
		separator = new JSeparator();
		separator.setBounds(35, 50, 435, 28);
		panelFondoPokemon.add(separator);
		
		lbltxtAltura = new JLabel("Altura:");
		lbltxtAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtAltura.setBounds(278, 88, 85, 14);
		panelFondoPokemon.add(lbltxtAltura);
		
		lblDatoDeAltura = new JLabel(""+Almacen.pokemones.get(pagina).getAltura());
		lblDatoDeAltura.setForeground(new Color(128, 128, 128));
		lblDatoDeAltura.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeAltura.setBounds(360, 87, 97, 18);
		panelFondoPokemon.add(lblDatoDeAltura);
		
		lbltxtPeso = new JLabel("Peso:");
		lbltxtPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtPeso.setBounds(288, 113, 75, 28);
		panelFondoPokemon.add(lbltxtPeso);
		
		lblDatoDePeso = new JLabel(""+Almacen.pokemones.get(pagina).getPeso());
		lblDatoDePeso.setForeground(new Color(128, 128, 128));
		lblDatoDePeso.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDePeso.setBounds(360, 119, 97, 18);
		panelFondoPokemon.add(lblDatoDePeso);
		
		lbltxtCategoria = new JLabel("Categoria:");
		lbltxtCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtCategoria.setBounds(251, 152, 112, 28);
		panelFondoPokemon.add(lbltxtCategoria);
		
		lblDatoDeCategoria = new JLabel(Almacen.pokemones.get(pagina).getCategoria());
		lblDatoDeCategoria.setForeground(new Color(128, 128, 128));
		lblDatoDeCategoria.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeCategoria.setBounds(360, 157, 97, 20);
		panelFondoPokemon.add(lblDatoDeCategoria);
		
		lbltxtHabilidad = new JLabel("Habilidad:");
		lbltxtHabilidad.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtHabilidad.setBounds(261, 191, 102, 27);
		panelFondoPokemon.add(lbltxtHabilidad);
		
		lblDatoDeHabilidad = new JLabel(Almacen.pokemones.get(pagina).getHabilidad());
		lblDatoDeHabilidad.setForeground(new Color(128, 128, 128));
		lblDatoDeHabilidad.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeHabilidad.setBounds(360, 195, 97, 20);
		panelFondoPokemon.add(lblDatoDeHabilidad);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBounds(10, 67, 46, 282);
		if(pagina == 0) {
			btnAnterior.setEnabled(false);
		}
		frmPokedex.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.setBounds(596, 67, 46, 282);
		if(pagina == Almacen.pokemones.size()-1) {
			btnSiguiente.setEnabled(false);
		}
		frmPokedex.getContentPane().add(btnSiguiente);
		
		panelOpciones = new JPanel();
		panelOpciones.setBounds(10, 365, 632, 73);
		frmPokedex.getContentPane().add(panelOpciones);
		panelOpciones.setBackground(Color.WHITE);
		panelOpciones.setLayout(null);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(72, 61, 139));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnBorrar.setBounds(60, 11, 120, 40);
		panelOpciones.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(72, 61, 139));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnActualizar.setBounds(242, 11, 150, 40);
		panelOpciones.add(btnActualizar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBackground(new Color(72, 61, 139));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCrear.setBounds(457, 11, 120, 40);
		panelOpciones.add(btnCrear);
		frmPokedex.setVisible(true);
		
	}
	
	/**
	 * Configura las acciones al presionar un botón
	 */
	private void setListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.dispose();
				frmLoginView.setVisible(true);	
				frmPokedex.dispose();
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					pagina--;
					new PokedexView(username, frmLoginView, pagina);
					frmPokedex.dispose(); 
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagina++;
				new PokedexView(username, frmLoginView, pagina);
				frmPokedex.dispose();
			} 
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new CrearView(frmPokedex, username);
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Almacen.pokemones.size() > 1) {
					Almacen.pokemones.remove(pagina);
					new PokedexView(username, frmLoginView, 0);
					frmPokedex.dispose();
				} else {
					JOptionPane.showMessageDialog(btnBorrar, "ERR0R! - La pokedex no puede quedar vacia");
				}
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnActualizar, "Esta opción se encuentra en desarrollo. Disuclpe las molestias");
			}
		});
	}
}
