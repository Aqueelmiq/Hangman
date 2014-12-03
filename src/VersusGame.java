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
	private String guessedWord2, tempWord2;
	private int guessPos2;
	
	public VersusGame(Word myWord, Word myWord2, int mycategory) {
		super(myWord, mycategory);
		gameWord2 = myWord2;
		tempWord2 = myWord2.getWord();
		guessPos2 = 0;
	}
	
	//Getters
	public String getGuessedWord2() {
		return guessedWord2;
	}
	
	public String getTempWord2() {
		return tempWord2;
	}
/*	
	@Override
	public void drawHangman() {
		System.out.println("-------------------Computer's Guess and Position------------------");
		System.out.println("Guesses: " + guessPos2 + "Guess so far: " + guessedWord2);
		System.out.println("------------------------------------------------------------------");
		
	}
*/
	@Override
	public void guess(char guess) {
		super.guess(guess);
		Random r = new Random();
		char random = (char)(r.nextInt(26) + 'a');
		for(int i=0; i<tempWord.length(); i++)
			if(tempWord.charAt(i)==random) {
				guessedWord2 = guessedWord2.substring(0,i) + random + guessedWord2.substring(i+1,guessedWord2.length());
			}
			guessPos2++;
		//	drawHangman();
	}
}
