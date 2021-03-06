/*
 * CS - 201 Final Project
 * Hangman Game
 * Created by Aqueel Miqdad, Dominik Wegiel
 * ObjectArray class is the general API for an encapsulated array
 * of type object. In this case, it is adapted with functions for
 * modifying and comparing instances of Word objects.
 */

import java.util.Arrays;


	public class AMDWObjectArray {
		
		//Instance variable to handle and sort the array
		private final int MAX = 100000;
		private Object[] myObject;
		private int index;
		
		public AMDWObjectArray() {
			myObject = new Object[MAX];
			index = 0;
		}
		
		//Getters
		public int getIndex() {
			return index;
		}
		
		public String toText(int pos) {
			return myObject[pos].toString();
		}
		
		//Setters
		public void add(Object anObj) {
			myObject[index] = anObj;
			index++;
		}
		
		public Object getAtPos(int pos) {
			return myObject[pos];
		}
		
		public void setAtPos(int pos, Object obj) {
			 myObject[pos] =  obj;
		}
		
		public void delete(int pos){
			for(int i=pos; i<(index-1); i++) {
				myObject[i]=myObject[i+1];
			}
			index--;
			
		} //deletes the object at pos and moves all elements up towards 0
		
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
	    		if(myObject[i].equals(myObj)) {
	    			myInt=i;
	    		}
	    	}
	    	return myInt;
	        	   
	    }  //searches for and returns the index of anObj, -1 if not found
	    
	    public void delete(Object myObj){
	    	int pos;
	    	if((pos=isThere(myObj))!=-1){
	    		delete(pos);
	    	}
	    	else{
	    		System.out.println("Object not found");
	    	}
	        	   
	    } //searches for anObj and deletes if found
	    
	    
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
		
		//To String method for Object array
		@Override
		public String toString(){
			String myString = null;
			for(int i=0; i<index; i++){
				myString += myObject[i].toString();
				myString += "\n";
			}
			return myString;
		}
		
		
		//Simple selection sort to sort the word list
		public void sort() {
			AMDWWord tmp;
			for(int i=0; i<index; i++) {
				for(int j=0; j<index; j++) {//originally j=i; i<index
					if(((AMDWWord)myObject[i]).compareTo((AMDWWord)myObject[j])<0) {
						tmp = (AMDWWord)myObject[i];
						myObject[i] = myObject[j];
						myObject[j] = tmp;
					}
				}
			}
		}
		
		//Overriding usual equals ethod
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AMDWObjectArray other = (AMDWObjectArray) obj;
			if (MAX != other.MAX)
				return false;
			if (index != other.index)
				return false;
			if (!Arrays.equals(myObject, other.myObject))
				return false;
			return true;
		}
	}


