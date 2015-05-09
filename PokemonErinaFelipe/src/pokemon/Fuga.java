package pokemon;

public class Fuga extends Evento {
	
	public Fuga(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao(){
		if (this.ator.perdeu == false && this.outro.perdeu == false)
			this.ator.fugir();
	}
}
