package com.castle.builder.company;

import java.util.Scanner;

public class CastleCompany {
	int castleInput[];
	int castleCounter=0;
	int peakCastleCounter=0;
	int valleyCastleCounter=0;

	

	public void receiveInput(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number of elements");

	    int n=sc.nextInt();
	    castleInput =new int[n];
	    System.out.println("enter elements");

	    for(int i=0;i<n;i++){//for reading array
	    	castleInput[i]=sc.nextInt();
	    }
	    	
		
}



	public void countCastle() {
		
	    for(int i=0;i<castleInput.length;i++){
	    	if(canBuildCastle(i)){
	    		castleCounter++;
	    	}
	    }
	System.out.println("Number Of Castle to be build are :"+castleCounter);
	}
	
	
	
	public  boolean canBuildCastle(int index){
		
		/**
		 * This is first condition mentioned , as mentioned in defined rules, is this is first index and that is non-zero then we could create a castle. 
		 */
		if(index == 0 ){
			if(castleInput[index] !=0){
			return true;
			}else {
			 return false;	
			}
			
		}
		 //validating if we found peak
		/**
		 * Following will be condition for peak....
		 * Condition a: index is not last index && value at index > (value at index-1 and value at index+1)
		 * Condition b: index is not last index && (value at index > (value at index -1) )&&(value at index == value at index + 1)
		 * Condition c: index  is last index && 
		 */
		else if(!(index==castleInput.length-1) && (castleInput[index-1] < castleInput[index] ) && castleInput[index] >=castleInput[index+1]){
			peakCastleCounter++;
			return true;
		}
		
			/**
			 * Following will be condition for valley....
			 * Condition a: index is not last index && value at index < (value at index-1 and value at index+1)
			 * Condition b: index is not last index && (value at index < (value at index -1) )&&(value at index == value at index + 1)
			 * 
			 */

		else if(!(index==castleInput.length-1) && (castleInput[index-1] > castleInput[index] )&& castleInput[index] <=castleInput[index+1] ) {
			valleyCastleCounter++;
			return true;
		}
		
		/**
		 * Condition c: index  is last index ,then we will only check for the previous index. 
		 */
		else if((index==castleInput.length-1) && ((castleInput[index] !=0)) && (castleInput[index-1] != castleInput[index])){
			return true;
		}
		
		return false;
	}

	public int[] getCastleInput() {
		return castleInput;
	}



	public void setCastleInput(int[] castleInput) {
		this.castleInput = castleInput;
	}



	public int getCastleCounter() {
		return castleCounter;
	}



	public void setCastleCounter(int castleCounter) {
		this.castleCounter = castleCounter;
	}


}

