package pokemon;

public class Ataque {

	String nome;
	String tipoAtaque; // Tipos do Pokemon: fogo, agua, choque, fisico.
	int dano;
	int prioridade;

	public Ataque(int numero) {
		switch (numero) {
		case 1:
			this.nome = "Bomba Hidraulica";
			this.tipoAtaque = "agua";
			this.dano = 30;
			break;
		case 2:
			this.nome = "Jato de Agua";
			this.tipoAtaque = "agua";
			this.dano = 20;
			break;
		case 3:
			this.nome = "Rajada Flamejante";
			this.tipoAtaque = "fogo";
			this.dano = 30;
			break;
		case 4:
			this.nome = "Bola de Fogo";
			this.tipoAtaque = "fogo";
			this.dano = 20;
			break;
		case 5:
			this.nome = "Trovao";
			this.tipoAtaque = "choque";
			this.dano = 30;
			break;
		case 6:
			this.nome = "Choque do Trovao";
			this.tipoAtaque = "choque";
			this.dano = 20;
			break;
		case 7:
			this.nome = "Heavy Metal";
			this.tipoAtaque = "metal";
			this.dano = 30;
			break;
		case 8:
			this.nome = "Tungstenio";
			this.tipoAtaque = "metal";
			this.dano = 20;
			break;
		case 9:
			this.nome = "Ataque Rapido";
			this.tipoAtaque = "fisico";
			this.dano = 15;
			break;
		case 10:
			this.nome = "Hyper Raio";
			this.tipoAtaque = "fisico";
			this.dano = 25;
			break;
		case 666:
			// Easter Egg
			this.nome = "Roubar Alma";
			this.tipoAtaque = "spectral";
			this.dano = 100;
			break;
		case 794:
			// Easter Egg
			this.nome = "Chan-chan-chan";
			this.tipoAtaque = "samurai";
			this.dano = 0;
			break;
		default:
			break;
		}
	}

	public static void mostraAtaques() {
		System.out.println("\nAtaques disponiveis: ");
		System.out.println("1. Bomba Hidraulica - agua - dano: 30 ");
		System.out.println("2. Jato de Agua - agua - dano: 20 ");
		System.out.println("3. Rajada Flamejante - fogo - dano: 30 ");
		System.out.println("4. Bola de Fogo - fogo - dano: 20 ");
		System.out.println("5. Trovao - choque - dano: 30 ");
		System.out.println("6. Choque do Trovao - choque - dano: 20 ");
		System.out.println("7. Heavy Metal - metal - dano: 30 ");
		System.out.println("8. Tungstenio - metal - dano: 20 ");
		System.out.println("9. Ataque Rapido - fisico - dano: 15 ");
		System.out.println("10. Hyper Raio  - fisico - dano: 25 ");
	}
}