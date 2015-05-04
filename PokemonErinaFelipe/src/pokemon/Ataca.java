package pokemon;

public class Ataca implements Evento{

	public void acao(Treinador t) {
	}
	
	public void acao(Treinador t1, Treinador t2, int opcao) {
		t1.ataca(t2,opcao);
	}
}
