package pokemon;

import java.util.Scanner;

public class BatalhaPokemon {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Treinador 1:");
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons = sc.nextInt();
		
		Treinador t1 = new Treinador(nome, numPokemons);
		
		System.out.println("Treinador 2:");
		System.out.print("Digite seu nome: ");
		sc.nextLine(); // para eliminar problemas com o buffer
		String nome2 = sc.nextLine();
		sc.nextLine();
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons2 = sc.nextInt();
		
		Treinador t2 = new Treinador(nome2, numPokemons2);
		
		Evento ev1;
		Evento ev2;
		
		while(t1.perdeu == false && t2.perdeu == false){
			
			mostraStatus(t1, t2);
			System.out.println(t1.nome);
			mostraOpcoes(t1);
			int opcao1 = sc.nextInt();
			
			System.out.println(t2.nome);
			mostraOpcoes(t2);
			int opcao2 = sc.nextInt();
			
			
			// Comparar as prioridades dos eventos
			if (opcao1 <= opcao2){
				ev1 = retornaEvento(opcao1);
				ev2 = retornaEvento(opcao2);
				
				if (opcao1 > 3) { // Ambas as acoes sao ataques
					((Ataca)ev1).acao(t1, t2,opcao1);
					t2.perdeu();
					
					if (t2.perdeu == true) 
						break;
					
					((Ataca)ev2).acao(t2, t1,opcao2);
					t1.perdeu();

					
				}
				else { // opcao1 < 3
					
					if(opcao2 > 3){
						ev1.acao(t1);
						if (t1.perdeu == true) 
							break;
						((Ataca)ev2).acao(t2, t1,opcao2);
						t2.perdeu();
						
					}
					
					else{ // Ambas as acoes nao sao ataques
						ev1.acao(t1);
						if (t1.perdeu == true) 
							break;
						ev2.acao(t2);
					}
				}
			}
			
			else { // opcao1 > opcao2
				ev1 = retornaEvento(opcao2);
				ev2 = retornaEvento(opcao1);
				
				if (opcao2 > 3) { // Ambas as acoes sao ataques
					((Ataca)ev1).acao(t2, t1,opcao2);
					t1.perdeu();
					
					if (t1.perdeu == true) 
						break;
					
					((Ataca)ev2).acao(t1, t2,opcao1);
					t2.perdeu();

					
				}
				else { // opcao2 < 3
					
					if(opcao1 > 3){
						ev1.acao(t2);
						if (t2.perdeu == true) 
							break;
						((Ataca)ev2).acao(t1, t2,opcao1);
						t2.perdeu();
						
					}
					
					else{ // Ambas as acoes nao sao ataques
						ev1.acao(t2);
						if (t2.perdeu == true) 
							break;
						ev2.acao(t1);
					}
				}
			}		
		}
		
		sc.close();
		
		System.out.println();
		if (t1.perdeu == true)
			System.out.println(t2.nome + " ganhou!!! Parabens, mestre pokemon!");
		else
			System.out.println(t1.nome + " ganhou!!! Parabens, mestre pokemon!");
			
	}
	
	public static void mostraOpcoes(Treinador t){
		System.out.println("Digite 1 para Fugir.");
		System.out.println("Digite 2 para Curar um de seus pokemons.");
		System.out.println("Digite 3 para Trocar de pokemon.");
		
		if (t.pAtivo.ataques[1] == null){
			System.out.println("Digite 4 para usar " + t.pAtivo.ataques[0].nome + "(" + t.pAtivo.ataques[0].tipoAtaque + ")");
		}
		else if (t.pAtivo.ataques[2] == null){
			System.out.println("Digite 4 para usar " + t.pAtivo.ataques[0].nome + "(" + t.pAtivo.ataques[0].tipoAtaque + ")");
			System.out.println("Digite 5 para usar " + t.pAtivo.ataques[1].nome + "(" + t.pAtivo.ataques[1].tipoAtaque + ")");
		}
		else if(t.pAtivo.ataques[3] == null){
			System.out.println("Digite 4 para usar " + t.pAtivo.ataques[0].nome + "(" + t.pAtivo.ataques[0].tipoAtaque + ")");
			System.out.println("Digite 5 para usar " + t.pAtivo.ataques[1].nome + "(" + t.pAtivo.ataques[1].tipoAtaque + ")");
			System.out.println("Digite 6 para usar " + t.pAtivo.ataques[2].nome + "(" + t.pAtivo.ataques[2].tipoAtaque + ")");
		}
		else{
			System.out.println("Digite 4 para usar " + t.pAtivo.ataques[0].nome + "(" + t.pAtivo.ataques[0].tipoAtaque + ")");
			System.out.println("Digite 5 para usar " + t.pAtivo.ataques[1].nome + "(" + t.pAtivo.ataques[1].tipoAtaque + ")");
			System.out.println("Digite 6 para usar " + t.pAtivo.ataques[2].nome + "(" + t.pAtivo.ataques[2].tipoAtaque + ")");
			System.out.println("Digite 7 para usar " + t.pAtivo.ataques[3].nome + "(" + t.pAtivo.ataques[3].tipoAtaque + ")"); 
		}
	}
	
	public static void mostraStatus(Treinador t1, Treinador t2){
		System.out.println(t1.nome + "		Pokemon: " + t1.pAtivo.nome
				+ "		Tipo: " + t1.pAtivo.tipoPokemon + "		HP: " + t1.pAtivo.hp);
		System.out.println(t2.nome + "		Pokemon: " + t2.pAtivo.nome
				+ "		Tipo: " + t2.pAtivo.tipoPokemon + "		HP: " + t2.pAtivo.hp);
		System.out.println();
	}
	
	public static Evento retornaEvento(int opcao){
		if (opcao == 1){
			Fuga ev = new Fuga();
			return ev;
		}
		
		else if (opcao == 2){
			Cura ev = new Cura();
			return ev;
		}
		
		else if (opcao == 3){
			Troca ev = new Troca();
			return ev;
		}
		
		else{
			Ataca ev = new Ataca();
			return ev;
		}
		
	}
	
}