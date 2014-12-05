
public class ObjectArrayAdvanced extends ObjectArray{
	
	private int pointer;
	
	//Default COnstructor Initialization
	public ObjectArrayAdvanced() {
		super();
	}
	//Non Default COnstructor Initialization
	public ObjectArrayAdvanced(int pointer) {
		super();
		pointer = 0;
	}
	
	//Search List for an Object
	public int seqSearch(String name) {
		for(int i=0; i<this.getIndex(); i++) {
			if((((Word)this.getAtPos(i)).getWord()).compareTo(name)==0)
				return i;
		}
		return -1;
		
	}
	
	//Sort the List
	public void sort(){
		for(int i=0; i<this.getIndex(); i++) {
			for(int j=i; j<this.getIndex(); j++) {
				if(((Word)this.getAtPos(i)).compareTo(((Word)this.getAtPos(j)))<0) {
					Word tmp = (Word)this.getAtPos(i);
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
			toString += ((Word)super.getAtPos(i)).toString();
			toString += "\n";
		}
		return toString;
	}

}
