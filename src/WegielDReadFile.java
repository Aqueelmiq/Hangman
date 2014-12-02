/*
 * Dominik Wegiel
 * CS 201 
 * Sec. 2 - 112F SB
 * 11/02/14
 * 
 * PROBLEM 1 and 2
 * 
 * This is the ReadFile class, responsible for 
 * reading in the CTA stop list, creating the objects,
 * and storing the objects in the encapsulated array,
 * containing 1 instance variable of scanner,
 * 1 nondefault constructor with the file name
 * as the parameter, and a method that reads the input file,
 * creates the objects, and stores the objects in the encapsulated array.
 * It will differentiate between a regular stop
 * and one that needs to be upgraded, and add it accordingly to the 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WegielDReadFile {

	private Scanner inFile; //instance variable of Scanner
	
	public WegielDReadFile(String newFile) throws FileNotFoundException{ //nondefault constructor, file as the argument
		FileReader aFile = new FileReader(newFile);
		inFile = new Scanner(aFile);
	}

	public WegielDObjectArr storeObjects(){ //method to read in the file and store data in encapsulated array and return it
		WegielDObjectArr stopsArr;
		stopsArr = new WegielDObjectArr();
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
			WegielDElStop1 levelStop;
			levelStop = new WegielDElStop1(stopId, stopLoc, level); //instantiate L stop with a level
			if (level != 0){ //if there is a level for the stop
				stopsArr.add(levelStop); //add the stop with a level to the next empty position
			} else stopsArr.add(newStop); //add the stop without a level in the next empty position in the array
		}
		return stopsArr;
	}
}
