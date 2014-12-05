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


import java.io.FileNotFoundException;
import java.io.IOException;
//Importing java libraries needed for the class
import java.util.*;

public class AMDWMenu {
	
	//Instance variables to hold data when user inputs something
	private int difficulty, category; //stores Difficulty level and category of the word
	private String userInput; //Stores any user input
	private String filename="dco.txt"; //stores filename, default filename set
	private AMDWReadFile reader; //Reader class instance to read the filename
	private AMDWObjectArrayAdvanced wordArr; //Word Array instance to store the file name
	private AMDWWriteFile writer;
	
	//Default constructor assigns null or 0 values to all variable in the beginning if constructor is called
	public AMDWMenu() {
		difficulty = 0;
		userInput = "";
		try {
			reader = new AMDWReadFile(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wordArr = reader.storeObjects();
	}

	//Displays and handles Main Menu of the game
	public void mainMenu() {
		
		Scanner in = new Scanner(System.in);
		
		int menuChoice;
		//Display Menu using System.out
		System.out.println("**************************************************");
		System.out.println("Welcome to Hangman Game, What do you want to play?");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Normal Game");
		System.out.println("2. Beat the Computer");
		System.out.println("3. Change File Name");
		System.out.println("4. Choose a category");
		System.out.println("5. Manipulate File Data");
		System.out.println("6. Quit game");
		System.out.println("--------------------------------------------------");
		
		//Calling getInput() to get a valid userInput under or equal to 4
		menuChoice = AMDWGameHandler.getInput(6);
		
		//The switch statement uses the userInput to navigate to the right function to start the game
		switch(menuChoice) {
			case 1:
				chooseDifficulty();
				normalMainMenu();
				//calling normal game menu
				mainMenu();
				break;
				
			case 2:
				chooseDifficulty();
				versusMenu();
				mainMenu();
				//calling versus game menu
				break;
				
			case 3: 
				System.out.println("**************************************************");
				System.out.println("Enter File Name: ");
				userInput = in.nextLine();
				//calling function to set filename
				try {
				setFileName(userInput);
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				}
				//calling main menu after, file is set
				mainMenu();
				break;
				
			case 4:
				System.out.println("**************************************************");
				System.out.println("Choose the specific category you want to play:");
				System.out.println("--------------------------------------------------");
				System.out.println("1. TOEFL");
				System.out.println("2. SAT");
				System.out.println("3. GRE");
				System.out.println("4. Quit to Main Menu");
				System.out.println("--------------------------------------------------");
						
				//if user presses 4, go back to main menu, Uses recursion here
				if(category == 4)
					mainMenu();
				
				//Calling getInput() to get a valid userInput under or equal to 4
				category = AMDWGameHandler.getInput(4);
				mainMenu();
				break;
				
			case 5: 
				System.out.println("**************************************************");
				System.out.println("Choose the specific category you want to play:");
				System.out.println("--------------------------------------------------");
				System.out.println("1. Add a Word");
				System.out.println("2. Delete Word");
				System.out.println("3. Search Word List");
				System.out.println("4. Write File");
				System.out.println("5. Quit to Main Menu");
				System.out.println("--------------------------------------------------");
				manipulateWordList(AMDWGameHandler.getInput(5));
				mainMenu();
				break;
			case 6:
				break;
						
			default:
				break;
		}
		in.close();

	}
	//Difficulty level chooser
	public void chooseDifficulty() {
		System.out.println("**************************************************");
		System.out.println("Choose difficulty level for your game");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Hard");
		System.out.println("2. Average");
		System.out.println("3. Easy");
		System.out.println("4. Quit to Main Menu");
		System.out.println("--------------------------------------------------");
				
		//Calling getInput() to get a valid userInput under or equal to 4
		difficulty = AMDWGameHandler.getInput(4);
				
		//if user presses 4, go back to main menu, Uses recursion here
		if(difficulty == 4)
			mainMenu();
				
	}
	
	public void manipulateWordList(int input) {
		Scanner in = new Scanner(System.in);
		switch(input) {
		case 1:
			AMDWWord myWord = new AMDWWord();
			System.out.println("**************************************************");
			System.out.println("Please enter the details of the word one by one");
			System.out.println("--------------------------------------------------");
			System.out.println("Enter the word:");
			myWord.setWord(in.nextLine());
			myWord.setLength(myWord.getWord().length());
			System.out.println("Enter the difficculty:");
			myWord.setDifficulty(AMDWGameHandler.getInput(3));
			System.out.println("Enter the explanation:");
			myWord.setExplanation(in.nextLine());
			System.out.println("Enter the type of word: ");
			myWord.setType(in.nextLine());
			System.out.println("Enter the exam type: ");
			myWord.setBaseType(in.nextLine());
			System.out.println("Enter the exam type: ");
			wordArr.add(myWord);
			System.out.println("--------------------------------------------------");
			System.out.println("Word Added at: " + wordArr.getIndex() + " pos.");
			System.out.println("**************************************************");
			mainMenu();
			break;
		case 2:
			System.out.println("**************************************************");
			System.out.println("Please choose your option");
			System.out.println("--------------------------------------------------");
			System.out.println("1. Delete by position");
			System.out.println("2. Delete by word name");
			int choice = AMDWGameHandler.getInput(2);
			if(choice == 1) {
				System.out.println("--------------------------------------------------");
				System.out.println("Please enter your pos");
				wordArr.delete(AMDWGameHandler.getInput(wordArr.getIndex()));
				System.out.println("Word Deleted");
				System.out.println("--------------------------------------------------");
			}
			else {
				System.out.println("--------------------------------------------------");
				System.out.println("Please enter your Word");
				wordArr.delete(in.nextLine().toLowerCase());
				System.out.println("Word Deleted");
				System.out.println("--------------------------------------------------");
			}
			mainMenu();
			break;
		case 3:
			System.out.println("**************************************************");
			System.out.println("Please choose your option");
			System.out.println("--------------------------------------------------");
			System.out.println("1. Search by position");
			System.out.println("2. Search by word name");
			int choice2 = AMDWGameHandler.getInput(2);
			if(choice2 == 1) {
				System.out.println("--------------------------------------------------");
				System.out.println("Please enter your pos");
				System.out.println(((AMDWWord)wordArr.getAtPos(AMDWGameHandler.getInput(wordArr.getIndex()))).toString());
				System.out.println("--------------------------------------------------");
			}
			else {
				System.out.println("--------------------------------------------------");
				System.out.println("Please enter your Word");
				wordArr.delete(in.nextLine().toLowerCase());
				System.out.println(((AMDWWord)(wordArr.getAtPos(wordArr.seqSearch(in.nextLine().toLowerCase())))).toString());
				System.out.println("--------------------------------------------------");
			}
			mainMenu();
			break;
		case 4:
			//Writes File
			try {
				writer = new AMDWWriteFile();
				writer.writeArray(wordArr);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Written to defaultoutput.txt");
			System.out.println("--------------------------------------------------");
			mainMenu();
			break;
			default:
				mainMenu();
		}
		in.close();
	}
	
	//Set the filename of the input file to read
	public void setFileName(String fileName) throws FileNotFoundException {
		filename = fileName;
		try {
			reader = new AMDWReadFile(filename);
			wordArr = reader.storeObjects();
			System.out.println("New File name set, Thank You.");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, please try again!");
		}
		System.out.println("**************************************************");
	}
	
	public void normalMainMenu() {
	
		//Display Sub Menu using System.out
				System.out.println("**************************************************");
				System.out.println("Welcome to Hangman Game!");
				System.out.println("We have chosen a word for you,\ntry to guess one letter at a time");
				System.out.println("--------------------------------------------------");
				AMDWGameHandler.playMainGame(difficulty, wordArr);
				mainMenu();
	}
	
	public void versusMenu(){
		
		System.out.println("**************************************************");
		System.out.println("Welcome to Hangman Game!");
		System.out.println("We have chosen a word for you,\ntry to guess one letter at a time");
		System.out.println("--------------------------------------------------");
		AMDWGameHandler.playVersusGame(difficulty, wordArr);
		mainMenu();
	
	}
	



}
