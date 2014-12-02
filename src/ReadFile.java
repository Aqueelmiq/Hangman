/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * 
 * This is the ReadFile class, responsible for 
 * reading in the word list, creating word objects,
 * and storing the objects in the encapsulated array,
 * containing 1 instance variable of scanner,
 * 1 nondefault constructor with the file name
 * as the parameter, and a method that reads the input file,
 * creates the objects, and stores the objects in the encapsulated array.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

	private Scanner inFile; //instance variable of Scanner
	
	public ReadFile() throws FileNotFoundException{ //default constructor, uses default wordlist as the file
		FileReader aFile = new FileReader("wordlist.txt");
		inFile = new Scanner(aFile);
	}
	
	public ReadFile(String newFile) throws FileNotFoundException{ //nondefault constructor, file as the argument
		FileReader aFile = new FileReader(newFile);
		inFile = new Scanner(aFile);
	}

	public ObjectArr storeObjects(){ //method to read in the file and store data in encapsulated array and return it
		ObjectArr stopsArr;
		stopsArr = new ObjectArr();
		while (inFile.hasNext()){ //while another line exists in chosen file
			String nextLine = inFile.nextLine(); //read next line
			String[] splitString = nextLine.split(","); //split input string into string array
			String currentWord = splitString[0]; //first element set to the word
			int wordLength = Integer.parseInt(splitString[1]); //second element set to the length
			int wordDiff = Integer.parseInt(splitString[2]); //third element set to the difficulty of the word
			String wordCat = splitString[3]; //fourth element set to the category of the word
			String wordType = splitString[4]; //fifth element set to the type of the word
			String wordDef = splitString[5]; //sixth element set to the definition of the word
			GPSLocation stopLoc;
			stopLoc = new GPSLocation(stopName,stopLat,stopLon); //instantiate stop gps location
			ElStop newStop;
			newStop = new ElStop(stopId, stopLoc); //instantiate L stop without a level
			ElStop1 levelStop;
			levelStop = new ElStop1(stopId, stopLoc, level); //instantiate L stop with a level
			if (level != 0){ //if there is a level for the stop
				stopsArr.add(levelStop); //add the stop with a level to the next empty position
			} else stopsArr.add(newStop); //add the stop without a level in the next empty position in the array
		}
		return stopsArr;
	}
}
