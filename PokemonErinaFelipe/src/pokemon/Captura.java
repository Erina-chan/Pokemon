package pokemon;

public class Captura extends Evento{

	public Captura(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao() {
		this.ator.captura(this.outro);
	}

}
