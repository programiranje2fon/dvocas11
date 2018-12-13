package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			String tekst = "Danas je lep dan.\nMozda ce temperatura biti iznad nule.";
			String imeFajla = "tekst.txt";
			
			upisiTekst(imeFajla, tekst);
			
			String ucitaniTekst = TekstualniFajlovi.ucitajIVratiTekst(imeFajla);
			
			assertEquals("Nije upisan ocekivani tekst.", tekst+"\n", ucitaniTekst);		
			
			File fajl = new File(imeFajla);
			fajl.delete();	
		} catch (IOException e) {
			fail("Greska prilikom ucitavanja teksta iz fajla tekst.txt proverite da li postoji fajl i da li ste prosledili dobro ime fajla metodi");
		}		
	}

	@Test
	public void metoda_upisiTekst() {
		try {
			String imeFajla = "tekst2.txt";
			
			TekstualniFajlovi.upisiTekst(imeFajla);
			String ucitaniTekst = TekstualniFajlovi.ucitajIVratiTekst(imeFajla);
			String ocekivaniTekst = "Danas je lep dan.\nMozda ce temperatura biti iznad nule.\n";
			assertEquals("Nije upisan ocekivani tekst", ocekivaniTekst, ucitaniTekst);
			
			File fajl = new File(imeFajla);
			fajl.delete();
		} catch (IOException e) {
			fail("Greska prilikom upisivanja teksta iz fajla tekst2.txt proverite da li postoji fajl i da li ste prosledili dobro ime fajla metodi");
		}
	}
	
	private void upisiTekst(String imeFajla, String tekst) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(imeFajla)));
		out.println(tekst);
		out.close();
	}
}	
