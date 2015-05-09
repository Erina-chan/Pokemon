package pokemon;

public class Rodada {
	private EventSet es = new EventSet();

	public void addEvent(Evento c) {
		es.add(c);
	}

	public void run() {
		Evento e;
		while ((e = es.getNext()) != null) {
			e.acao();
			es.removeCurrent();
			BatalhaPokemon.delay(1000);
		}
		
	}
}
