import java.io.*;
import java.util.*;
import java.io.FileReader;


public class CreateList {

	public static void main(String[] args) {
		String[] split;
		int category=0;
		String reader;
		ObjectArray wordList = new ObjectArray();
		try{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		while((reader=in.readLine())!=null) {
			split = reader.split(",");
			if(split[1].compareTo("1")==0)
				category=1;
			else if(split[2].compareTo("1")==0)
				category=2;
			else if(split[3].compareTo("1")==0)
				category=3;
			else if(split[4].compareTo("1")==0)
				category=4;
			else if(split[5].compareTo("1")==0)
				category=5;
			else if(split[6].compareTo("1")==0)
				category=6;
			else if(split[7].compareTo("1")==0)
				category=7;
			
			Word myWord = new Word(split[0],split[8],split[9],category);
			wordList.add(myWord);
		}
		BufferedWriter br = null;
		try {
			File file = new File("output.txt");
		    file.createNewFile();
		    br = new BufferedWriter(new FileWriter(file));
			br.write(wordList.toString());
			}catch (IOException e) {
				e.printStackTrace();
			}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}finally{}


	}

}
