package src;


import java.io.IOException;
import java.util.List;



public class Main {

    public static void main(String[] args) {


        @SuppressWarnings("rawtypes")
		List users = null;
        try {
            users = FilePath.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RoundInterface round = new RoundGenerator(users);
        round.run();


    }

}
