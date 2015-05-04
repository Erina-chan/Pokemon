package pokemon;

import java.util.Scanner;

public class Troca implements Evento{
	
	public void acao(Treinador t) {
		Scanner sc = new Scanner(System.in);
		boolean acao = imprimePokemons(t);
		if (acao == true){
			System.out.print("Digite o numero do pokemon que voce quer trocar: ");
			int num = sc.nextInt() - 1;
			t.trocaPokemon(t.pokebola[num]);
			//sc.close();
			System.out.println("O pokemon foi trocado.");
		}
	}
	
	public static boolean imprimePokemons(Treinador t) {
		boolean possibilidadeTroca = false;
		for(int i = 0; i < 6; i++){
			if (t.pokebola[i] != null){
				System.out.println(i + 1 + "..." + t.pokebola[i].nome + "... HP:" + t.pokebola[i].hp);
				possibilidadeTroca = true;
			}
		}
		return possibilidadeTroca;
	}
	
}	