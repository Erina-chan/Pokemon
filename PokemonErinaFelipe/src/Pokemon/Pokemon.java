package Pokemon;

public class Pokemon {

	String nome;
	String tipo; // Tipos: fogo, agua, choque, fisico.
	int hp = 100;
	boolean ativo = false; //Indica se o pokemon esta em combate.
	
	public Pokemon(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public void investida(Pokemon p) {
		p.hp -= 20;
	}

	public void rajadaFlamejante(Pokemon p) {
		if (p.tipo.equals("choque")) {
			p.hp -= 30;
		} else if (p.tipo.equals("agua")) {
			p.hp -= 10;
		} else {
			p.hp -= 20;
		}
	}

	public void trovao(Pokemon p) {
		if (p.tipo.equals("agua")) {
			p.hp -= 30;
		} else if (p.tipo.equals("fogo")) {
			p.hp -= 10;
		} else {
			p.hp -= 20;
		}
	}

	public void bombaHidraulica(Pokemon p) {
		if (p.tipo.equals("fogo")) {
			p.hp -= 30;
		} else if (p.tipo.equals("choque")) {
			p.hp -= 10;
		} else {
			p.hp -= 20;
		}
	}

	public void morre() {
		if (this.hp <= 0) {
			System.out.println(this.nome + " foi nocauteado.");
			this.ativo = false;
		}
	}
}
