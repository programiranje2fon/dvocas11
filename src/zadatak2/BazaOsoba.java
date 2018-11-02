package zadatak2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BazaOsoba {
	private List<Osoba> osobe = new ArrayList<>();
	
	public void dodajOsobu(Osoba osoba) {
		osobe.add(osoba);
	}
	
	public void sacuvaUFajl(String imeFajla) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(imeFajla));

		for(Osoba osoba : osobe) {
			out.writeObject(osoba);
		}
		
		out.flush();
		out.close();		
	}
	
	public List<Osoba> ucitajIzFajla(String imeFajla) throws IOException {
		osobe.clear();
		
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
	
	public List<Osoba> vratiOsobe() {
		return osobe;
	}
	
	
}
