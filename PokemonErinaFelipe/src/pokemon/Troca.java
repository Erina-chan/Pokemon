package pokemon;

import java.util.Scanner;

public class Troca extends Evento{
	
	public Troca(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao() {
		if (this.ator.perdeu == false && this.outro.perdeu == false){
			Scanner sc = new Scanner(System.in);
			boolean acao = imprimePokemons();
			if (acao == true){
				System.out.println(this.ator.nome);
				System.out.print("Digite o numero do pokemon que voce quer trocar: ");
				int num = sc.nextInt() - 1;
				this.ator.trocaPokemon(this.ator.pokebola[num]);
				System.out.println("O pokemon foi trocado.");
				System.out.println();
			}
		}
	}
	
	public boolean imprimePokemons() {
		boolean possibilidadeTroca = false;
		System.out.println("Time Pokemon: ");
		System.out.println("----------------------------------------------------------------------------------");
		for(int i = 0; i < 6; i++){
			if (this.ator.pokebola[i] != null){
				System.out.println(i + 1 + ". " + this.ator.pokebola[i].nome + " - HP:" + this.ator.pokebola[i].hp + "/100");
				possibilidadeTroca = true;
			}
		}
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
		return possibilidadeTroca;
	}
	
}	