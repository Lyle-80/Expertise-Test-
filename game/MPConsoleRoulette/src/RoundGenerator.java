package src;

import java.util.*;

public class RoundGenerator extends MPCRoulette implements RoundInterface{

// Set Round Duration (milliseconds) 
    private static final short ROUND_TIME = 25000;


    public RoundGenerator(){
        super();
    }
    @SuppressWarnings("unchecked")
	public RoundGenerator(@SuppressWarnings("rawtypes") List users){
        super(users);
        randomNumber = genRandom();
    }

// Random Number Generator inclusive (0-36) 
    private byte genRandom(){
        return (byte) Math.round(Math.random() * 36);
    }

// Round Initializer & Result Report Compiler
    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask results = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\n\n\n--------------------\n" +
                        "Results of Rounds" +
                        "\n--------------------\n");
                System.out.println(
                        "Number: "+randomNumber+
                                "\n-----------" + "\nPlayer \t|\t Bet \t|\t Outcome \t|\t Winnings \n" +
                                "===========================================================\n");
                for(Bets bet : bets){
                    if(bet instanceof BetType){

                        System.out.println(bet.getUsername() + " \t|\t " +((BetType) bet).getChosenOption()+ " \t|\t " + (bet.getWin() ? "WIN" : "LOSE" )+ " \t|\t " + bet.getWinning());
                    }else if(bet instanceof BetStraight){
                        System.out.println(bet.getUsername() + " \t|\t " +((BetStraight) bet).getChosenNumber()+ " \t|\t " + (bet.getWin() ? "WIN" : "LOSE" )+ " \t|\t " + bet.getWinning());
                    }
                }
                clearer();

                landingTexts();
                System.out.print("-> ");
            }
        };

        timer.schedule(results,ROUND_TIME,ROUND_TIME);

        landingTexts();

        takeBets();

    }


// Clears Bets, Generates Number for new game
    private void clearer() {
        bets.clear();
        randomNumber = genRandom();
    }
}
