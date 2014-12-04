import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Game Class handles the main game functions in the game.
 * It has methods required to handle user input and process game tasks accordingly
 */

public class GameHandler {
	
	private static ReadFile reader;
	private static ObjectArray wordArr;
	private static char userCharInput;
	private static String userInput;
	private static int userInputInt;
	
	public static void playMainGame(int difficulty, String filename) {
		try {
			reader = new ReadFile(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wordArr = reader.storeObjects();
		wordArr.sort();
		int random = (int) (((difficulty-1)*wordArr.getIndex()/3) + Math.random()*wordArr.getIndex()/3);
		System.out.println(random);
		Word myWord = ((Word)wordArr.getAtPos(random));
		Game hangman = new Game(myWord, difficulty);
		System.out.println(hangman.toString());
		while(!hangman.endGame()) {
			hangman.guess(getCharInput());
		
		}
	}
	
	public static void playVersusGame(int difficulty, String filename) {
		try {
			reader = new ReadFile(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wordArr = reader.storeObjects();
		wordArr.sort();
		int random = (int) (((difficulty-1)*wordArr.getIndex()/3) + Math.random()*wordArr.getIndex()/3);
		System.out.println(random);
		Word myWord = ((Word)wordArr.getAtPos(random)), myWord2 = ((Word)wordArr.getAtPos(random+1));
		VersusGame hangman2 = new VersusGame(myWord, myWord2, difficulty);
		System.out.println(hangman2.toString());
		while(!hangman2.endGame()) {
			hangman2.guess(getCharInput());
		}
	}
	
	//getInput gets a valid input from the user and returns the integer input. 
		//(integer limit) is the max limit of the userInput you want, anything more than limit will result in disregarding input.
		public static int getInput(int limit){
			//Flag for control loop
			boolean flag = false;
			
			//Initializing Scanner for the menu class
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			//The below loop ensures that the user presses a valid input
			while(!flag){
				System.out.println("Please enter your choice: ");
				try {
					userInput = in.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try { 
			        userInputInt = Integer.parseInt(userInput);
			        if(userInputInt<=limit)
			        	flag = true;
			        else{
			        	flag = false;
			        	System.out.println("--------------------------------------------------");
			        	System.out.println("That is not a valid input, Please try again");
			        	System.out.println("--------------------------------------------------");
			        }
			    } catch(NumberFormatException e) { 
			        flag = false; 
			        System.out.println("--------------------------------------------------");
			        System.out.println("That is not a valid input, please try again!");
			        System.out.println("--------------------------------------------------");
			    }
			}
			
			//returns the valid value after exiting the loop
			return userInputInt;
		}
		
		public static char getCharInput() {
			
			//Flag for control loop
					boolean flag = false;
					
					//Initializing Scanner for the menu class
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					
					//The below loop ensures that the user presses a valid input
					while(!flag){
						System.out.println("Guess a Letter");
						try {
							userInput = in.readLine();
							userInput = userInput.toLowerCase(); 
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						if(userInput.length()>0) {
							userCharInput = userInput.charAt(0);
							for(int i=0; i<26; i++) {
								if(userCharInput == (char)(i+'a')) {
									flag = true;
								}
							}
						}
						if(flag == false) {
							System.out.println("--------------------------------------------------");
							System.out.println("That is not a valid input, please try again!");
							System.out.println("--------------------------------------------------");
						} 
					}
					
					//returns the valid value after exiting the loop
					return userCharInput;
		}
		
}
	
