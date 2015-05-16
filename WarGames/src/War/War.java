package War;

import java.util.Random;


public class War {
	//make some private stacks here, one for each player's unplayed cards and used cards, 
	//the initial deck that needs to be allocated and shuffled. etc.

	MyStack<Card>  deck = new MyStack<Card>();
	MyStack <Card> playerOneDeck = new MyStack<Card>();
	MyStack <Card> playerTwoDeck = new MyStack<Card>();
	MyStack <Card> playerOneUsedCards = new MyStack<Card>();
	MyStack <Card> playerTwoUsedCards = new MyStack<Card>();
	MyStack <Card> warStack = new MyStack<Card>();

	War (MyStack<Card> d,long seed){
		deck = d; // deck, undefined right now, will be the stack that holds the initial set of 52 cards.
		deal();
	}
	War (long seed) {
		fullDeck();
		deck.shuffle(seed);
		deal();

	}


	public void fullDeck() {
		// this will allocate 52 cards into deck

		for (int i = 14; i >= 2; i--){

			deck.push(new Card(i, "C"));
			deck.push(new Card(i, "d"));
			deck.push(new Card(i, "S"));
			deck.push(new Card(i, "h"));
		}	
	}

	//splits deck evenly in two, 26 cards in a stack for each player
	private void deal() {
		for (int i = deck.size()/2; i > 0; i-- ){
			playerOneDeck.push(deck.pop());
			playerTwoDeck.push(deck.pop());
		}
	}

	public String toString(){

		String tmp = "";

		tmp += "Deck: \n" + deck + "\n";
		tmp += "Player1: \n" + playerOneDeck + "\n";
		tmp += "Player2: \n" + playerTwoDeck + "\n";

		return tmp;
	}

	// this method should assume that each player has been given 26 randomly ordered cards
	public int playRounds(){
		int numOfRounds = 0;

		while( (!playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()) ){



			if (playerOneDeck.peek().getValue() > playerTwoDeck.peek().getValue()){
				playerOneUsedCards.addStackToBottom(warStack);
				playerOneUsedCards.push(playerOneDeck.pop());
				playerOneUsedCards.push(playerTwoDeck.pop());
				playerOneDeck.addStackToBottom(playerOneUsedCards);
			}

			else if (playerOneDeck.peek().getValue() < playerTwoDeck.peek().getValue()){
				playerTwoUsedCards.addStackToBottom(warStack);
				playerTwoUsedCards.push(playerTwoDeck.pop());
				playerTwoUsedCards.push(playerOneDeck.pop());
				playerTwoDeck.addStackToBottom(playerTwoUsedCards);
			}
			//First War
			else if (playerOneDeck.peek().getValue() == playerTwoDeck.peek().getValue()){


				warStack.push(playerOneDeck.pop());
				warStack.push(playerOneDeck.pop());
				warStack.push(playerOneDeck.pop());

				warStack.push(playerTwoDeck.pop());
				warStack.push(playerTwoDeck.pop());
				warStack.push(playerTwoDeck.pop());

				numOfRounds++;
			}

			numOfRounds++;
		}
		return numOfRounds;
	}
}  //end

