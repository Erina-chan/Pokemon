package pokemon;

public class EventSet {
	private Evento[] events = new Evento[2];
	private int atual = 0;

	public void add(Evento e) {
		if (events[0] == null)
			events[0] = e;
		else{
			if (events[0].prioridade <= e.prioridade)
				events[1] = e;
			else{
				events[1] = events[0];
				events[0] = e;
			}
		}	
	}

	public Evento getNext(){
		if (events[0] == null){
			atual = 1;
			return events[1];
		}
		
		else{
			atual = 0;
			return events[0];
		}
	}

	public void removeCurrent() {
		events[atual] = null;
	}
}