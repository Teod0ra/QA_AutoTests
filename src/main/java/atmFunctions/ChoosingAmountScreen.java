package atmFunctions;


import bankInformation.ClientAccount;

public class ChoosingAmountScreen implements UserInput{

    ClientAccount clientAccount;

    @Override
    public boolean getUserInput(String amount) {
        clientAccount = new ClientAccount();
        clientAccount.setAmountAvailable(10000);
        clientAccount.setDailyLimit(60000);

        System.out.println("current amount available = " + clientAccount.getAmountAvailable());
        long amountInserted = Long.parseLong(amount);
        long amountAvailable = clientAccount.getAmountAvailable();

        if(amountInserted < clientAccount.getDailyLimit() && amountInserted <= clientAccount.getAmountAvailable()){
            clientAccount.setAmountAvailable(amountAvailable - amountInserted);
        }

        System.out.println("current amount available = " + clientAccount.getAmountAvailable());
        return amountInserted < clientAccount.getDailyLimit() && amountInserted <= clientAccount.getAmountAvailable();
    }
}
