package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Treinador {

	String nome;
	boolean perdeu = false;
	Pokemon[] pokebola = new Pokemon[6];
	Pokemon pAtivo; // ponteiro para o pokemon em combate

	public Treinador(String nome, int numPokemons) {
		this.nome = nome;
		Pokemon.mostraPokemons();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numPokemons; i++) {

			System.out.print("Digite o numero do " + (i + 1) + "- pokemon: ");
			int pokeNum = sc.nextInt();

			this.pokebola[i] = new Pokemon(pokeNum);
			
			if (i == 0) {
				this.pokebola[i].ativo = true; // Primeiro pokemon sempre sera o
											   // primeiro a entrar em combate.
				this.pAtivo = this.pokebola[i];
			}
			
		}
	}
	
	public Treinador(String nome) {
		this.nome = nome;
			
		int numPoke = (int) Math.random() * 10; // Vezes 10 porque temos 10 pokemons. A funcao gera numeros de 0 a 1
		int atq1 = (int) Math.random() * 10;
		int atq2 = (int) Math.random() * 10;
		int atq3 = (int) Math.random() * 10;
		int atq4 = (int) Math.random() * 10;
			
		this.pokebola[0] = new Pokemon(numPoke,atq1,atq2,atq3,atq4);
		this.pokebola[0].ativo = true;
		this.pAtivo = this.pokebola[0];
	}
	
	public Treinador(String nome, String inutil){
		this.nome = nome;
		this.pokebola[0] = new Pokemon(nome);
		this.pokebola[0].ativo = true;
		this.pAtivo = this.pokebola[0];
	}
	
	
	public void fugir() {
		this.perdeu = true;
		System.out.println("O treinador " + this.nome + " fugiu da batalha!!!");
	}

	public void cura(Pokemon p) {
		p.hp += 25;
		if (p.hp > 100) {
			p.hp = 100;
		}
	}

	public void trocaPokemon(Pokemon pReserva) {
		if(this.pAtivo != null)
			this.pAtivo.ativo = false;
		pReserva.ativo = true;
		this.pAtivo = pReserva;
	}

	public void ataca(Treinador outro, int opcao) {

		Pokemon atacante = this.pAtivo;
		Pokemon atacado = outro.pAtivo;
		int num = 0; // Somente para o compilador não reclamar
		
		if (opcao == 4)
			num = 0;
		else if (opcao == 5)
			num = 1;
		else if (opcao == 6)
			num = 2;
		else if (opcao == 7)
			num = 3;
		
		
		if (atacante.ataques[num].tipoAtaque.equals("choque") && atacado.tipoPokemon.equals("agua"))
			atacado.hp -=  2 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("agua") && atacado.tipoPokemon.equals("fogo"))
			atacado.hp -=  2 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("fogo") && atacado.tipoPokemon.equals("metal"))
			atacado.hp -=  2 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("metal") && atacado.tipoPokemon.equals("choque"))
			atacado.hp -=  2 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("choque") && atacado.tipoPokemon.equals("metal"))
			atacado.hp -=  0.5 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("agua") && atacado.tipoPokemon.equals("choque"))
			atacado.hp -=  0.5 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("fogo") && atacado.tipoPokemon.equals("agua"))
			atacado.hp -=  0.5 * atacante.ataques[num].dano;
		
		else if (atacante.ataques[num].tipoAtaque.equals("metal") && atacado.tipoPokemon.equals("fogo"))
			atacado.hp -=  0.5 * atacante.ataques[num].dano;
		
		else
			atacado.hp -= atacante.ataques[num].dano;
		
		if(atacado.hp <= 0) {
			System.out.println(atacado.nome + " foi nocauteado!");
			
			for (int i = 0; i < 6; i++){
				if(outro.pokebola[i] == atacado){
					outro.pokebola[i] = null;
					atacado = null;
				}
			}
			Troca troca = new Troca();
			troca.acao(outro);
		}
		
		
	}

	public void perdeu() { 
		// verifica se ainda existe pokemon vivo
		boolean possibilidadePerdeu = true;
		for (int i = 0; i < 6; i++) {
			if(pokebola[i] != null){
				if (pokebola[i].ativo == true) {
					possibilidadePerdeu = false;
				}
			}
		}
		if (this.perdeu == false) {
			this.perdeu = possibilidadePerdeu;
		}
	}
}