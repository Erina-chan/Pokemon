package pokemon;

import java.util.Scanner;

public class BatalhaPokemon {

	private class Cura extends Evento {

		public void action(Treinador t) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite o numero do pokemon que você deseja curar: ");
			int num = sc.nextInt() - 1;
			t.cura(t.pokebola[num]);
			sc.close();
		}

		public String description() {
			return "O pokemon foi curado!";
		}
	}
	
	private class LightOn extends Evento {
		public LightOn(long eventTime) {
			super(eventTime);
		}

		public void action() {
			// Put hardware control code here to
			// physically turn on the light.
			light = true;
		}

		public String description() {
			return "Light is on";
		}
	}
	
}
