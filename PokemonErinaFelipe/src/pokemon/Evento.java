package pokemon;

abstract public class Evento {
	
	int prioridade;
	Treinador ator;
	Treinador outro;

	public Evento(int prioridade, Treinador ator, Treinador outro) {
		this.prioridade = prioridade;
		this.ator = ator;
		this.outro = outro;
	}

	abstract public void acao();

}
