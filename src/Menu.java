/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Weigel
 * Last updated 11/29/2014
 * Menu class handles all the menus in the game. 
 * It takes the input received from the user through the menu and processes it.
 * It converts vague userInput into understandable output for other classes to process.
 * The menu class also error handles the entire output.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
//Importing java libraries needed for the class
import java.util.*;

public class Menu {
	
	//Instance variables to hold data when user inputs something
	private int userInputInt, difficulty;
	private String userInput;
	private  String filename="output.txt";
	static ReadFile reader;
	ObjectArray wordArr;
	
	//Default constructor assigns null or 0 values to all variable in the beginning if constructor is called
	public Menu() {
		userInputInt = 0;
		difficulty = 0;
		userInput = "";
	}
	
	//getInput gets a valid input from the user and returns the integer input. 
	//(int limit) is the max limit of the userInput you want, anything more than limit will result in disregarding input.
	public int getInput(int limit){
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
		        }
		    } catch(NumberFormatException e) { 
		        flag = false; 
		        System.out.println("--------------------------------------------------");
		        System.out.println("That is not a valid input, Please try again");
		    }
		}
		
		//returns the valid value after exiting the loop
		return userInputInt;
	}
	
	//Displays and handles Main Menu of the game
	public void mainMenu() throws FileNotFoundException{
		
		int menuChoice;
		//Display Menu using System.out
		System.out.println("**************************************************");
		System.out.println("Welcome to Hangman Game, What do you want to play?");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Normal Game");
		System.out.println("2. Beat the Computer");
		System.out.println("3. Change File Name");
		System.out.println("4. Quit game");
		System.out.println("--------------------------------------------------");
		
		//Calling getInput() to get a valid userInput under or equal to 4
		menuChoice = getInput(4);
		
		//Difficulty level chooser
		System.out.println("**************************************************");
		System.out.println("Choose difficculty level for your game");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Easy");
		System.out.println("2. Average");
		System.out.println("3. Hard");
		System.out.println("4. Quit to Main Menu");
		System.out.println("--------------------------------------------------");
		
		//Calling getInput() to get a valid userInput under or equal to 4
		difficulty = getInput(4);
		
		//if user presses 4, go back to main menu, Uses recursion here
		if(difficulty == 4)
			mainMenu();
		
		//The switch statement uses the userInput to navigate to the right function to start the game
		switch(menuChoice) {
			case 1: 
				normalMainMenu();
				break;
			case 2: 
				versusMenu();
				break;
			case 3: 
				System.out.println("**************************************************");
				System.out.println("Enter File Name: ");
				setFileName(userInput);
				mainMenu();
				break;
			default:
				break;
		}

	}
	
	//Set the filename of the input file to read
	public void setFileName(String fileName) {
		filename = fileName;
		try {
			reader = new ReadFile(filename);
			wordArr = reader.storeObjects();
			System.out.println("New File name set, Thank You.");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, Please try agin");
			setFileName(fileName);
			e.printStackTrace();
		}
		System.out.println("**************************************************");
	}
	
	public void normalMainMenu() {
	
		//Display Sub Menu using System.out
				System.out.println("**************************************************");
				System.out.println("Welcome to Hangman Game!");
				System.out.println("We have chosen a word for you,\ntry to guess one letter at a time");
				System.out.println("--------------------------------------------------");
				try {
					reader = new ReadFile(filename);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				wordArr = reader.storeObjects();
				String guess="";
				int random = (int) ((difficulty*wordArr.getIndex()/3) + Math.random()*wordArr.getIndex()/3);
				System.out.println(random);
				Word myWord = ((Word)wordArr.getAtPos(random));
				Scanner in = new Scanner(System.in);
				Game hangman = new Game(myWord);
				System.out.println(hangman.toString());
				while(!hangman.endGame()) {
					System.out.println("Guess a letter");
					guess = in.next();
					hangman.guess(guess.charAt(0));
				}
				in.close();
	}
	
	public static void versusMenu(){
		
		int menuChoice;
		
	
	}
	



}
