package pokemon;

public class Rodada {
	private EventSet es = new EventSet();
	static boolean fimRodada = false;

	public void addEvent(Evento c) {
		es.add(c);
	}

	public void run() {
		Evento e;
		while ((e = es.getNext()) != null) {
			e.acao();		
			es.removeCurrent();
			if (fimRodada == true) {
				e = es.getNext();
				es.removeCurrent();
				fimRodada = false;
			}
			BatalhaPokemon.delay(1000);
		}
	}
}