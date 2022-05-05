package anagramator.logika;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

public class SprawdzaczSlow {

	public static String[] sprawdzSlowa(String[] slowa) {

		BufferedReader br;
		String[] slowaOdczytane = new String[116503];
		String[] tymczasowa = new String[slowa.length];
		int ileSlowZnaleziono = 0;
		String[] slowaZnalezione;
		
		String path1 = System.getProperty("catalina.base");
		String path2 = "/webapps/AnagramatorEE/WEB-INF/lib/7literowkiSort.txt";
		String pathToFile7liter = path1 + path2;
		//pod eclipsem wtpwebapps
		File f = new File(pathToFile7liter);
		if(!f.exists())
			path2 = "/wtpwebapps/AnagramatorEE/WEB-INF/lib/7literowkiSort.txt";
			pathToFile7liter = path1 + path2;
		
		try {

			InputStream is = new FileInputStream(pathToFile7liter);
			InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
			br = new BufferedReader(isr);
			
			for (int i = 0; i < 116503; i++)
				slowaOdczytane[i] = br.readLine();

			br.close();

		} catch (Exception e) {
			System.out.println("blad w trakcie pobierania listy slow! " + e);
		}
		
		for (String slowoSprawdzane : slowa) {

			int startPrzeszukiwania = zacznijSzukacOd(slowaOdczytane, slowoSprawdzane);

			for (int i = startPrzeszukiwania - 30; i < startPrzeszukiwania + 30; i++) {
				if (slowaOdczytane[i].equals(slowoSprawdzane)) {
					ileSlowZnaleziono++;
					tymczasowa[ileSlowZnaleziono - 1] = slowoSprawdzane;
					break;
				}
			}
		}

		slowaZnalezione = new String[ileSlowZnaleziono];
		for (int i = 0; i < ileSlowZnaleziono; i++)
			slowaZnalezione[i] = tymczasowa[i];
		
		return slowaZnalezione;

	}

	static int zacznijSzukacOd(String[] slowaOdczytane, String slowoSprawdzane) {

		int aktualnaPozycja = (int) Math.pow(2, 16);
			
		for (int potega2 = 15; potega2 > 3; potega2--) {
			if (aktualnaPozycja > 116502)
				aktualnaPozycja = 116502;
			if (slowaOdczytane[aktualnaPozycja].compareTo(slowoSprawdzane) > 0)
				aktualnaPozycja -= (int) Math.pow(2, potega2);
			else
				aktualnaPozycja += (int) Math.pow(2, potega2);
		}
		if (aktualnaPozycja < 30)
			aktualnaPozycja = 30;
		if (aktualnaPozycja > 116502)
			aktualnaPozycja = 116472;
		return aktualnaPozycja;
	}

}
