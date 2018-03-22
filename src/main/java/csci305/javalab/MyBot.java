package csci305.javalab;

public class MyBot extends Player
{
	private int[] plays;
	//for both arrays, 0 stores rock, 1 stores paper, 2 stores scissors, 3 stores lizard, and 4 stores spock

	public MyBot()
	{
		super("Predictive Bot");
		plays = new int[] {0, 0, 0, 0, 0};
	}
	public MyBot (String name)
	{
		super (name);
		plays = new int[]{0, 0, 0, 0, 0};
	}

	public void takeOpponentMove (Element move)
	{
		switch (move.getName())
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
		boolean[] common = new boolean[] {false, false, false, false, false};	//notes the most common play(s)
		int[] winners = new int[] {0, 0, 0, 0, 0};			//used to determine the most likely winner
		int max = 0;

		for (int a = 0; a < plays.length; a++)
		{
			if (plays[a] > max)
			{
				max = plays[a];
				for (int b = 0; b < common.length; b++) {
					common[b] = false;		//new max, so discard the old ones
				}
				common[a] = true;			//now set this one to be the most common!
			}
			else if (plays[a] == max) common[a] = true;	//just add a new max to the others

		}

		if (common[0] == true) {	//other player tends to pick rock
			winners[1]++;			//so pick paper
			winners[4]++;			//or spock
		}
		if (common[1] == true) {	//tends towards paper
			winners[2]++;			//so pick scissors
			winners[3]++;			//or lizards
		}
		if (common[2] == true) {	//scissors
			winners[0]++;
			winners[4]++;			//rock or spock
		}
		if (common[3] == true) {	//lizard
			winners[0]++;
			winners[2]++;			//rock or scissors
		}
		if (common[4] == true) {	//spock
			winners[1]++;
			winners[3]++;			//paper or lizard
		}

		max = 0;

		for (int a = 0; a < winners.length; a++)
		{
			if (winners[a] > max)
			{
				max = winners[a];
				for (int b = 0; b < common.length; b++) {	//reusing common to mark the most common winners
					common[b] = false;        				//winners should never be filled with 0s, so no need to reset beforehand
				}
				common[a] = true;            //now set this one to be the most common!
			}
			else if (winners[a] == max) common[a] = true;    //just add a new max to the others
		}

		//randomly pick from all marked true in common
		int toPickFrom = 0;
		for (int a = 0; a < common.length; a++) {
			if (common[a]) toPickFrom++;	//add up how many best options there are
		}
		int counter = 0, choice = (int)(Math.random()*toPickFrom);

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
		return new Lizard("Jay's bot really sucks.");	//if nothing works
	}
}
