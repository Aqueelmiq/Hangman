import java.io.*;
import java.util.*;


public class AMDWEveryXthLine {
	public static void main(String[] args) throws IOException{
		String[] newArr = new String[99999999];
		Scanner input = new Scanner(System.in);
		System.out.println("Choose input file");
		String inputFile = input.nextLine();
		FileReader in = new FileReader(inputFile);
		Scanner inFile = new Scanner(in);
		System.out.println("Choose output file");
		String outputFile = input.nextLine();
		FileWriter out = new FileWriter(outputFile);
		int linesRead = 0;
		while (inFile.hasNext()){
			String processing = inFile.nextLine();
			newArr[linesRead] = processing;
			linesRead++;
		}
		System.out.println("Read " + linesRead + " lines");
		//System.out.println(list.size());
		
		System.out.println("Write every how many lines?");
		String lineSkip = input.nextLine();
		int numSkip = Integer.parseInt(lineSkip);
		
		for (int i=0; i<newArr.length; i++){
			if ((i % numSkip) != 0){
				//System.out.println("Removed line " + i);
				newArr[i] = null;
			}
		}
		int written = 0;
		//System.out.println(list.size());
		for (int i=0; i<newArr.length; i++){
			if (newArr[i] != null){
				//System.out.println(list.get(i));
				out.write(newArr[i] + "\n");
				written++;
			}
		}
		System.out.println("Wrote " + written + " lines");
		out.close();
		in.close();
		inFile.close();
		input.close();
	}
}
