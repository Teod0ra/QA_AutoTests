package atmFunctions;


import java.util.Random;

public class PrintReceiptScreen implements UserInput{

    @Override
    public boolean getUserInput(String input) {
        Random random = new Random();
        boolean hasPaper = input.equals("Y-Has paper");
        if(!hasPaper){
            System.out.println("no paper for printing receipt!");
        }
        return input.equals("Y-Has paper") && hasPaper;
    }
}
