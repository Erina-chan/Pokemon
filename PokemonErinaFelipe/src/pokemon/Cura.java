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
			this.ator.imprimePokemons();
			System.out.print("Digite o numero do pokemon que voce quer curar: ");
			int num = sc.nextInt() - 1;
			this.ator.cura(this.ator.pokebola[num]);
			System.out.println(this.ator.pokebola[num].nome + " foi curado.");
		}
	}
	
}