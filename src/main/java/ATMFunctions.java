public class ATMFunctions {

    ClientAccount clientAccount = new ClientAccount();
    DebitCard debitCard = new DebitCard();

    public boolean getUserInput(String pin){
        return pin.equals(clientAccount.getCardPinNumber());
    }

    public DebitCard getCardInfo(){
    return new DebitCard();
    }

    public ClientAccount getAccountData(){
    return new ClientAccount();
    }
}
