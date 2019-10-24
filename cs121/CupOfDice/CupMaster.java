
public class CupMaster {

	public static void main(String[] args) {
		
		CupOfDice shaker = new CupOfDice();
		
		shaker.shake();
		int player1score = shaker.getScore();
		System.out.println("Player 1's Cup:");
		System.out.println(shaker);
		
		
		shaker.shake();
		int player2score = shaker.getScore();
		System.out.println("Player 2's Cup:");
		System.out.println(shaker);
		
		
		if (player1score > player2score) {
			System.out.println("Player 1 wins with: " + player1score);
		} else if ( player1score < player2score) {
			System.out.println("Player 2 wins with:" + player2score);
		} else {
			System.out.println("Tie game, everyone's a winner!");
		}

	}

}
