package bankInformation;

import bankInformation.ClientInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DebitCard implements ClientInfo {

    private String cardPinNumber;
    private long cvvNumber;
    private String clientName;
    private Date expiryDate;
    private String issuerBank;
    private String cardType;
    private long cardSerialNumber;

}
