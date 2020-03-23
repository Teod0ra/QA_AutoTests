package atmFunctions;

import bankInformation.ClientAccount;

public class InputPinScreen implements UserInput{

    private static final int MAX_PIN_ATTEMPTS = 3;
    public int tries = 0;

    ClientAccount clientAccount;
    @Override
    public boolean getUserInput(String pin) {
        clientAccount = new ClientAccount();
        clientAccount.setCardPinNumber("1234");

        if(tries == MAX_PIN_ATTEMPTS){
            System.out.println("Max pin attempts");
            return false;
        }
        boolean correctPin = pin.equals(clientAccount.getCardPinNumber());
        if(!correctPin && tries < MAX_PIN_ATTEMPTS){
            System.out.println("Wrong pin");
            if(tries == MAX_PIN_ATTEMPTS){
                System.out.println("Max pin attempts");
                return false;
            }
           return false;
        }
        return true;

    }

}
