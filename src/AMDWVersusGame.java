/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to play a sub game against computer
 */

import java.util.*;

public class AMDWVersusGame extends AMDWGame {
	//usual instance variables but this time for the computer
	private AMDWWord gameWord2;
	private String guessedWord2, tempWord2;
	private int guessPos2; //Computer's Guess Pos
	private final int guessLimit2 =16; //Computer's guess limit
	private int pointer2; //pointer to iterate
	private char[] computerGuessPool; //The guess Pool for computer
	int counter,check; //counts guess pool;
	
	//Non-default constructor
	public AMDWVersusGame(AMDWWord myWord, AMDWWord myWord2, int difficulty) {
		super(myWord, difficulty);
		setGameWord2(myWord2);
		tempWord2 = myWord2.getWord();
		guessPos2 = 0;
		this.pointer2 = 0;
		this.guessedWord2="";
		while(pointer2<tempWord2.length()) {
			guessedWord2 += "X";
			pointer2++;
			
		}
		counter = 0;
		computerGuessPool = new char[100];
		//Generates a pool of characters for computer to guess from
		//Now the loop generates some random characters and accurate guesses
		for(int s=0;s<tempWord2.length(); s++) {
			for(int t=0; t<(difficulty); t++) {
				Random r = new Random();
				computerGuessPool[counter] = (char)(r.nextInt(26) + 'a');
				counter++;
			}
			computerGuessPool[counter] = tempWord2.charAt(s);
			counter++;
		}
		check = 0;
	}

	
	//Getters
	public String getGuessedWord2() {
		return guessedWord2;
	}
	
	public String getTempWord2() {
		return tempWord2;
	}
	
	//Setters
	public void getGuessedWord2(String guessedWord2) {
		this.guessedWord2=guessedWord2;
	}
	
	public void getTempWord2(String tempWord2) {
		this.tempWord2=tempWord2;
	}
	
	//Draw Hang-man along with details from Computer's guess
	@Override
	public void drawHangman() {
		System.out.println("-------------------Computer's Guess and Position------------------");
		System.out.println("Incorrect guesses: " + guessPos2 + "\nGuesses left: " + (guessLimit2 - guessPos2) + "\nGuessed so far: " + guessedWord2);
		System.out.println("------------------------------------------------------------------");
		System.out.println("----------------------Your Guess and Position---------------------");
		System.out.println("Incorrect guesses: " + guessPos + "\nGuesses left: " + (guessLimit - guessPos) + "\nGuessed so far: " + guessedWord);
		System.out.println("------------------------------------------------------------------");
		//Add new Graphic in the pane
		window.getContentPane().add(new AMDWGraphic(guessPos));
	    window.setVisible(true);
	}

	//Overridden Guess method to include computer Guess as well
	@Override
	public void guess(char guess) {
		boolean guessCorrect2 = false;
		boolean guessCorrect = false;
		//Checks for any correct guess
		for(int i=0; i<tempWord.length(); i++){
			if(tempWord.charAt(i)==guess) {
				guessCorrect = true;
				guessedWord = guessedWord.substring(0,i) + guess + guessedWord.substring(i+1,guessedWord.length());
			} 
		}
		//If false
		if (guessCorrect == false){
			System.out.println("Incorrect guess!");
			guessPos++;
		}
		else {
			System.out.println("Correct guess!");
		}
		//Computer Guessing
		char computerGuess='\0';
		check = (int)(Math.random()*counter);
		computerGuess = computerGuessPool[check];
		for(int i=check; i<counter-1; i++) {
			computerGuessPool[i]=computerGuessPool[i+1];
		}
		counter--;
		
		for(int i=0; i<tempWord2.length(); i++){
			if(tempWord2.charAt(i)==computerGuess) {
				guessCorrect2 = true;
				guessedWord2 = guessedWord2.substring(0,i) + computerGuess + guessedWord2.substring(i+1,guessedWord2.length());
			} 
		}
		//If Computer Guesses False
		if (guessCorrect2 == false){
			System.out.println("Computer did an Incorrect guess!");
			guessPos2++;
		}
		else {
			System.out.println("Correct Guess");
		}
		//DrawHangman and details
		drawHangman();
	}
	
	public boolean endGame() {
		if(guessedWord.compareTo(tempWord)==0) {
			System.out.println("You Win!");
			return true;
		}
		if(guessedWord2.compareTo(tempWord2)==0) {
			System.out.println("You Loose!");
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
	
	//Overridden ToString
	@Override
	public String toString() {
		return super.toString() + "Category 2: " + gameWord2.getBaseType() + "\n" + "Guess Limit 2: " + guessLimit2 + "\n" + "Guesses finished 2: " + guessPos2 + "Word 2: " + gameWord2.toString();
	}
	
	//Getters
	public AMDWWord getGameWord2() {
		return gameWord2;
	}

	public void setGameWord2(AMDWWord gameWord2) {
		this.gameWord2 = gameWord2;
	}

	public int getGuessPos2() {
		return guessPos2;
	}
	
	//Setters
	public void setGuessPos2(int guessPos2) {
		this.guessPos2 = guessPos2;
	}
	
	public int getGuessLimit2(){
		return guessLimit2;
	}
}
