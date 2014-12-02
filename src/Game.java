/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 *
 */
 
public class Game implements Graphics {

	private Word gameWord;
	private int category, guessLimit, guessPos;
	String tempWord;
	String guessedWord;
	//private char guess;
	
	private Game(Word myWord, int category) {
		gameWord = myWord;
		this.category = category;
		guessLimit = myWord.getLength() + 10;
		guessPos = 0;
		tempWord = gameWord.getWord();
		int i=0;
		guessedWord = "";
		while(i < myWord.getLength()) {
			guessedWord += "X";
		}
	}
	
	//Getters
//	public char getGuess() {
	//	return guess;
	//}
	
	public int getCategory() {
		return category;
	}
	
	public int getGuessLimit() {
		return guessLimit;
	}
	
	public int getGuessPos() {
		return guessPos;
	}
	
	public String getGuessedWord() {
		return guessedWord;
	}
	
	public String getTempWord() {
		return tempWord;
	}
	
	//Setters
	public void setGuess(char guess) {
	//	this.guess = guess;
	}
	
	public void setGuessPos(int guess) {
		this.guessPos = guess;
	}
	
	public void setGuessLimit(int guess) {
		this.guessLimit = guess;
	}
	
	public void setCategory(int cat) {
		this.category = cat;
	}
	
	//Game Methods
	public void guess(char guess) {
		for(int i=0; i<tempWord.length(); i++)
		if(tempWord.charAt(i)==guess) {
			guessedWord = guessedWord.substring(0,i) + guess + guessedWord.substring(i+1,guessedWord.length());
			guessPos++;
		}
	}
	
	public boolean endGame() {
		if(guessPos == guessLimit)
			return true;
		else 
			return false;
	}
	
	@Override
	public void drawHangman() {
		
	}
	
	//To String
	public String toString() {
		return "Category: " + category + "\n" + "Guess Limit: " + guessLimit + "\n" + "Guesses finished: " + guessPos + "Word: " + gameWord.toString();
	}
	
	//Equals
	public boolean equals(Object obj) {
		if(obj instanceof Game) {
			if(gameWord.equals(((Game) obj).gameWord))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	
}
