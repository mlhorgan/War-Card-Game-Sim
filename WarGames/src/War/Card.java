package War;

public class Card {

	/* **
	In this file, you�ll define a class for a single Card. 
	You can do anything you want here but each card must have a value from 2 to 14 (Aces high and worth 14) 
	and also have a suit. War doesn�t use suits to decide a winner, but you must have them. 

	The suit for a card must be one of either h, C, d, S when printed out. 
	Internally you can do as you wish to make that happen.   
	You must have toString(), getSuit(), setSuit(), getValue(), and setValue()  
	methods in this class. Your toString() should return nice strings like 2h, 3C, 14S, and so on. 
	I used lower case for hearts and diamonds to approximate that they are colored red, versus upper case for the black suits.
	 ** */
	private String suit;
	private int value;

	public Card(int v , String s) {
		suit=s;
		value=v;
	}

	public String getSuit(){
		return suit;

	}

	public void setSuit(String s){
		suit = s;
	}

	public Integer getValue(){
		return value;
	}

	public void setValue(int n){
		value = n;
	}

	public String toString(){

		return getValue()+""+getSuit();
	}

}

