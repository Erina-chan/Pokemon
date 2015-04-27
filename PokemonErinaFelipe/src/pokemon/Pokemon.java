package pokemon;

public class Pokemon {

	String nome;
	String tipoPokemon; // Tipos do Pokemon: fogo, agua, choque, fisico.
	int hp = 100;
	boolean ativo = false; // Indica se o pokemon esta em combate.

	public Pokemon(String nome, String tipo) {
		this.nome = nome;
		this.tipoPokemon = tipo;
	}

}
