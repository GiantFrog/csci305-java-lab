package csci305.javalab;

public class MyBot extends Player
{
	private int[] plays, winners;
	private boolean[] common;
	//for all arrays, 0 stores rock, 1 stores paper, 2 stores scissors, 3 stores lizard, and 4 stores spock

	public MyBot()
	{
		super("Predictive Bot");
		plays = new int[] {0, 0, 0, 0, 0};							//tallies up opponent moves
		common = new boolean[] {false, false, false, false, false};	//flags the most common play(s)
		winners = new int[] {0, 0, 0, 0, 0};						//used to determine the most likely winner
	}
	public MyBot (String name)
	{
		super (name);
		plays = new int[]{0, 0, 0, 0, 0};
		common = new boolean[] {false, false, false, false, false};
		winners = new int[] {0, 0, 0, 0, 0};
	}

	public void takeOpponentMove (Element move)
	{								//opponent made a move, so add a tally
		switch (move.getName())		//to the proper space in the plays array
		{
			case "rock":
				plays[0]++;
				break;
			case "paper":
				plays[1]++;
				break;
			case "scissors":
				plays[2]++;
				break;
			case "lizard":
				plays[3]++;
				break;
			case "Spock":
				plays[4]++;
				break;
			default: System.out.println("Jay's bot can't take in a move.");
		}
	}

	public Element play()
	{
		for (int a = 0; a < common.length; a++) {
			common[a] = false;	//reset common to all false before use
		}
		for (int a = 0; a < winners.length; a++) {
			winners[a] = 0;		//reset winners to all 0 before use
		}

		flagMax(plays);			//values tied for max are flagged true in common

		if (common[0]) {		//other player tends to pick rock
			winners[1]++;		//so pick paper
			winners[4]++;		//or spock
		}
		if (common[1]) {		//tends towards paper
			winners[2]++;		//so pick scissors
			winners[3]++;		//or lizards
		}
		if (common[2]) {		//scissors
			winners[0]++;
			winners[4]++;		//rock or spock
		}
		if (common[3]) {		//lizard
			winners[0]++;
			winners[2]++;		//rock or scissors
		}
		if (common[4]) {		//spock
			winners[1]++;
			winners[3]++;		//paper or lizard
		}

		flagMax(winners);		//flag best move candidates in common;
								//common is reset in flagMax, because there will never be a max of 0

		int toPickFrom = 0;
		//add up how many best options there are
		for (int a = 0; a < common.length; a++) {
			if (common[a]) toPickFrom++;
		}
		int counter = 0, choice = (int)(Math.random()*toPickFrom);

		/*randomly pick from all winners marked true in common
		Counter increases by 1 when it passes over a 'true' in common.
		The counter stops when it reaches the randomly generated choice.
		At this point, the proper move is returned, based off the location in the array.*/
		for (int a = 0; a < common.length; a++)
		{
			if (common[a])
			{
				if (counter == choice)
				{
					switch (a)
					{
						case 0: return RPSLS.moves.get("Rock");
						case 1: return RPSLS.moves.get("Paper");
						case 2: return RPSLS.moves.get("Scissors");
						case 3: return RPSLS.moves.get("Lizard");
						case 4: return RPSLS.moves.get("Spock");
						default: return new Lizard("Jay's bot sucks.");
					}
				}
				else counter++;
			}
		}
		return new Lizard("Jay's bot really sucks.");	//only reached if nothing works
	}

	private void flagMax (int[] array)
	{
		int max = 0;

		for (int a = 0; a < array.length; a++)
		{
			if (array[a] > max)
			{
				max = array[a];
				for (int b = 0; b < common.length; b++) {
					common[b] = false;		//new max, so discard the old ones
				}
				common[a] = true;			//now set this one to be the most common!
			}
			else if (array[a] == max) common[a] = true;	//just add a new max to the others without discarding them
		}
	}
}
