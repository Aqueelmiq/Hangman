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
		Word myWord2 = (Word)wordArr.getAtPos(68);
		Word falseWord = new Word("acco", 23,8,"noun","secure"); //a word not contained in our data file (should not be found)
		
		//testing the search function (isThere) for a word present in the Array
		System.out.println("We are searching for:");
		System.out.println(myWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(myWord));
		
		//testing the search function (isThere) for a word not present in the Array
		System.out.println("We are searching for:");
		System.out.println(falseWord.toString());
		System.out.println("Found at position: " + wordArr.isThere(falseWord));
		
		//testing the sort function for the array
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		wordArr.sort();
		System.out.println("First word:\n" + wordArr.getAtPos(0).toString());
		System.out.println("Last word:\n" + wordArr.getAtPos(wordArr.getIndex()-1).toString());
		
		
	}

}
