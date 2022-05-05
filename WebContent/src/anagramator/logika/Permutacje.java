package anagramator.logika;

public class Permutacje {
	
	String slowo;
	char[] primitiveResults;
	int resultMarker;
	int ileSlow;
	
	public Permutacje(String slowo){
		this.slowo = slowo;
		this.ileSlow = SmallTools.silnia(slowo.length());
		this.primitiveResults = new char[ileSlow*slowo.length()];
		this.resultMarker = 0;
	}
		
	public char[][] findAllPermutations () {
		char[] enter = slowo.toCharArray();
		char[] exit = {};
		findPermutations(enter, exit);
		return fixResultsStructure();
	}
	
	private char[][] fixResultsStructure(){
		char[][] wynikDopasowany = new char[ileSlow][slowo.length()];
		for(int i = 0; i < ileSlow; i++){
			for(int j = 0; j < slowo.length(); j++) wynikDopasowany[i][j] = 
					primitiveResults[i*slowo.length() + j];
		}
		return wynikDopasowany;	
	}
	
	private void findPermutations(char[] enter ,char[] exit){
		
		if(enter.length == 2){
			char[] wynik1 = SmallTools.zlaczTablice(exit, enter);
			for(char ch : wynik1) {
				primitiveResults[resultMarker] = ch;
				resultMarker ++;
			}
			char[] wynik2 = SmallTools.zamienMiejscamiOstatnieElementy(wynik1);
			for(char ch : wynik2) {
				primitiveResults[resultMarker] = ch;
				resultMarker ++;
			}
		}
		else {
			for(int i = 0; i < enter.length; i++){
				char temp = enter[i];
				char[] exitT = SmallTools.dodajElementDoTablicy(exit, temp);
				char[] enterT = SmallTools.usunElement(enter, i);
				findPermutations(enterT, exitT);
				enterT = SmallTools.dodajElementDoTablicy(enterT, temp);
				
			}				
		}
	}
	
}
