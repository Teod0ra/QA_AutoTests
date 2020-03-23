package atmFunctions;

import bankInformation.DebitCard;

public class InputCardScreen implements UserInput{

    DebitCard debitCard;
    @Override
    public boolean getUserInput(String card) {
     return true;
    }
}
