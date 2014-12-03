import javax.swing.JFrame;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to play a sub game
 */

public class Game implements Graphics  {

	private Word gameWord;
	private int guessLimit, guessPos;
	String tempWord, guessedWord, category;
	int pointer;
	//private char guess;
	
	public Game(Word myWord) {
		this.gameWord = myWord;
		this.category = myWord.getCategory();
		this.guessLimit = myWord.getLength() + 10;
		this.guessPos = 0;
		this.tempWord = gameWord.getWord().toLowerCase();
		this.pointer = 0;
		this.guessedWord="";
		while(pointer<tempWord.length()) {
			guessedWord += "X";
			pointer++;
		}
	}
	
	public Game(Word myWord, String category) {
		this.gameWord = myWord;
		this.category = category;
		this.guessLimit = myWord.getLength() + 10;
		this.guessPos = 0;
		this.tempWord = gameWord.getWord().toLowerCase();
		this.pointer = 0;
		this.guessedWord="";
		while(pointer<tempWord.length()) {
			guessedWord += "X";
			pointer++;
		}
	}
	
	//Getters
//	public char getGuess() {
	//	return guess;
	//}
	
	public String getCategory() {
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
	
	public void setCategory(String cat) {
		this.category = cat;
	}
	
	//Game Methods
	public void guess(char guess) {
		for(int i=0; i<tempWord.length(); i++)
		if(tempWord.charAt(i)==guess) {
			guessedWord = guessedWord.substring(0,i) + guess + guessedWord.substring(i+1,guessedWord.length());
		}
		drawHangman();
		guessPos++;
	}
	
	public boolean endGame() {
		if(guessPos == guessLimit || guessedWord.compareTo(tempWord)==0)
			return true;
		else 
			return false;
	}
	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Your Guess and Position------------------");
		System.out.println("Guesses: " + guessPos + "Guess so far: " + guessedWord);
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(30, 30, 300, 300);
	    window.getContentPane().add(new Graphic());
	    window.setVisible(true);
		
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
