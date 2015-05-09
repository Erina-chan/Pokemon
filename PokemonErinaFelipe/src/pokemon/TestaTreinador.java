package pokemon;

import org.junit.*;

import static org.junit.Assert.*;

public class TestaTreinador {

	Treinador t1;
	Treinador t2;
	
	@Before
	public void setUp() {
		t1 = new Treinador("Felipe", "teste");
		t2 = new Treinador("Erina", "teste");
	}
	
	@Test
	public void testaAtaca(){
		assertEquals(t2.pAtivo.hp,100);
		t1.ataca(t2,4); // Ataque tira 30 de HP
		assertEquals(t2.pAtivo.hp,70);
		
	}
	
	@Test
	public void testaPerdeu(){
		assertEquals(t2.perdeu,false);
		t2.pAtivo.ativo = false;
		t2.perdeu();
		assertEquals(t2.perdeu,true);
		
	}
	
	@Test
	public void testaCura() {
		t1.pAtivo.hp = 75;
		t1.cura(t1.pAtivo);
		assertEquals(t1.pAtivo.hp,100);
	}
	
	@Test
	public void testaFugir(){
		assertEquals(t2.perdeu,false);
		t2.fugir();
		assertEquals(t2.perdeu,true);
		
	}
}
