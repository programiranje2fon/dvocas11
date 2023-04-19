package zadatak2;

import static org.junit.Assert.*;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
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
	public void metoda_sacuvajUFajl() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);

		try {
			String imeFajla = "testFajl.out";
			baza.sacuvajUFajl(imeFajla);

			List<Osoba> ucitaneOsobe = ucitajOsobeIzFajla(imeFajla);

			assertTrue("Ako se dodaju dve osobe, prva osoba nije sacuvana u fajlu.", ucitaneOsobe.get(0).equals(o1));
			assertTrue("Ako se dodaju dve osobe, druga osoba nije sacuvana u fajlu.", ucitaneOsobe.get(1).equals(o2));
		} catch (Exception e) {
			fail("Greska prilikom cuvanja u fajl!");
		} finally {
			File fajl = new File("testFajl.out");
			fajl.delete();
		}
	}

	@Test
	public void metoda_ucitajIzFajla() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		try {
			String imeFajla = "testFajl.out";
			baza.sacuvajUFajl(imeFajla);

			List<Osoba> ucitaneOsobe = baza.ucitajIzFajla(imeFajla);
			assertTrue("Iz fajla u kojem se nalaze dve osobe, prva osoba nije dobro ucitane",
					ucitaneOsobe.get(0).equals(o1));
			assertTrue("Iz fajla u kojem se nalaze dve osobe, prva osoba nije dobro ucitane",
					ucitaneOsobe.get(0).equals(o1));
		} catch (Exception e) {
			fail("Greska prilikom citanja iz fajla!");
		} finally {
			File fajl = new File("testFajl.out");
			fajl.delete();
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
		assertTrue("Metoda ne vraca ocekivanu listu osoba.", areEqual);
	}

	@Test
	public void metoda_pronadjiOsobe1() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Mara", "Maric");
		Osoba o3 = new Osoba("Dragan", "Djuric");
		Osoba o4 = new Osoba("Bojan", "Tomic");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		baza.dodajOsobu(o3);
		baza.dodajOsobu(o4);

		baza.pronadjiOsobe1("Pera", "Tomic");

		BazaOsoba baza2 = new BazaOsoba();
		try {
			baza2.ucitajIzFajla("pretraga1.ser");
			List<Osoba> osobe2 = baza2.vratiOsobe();

			boolean areEqual = osobe2.get(0).equals(o1) && osobe2.get(1).equals(o4) && osobe2.size() == 2;
			assertTrue("Metoda ne vraca ocekivanu listu osoba", areEqual);

			// brisemo fajl
			new File("pretraga1.ser").delete();
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja osoba u fajl!");
		}
	}

	@Test
	public void metoda_pronadjiOsobe2() {
		Osoba o1 = new Osoba("Pera", "Peric");
		Osoba o2 = new Osoba("Ana", "Ivic");
		Osoba o3 = new Osoba("Nina", "Nikolic");
		Osoba o4 = new Osoba("Ena", "Jovic");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		baza.dodajOsobu(o3);
		baza.dodajOsobu(o4);

		baza.pronadjiOsobe2();

		BazaOsoba baza2 = new BazaOsoba();
		try {
			baza2.ucitajIzFajla("pretraga2.ser");
			List<Osoba> osobe2 = baza2.vratiOsobe();

			boolean areEqual = osobe2.get(0).equals(o1) && osobe2.get(1).equals(o3) && osobe2.size() == 2;
			assertTrue("Metoda ne vraca ocekivanu listu osoba", areEqual);

			// brisemo fajl
			new File("pretraga2.ser").delete();
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja osoba u fajl!");
		}
	}

	@Test
	public void metoda_ukloniOsobe() {
		Osoba o1 = new Osoba("Pera", "Nikolic");
		Osoba o2 = new Osoba("Ana", "Ivic");
		Osoba o3 = new Osoba("Nina", "Nikolic");
		Osoba o4 = new Osoba("Ena", "Jovic");
		baza.dodajOsobu(o1);
		baza.dodajOsobu(o2);
		baza.dodajOsobu(o3);
		baza.dodajOsobu(o4);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		baza.ukloniOsobe("Nikolic");
		System.setOut(System.out);
		BazaOsoba baza2 = new BazaOsoba();
		try {
			baza2.ucitajIzFajla("uklonjene.ser");
			List<Osoba> osobe2 = baza2.vratiOsobe();

			boolean areEqual = osobe2.get(0).equals(o1) && osobe2.get(1).equals(o3) && osobe2.size() == 2;
			assertTrue("Metoda ne vraca ocekivanu listu osoba", areEqual);
			String expected = "Broj uklonjenih osoba: " + osobe2.size();
			assertEquals("Metoda na standardnom izlazu nije ispravno ispisala broj uklonjenih osoba", expected, out.toString());

			new File("uklonjene.ser").delete();
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja osoba u fajl!");
		}
	}

	private List<Osoba> ucitajOsobeIzFajla(String imeFajla) throws IOException {
		List<Osoba> osobe = new ArrayList<>();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(imeFajla));

		try {
			while (true) {
				Osoba osoba = (Osoba) in.readObject();
				osobe.add(osoba);
			}
		} catch (EOFException eof) {
		} catch (ClassNotFoundException e) {
		}

		in.close();

		return osobe;

	}

}
