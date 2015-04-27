package pokemon;

public class Ataque {

	String nome;
	String tipoAtaque; // Tipos do Pokemon: fogo, agua, choque, fisico.
	int dano;
	int prioridade;
	
	public Ataque(String nome, String tipo, int dano, int prioridade){
		this.nome = nome;
		this.tipoAtaque = tipo;
		this.dano = dano;
		this.prioridade = prioridade;
	}
}
