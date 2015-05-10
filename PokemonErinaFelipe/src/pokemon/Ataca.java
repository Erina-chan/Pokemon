package pokemon;

import pokemon.Troca;

public class Ataca extends Evento{

	public Ataca(int prioridade, Treinador ator, Treinador outro) {
		super(prioridade, ator, outro);
	}

	public void acao() {
		if (this.ator.perdeu == false && this.outro.perdeu == false) {
			this.ator.ataca(this.outro,this.prioridade);
			Pokemon atacado = this.outro.pAtivo;
			if (atacado.hp <= 0) {
				System.out.println(atacado.nome + " foi nocauteado!");
				atacado.hp = 0;
				atacado.nome = atacado.nome + "(Nocauteado)";
				
				Rodada.fimRodada = true;

				for (int i = 0; i < 6; i++) {
					if (outro.pokebola[i] == atacado) {
						outro.pokebola[i].vivo = false;
						atacado.vivo = false;
					}
				}
				outro.perdeu();
				if (outro.perdeu == false) {
					Troca troca = new Troca(0,this.outro,this.ator);
					troca.acao();
				}
			}
		}
	}
}
