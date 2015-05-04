package pokemon;

import java.util.Scanner;

public class Cura implements Evento {
	
	public void acao(Treinador t) {
		Scanner sc = new Scanner(System.in);
		imprimePokemons(t);
		System.out.print("Digite o numero do pokemon que voce quer curar: ");
		int num = sc.nextInt() - 1;
		t.cura(t.pokebola[num]);
		System.out.println("O pokemon foi curado.");
	}
	
	public static void imprimePokemons(Treinador t) {
		for(int i = 0; i < 6; i++){
			if (t.pokebola[i] != null){
				System.out.println(i + 1 + "..." + t.pokebola[i].nome 
						+ "... HP:" + t.pokebola[i].hp);
			}
		}
		System.out.println();
	}
}