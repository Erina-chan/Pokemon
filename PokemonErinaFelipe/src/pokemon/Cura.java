package pokemon;

import java.util.Scanner;

public class Cura extends Evento {
	
	public Cura(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao() {
		if (this.ator.perdeu == false && this.outro.perdeu == false){
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println(this.ator.nome);
			imprimePokemons();
			System.out.print("Digite o numero do pokemon que voce quer curar: ");
			int num = sc.nextInt() - 1;
			this.ator.cura(this.ator.pokebola[num]);
			System.out.println(this.ator.pokebola[num].nome + " foi curado.");
		}
	}
	
	public void imprimePokemons() {
		System.out.println("Time Pokemon: ");
		System.out.println("----------------------------------------------------------------------------------");
		for(int i = 0; i < 6; i++){
			if (this.ator.pokebola[i] != null)
				System.out.println(i + 1 + ". " + this.ator.pokebola[i].nome + " - HP:" +this.ator.pokebola[i].hp + "/100");
		}
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();
	}
}
