/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to play a sub game
 */

import java.util.*;

public class VersusGame extends Game {
	private Word gameWord2;
	private String guessedWord2, tempWord2, guessesMade;
	private int guessPos2;
	private int guessLimit2;
	private int difficulty; //set the frequency for the AI getting a correct letter
	
	public VersusGame(Word myWord, Word myWord2, int mycategory) {
		super(myWord, mycategory);
		setGameWord2(myWord2);
		tempWord2 = myWord2.getWord();
		setGuessPos2(0);
		setGuessLimit2(15);
	}
	
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
	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Computer's Guess and Position------------------");
		System.out.println("Incorrect guesses: " + guessPos2 + "\nGuesses left: " + (guessLimit2 - guessPos2) + "\nGuessed so far: " + guessedWord2);
		System.out.println("------------------------------------------------------------------");
	}

	@Override
	public void guess(char guess) {
		super.guess(guess);
		Random r = new Random();
		char random = (char)(r.nextInt(26) + 'a');
		char actual = getGameWord2().charAt((int) (getGameWord2().getLength() * Math.random()));
		char toGuess;
		int chance;
		if (difficulty == 2){
			chance = (int)(Math.random() * 3);
			if (chance == 1){
				toGuess = actual;
			} else toGuess = random;
		} else if (difficulty == 3){
			chance = (int)(Math.random() * 2);
			if (chance == 1){
				toGuess = actual;
			} else toGuess = random;
		} else toGuess = random;
		for(int i=0; i<tempWord2.length(); i++)
			if(tempWord2.charAt(i)==toGuess) {
				guessedWord2 = guessedWord2.substring(0,i) + random + guessedWord2.substring(i+1,guessedWord2.length());
			}
			setGuessPos2(getGuessPos2() + 1);
		//	drawHangman();
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
