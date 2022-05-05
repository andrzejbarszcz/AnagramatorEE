package anagramator.logika;

public class UsuwaczDuplikatow {
	
static String[] usunDuplikaty(String[] slowaSensowne) {
		
		//bit unikalnosci
		boolean[] bityUnikalnosci = new boolean[slowaSensowne.length];
		for(int i=0; i<slowaSensowne.length; i++) bityUnikalnosci[i] = true;
		//ustawianie bitowUnikalnosci
		for(int i=0; i<slowaSensowne.length; i++) {
			for(int j=i+1; j<slowaSensowne.length; j++) {
				if(slowaSensowne[i].equals(slowaSensowne[j])) bityUnikalnosci[j] = false;
			}
		}
		
		//zliczenie slow unikalnych i stworzenie tablicy slow unikalnych
		int ileUnikalnych = 0;
		for(boolean b :bityUnikalnosci) if(b==true) ileUnikalnych++; 
		String[] slowaUnikalne = new String[ileUnikalnych];
		ileUnikalnych = -1;
		for(int i=0; i<slowaSensowne.length; i++) { 
			if(bityUnikalnosci[i] == true) { 
				ileUnikalnych++;
				slowaUnikalne[ileUnikalnych] = slowaSensowne[i].toUpperCase();
			}
		}
		
		return slowaUnikalne;
	}
	
	
	
}
