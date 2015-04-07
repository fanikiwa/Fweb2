package com.sp.fanikiwa.business.SMS;

import java.util.Date;


public class MpesaDepositMessage extends FanikiwaMessage
{
    public String CustomerTelno ;
    public Long AccountId ;
    public double Amount ;
    public String Mpesaref ;
    public Date SentDate ;
    public double Bal ;

    public MpesaDepositMessage()
    {

    }
    public MpesaDepositMessage(Long acc, double amount, String customerTelno)
    {
        this.Amount = amount;
        this.AccountId = acc;
        this.CustomerTelno = customerTelno;
    }
}






