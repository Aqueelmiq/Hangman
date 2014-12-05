import javax.swing.JFrame;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to play the normal game
 */

public class Game implements Graphics  {
	
	//instance variables to handle game data
	private Word gameWord; //Stores the word object for manipulation
	private int category; //Stores the game category
	protected final int guessLimit = 16; //Maximum Guesses allowed in our Hang-man game
	protected int guessPos; //Number of incorrect guesses
	protected String tempWord; //Stores the actual word from word class for manipulation
	protected String guessedWord; //Stores user's guessed word
	protected JFrame window;
	
	//Non default Constructor to initialize values
	public Game(Word myWord, int category) {
		this.gameWord = myWord;
		this.category = category;
		this.guessPos = 0;
		this.tempWord = gameWord.getWord().toLowerCase();
		int pointer = 0;
		this.guessedWord="";
		
		// The below code generates a null word of Xs to start with
		while(pointer<tempWord.length()) {
			guessedWord += "X";
			pointer++;
			
		}
		//Initializes Game window for drawing
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
	
	//Setters
	
	public void setGuessPos(int guess) {
		this.guessPos = guess;
	}
	
	public void setCategory(int cat) {
		this.category = cat;
	}
	
	public void setTempWord(String tempWord) {
		this.tempWord = tempWord;
	}
	
	public void setGuessedWord(String tempWord) {
		this.guessedWord = tempWord;
	}

	
	//Game Methods
	
	/*
	 * Guess method takes in user guess and checks if the guess is right or wrong
	 */
	public void guess(char guess) {
		boolean guessCorrect = false;
		//Checks for correct Guess
		for(int i=0; i<tempWord.length(); i++){
			//If Correct do this
			if(tempWord.charAt(i)==guess) {
				guessCorrect = true;
				System.out.println("Correct guess!");
				guessedWord = guessedWord.substring(0,i) + guess + guessedWord.substring(i+1,guessedWord.length());
			} 
		}
		//If wrong do this
		if (guessCorrect == false){
			System.out.println("Incorrect guess!");
			guessPos++;
		}
		//DrawHangman and details
		drawHangman();
	}
	
	/*
	 * End game checks if a player has won or lost the game.
	 */
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
	
	/*
	 * Draw Hangman displays the result of current game and also draws the hangman in a window
	 */
	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Your Guess and Position------------------");
		System.out.println("Incorrect guesses: " + guessPos + "\nGuesses left: " + (guessLimit - guessPos) + "\nGuessed so far: " + guessedWord);
		window.getContentPane().add(new Graphic(guessPos));
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
	
}
