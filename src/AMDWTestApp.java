import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Tests the functions used by our application in order to 
 * fill in the test table and make needed modifications
 * for proper application operation.
 */

public class AMDWTestApp {
	
	public static void main(String[] args) throws IOException{
		//instantiation of variables
		String filename = "dco.txt";
		AMDWReadFile reader = new AMDWReadFile(filename); //read in our input file
		AMDWObjectArray wordArr = reader.storeObjects(); //create an array of Word objects from our input file
		AMDWWord myWord = new AMDWWord("accomplished",3,5,"adjective","settled securely and unconditionally"); //a word contained in our data file (should be found)
		AMDWWord falseWord = new AMDWWord("acco",4,8,"noun","secure"); //a word not contained in our data file (should not be found)
		
		System.out.println("* Search function (isThere) for a word present in the Array");
		System.out.println();
		System.out.println("We are searching for:");
		System.out.println(myWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(myWord));
		System.out.println();
		System.out.println();
		
		System.out.println("* Search function (isThere) for a word not present in the Array");
		System.out.println();
		System.out.println("We are searching for:");
		System.out.println(falseWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(falseWord));
		System.out.println();
		System.out.println();
		
		System.out.println("* Sort (by word length) function for the array");
		System.out.println();
		System.out.println("Prior to sorting by length:");
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println("Sorting by length...");
		wordArr.sort();
		System.out.println();
		System.out.println("After sorting by length:");
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		System.out.println("* Adding a new word to the array");
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println("Adding a new word at the index with the following properties:");
		System.out.println(falseWord.toString());
		wordArr.add(falseWord);
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		System.out.println("* Inserting a new word to the array at a specific position (5)");
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at position 4:");
		System.out.println(wordArr.getAtPos(4).toString());
		System.out.println();
		System.out.println("Word at position 5:");
		System.out.println(wordArr.getAtPos(5).toString());
		System.out.println();
		System.out.println("Word at position 6:");
		System.out.println(wordArr.getAtPos(6).toString());
		System.out.println();
		System.out.println("Adding a new word at position 5 with the following properties:");
		System.out.println(falseWord.toString());
		wordArr.insert(5,falseWord);
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at position 4:");
		System.out.println(wordArr.getAtPos(4).toString());
		System.out.println();
		System.out.println("Word at position 5:");
		System.out.println(wordArr.getAtPos(5).toString());
		System.out.println();
		System.out.println("Word at position 6:");
		System.out.println(wordArr.getAtPos(6).toString());
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("* Removing the first word from the array, by position");
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("First word in the array:");
		System.out.println(wordArr.getAtPos(0).toString());
		System.out.println();
		System.out.println("Removing the first word by position...");
		wordArr.delete(0);
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("(New) First word in the array:");
		System.out.println(wordArr.getAtPos(0).toString());
		System.out.println();
		System.out.println();
		
		System.out.println("* Removing the last word from the array, by object");
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println("Removing the last word by object...");
		wordArr.delete(falseWord);
		System.out.println();
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		//Menu testing performed externally, copied and pasted into the output file.
		
		//Polymorphism testing
		AMDWGame myGame = new AMDWGame(myWord,1);
		AMDWVersusGame vsGame = new AMDWVersusGame(myWord, falseWord, 1);
		
		System.out.println("* toString()");
		System.out.println();
		System.out.println("For a regular game");
		System.out.println(myGame.toString());
		System.out.println();
		System.out.println("For a game against AI");
		System.out.println(vsGame.toString());
		System.out.println();
		System.out.println();
		
		System.out.println("* guess()");
		System.out.println();
		System.out.println("For a regular game");
		myGame.guess('b');
		System.out.println();
		System.out.println("For a game against AI");
		vsGame.guess('b');
		System.out.println();
		System.out.println();
		System.out.println();
		
		//WriteFile
		AMDWWriteFile write = new AMDWWriteFile("newww.txt");
		
		
		System.out.println("* Write array to file:");
		write.writeArray((AMDWObjectArrayAdvanced) wordArr);
		System.out.println("Wrote to file");
		System.out.println();
		System.out.println();
		
		System.out.println("* Write word to file:");
		System.out.println(myWord.toString());
		write.writeLine(myWord);
		System.out.println("Wrote to file");
		System.out.println();
		System.out.println();
		
		String test = "A test string";
		System.out.println("* Write string to file:");
		System.out.println(test);
		write.writeLine(test);
		System.out.println("Wrote to file");
		System.out.println();
		System.out.println();
		
	}

}
