class Dividend{
    private double divAmount;

    // Calculate dividend without needing FinanceOfficer
    public double calcDivAmount(double balance, double divRate) {
        this.divAmount = balance * divRate;
        return divAmount;
    }
    
}