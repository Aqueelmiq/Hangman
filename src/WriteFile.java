import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Supplement to the ReadFile class. Will write a changed
 * ObjectArray to the output file for more permanent storage.
 */

public class WriteFile {
	FileWriter fWriter;
	//BufferedWriter bWriter = new BufferedWriter(fWriter);
	//PrintWriter out = new PrintWriter(bWriter);
	
	public WriteFile() throws IOException{ //default constructor, uses "defaultoutput.txt" as the file to write to
		fWriter = new FileWriter("defaultoutput.txt",true);
	}
	
	public WriteFile(String newFile) throws IOException{ //nondefault constructor, file to write to as the argument
		fWriter = new FileWriter(newFile,true);
	}
	
	//writes a specific string to the output file
	public void writeLine(String toWrite) throws IOException{
		fWriter.write(toWrite + "\n");
	}
	//writes an object to the output file
	public void writeLine(Object obj) throws IOException{
		fWriter.write(obj.toString() + "\n");
	}
	
	//writes the array from first element to the index into output file
	public void writeArray(ObjectArrayAdvanced objArr) throws IOException{
			fWriter.write(objArr.toString() + "\n");
	}
}
