package pokemon;

import java.util.Scanner;

public class Pokemon {

	String nome;
	String tipoPokemon; // Tipos do Pokemon: fogo, agua, choque, fisico.
	int hp = 100;
	boolean ativo = false; // Indica se o pokemon esta em combate.
	boolean vivo = true; // Indica se o pokemon esta vivo ou morto
	Ataque[] ataques = new Ataque[4]; // Vetor de ataques do pokemon

	public Pokemon(int num) {
		if (num == 1) {
			this.nome = "Goldman";
			this.tipoPokemon = "fogo";
		} else if (num == 2) {
			this.nome = "Thiaguinho";
			this.tipoPokemon = "metal";
		} else if (num == 3) {
			this.nome = "Selma";
			this.tipoPokemon = "fisico";
		} else if (num == 4) {
			this.nome = "Gilson";
			this.tipoPokemon = "metal";
		} else if (num == 5) {
			this.nome = "Magno";
			this.tipoPokemon = "choque";
		} else if (num == 6) {
			this.nome = "Fajardo";
			this.tipoPokemon = "agua";
		} else if (num == 7) {
			this.nome = "Pai Hirata";
			this.tipoPokemon = "fogo";
		} else if (num == 8) {
			this.nome = "Roseli";
			this.tipoPokemon = "choque";
		} else if (num == 9) {
			this.nome = "Andre Trivial";
			this.tipoPokemon = "agua";
		} else if (num == 10) {
			this.nome = "Gomi";
			this.tipoPokemon = "fisico";
		}

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o numero de ataques (1 <= n <= 4): ");
		int numAtaques = sc.nextInt();

		Ataque.mostraAtaques();

		for (int i = 0; i < numAtaques; i++) {

			System.out.print("Digite o numero do " + (i + 1) + "- ataque: ");
			int numAtaque = sc.nextInt();

			this.ataques[i] = new Ataque(numAtaque);

		}

		// sc.close();
	}

	public Pokemon(int num, int atq1, int atq2, int atq3, int atq4) {
		if (num == 1) {
			this.nome = "Goldman";
			this.tipoPokemon = "fogo";
		} else if (num == 2) {
			this.nome = "Thiaguinho";
			this.tipoPokemon = "metal";
		} else if (num == 3) {
			this.nome = "Selma";
			this.tipoPokemon = "fisico";
		} else if (num == 4) {
			this.nome = "Gilson";
			this.tipoPokemon = "metal";
		} else if (num == 5) {
			this.tipoPokemon = "choque";
		} else if (num == 6) {
			this.nome = "Fajardo";
			this.tipoPokemon = "agua";
		} else if (num == 7) {
			this.nome = "Pai Hirata";
			this.tipoPokemon = "fogo";
		} else if (num == 8) {
			this.nome = "Roseli";
			this.tipoPokemon = "choque";
		} else if (num == 9) {
			this.nome = "Andre Trivial";
			this.tipoPokemon = "agua";
		} else if (num == 10) {
			this.nome = "Gomi";
			this.tipoPokemon = "fisico";
		}

		this.ataques[0] = new Ataque(atq1);
		this.ataques[1] = new Ataque(atq2);
		this.ataques[2] = new Ataque(atq3);
		this.ataques[3] = new Ataque(atq4);
	}

	public Pokemon(String nome) { // SOMENTE PARA USAR NO JUNIT
		this.nome = nome;
		this.ataques[0] = new Ataque(1);
		this.tipoPokemon = "agua";
	}

	public static void mostraPokemons() {
		System.out.println("\nPokemons disponiveis: ");
		System.out.println("1. Goldman - fogo");
		System.out.println("2. Thiaguinho - metal");
		System.out.println("3. Selma - fisico");
		System.out.println("4. Gilson - metal");
		System.out.println("5. Magno - choque");
		System.out.println("6. Fajardo - agua");
		System.out.println("7. Pai Hirata - fogo");
		System.out.println("8. Roseli - choque");
		System.out.println("9. Andre Trivial - agua");
		System.out.println("10. Gomi - fisico");
	}
}