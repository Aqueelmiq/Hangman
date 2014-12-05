
public class Word {
	String wordContent;
	int length, difficulty, category;
	String type, explanation;
	String baseType;
	/*
	 * 
	 *
	 * 1.'gre', 2.'gre_hf', 3.'sat1', 4.'sat2', 5.'toefl', 6.'toefl_hf', 7.'trial'
	 */
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
		case 8: baseType="US_Cities";
		break;
		case 9: baseType="US_Sports";
		break;
		default: baseType="None";
		}
	}
	public String toString(){
		String myString="";
		myString = wordContent + "," + length + ","  + difficulty + "," + baseType + "," + type + "," + explanation; 
		return myString;
	}

	
}
