class Dividend{
    private FinanceOfficer finOfficer;  //to get dividend
    private double rate;
    private double divAmount;

    public double getRate(){
        rate = finOfficer.getDiv();
        return rate;
    }

    public double calcDivAmount(BankAccount bankAccount){
        divAmount = bankAccount.balance*rate;
        return divAmount;
    }
    
}