import java.io.FileNotFoundException;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Tests the functions used by our application in order to 
 * fill in the test table and make needed modifications
 * for proper application operation.
 */

public class TestApp {
	
	public static void main(String[] args) throws FileNotFoundException{
		//instantiation of variables
		String filename = "dco.txt";
		ReadFile reader = new ReadFile(filename); //read in our input file
		ObjectArray wordArr = reader.storeObjects(); //create an array of Word objects from our input file
		Word myWord = new Word("accomplished",3,5,"adjective","settled securely and unconditionally"); //a word contained in our data file (should be found)
		Word falseWord = new Word("acco",4,8,"noun","secure"); //a word not contained in our data file (should not be found)
		
		//testing the search function (isThere) for a word present in the Array
		System.out.println("We are searching for:");
		System.out.println(myWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(myWord));
		System.out.println();
		System.out.println();
		
		//testing the search function (isThere) for a word not present in the Array
		System.out.println("We are searching for:");
		System.out.println(falseWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(falseWord));
		System.out.println();
		System.out.println();
		
		//testing the sort (by word length) function for the array
		System.out.println("Prior to sorting by length:");
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println("Sorting by length...");
		wordArr.sort();
		System.out.println("After sorting by length:");
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		//adding a new word to the array
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println("Adding a new word at the index with the following properties:");
		System.out.println(falseWord.toString());
		wordArr.add(falseWord);
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		//removing the first word from the array, by position
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("First word in the array:");
		System.out.println(wordArr.getAtPos(0).toString());
		System.out.println("Removing the first word by position...");
		wordArr.delete(0);
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("(New) First word in the array:");
		System.out.println(wordArr.getAtPos(0).toString());
		System.out.println();
		System.out.println();
		
		//removing the last word from the array, by object
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println("Removing the last word by object...");
		wordArr.delete(falseWord);
		System.out.println("Current index: " + wordArr.getIndex());
		System.out.println("Word at current index-1 position:");
		System.out.println(wordArr.getAtPos(wordArr.getIndex()-1).toString());
		System.out.println();
		System.out.println();
		
		//Menu testing TO ADD in the output file
		
		//Polymorphism testing
		
	}

}
