package War;

public class PlayGame {
	public static void main(String[] args) {
		// 1000 times, allocate an instance of war and play. Find the average number of rounds 
		// played in each game and print that out.
		int numOfGames = 10000;
		int totalRoundsForAllGames = 0;	

		for( int i = 0; i < numOfGames; i++){
			War g = new War(1);	
			totalRoundsForAllGames += g.playRounds();
		}
		System.out.println(totalRoundsForAllGames/numOfGames);
	}
}
