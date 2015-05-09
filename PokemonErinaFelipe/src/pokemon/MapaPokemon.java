package pokemon;

import java.util.Scanner;

public class MapaPokemon {

	public static void main(String[] args) {

		boolean batalhou = false;
		int escolha;
		int opcao1;
		int opcao2;
		double pivo;
		Rodada rodada = new Rodada();
		Evento ev1;
		Evento ev2;
		
		MP3 mp3 = new MP3("Pokemon Theme.mp3");
		mp3.play();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Treinador");
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons = sc.nextInt();

		Treinador t1 = new Treinador(nome, numPokemons);
		Treinador t2 = new Treinador("Pokemon");

		while (batalhou == false) {
			System.out.println();
			System.out.println("Digite 1 para andar sobre um chao comum ");
			System.out.println("Digite 2 para andar sobre um chao gramado ");
			System.out.println("Digite 3 para desistir ");
			escolha = sc.nextInt();
			
			delay(1000);
			
			if (escolha == 2) {
				// Aqui foi definido que a chance de encontrar um pokemon sera de 50 %

				if (Math.random() * 100 > 50) {
					mp3.close();
					mp3 = new MP3("Pokemon Battle Theme.mp3");
					delay(1000);
					System.out.println("Um pokemon selvagem foi encontrado!!!");
					mp3.play();
					delay(3000);

					while (t1.perdeu == false && t2.perdeu == false) {

						BatalhaPokemon.mostraStatus(t1, t2);
						System.out.println(t1.nome);
						System.out.println("Digite 0 para usar uma pokebola.");
						BatalhaPokemon.mostraOpcoes(t1);
						opcao1 = sc.nextInt();

						// Gerando a opcao do ataque do pokemon selvagem
						pivo = Math.random();
						if (pivo <= 0.25)
							opcao2 = 4;
						else if (pivo <= 0.5 && pivo > 0.25)
							opcao2 = 5;
						else if (pivo <= 0.75 && pivo > 0.5)
							opcao2 = 6;
						else
							opcao2 = 7;
						
						ev1 = BatalhaPokemon.retornaEvento(opcao1,t1,t2);
						ev2 = BatalhaPokemon.retornaEvento(opcao2,t2,t1);
						
						rodada.addEvent(ev1);
						rodada.addEvent(ev2);
						rodada.run();
						
						
					}
					batalhou = true;
				}
					
				else
					System.out.println("Nenhum pokemon foi encontrado na grama");
			}

			else if (escolha == 3)
				batalhou = true; // Vamos considerar que ele batalhou pra sair
									// do laco

			else
				System.out.println("Nenhum pokemon foi encontrado");

		}
		sc.close();
		
		delay(1000);
		mp3.close();
		
		System.out.println();
		//Cura.imprimePokemons(t1);
		
		System.out.println();
		System.out.println("A simulacao acabou!");
	}
	
	public static void delay(int tempo){ 
		try {  
			   Thread.sleep(tempo);  
			} catch (Exception e) {  
			   e.printStackTrace();  
			} 
	}

}
