package pokemon;

import java.util.Scanner;

public class BatalhaPokemon {
	
	public static void main(String[] args) {
		
		Rodada rodada = new Rodada();
		Evento ev1;
		Evento ev2;		
		MP3 mp3 = new MP3("Pokemon Theme.mp3");
		
		mp3.play();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Treinador 1:");
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons = sc.nextInt();
		
		Treinador t1 = new Treinador(nome, numPokemons);
		
		System.out.println("");
		System.out.println("Treinador 2:");
		System.out.print("Digite seu nome: ");
		sc.nextLine(); // para eliminar problemas com o buffer
		String nome2 = sc.nextLine();
		System.out.print("Aperte ENTER para continuar: ");
		sc.nextLine();	
		System.out.print("Digite seu numero de pokemons (1 <= n <= 6): ");
		int numPokemons2 = sc.nextInt();
		
		Treinador t2 = new Treinador(nome2, numPokemons2);

		System.out.print("A batalha vai come�ar!");
		mp3.close();
		mp3 = new MP3("Pokemon Battle Theme.mp3");
		mp3.play();
		delay(2000);
		
		while(t1.perdeu == false && t2.perdeu == false){
			
			mostraStatus(t1, t2);
			System.out.println(t1.nome);
			mostraOpcoes(t1);
			int opcao1 = sc.nextInt();
			delay(500);
			
			System.out.println(t2.nome);
			mostraOpcoes(t2);
			int opcao2 = sc.nextInt();
			delay(500);
			

			ev1 = retornaEvento(opcao1,t1,t2);
			ev2 = retornaEvento(opcao2,t2,t1);
			
			rodada.addEvent(ev1);
			rodada.addEvent(ev2);
			rodada.run();
			
		}
		
		sc.close();	
		delay(1000);
		mp3.close();
		mp3 = new MP3("Pokemon Victory Theme.mp3");
		mp3.play();
		System.out.println();
		if (t1.perdeu == true)
			System.out.println(t2.nome + " ganhou!!! Parabens, mestre pokemon!");
		else
			System.out.println(t1.nome + " ganhou!!! Parabens, mestre pokemon!");
		delay(7000);
		mp3.close();
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
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(t1.nome + "		Pokemon: " + t1.pAtivo.nome
				+ "		Tipo: " + t1.pAtivo.tipoPokemon + "		HP: " + t1.pAtivo.hp + "/100");
		System.out.println(t2.nome + "		Pokemon: " + t2.pAtivo.nome
				+ "		Tipo: " + t2.pAtivo.tipoPokemon + "		HP: " + t2.pAtivo.hp + "/100");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
	}
	
	public static Evento retornaEvento(int opcao,Treinador ator, Treinador outro){
		
		if (opcao == 0){
			Captura ev = new Captura(opcao,ator,outro);
			return ev;
		}
		
		else if (opcao == 1){
			Fuga ev = new Fuga(opcao,ator,null);
			return ev;
		}
		
		else if (opcao == 2){
			Cura ev = new Cura(opcao,ator,null);
			return ev;
		}
		
		else if (opcao == 3){
			Troca ev = new Troca(opcao,ator,null);
			return ev;
		}
		
		else{
			Ataca ev = new Ataca(opcao,ator,outro);
			return ev;
		}
		
	}
	
	public static void delay(int tempo){
		try {  
			   Thread.sleep(tempo);  
			} catch (Exception e) {  
			   e.printStackTrace();  
			} 
	}
}
