package pokemon;

public class Ataca implements Evento{

	public void acao(Treinador t) {
	}
	
	public void acao(Treinador t1, Treinador t2, int opcao) {
		System.out.println(t1.pAtivo.nome + " atacou " + t2.pAtivo.nome);
		t1.ataca(t2,opcao);
	}
}
