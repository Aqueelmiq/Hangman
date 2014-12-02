
public class Test {

	public static void main(String[] args) {
		String guessedWord = "Aqueel";
		int i = 4;
		guessedWord = guessedWord.substring(0,i) + "g" + guessedWord.substring(i+1,guessedWord.length());
		System.out.print(guessedWord);
	}

}
