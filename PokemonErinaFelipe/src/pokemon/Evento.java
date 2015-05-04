package pokemon;

interface Evento {

	int prioridade = 0;
	
	abstract public void acao(Treinador t);
	
}