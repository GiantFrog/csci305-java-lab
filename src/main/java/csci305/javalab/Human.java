package csci305.javalab;

import java.util.Scanner;

public class Human extends Player
{
	private Scanner scanThat;

	public Human() {
		super ("Human");
	}
	public Human (String name) {
		super (name);
	}
	public void takeOpponentMove (Element move) {
		//don't do anything with it
	}

	public Element play()
	{
		System.out.println("\n1: Rock\n2: Paper\n3: Scissors\n4: Lizard\n5: Spock");

		while (true)
		{
			System.out.print("Your move: ");
			try
			{
				switch (Integer.parseInt(RPSLS.scone.readLine()))
				{
					case 1:
						return RPSLS.moves.get("Rock");
					case 2:
						return RPSLS.moves.get("Paper");
					case 3:
						return RPSLS.moves.get("Scissors");
					case 4:
						return RPSLS.moves.get("Lizard");
					case 5:
						return RPSLS.moves.get("Spock");
					default:
						System.out.println("Invalid input! 1-5 only, please!");
				}
			}
			catch (Exception shucks)
			{
				System.out.println("Invalid input! 1-5 only, please!");
			}
		}
	}
}
