package mainapp;

import javax.swing.ImageIcon;

import enums.TipoPokemons;
import models.Pokemon;
import ui.LoginView;
import utils.Almacen;

public class mainapp {

	public static void main(String[] args) {
		
		Pokemon p1 = new Pokemon(1, "Bulbasaur", TipoPokemons.Planta, 0.7, 6.9, "Semilla", "Espesura", new ImageIcon(Pokemon.class.getResource("/img/Bulbasaur.png")));
		Almacen.pokemones.add(p1);
		Pokemon p2 = new Pokemon(2, "Charmander", TipoPokemons.Fuego, 0.6, 8.5, "Lagartija", "Mar llamas", new ImageIcon(Pokemon.class.getResource("/img/Charmander.png")));
		Almacen.pokemones.add(p2);
		Pokemon p3 = new Pokemon(3, "Squirtle", TipoPokemons.Agua, 0.5, 9.0, "Tortuguita", "Torrente",new ImageIcon(Pokemon.class.getResource("/img/Squirtle.png")));
		Almacen.pokemones.add(p3);
		LoginView lg = new LoginView();

	}

}
