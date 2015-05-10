package pokemon;

public class Ataca extends Evento{

	public Ataca(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao() {
		if (this.ator.perdeu == false && this.outro.perdeu == false)
			this.ator.ataca(this.outro,this.prioridade);
	}
}
