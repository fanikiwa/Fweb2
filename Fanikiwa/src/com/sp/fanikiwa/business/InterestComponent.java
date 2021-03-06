package com.sp.fanikiwa.business;

public class InterestComponent {
	  // term is in years and rate is in doubles
    //Interest = Pricipal x rate x time
    /*
     * A = P(1 + rt); R = r * 100

Where:

A = Total Accrued Amount (principal + interest)
P = Principal Amount
I = Interest Amount
r = Rate of Interest per year in double; r = R/100
t = Time Period involved in months or years

From the base formula, A = P(1 + rt) derived from A = P + I and I = Prt so A = P + I = P + Prt = P(1 + rt)
     */
    public double ComputeSimpleInterest(double amount, int term, double rate) //Yearly
    {
        return ComputeSimpleInterest("Y", amount, term, rate);
    }
    public double ComputeSimpleInterest(String period, double amount, int term, double rate) 
    {
        if (period.toUpperCase().equals("D"))
            return amount * term * 30 * (rate / 100);

        if(period.toUpperCase().equals("D360"))
            return amount * (term * 30 / 360) * (rate / 100);

        if (period.toUpperCase().equals("D365"))
            return amount * (term * 30 / 365) * (rate / 100);

        if(period.toUpperCase().equals("M"))
            return amount * term * (rate / 100);
            
        //Yearly == defaulut
        double intr = amount * (term / 12) * (rate / 100);
        return intr;
    }


}

