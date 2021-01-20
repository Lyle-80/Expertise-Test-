package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MPCRoulette {
    protected static byte randomNumber = 0;
    protected static List<Users> users;
    protected static List<Bets> bets = new ArrayList<>();
    private static Scanner sc = null;


    public MPCRoulette(){

    }
    @SuppressWarnings("static-access")
	public MPCRoulette(List<Users> users){
        this.users = users;
    }


// Welcome Screen & Bet Taker
    protected static void takeBets(){

        sc = new Scanner(System.in);
        sc.reset();

        System.out.print("-> ");

        String currentBet = "";

        if (sc.hasNextLine()) {
            currentBet = sc.nextLine().trim();
        } else {
            System.out.println("Incorrect bet placement. Please try "
            		+ "Bet Type 1: Jacki 7 100.0  or Bet Type 2: Tanya ODD 250");
            sc.next();
            System.out.println();
        }

        Dealer.processBet(currentBet);

    }
    protected void landingTexts(){
        System.out.println("\n\nWelcome to Multiplayer Roulette!!!" +
                "\n==================================\n\n" +
                "How to play? -> (Name, Wheel-Number 1-36 OR ODD/EVEN  &  Bet$)\n" +
                "Bet Type 1: Jacki 7 100.0\n" +
                "Bet Type 2: Tanya ODD 250\n");

    }
}
