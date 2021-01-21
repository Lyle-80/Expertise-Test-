package src;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dealer extends MPCRoulette{


    private static final byte MAX_NUMBER_TO_BET_ON = 36;
    private static final String BET_FORMAT_PATTERN = "^[a-zA-Z0-9_-]{3,} ([0-9]{1,2}|EVEN|ODD) [0-9.]+$";


    public Dealer(){
        super();
    }

    public static void processBet (String currentBet){
        Pattern p = Pattern.compile(BET_FORMAT_PATTERN);
        Matcher isMatch = p.matcher(currentBet);

        if (!isMatch.matches()) {
            takeBetMsgs("\n--- Please Place your bet in the format -> username chosen_number bet_amount ---\n");
        }

        String[] data = currentBet.split(" ");

        byte chosenNumber = 0;
        double betAmount = 0;
        String username = data[0];


        try{
            betAmount = Double.parseDouble(data[2]);
            chosenNumber = Byte.parseByte(data[1]);

        }catch (NumberFormatException e){


            // Straight Bet & String Scan Function
            String opt = data[1].toUpperCase();
            switch (opt){
                case "EVEN":
                case "ODD":

                    addBet( username, betAmount, opt);
                    break;
                default:
                    takeBetMsgs("++ Please choose a number between 1-36 or EVEN/ODD ++");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // New Bet (Straight)
        addBet( username, betAmount, chosenNumber);

    }

    // Number or Straight Bet Identifier
    private static void addBet(String username, double betAmount, byte chosenNumber){
        if((betAmount > 0) && (chosenNumber > 0 && chosenNumber <= MAX_NUMBER_TO_BET_ON )){

            int userIndex = userCheck(username, betAmount);

            boolean win = false;
            double winning = 0;

            if(chosenNumber == randomNumber){
                winning = betAmount * MAX_NUMBER_TO_BET_ON;
                win = true;
                users.get(userIndex).setTotalWins(users.get(userIndex).getTotalWins()+winning);
                try {
                    FilePath.saveUsersInfos(users);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            saveBet(new BetStraight(username,chosenNumber,betAmount,win,winning));


        } else {
            takeBetMsgs("++ Please choose a number between 1-36 or EVEN/ODD ++");
        }

    }

    // String Options
    private static void addBet(String username, double betAmount, String chosenOpt){

        int userIndex = userCheck(username,betAmount);

        boolean win = false;
        double winning = 0;

        switch (chosenOpt){
            case "EVEN":
                if(isEven()){
                    winning = betAmount * 2;
                    win = true;
                    users.get(userIndex).setTotalWins(users.get(userIndex).getTotalWins()+winning);
                    try {
                        FilePath.saveUsersInfos(users);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "ODD":
                if(!isEven()){
                    winning = betAmount * 2;
                    win = true;
                    users.get(userIndex).setTotalWins(users.get(userIndex).getTotalWins()+winning);
                    try {
                        FilePath.saveUsersInfos(users);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                takeBetMsgs("++ Please choose a number between 1-36 or EVEN/ODD ++");
                break;

        }


        // Saves bet for Numbered input
        saveBet(new BetType(username,chosenOpt,betAmount,win,winning));

    }

    //Scans Player.txt file for listed players
    private static int userCheck(String username, double betAmount){
        boolean found = false;
        int i = 0;
        while (!found && i < users.size()){
            if ((users.get(i).getUsername().equals(username))) {
                found = true;
            } else i++;
        }

        if(!found){
            takeBetMsgs("++User Not Found++");
        }

        users.get(i).setTotalBets(users.get(i).getTotalBets() + betAmount);

        users.get(i).getStatistics();
        return i;
    }

    // Appends bets to round list
    private static void saveBet(Bets newBet){

        bets.add(newBet);
        System.out.println("Bet saved!!!\n");

        takeBetMsgs("Place your bets\n" +
                "----------------");

    }

    //Checks if Number EVEN or ODD
    private static boolean isEven(){
        return randomNumber % 2 == 0;
    }

    // Message Generator & User Prompt
    private static void takeBetMsgs(String msg){
        System.out.println(msg);
        takeBets();
    }


}
