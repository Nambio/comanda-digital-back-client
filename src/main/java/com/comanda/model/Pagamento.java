package com.comanda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagamento {
	
//    public String token;
//    public int installments;
//    public String transactionAmount;
//    public String description;
//    public String paymentMethodId;
//    public Payer payer;
//    public String notificationUrl;
//    public Object sponsorId;
//    public boolean binaryMode;
//    public String externalReference;
//    public String statementDescriptor;
//    public AdditionalInfo additionalInfo;
	
	public String email;
	public String docType;
	public String docNumber;
	public String issuer;
	public String installments;
	public String transactionAmount;
	public String paymentMethodId;
	public String description;
    public String token;
}
