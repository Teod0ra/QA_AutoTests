package atmFunctions;

import bankInformation.ClientAccount;

public class InputPinScreen implements UserInput{

    private static final int MAX_PIN_ATTEMPTS=2;

    ClientAccount clientAccount;
    @Override
    public boolean getUserInput(String pin) {
        clientAccount = new ClientAccount();
        clientAccount.setCardPinNumber("1234");

        int tries = 0;
        boolean correctPin = pin.equals(clientAccount.getCardPinNumber());
        while(!correctPin && tries <= MAX_PIN_ATTEMPTS){
            System.out.println("Wrong pin");
            if(tries == MAX_PIN_ATTEMPTS){
                return false;
            }
            tries++;
        }
        return true;

    }

}
