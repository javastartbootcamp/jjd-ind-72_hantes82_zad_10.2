package pl.javastart.task.contract;

public class CardPhoneContract extends PhoneContract {
    protected double accountBalance;
    protected double smsCost;
    protected double mmsCost;
    protected double callCostPerMinute;

    public CardPhoneContract(double accountBalance, double smsCost, double mmsCost, double callCostPerMinute) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCostPerMinute = callCostPerMinute;
    }

    @Override
    public boolean sendSms() {
        if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
            sentSmsCount++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMms() {
        if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
            sentMmsCount++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int makeCall(int seconds) {
        double callCost = seconds * (callCostPerMinute / 60);
        if (accountBalance == 0) {
            return 0;
        }
        if (accountBalance >= callCost) {
            accountBalance -= callCost;
            usedCallSeconds += seconds;
            return seconds;
        } else {
            double callTime = accountBalance / (callCostPerMinute / 60);
            usedCallSeconds += callTime;
            accountBalance = 0;
            return (int) callTime;
        }
    }

    @Override
    public String getContractInfo() {
        return "Umowa na kartę: Stan konta: " + accountBalance + " zł";
    }
}