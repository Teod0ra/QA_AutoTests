import atmFunctions.ChoosingAmountScreen;
import atmFunctions.InputPinScreen;
import atmFunctions.PrintReceiptScreen;
import bankInformation.ClientAccount;
import bankInformation.ClientInfo;
import bankInformation.DebitCard;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsATM {

    ClientInfo clientInfo;
    DebitCard debitCard;
    InputPinScreen inputPinScreen = new InputPinScreen();
    ChoosingAmountScreen choosingAmountScreen = new ChoosingAmountScreen();
    ClientAccount clientAccount = new ClientAccount();
    PrintReceiptScreen printReceiptScreen = new PrintReceiptScreen();

    /*
    If Assertion return true, withdrawing money successfully proceeded.
     */

    @Test
    public void getAmountSmallerThanAmountAvailableAndInsertCorrectPinAndPrintReceipt(){
        Assert.assertTrue(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("2000")
                &&  printReceiptScreen.getUserInput("Y-Has paper"));
    }

    @Test
    public void getAmountBiggerThanAmountAvailableAndInsertCorrectPinAndPrintReceipt(){
        Assert.assertFalse(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("11000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
    }

    @Test
    public void getAmountSmallerThanAmountAvailableAndInsertWrongPinAndPrintReceipt(){
        inputPinScreen.tries = 0;
        Assert.assertFalse(inputPinScreen.getUserInput("1111") && choosingAmountScreen.getUserInput("4000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
        inputPinScreen.tries += 1;
        Assert.assertFalse(inputPinScreen.getUserInput("2222") && choosingAmountScreen.getUserInput("4000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
        inputPinScreen.tries += 1;
        Assert.assertFalse(inputPinScreen.getUserInput("3333") && choosingAmountScreen.getUserInput("4000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
        inputPinScreen.tries += 1;
        /*
        After MAX times wrong pin, If wrong pin inserted, money cannot be withdrawn
         */
        Assert.assertFalse(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("4000")
                && printReceiptScreen.getUserInput("Y-Has paper"));

    }

    @Test
    public void getAmountSmallerThanAmountAvailableAndBiggerThanDailyLimit(){
        Assert.assertFalse(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("80000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
    }

    @Test
    public void getAmountSmallerThanAmountAvailableAndDontPrintReceipt(){
        //Or printReceipt because withdrawing money should not depend on receipt printing
        Assert.assertTrue(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("3500")
                || printReceiptScreen.getUserInput("N"));
    }




}
