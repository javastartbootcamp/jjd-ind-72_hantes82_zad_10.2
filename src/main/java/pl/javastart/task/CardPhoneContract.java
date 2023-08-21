package pl.javastart.task;

class CardPhoneContract implements PhoneContract {
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double callCostPerMinute;

    public CardPhoneContract(double accountBalance, double smsCost, double mmsCost, double callCostPerMinute) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCostPerMinute = callCostPerMinute;
    }

    @Override
    public boolean canSendSms() {
        return accountBalance >= smsCost;
    }

    @Override
    public boolean canSendMms() {
        return accountBalance >= mmsCost;
    }

    @Override
    public boolean canMakeCall(int seconds) {
        double callCost = seconds * (callCostPerMinute / 60);
        return accountBalance >= callCost;
    }

    @Override
    public void applySmsCharge() {
        accountBalance -= smsCost;
    }

    @Override
    public void applyMmsCharge() {
        accountBalance -= mmsCost;
    }

    @Override
    public void applyCallCharge(int seconds) {
        double callCost = seconds * (callCostPerMinute / 60);
        accountBalance -= callCost;
    }

    @Override
    public void applyMonthlyFee() {
        // There is no monthly fee for card contracts
    }

    @Override
    public String getContractInfo() {
        return "Umowa na kartę: Stan konta: " + accountBalance + " zł";
    }
}