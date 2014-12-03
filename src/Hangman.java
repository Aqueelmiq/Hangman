import java.io.FileNotFoundException;


public class Hangman {

	public static void main(String[] args) throws FileNotFoundException{
		ObjectArray wordArray;
		ReadFile readWords = new ReadFile();
		wordArray = readWords.storeObjects();
		Object randomWord = wordArray.getAtPos((int) (Math.random() * wordArray.getIndex()));
		Game game = new Game((Word) randomWord);
	}
	
}
