/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * ObjectArrayAdvanced is an extension to the regular ObjectArray.
 * It adds a pointer variable for iteration, along with search
 * and sort functionality.
 */


public class AMDWObjectArrayAdvanced extends AMDWObjectArray{
	
	private int pointer;
	
	//Default COnstructor Initialization
	public AMDWObjectArrayAdvanced() {
		super();
	}
	//Non Default COnstructor Initialization
	public AMDWObjectArrayAdvanced(int pointer) {
		super();
		pointer = 0;
	}
	
	//Search List for an Object
	public int seqSearch(String name) {
		for(int i=0; i<this.getIndex(); i++) {
			if((((AMDWWord)this.getAtPos(i)).getWord()).compareTo(name)==0)
				return i;
		}
		return -1;
		
	}
	
	//Sort the List
	public void sort(){
		for(int i=0; i<this.getIndex(); i++) {
			for(int j=i; j<this.getIndex(); j++) {
				if(((AMDWWord)this.getAtPos(i)).compareTo(((AMDWWord)this.getAtPos(j)))<0) {
					AMDWWord tmp = (AMDWWord)this.getAtPos(i);
					this.setAtPos(i,(this.getAtPos(j)));
					this.setAtPos(j,tmp);
				}
			}
		}
	}
	
	//Deletes a specific word from the list
	public void delete(String word){
    	if(seqSearch(word)!=-1) {
    		super.delete(seqSearch(word));
    	}
    	else {
    		System.out.println("Not Found");
    	}
    }
	
	//Reset Method
	public void reset(){
		pointer = 0;
	}
	
	//Has Next
	public boolean hasNext(){
		if(pointer<super.getIndex())
			return true;
		else
			return false;
	}
	
	//Has Next
	public Object getNext(){
		pointer++;
		return super.getAtPos(pointer-1);
	}
	
	//To String method overrides Object Array
	public String toString(){
		String toString = "";
		for(int i=0; i<super.getIndex(); i++) {
			toString += ((AMDWWord)super.getAtPos(i)).toString();
			toString += "\n";
		}
		return toString;
	}

}
