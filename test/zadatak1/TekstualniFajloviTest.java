package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TekstualniFajloviTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void metoda_ucitajIVratiTekst() {
		try {
			String ucitaniTekst = TekstualniFajlovi.ucitajIVratiTekst("tekst.txt");
			String ocekivaniTekst = "Ovo je neki tekst koji se nalazi u fajlu. Ovaj tekst treba ucitati i ispisati na ekranu. ";
			assertEquals("Nije ucitan ocekivani tekst", ocekivaniTekst, ucitaniTekst);
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja teksta iz fajla tekst.txt proverite da li postoji fajl i da li ste prosledili dobro ime fajla metodi");
		}		
	}

	@Test
	public void metoda_upisiTekst() {
		try {
			TekstualniFajlovi.upisiTekst("tekst2.txt");
			String ucitaniTekst = TekstualniFajlovi.ucitajIVratiTekst("tekst2.txt");
			String ocekivaniTekst = "Danas je lep dan. Mozda ce temperatura biti iznad nule. ";
			assertEquals("Nije upisan ocekivani tekst", ocekivaniTekst, ucitaniTekst);			
		} catch (IOException e) {
			fail("Greska prilikom upisivanja teksta iz fajla tekst2.txt proverite da li postoji fajl i da li ste prosledili dobro ime fajla metodi");
		}
	}

}
