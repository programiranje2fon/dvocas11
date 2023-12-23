package zadatak2;

import java.io.IOException;
import java.util.List;

public class ProveraBazeOsoba {

	public static void main(String[] args) {
		BazaOsoba baza = new BazaOsoba();
		
		baza.dodajOsobu(new Osoba("Pera", "Peric"));
		baza.dodajOsobu(new Osoba("Sara", "Saric"));
		baza.dodajOsobu(new Osoba("Laza", "Lazic"));
		baza.dodajOsobu(new Osoba("Milan", "Tosic"));
		baza.dodajOsobu(new Osoba("Marija", "Peric"));

		
		try {
			baza.sacuvajUFajl("baza.out");
		} catch (IOException e) {
			System.out.println("Greska prilikom cuvanja sadrzaja baze u fajl!");
		}
		
		try {
			baza.ucitajIzFajla("baza.out");
			System.out.println(baza.vratiOsobe());
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja sadrzaja baze iz fajla!");
		}
		
		baza.pronadjiOsobe1("Pera", "Tosic");
		baza.pronadjiOsobe2();
		baza.ukloniOsobe("Peric");
		
	}
	
}
