package anagramator.logika;

public class Anagramator {

	public static String[] szukajSlow(String slowoWejsciowe) {

		char[][] tabTest;
		
		Permutacje p = new Permutacje(slowoWejsciowe);
		tabTest = p.findAllPermutations();
		
		String[] slowaKomb = SkladaczSlow.zlozSlowa(tabTest);
		if (slowoWejsciowe.indexOf("?") != -1)
			slowaKomb = SkladaczSlow.zlozSlowaBlank(slowaKomb);
		
		String[] slowaSensowne = SprawdzaczSlow.sprawdzSlowa(slowaKomb);
		String[] slowaUnikalne = UsuwaczDuplikatow.usunDuplikaty(slowaSensowne);
			
		return slowaUnikalne;

	}
}
