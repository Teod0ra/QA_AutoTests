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
        Assert.assertFalse(inputPinScreen.getUserInput("1233") && choosingAmountScreen.getUserInput("4000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
    }


    @Test
    public void getAmountSmallerThanAmountAvailableAndBiggerThanDailyLimit(){
        Assert.assertFalse(inputPinScreen.getUserInput("1234") && choosingAmountScreen.getUserInput("80000")
                && printReceiptScreen.getUserInput("Y-Has paper"));
    }




}
