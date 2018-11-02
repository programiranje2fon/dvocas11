package zadatak2;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BazaOsobaTest {

	BazaOsoba baza;
	
	@Before
	public void setUp() throws Exception {
		baza = new BazaOsoba();
	}

	@After
	public void tearDown() throws Exception {
		baza = null;
	}

	@Test
	public void metoda_dodajOsobu() {
		Osoba o = new Osoba("Pera", "Peric");
		baza.dodajOsobu(o);
		boolean ubacen = (baza.vratiOsobe().get(0) == o);
		assertTrue("Osoba nije dobro ubacena", ubacen);
	}

	@Test
	public void metoda_sacuvaUFajl() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		
		try {
			baza.sacuvaUFajl("testFajl.out");
			List<Osoba> ucitaneOsobe = ucitajOsobeIzFajla("testFajl.out");			
			boolean areEqual = ucitaneOsobe.get(0).equals(o1) && ucitaneOsobe.get(1).equals(o2); 			
			assertTrue("Osobe nisu dobro sacuvane", areEqual);
		} catch (IOException e) {
			fail("Greska prilikom cuvanja u fajl!");
		}		
	}

	@Test
	public void metoda_ucitajIzFajla() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");		
		try {
			List<Osoba> ucitaneOsobe =  baza.ucitajIzFajla("testFajl.out");
			boolean areEqual = ucitaneOsobe.get(0).equals(o1) && ucitaneOsobe.get(1).equals(o2);
			assertTrue("Osobe nisu dobro ucitane", areEqual);
		} catch (IOException e) {
			fail("Greska prilikom citanja iz fajla!");
		}
	}

	@Test
	public void metoda_vratiOsobe() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		
		List<Osoba> osobe = baza.vratiOsobe();
		
		boolean areEqual = osobe.get(0).equals(o1) && osobe.get(1).equals(o2);
		assertTrue("Metoda ne vraca ocekivanu listu osoba", areEqual);		
	}

	
	private List<Osoba> ucitajOsobeIzFajla(String imeFajla) throws IOException {
		List<Osoba> osobe = new ArrayList<>();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(imeFajla));
		
		try {
			while (true) {
				Osoba osoba = (Osoba) in.readObject();
				osobe.add(osoba);
			}
		} catch(EOFException eof) { }
		  catch (ClassNotFoundException e) { }
		
		
		in.close();		
		
		return osobe;
		
	}
	
}
