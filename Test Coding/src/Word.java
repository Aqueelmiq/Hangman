
public class Word {
	String wordContent;
	int length, difficulty, category;
	String type, explanation;
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
	}
	public String toString(){
		string
	}

	
}
