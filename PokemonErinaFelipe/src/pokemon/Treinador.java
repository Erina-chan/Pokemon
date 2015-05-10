package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Treinador {

	String nome;
	boolean perdeu = false;
	Pokemon[] pokebola = new Pokemon[6];
	Pokemon pAtivo; // ponteiro para o pokemon em combate

	public Treinador(String nome, int numPokemons) {
		this.nome = nome;
		Pokemon.mostraPokemons();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numPokemons; i++) {

			System.out.print("Digite o numero do " + (i + 1) + "- pokemon: ");
			int pokeNum = sc.nextInt();

			this.pokebola[i] = new Pokemon(pokeNum);

			if (i == 0) {
				this.pokebola[i].ativo = true; // Primeiro pokemon sempre sera o
												// primeiro a entrar em combate.
				this.pAtivo = this.pokebola[i];
			}

		}
	}

	public Treinador(String nome) {
		this.nome = nome;

		Random generator = new Random(System.currentTimeMillis());

		int numPoke = Math.abs(generator.nextInt() % 11);

		if (numPoke == 0)
			numPoke = 1;
		int atq1 = Math.abs(generator.nextInt() % 11);
		if (atq1 == 0)
			atq1 = 1;
		int atq2 = Math.abs(generator.nextInt() % 11);
		if (atq2 == 0)
			atq2 = 1;
		int atq3 = Math.abs(generator.nextInt() % 11);
		if (atq3 == 0)
			atq3 = 1;
		int atq4 = Math.abs(generator.nextInt() % 11);
		if (atq4 == 0)
			atq4 = 1;

		this.pokebola[0] = new Pokemon(numPoke, atq1, atq2, atq3, atq4);
		this.pokebola[0].ativo = true;
		this.pAtivo = this.pokebola[0];
	}

	public Treinador(String nome, String inutil) {
		this.nome = nome;
		this.pokebola[0] = new Pokemon(nome);
		this.pokebola[0].ativo = true;
		this.pAtivo = this.pokebola[0];
	}

	public void fugir() {
		this.perdeu = true;
		System.out.println("O treinador " + this.nome + " fugiu da batalha!!!");
	}

	public void cura(Pokemon p) {
		if (p.hp != 0) {
			p.hp += 25;
			if (p.hp > 100)
				p.hp = 100;
		}
	}

	public void trocaPokemon(Pokemon pReserva) {
		this.pAtivo.ativo = false;
		pReserva.ativo = true;
		this.pAtivo = pReserva;
	}

	public void ataca(Treinador outro, int opcao) {

		Pokemon atacante = this.pAtivo;
		Pokemon atacado = outro.pAtivo;
		int num = 0; // Somente para o compilador nao reclamar

		if (opcao == 4)
			num = 0;
		else if (opcao == 5)
			num = 1;
		else if (opcao == 6)
			num = 2;
		else if (opcao == 7)
			num = 3;

		System.out.println(atacante.nome + " atacou " + atacado.nome + " com "
				+ atacante.ataques[num].nome);

		if (atacante.ataques[num].tipoAtaque.equals("choque")
				&& atacado.tipoPokemon.equals("agua"))
			atacado.hp -= 2 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("agua")
				&& atacado.tipoPokemon.equals("fogo"))
			atacado.hp -= 2 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("fogo")
				&& atacado.tipoPokemon.equals("metal"))
			atacado.hp -= 2 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("metal")
				&& atacado.tipoPokemon.equals("choque"))
			atacado.hp -= 2 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("choque")
				&& atacado.tipoPokemon.equals("metal"))
			atacado.hp -= 0.5 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("agua")
				&& atacado.tipoPokemon.equals("choque"))
			atacado.hp -= 0.5 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("fogo")
				&& atacado.tipoPokemon.equals("agua"))
			atacado.hp -= 0.5 * atacante.ataques[num].dano;

		else if (atacante.ataques[num].tipoAtaque.equals("metal")
				&& atacado.tipoPokemon.equals("fogo"))
			atacado.hp -= 0.5 * atacante.ataques[num].dano;

		else
			atacado.hp -= atacante.ataques[num].dano;
	}

	public void perdeu() {
		// verifica se ainda existe pokemon vivo
		boolean possibilidadePerdeu = true;
		for (int i = 0; i < 6; i++) {
			if (pokebola[i] != null) {
				if (pokebola[i].vivo == true) {
					possibilidadePerdeu = false;
				}
			}
		}

		if (this.perdeu == false) {
			this.perdeu = possibilidadePerdeu;
		}
	}

	public void captura(Treinador t) {
		if (this.pokebola[5] == null) {
			System.out.println(this.nome + " jogou uma pokebola");
			BatalhaPokemon.delay(1000);
			System.out.println("Tu...");
			BatalhaPokemon.delay(1000);
			System.out.println("Tu...");
			BatalhaPokemon.delay(1000);
			if (Math.random() * 100 > t.pAtivo.hp) {

				System.out.println("Tu!");
				BatalhaPokemon.delay(1000);
				System.out.println("Voce capturou " + t.pAtivo.nome + "!!!");

				for (int i = 0; i < 5; i++) {

					if (pokebola[i] == null) {
						pokebola[i] = t.pAtivo;
						break;
					}
				}
				t.pokebola[0] = null;
				t.pAtivo.ativo = false;
				t.perdeu = true;
			}

			// FALHOU
			else {
				System.out.println("O pokemon escapou da pokebola");
			}
		} else
			System.out
					.println("Voce nao tem espaco para capturar esse pokemon");

	}
	
	public void imprimePokemons() {
		System.out.println("Time Pokemon: ");
		System.out.println("----------------------------------------------------------------------------------");
		for(int i = 0; i < 6; i++){
			if (this.pokebola[i] != null)
				System.out.println(i + 1 + ". " + this.pokebola[i].nome + " - HP:" +this.pokebola[i].hp + "/100");
		}
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
	}
}