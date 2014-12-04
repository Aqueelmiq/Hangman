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
	private int category, guessLimit, guessPos;
	String tempWord;
	String guessedWord;
	int pointer;
	JFrame window;
	
	public Game(Word myWord, int category) {
		this.gameWord = myWord;
		this.category = category;
		this.guessLimit = 15;
		this.guessPos = 0;
		this.tempWord = gameWord.getWord().toLowerCase();
		this.pointer = 0;
		this.guessedWord="";
		while(pointer<tempWord.length()) {
			guessedWord += "X";
			pointer++;
			
		}
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 450);
	}
	
	//Getters
	
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
		boolean guessCorrect = false;
		for(int i=0; i<tempWord.length(); i++){
			if(tempWord.charAt(i)==guess) {
				guessCorrect = true;
				System.out.println("Correct guess!");
				guessedWord = guessedWord.substring(0,i) + guess + guessedWord.substring(i+1,guessedWord.length());
			} 
		}
		if (guessCorrect == false){
			System.out.println("Incorrect guess!");
			guessPos++;
		}
		drawHangman();
	}
	
	public boolean endGame() {
		if(guessedWord.compareTo(tempWord)==0) {
			System.out.println("You Win!");
			return true;
		}
		else if(guessPos<guessLimit) { 
			return false;
		}
		else {
			System.out.println("You Lose!"); 
			return true;
		}
	}
	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Your Guess and Position------------------");
		System.out.println("Incorrect guesses: " + guessPos + "\nGuesses left: " + (guessLimit - guessPos) + "\nGuessed so far: " + guessedWord);
		window.getContentPane().add(new Graphic(guessPos, guessedWord));
	    window.setVisible(true);
		
	}
	
	//To String
	public String toString() {
		return "Category: " + gameWord.getBaseType() + "\n" + "Guess Limit: " + guessLimit + "\n" + "Guesses finished: " + guessPos + "Word: " + gameWord.toString();
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

	@Override
	public void clearHangman() {
		// TODO Auto-generated method stub
		
	}
	
	
}
