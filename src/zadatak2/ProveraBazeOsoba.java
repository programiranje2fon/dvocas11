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
		
		try {
			baza.sacuvaUFajl("baza.out");
		} catch (IOException e) {
			System.out.println("Greska prilikom cuvanja sadrzaja baze u fajl!");
		}
		
		try {
			baza.ucitajIzFajla("baza.out");
			System.out.println(baza.vratiOsobe());
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja sadrzaja baze iz fajla!");
		}
		
		List<Osoba> rezultati = baza.pronadjiOsobe("Pera", "Tosic");
		System.out.println(rezultati);
		
	}
	
}
