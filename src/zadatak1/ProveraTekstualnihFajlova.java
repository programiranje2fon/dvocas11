package zadatak1;

import java.io.IOException;

public class ProveraTekstualnihFajlova {
	
		public static void main(String[] args) {

			try {
				String tekst = TekstualniFajlovi.ucitajIVratiTekst("tekst.txt");
				System.out.println(tekst);
			} catch (IOException e) {
				System.out.println("Greska prilikom citanja fajla!");
			}

			
			try {
				TekstualniFajlovi.upisiTekst("tekst2.txt");
			} catch (IOException e) {
				System.out.println("Greska prilikom upisivanja teksta u fajl!");
			}
		}
		
	
}
