package zadatak2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OsobaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void konstruktor_testOsoba() {
		Osoba o = new Osoba("Pera", "Peric");
		String ime = o.getIme();
		String prezime = o.getPrezime();
		
		assertTrue("Konstruktor nije dobro inicijalizovao ime. Proverite konstruktor i odgovarajuci getter.", ime.equals("Pera"));
		assertTrue("Konstruktor nije dobro inicijalizovao prezime. Proverite konstruktor i odgovarajuci getter.", prezime.equals("Peric"));
	}

	@Test
	public void metoda_getIme() {
		Osoba o = new Osoba("Pera", "Peric");
		String ime = o.getIme();
		
		assertTrue("Konstruktor nije dobro inicijalizovao ime. Proverite konstruktor i odgovarajuci getter.", ime.equals("Pera"));	
	}

	@Test
	public void metoda_getPrezime() {
		Osoba o = new Osoba("Pera", "Peric");
		String prezime = o.getPrezime();
		
		assertTrue("Konstruktor nije dobro inicijalizovao prezime. Proverite konstruktor i odgovarajuci getter.", prezime.equals("Peric"));		
	}

	@Test
	public void metoda_equals() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Pera", "Peric");
		Osoba o3 = new Osoba("Luka", "Lukic");
		
		assertTrue("Metoda eauals ne poredi dobro objekte", o1.equals(o2));
		assertFalse("Metoda eauals ne poredi dobro objekte", o1.equals(o3));
		
	}
	
	
	@Test
	public void metoda_toString() {
		Osoba o = new Osoba("Pera", "Peric");
		
		assertTrue("Metoda toString ne vraca ocekivanu vrednost", o.toString().equals("Osoba [ime=Pera, prezime=Peric]"));
	}

}
