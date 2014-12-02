/*
 * Dominik Wegiel
 * Aqueel Miqdad
 * CS 201 
 * Sec. 2 - 112F SB
 * 
 * 11/30/14
 * 
 * Final project
 * 
 * This is the ReadFile class, it will process the chosen word list
 * into a generic list, readable and usable by the rest of the project.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WegielDReadFile {

	private Scanner inFile; //instance variable of Scanner
	
	public WegielDReadFile() throws FileNotFoundException{ //default constructor, reads the standard word list
		FileReader aFile = new FileReader(wordlist.txt);
		inFile = new Scanner(aFile);
	}
	
	public WegielDReadFile(String newFile) throws FileNotFoundException{ //nondefault constructor, file as the argument
		FileReader aFile = new FileReader(newFile);
		inFile = new Scanner(aFile);
	}

	@SuppressWarnings("rawtypes")
	public GenericList_DW storeObjects(){ //method to read in the file and store data in encapsulated array and return it
		GenericList_DW stopsArr;
		stopsArr = new GenericList_DW();
		while (inFile.hasNext()){ //while another line exists in chosen file
			String nextLine = inFile.nextLine(); //read next line
			String[] splitString = nextLine.split(","); //split input string into string array
			String currentWord = splitString[0]; //first element set to the word
			int wordLength = Integer.parseInt(splitString[1]); //second element set to the length
			int wordDiff = Integer.parseInt(splitString[2]); //third element set to the difficulty of the word
			String wordCat = splitString[3]; //fourth element set to the category of the word
			String wordType = splitString[4]; //fifth element set to the type of the word
			String wordDef = splitString[5]; //sixth element set to the definition of the word
			WegielDGPSLocation stopLoc;
			stopLoc = new WegielDGPSLocation(stopName,stopLat,stopLon); //instantiate stop gps location
			WegielDElStop newStop;
			newStop = new WegielDElStop(stopId, stopLoc); //instantiate L stop without a level
			WegielDElStopUpgrade levelStop;
			levelStop = new WegielDElStopUpgrade(stopId, stopLoc, level); //instantiate L stop with a level
			stopsArr.add(newStop); //add the stop without a level in the next empty position in the array
		}
		return stopsArr;
	}
}
