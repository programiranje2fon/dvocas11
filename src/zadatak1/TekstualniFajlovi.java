package zadatak1;

import java.io.*;

public class TekstualniFajlovi {

	public static String ucitajIVratiTekst(String imeFajla) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(imeFajla));
		boolean kraj = false;
		String s = "";
		
		while (!kraj) {
			String pom = in.readLine();
			
			if (pom == null)
				kraj = true;
			else
				s = s + pom + "\n";
		}
		in.close();

		return s;
	}

	public static void upisiTekst(String imeFajla) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(imeFajla)));
		out.println("Danas je lep dan.");
		out.println("Mozda ce temperatura biti iznad nule.");
		out.close();
	}

}
