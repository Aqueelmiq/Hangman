/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to play a sub game against computer
 */

import java.util.*;

public class VersusGame extends Game {
	//usual instance variables but this time for the computer
	private Word gameWord2;
	private String guessedWord2, tempWord2;
	private int guessPos2;
	private int guessLimit2;
	private int pointer2;
	private int difficulty; //set the frequency for the AI getting a correct letter
	private char[] computerGuessPool;
	
	//Non-default constructor
	public VersusGame(Word myWord, Word myWord2, int mycategory) {
		super(myWord, mycategory);
		setGameWord2(myWord2);
		tempWord2 = myWord2.getWord();
		guessPos2 = 0;
		guessLimit2=15;
		this.pointer2 = 0;
		this.guessedWord2="";
		while(pointer2<tempWord2.length()) {
			guessedWord2 += "X";
			pointer2++;
			
		}
		int counter=0;
		computerGuessPool = new char[(difficulty+1)*tempWord2.length()];
		for(int s=0;s<tempWord2.length(); s++) {
			for(int t=0; t<difficulty; t++) {
				Random r = new Random();
				computerGuessPool[counter] = (char)(r.nextInt(26) + 'a');
				counter++;
			}
			computerGuessPool[counter] = tempWord2.charAt(s);
			counter++;
		}
	}
	
	//Non-default Constructor
	public VersusGame(Word myWord, Word myWord2, int mycategory, int diff) {
		super(myWord, mycategory);
		setGameWord2(myWord2);
		tempWord2 = myWord2.getWord();
		setGuessPos2(0);
		setGuessLimit2(15);
		difficulty = diff;
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
	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Computer's Guess and Position------------------");
		System.out.println("Incorrect guesses: " + guessPos2 + "\nGuesses left: " + (guessLimit2 - guessPos2) + "\nGuessed so far: " + guessedWord2);
		System.out.println("------------------------------------------------------------------");
		System.out.println("----------------------Your Guess and Position---------------------");
		System.out.println("Incorrect guesses: " + guessPos + "\nGuesses left: " + (guessLimit - guessPos) + "\nGuessed so far: " + guessedWord);
		System.out.println("------------------------------------------------------------------");
	}

	@Override
	public void guess(char guess) {
		boolean guessCorrect2 = false;
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
		char computerGuess = computerGuessPool[(int) (Math.random()*computerGuessPool.length)+1];
		for(int i=0; i<tempWord2.length(); i++){
			if(tempWord2.charAt(i)==computerGuess) {
				guessCorrect2 = true;
				System.out.println("Computer did a Correct guess!");
				guessedWord2 = guessedWord2.substring(0,i) + computerGuess + guessedWord2.substring(i+1,guessedWord2.length());
			} 
		}
		if (guessCorrect2 == false){
			System.out.println("Computer did an Incorrect guess!");
			guessPos2++;
		}
		drawHangman();
	}

	public Word getGameWord2() {
		return gameWord2;
	}

	public void setGameWord2(Word gameWord2) {
		this.gameWord2 = gameWord2;
	}

	public int getGuessPos2() {
		return guessPos2;
	}

	public void setGuessPos2(int guessPos2) {
		this.guessPos2 = guessPos2;
	}
	
	public int getGuessLimit2(){
		return guessLimit2;
	}
	
	public void setGuessLimit2(int guessLimit2){
		this.guessLimit2 = guessLimit2;
	}
}
