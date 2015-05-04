package pokemon;

public class Ataque {

	String nome;
	String tipoAtaque; // Tipos do Pokemon: fogo, agua, choque, fisico.
	int dano;
	int prioridade;
	
	public Ataque(int numero){
		if (numero == 1){
			this.nome = "Bomba Hidraulica";
			this.tipoAtaque = "agua";
			this.dano = 30;
		}
		else if (numero == 2){
			this.nome = "Jato de Agua";
			this.tipoAtaque = "agua";
			this.dano = 20;
		}
		else if (numero == 3){
			this.nome = "Rajada Flamejante";
			this.tipoAtaque = "fogo";
			this.dano = 30;
		}
		else if (numero == 4){
			this.nome = "Bola de Fogo";
			this.tipoAtaque = "fogo";
			this.dano = 20;
		}
		else if (numero == 5){
			this.nome = "Trovao";
			this.tipoAtaque = "choque";
			this.dano = 30;
		}
		else if (numero == 6){
			this.nome = "Choque do Trovao";
			this.tipoAtaque = "choque";
			this.dano = 20;
		}
		else if (numero == 7){
			this.nome = "Heavy Metal";
			this.tipoAtaque = "metal";
			this.dano = 30;
		}
		else if (numero == 8){
			this.nome = "Tungstenio";
			this.tipoAtaque = "metal";
			this.dano = 20;
		}
		else if (numero == 9){
			this.nome = "Ataque Rapido";
			this.tipoAtaque = "fisico";
			this.dano = 15;
		}
		else if (numero == 10){
			this.nome = "Hyper Raio";
			this.tipoAtaque = "fisico";
			this.dano = 25;
		}
		else if (numero == 666){ 
			// Easter Egg
			this.nome = "Roubar Alma";
			this.tipoAtaque = "spectral";
			this.dano = 100;
		}
		else if (numero == 794){
			// Easter Egg
			this.nome = "Chan-chan-chan";
			this.tipoAtaque = "samurai";
			this.dano = 0;
		}
	}
	
	public static void mostraAtaques(){
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