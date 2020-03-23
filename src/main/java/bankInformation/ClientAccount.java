package bankInformation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientAccount implements ClientInfo {

    private long amountAvailable;
    private long dailyLimit;
    private String clientName;
    private String cardPinNumber;

}
