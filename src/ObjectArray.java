
	public class ObjectArray {
		
		private final int MAX = 100000;
		private Object[] myObject;
		private int index;
		private int pointer;
		
		public ObjectArray() {
			myObject = new Object[MAX];
			index = 0;
			pointer = 0;
		}
		
		public int getIndex() {
			return index;
		}
		
		public String toText(int pos) {
			return myObject[pos].toString();
		}
		
		public void add(Object anObj) {
			myObject[index] = anObj;
			index++;
		}

		public void delete(int pos){
			for(int i=pos; i<(index-1); i++) {
				myObject[i]=myObject[i+1];
			}
			index--;
			
		}             //deletes the object at pos and moves all elements up towards 0
		
		public void insert(int pos, Object myObj){
			for(int i=(index-1); i>pos; i--) {
				myObject[i+1]=myObject[i];
			}
			myObject[pos] = myObj;
			index++;
			
		}	//inserts the object at pos and moves all elements down towards the end
		
	    public int isThere(Object myObj){
	    	int myInt=-1;
	    	for(int i=0; i<index; i++) {
	    		if(myObject[i]==myObj) {
	    			myInt=i;
	    		}
	    	}
	    	return myInt;
	        	   
	    }        //searches for and returns the index of anObj, -1 if not found
	    
	    public void delete(Object myObj){
	    	int pos;
	    	if((pos=isThere(myObj))!=-1){
	    		delete(pos);
	    	}
	    	else{
	    		System.out.println("Object not found");
	    	}
	        	   
	           }   //searches for anObj and deletes if found
	    
		public boolean isFull(){
			if(index==MAX)
				return true;
			else
				return false;
		}		//returns true if array is full, false if array is not
		
		public boolean isEmpty(){
			if(index==0)
				return true;
			else
				return false;
			
		}		//returns true if array is empty, false if array is not	
		
		public void clear(){
			myObject = new Object[MAX];
			index=0;
			
		}			//deletes all data from list 
		
		 
		public void trim(){
			Object[] newObject = new Object[index];
			for(int i=0; i<index; i++){
				newObject[i] = myObject[i];
			}
			myObject = new Object[index];
			myObject = newObject;
			
		}			//remove excess allocated memory so data fills array
		
		public void moreCapacity(int myInt){
			Object[] newObject = new Object[index*myInt];
			for(int i=0; i<index; i++){
				newObject[i] = myObject[i];
			}
			myObject = new Object[index*myInt];
			myObject = newObject;
			
		}		//automatically allocates int times more memory 
		
		public String toString(){
			String myString = null;
			for(int i=0; i<index; i++){
				myString += myObject[i].toString();
				myString += "\n";
			}
			return myString;
		}
		
		//Reset Method
		public void reset(){
			
		}
		
		//Has Next
		public boolean hasNext(){
			if(pointer<index)
				return true;
			else
				return false;
		}
		
		//Has Next
		public Object getNext(){
			pointer++;
			return myObject[pointer-1];
		}
	}


