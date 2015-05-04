package pokemon;

import java.util.Scanner;

public class MapaPokemon {

	public static void main(String[] args) {

		boolean batalhou = false;
		int escolha;
		int opcao1;
		int opcao2;
		double pivo;
		Evento ev1;
		Evento ev2;

		Scanner sc = new Scanner(System.in);
		System.out.println("Treinador");
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons = sc.nextInt();

		Treinador t1 = new Treinador(nome, numPokemons);
		Treinador t2 = new Treinador("Pokemon Selvagem");

		while (batalhou == false) {
			System.out.println();
			System.out.println("Digite 1 para andar sobre um chao comum ");
			System.out.println("Digite 2 para andar sobre um chao gramado ");
			System.out.println("Digite 3 para desistir ");
			escolha = sc.nextInt();

			if (escolha == 2) {
				// Aqui foi definido que a chance de encontrar um pokemon sera
				// de 50%

				if (Math.random() * 100 > 50) {
					
					System.out.println("Um pokemon selvagem foi encontrado!!!");

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

						// Comparar as prioridades dos eventos
						
						if (opcao1 == 0){
							
							ev2 = BatalhaPokemon.retornaEvento(opcao2);
							
							t1.captura(t2);
							if (t2.perdeu == true)
								break;
							
							((Ataca) ev2).acao(t2, t1, opcao2);

							t1.perdeu();
							if (t1.perdeu == true)
								break;	
			
						
							
						}
						else if (opcao1 <= opcao2) { // O treinador faz sua rodada
												// primeiro

							ev1 = BatalhaPokemon.retornaEvento(opcao1);
							ev2 = BatalhaPokemon.retornaEvento(opcao2);

							if (opcao1 > 3) {
								((Ataca) ev1).acao(t1, t2, opcao1);
								
								t2.perdeu();
								if (t2.perdeu == true)
									break;
							}
							else {
								ev1.acao(t1);
								if (t1.perdeu == true)
									break;
							}

							((Ataca) ev2).acao(t2, t1, opcao2);

							t1.perdeu();
							if (t1.perdeu == true)
								break;

						}

						else { // O pokemon faz sua rodada primeiro

							ev1 = BatalhaPokemon.retornaEvento(opcao2);
							ev2 = BatalhaPokemon.retornaEvento(opcao1);

							((Ataca) ev1).acao(t2, t1, opcao2);

							t1.perdeu();
							if (t1.perdeu == true)
								break;

							if (opcao1 > 3)
								((Ataca) ev2).acao(t1, t2, opcao1);
							else
								ev2.acao(t1);

							t2.perdeu();
							if (t2.perdeu == true)
								break;
						}
					}

					batalhou = true;
				} else
					System.out
							.println("Nenhum pokemon foi encontrado na grama");
			}

			else if (escolha == 3)
				batalhou = true; // Vamos considerar que ele batalhou pra sair
									// do laço

			else
				System.out.println("Nenhum pokemon foi encontrado");

		}
		sc.close();
		System.out.println();
		System.out.println("A simulacao acabou!");
	}

}