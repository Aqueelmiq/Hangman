//import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * Supplement to the ReadFile class. Will write a changed
 * ObjectArray to the output file for more permanent storage.
 */

public class AMDWWriteFile {
	FileWriter fWriter;
	//BufferedWriter bWriter = new BufferedWriter(fWriter);
	//PrintWriter out = new PrintWriter(bWriter);
	
	public AMDWWriteFile() throws IOException{ //default constructor, uses "defaultoutput.txt" as the file to write to
		fWriter = new FileWriter("defaultoutput.txt",true);
	}
	
	public AMDWWriteFile(String newFile) throws IOException{ //nondefault constructor, file to write to as the argument
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
	public void writeArray(AMDWObjectArrayAdvanced objArr) throws IOException{
			fWriter.write(objArr.toString());
	}
}
