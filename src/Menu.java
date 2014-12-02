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

//Importing java libraries needed for the class
import java.util.*;

public class Menu {
	
	//Instance variables to hold data when user inputs something
	static int userInputInt, difficulty, subGameChoice, garbageInt;
	static String userInput;
	
	//Default constructor assigns null or 0 values to all variable in the beginning if constructor is called
	public Menu() {
		userInputInt = 0;
		garbageInt = 0;
		subGameChoice = 0;
		difficulty = 0;
		userInput = "";
	}
	
	//getInput gets a valid input from the user and returns the integer input. 
	//(int limit) is the max limit of the userInput you want, anything more than limit will result in disregarding input.
	public static int getInput(int limit){
		//Flag for control loop
		boolean flag = false;
		
		//Initializing Scanner for the menu class
		Scanner in = new Scanner(System.in);
		
		//The below loop ensures that the user presses a valid input
		while(in.hasNext() && !flag){
			System.out.println("Please enter your choice: ");
			userInput = in.next();
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
		//Avoids Memory leak
		in.close();
		
		//returns the valid value after exiting the loop
		return userInputInt;
	}
	
	//Displays and handles Main Menu of the game
	public static void mainMenu(){
		
		int menuChoice;
		//Display Menu using System.out
		System.out.println("**************************************************");
		System.out.println("Welcome to Hangman Game, What do you want to play?");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Normal Game for exams");
		System.out.println("2. Sports fun");
		System.out.println("3. Beat the computer");
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
				break;
			case 3: 
				break;
			default:
				break;
		}

	}
	
	public static void normalMainMenu(){
		
		int menuChoice;
		
		//Display Sub Menu using System.out
				System.out.println("**************************************************");
				System.out.println("Welcome to Exam words Hangman!");
				System.out.println("Choose your Exam");
				System.out.println("--------------------------------------------------");
				System.out.println("1. SAT");
				System.out.println("2. TOEFL");
				System.out.println("3. GRE");
				System.out.println("4. Quit to Menu");
				System.out.println("--------------------------------------------------");
				
				menuChoice = getInput(4);
				
				switch(menuChoice){
					case 1: 
						break;
					case 2: 
						break;
					case 3: 
						break;
					default:
						break;
				}
				
	}
	
	public static void subMenu(String welcome){
		
		int menuChoice;
		
		//Display Sub Menu using System.out
		System.out.println("**************************************************");
		System.out.println("Welcome to " + welcome);
		System.out.println("Are you ready to start?");
		System.out.println("--------------------------------------------------");
		System.out.println("1. to start");
		System.out.println("2. to exit to Main Menu");
		System.out.println("--------------------------------------------------");
		
		//Get menu choice from user
		menuChoice = getInput(2);
		
		//If user proceeds to game execute game according to which game it is
		if(menuChoice==1) {
			switch(welcome){
				case "SAT Hangman Game": 
					break;
				case "TOEFL Hangman Game": 
					break;
				case "GRE Hangman Game": 
					break;
				case "Sports Hangman Game": 
					break;
				case "Versus Hangman Game": 
					break;
				default:
					break;
			}
		}
		
		//Else go back to main menu
		else
			mainMenu();
	}
	



}
