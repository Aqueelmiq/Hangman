/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Weigel
 * Last updated 11/29/2014
 * Word class stores each word in a class along with other details like category and difficulty
 * It provides methods to access and manipulate details about each word. The word objects will be stored in object array
 */

public class Word {
	
	//Instance Variables for the word class
	private String wordContent; //Stores the word
	private int length, difficulty, category;  //Stores length of the word, difficulty and also the category of the word
	private String type, explanation; //Type  and explanation gives meaning of the word
	private String baseType; //Base type stores which exam, the word is more frequently used
	
	/*
	 * 1.'gre', 2.'gre_hf', 3.'sat1', 4.'sat2', 5.'toefl', 6.'toefl_hf', 7.'trial'
	 */
	
	//Non Default constructor below. The switch statement converts the input numeric category into text Category.
	public Word(String word,String type,String explanation,int category) {
		this.wordContent=word;
		this.category=category;
		this.type= type;
		this.explanation=explanation;
		this.length=word.length();
		if(this.length<5)
			this.difficulty=1;
		else if(this.length<8)
			this.difficulty=2;
		else
			this.difficulty=3;
		switch(category) {
		case 1: baseType="GRE";
				break;
		case 2: baseType="GRE_HF";
		break;
		case 3: baseType="SAT1";
		break;
		case 4: baseType="SAT2";
		break;
		case 5: baseType="TOEFL";
		break;
		case 6: baseType="TOEFL_HF";
		break;
		case 7: baseType="Trial";
		break;
		default: baseType="None";
		}
	}
	
	//Getters below
	public String getWord(){
		return wordContent;
	}
	
	public String getType(){
		return type;
	}
	
	public String getExplanation(){
		return explanation;
	}
	
	public String getBaseType(){
		return baseType;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getCategory(){
		return category;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	//Setters below
	public void setWord(String value){
		this.wordContent=value;
	}
	
	public void setBaseType(String value){
		this.baseType=value;
	}
	
	public void setType(String value){
		this.type=value;
	}
	
	public void setLength(int value){
		this.length=value;
	}
	
	public void setCategory(int value){
		this.category=value;
	}
	
	public void setDifficulty(int value){
		this.difficulty=value;
	}
	
	public void setExplanation(String value){
		this.explanation=value;
	}
	
	//Custom equals method to check for a redundant same word.
	public boolean equals(Object obj){
		if(obj instanceof Word){
			if(this.wordContent.compareTo(((Word) obj).getWord())==0 && this.category==((Word) obj).getCategory())
				return true;
			else
				return false;
		}
		else{
			return false;
		}
	}
	
	//toString method returns a string with descriptive info about the word.
	@Override
	public String toString(){
		String myString="";
		myString = wordContent + "," + length + ","  + difficulty + "," + baseType + "," + type + "," + explanation; 
		return myString;
	}

	
}