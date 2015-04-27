package pokemon;

import java.util.Scanner;

public class Treinador {

	String nome;
	boolean perdeu = false;
	Pokemon[] pokebola = new Pokemon[6];

	public Treinador(String nome, int numPokemons) {
		this.nome = nome;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numPokemons; i++) {

			System.out.print("Digite o nome do " + (i + 1) + " pokemon: ");
			String pokeNome = sc.nextLine();
			System.out.print("Digite o tipo do " + pokeNome);
			String pokeTipo = sc.nextLine();

			pokebola[i] = new Pokemon(pokeNome, pokeTipo);
			if (i == 0) {
				pokebola[i].ativo = true; // Primeiro pokemon sempre sera o
											// primeiro a entrar em combate.
			}
		}
		sc.close();
	}

	public void fugir() {
		System.out.println("O treinador " + this.nome + " fugiu da batalha!!!");
	}

	public void cura(Pokemon p) {
		p.hp += 25;
	}

	public void trocaPokemon(Pokemon pAtual, Pokemon pReserva) {
		pAtual.ativo = false;
		pReserva.ativo = true;
	}

	public void ataca(Treinador outro) {
		//TODO temos que completar isso!
		Pokemon atacante;
		Pokemon atacado;
		for (int i = 0; i < 6; i++) {
			// Achando os pokemons em combate de cada treinador.
			if (this.pokebola[i].ativo) {
				atacante = this.pokebola[i];
			}
			if (outro.pokebola[i].ativo) {
				atacado = outro.pokebola[i];
			}
		}
	}
	
	public void perdeu() {
		boolean possibilidadePerdeu = true;
		for(int i = 0; i < 6; i++) {
			if (pokebola[i].ativo == true) {
				possibilidadePerdeu = false;
			}
		}
		this.perdeu = possibilidadePerdeu;
	}
}
