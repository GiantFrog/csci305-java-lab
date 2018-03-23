package csci305.javalab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RPSLS
{
	public static final Map<String, Element> moves = new HashMap<>();
	public static BufferedReader scone = new BufferedReader(new InputStreamReader(System.in));

	public static void main (String[] args)
	{
		System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock!\n\timplemented by Jay Van Alstyne\n");

		System.out.println("Chose your fighters!\n\t1: Human\n\t2: Stupid Bot\n\t3: Random Bot\n" +
				"\t4: Iterative Bot\n\t5: Copycat Bot\n\t6: Predictive Bot\n");

		//assign the Map of moves while the player deliberates
		moves.put("Rock", new Rock());
		moves.put("Paper", new Paper());
		moves.put("Scissors", new Scissors());
		moves.put("Lizard", new Lizard());
		moves.put("Spock", new Spock());

		Player p1 = assignPlayer("Player 1");
		Player p2 = assignPlayer("Player 2");

		System.out.print(p1.getName() + " vs. " + p2.getName() +". ");
		//just a fun generator for a little variety. How fun.
		switch ((int)(Math.random()*5))
		{
			case 0:
				System.out.println("Go!");
				break;
			case 1:
				System.out.println("Begin!");
				break;
			case 2:
				System.out.println("Fight!");
				break;
			case 3:
				System.out.println("はじめ!");
				break;
			case 4:
				System.out.println("Anfangen!");
				break;
		}

		for (int a = 1; a <= 5; a++)		//change this to set match length
		{
			Element p1move = p1.play();
			Element p2move = p2.play();
			p1.takeOpponentMove(p2move);	//send the opponent's move to the player, which may be
			p2.takeOpponentMove(p1move);	//used to determine certain bots' next moves
			Outcome outcome = p1move.compareTo(p2move);

			System.out.print("\nRound " + a + "\n\tP1: " + p1.getName() + " chooses " + p1move.getName() + ".\n" +
					"\tP2: " + p2.getName() + " chooses " + p2move.getName() + ".\n" +
					"\t" + outcome + "\n\t");

			//add a point to the proper winner and print the results
			if (outcome.getOutcome().equals("Win")) {
				System.out.println(p1.getName() + " (P1) wins the round!");
				p1.addPoint();
			}
			else if (outcome.getOutcome().equals("Lose")) {
				System.out.println(p2.getName() + " (P2) wins the round!");
				p2.addPoint();
			}
			else System.out.println("The round ends in a draw!");
		}

		//game conclusion and stats time!
		System.out.println("\nFinal Score: " + p1.getScore() + " - " + p2.getScore());
		if (p1.getScore() > p2.getScore())
			System.out.println("A thrilling victory for player 1, the legendary " + p1.getName() + "!");
		else if (p1.getScore() < p2.getScore())
			System.out.println("Yet another win for player 2, the unstoppable " + p2.getName() + "!");
		else System.out.println("The match ends in a draw! What a close game!");
	}


	//returns a Player: either the proper bot or a human
	private static Player assignPlayer(String player)
	{
		while (true)
		{
			System.out.print(player + ": ");
			try
			{
				switch (Integer.parseInt(scone.readLine()))
				{
					case 1:
						System.out.println("What is the name of this player? ");	//name your humans!
						String name = scone.readLine();
						if (name.equals("")) return new Human();
						else return new Human(name);
					case 2:
						return new StupidBot();				//bots can also support custom names, if you
					case 3:									//want to add prompts to name them later
						return new RandomBot();
					case 4:
						return new IterativeBot();
					case 5:
						return new LastPlayBot();
					case 6:
						return new MyBot();
					default:
						System.out.println("Invalid input! 1-6 only, please!");
				}
			}
			catch (Exception dang)
			{
				System.out.println("Invalid input! 1-6 only, please!");
			}
		}
	}
}
