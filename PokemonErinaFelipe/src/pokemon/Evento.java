package pokemon;

public abstract class Evento {
	
	private int prioridade;

	public Evento(int prioridade) {
		this.prioridade = prioridade;
	}

	abstract public void acao(Treinador t);

	abstract public String descricao();
	
}
