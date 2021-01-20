package src;

public class BetType extends Bets{

    private String chosenOption;

    public BetType(){
        super();
    }


    public BetType(String username, String chosenOption, double betAmount, boolean win, double winning){
        super(username,betAmount,win,winning);
        this.chosenOption = chosenOption;

    }


    public String getChosenOption() {
        return chosenOption;
    }

    @Override
    public String toString() {
        return "BetOpts{" +
                "chosenOption='" + chosenOption + '\'' +
                '}';
    }
}
