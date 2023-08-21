package pl.javastart.task;

class MixPhoneContract implements PhoneContract {
    private int remainingSms;
    private int remainingMms;
    private int remainingMinutes;
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double callCostPerMinute;

    public MixPhoneContract(int smsCount, int mmsCount, int minutes, double accountBalance, double smsCost, double mmsCost, double callCostPerMinute) {
        this.remainingSms = smsCount;
        this.remainingMms = mmsCount;
        this.remainingMinutes = minutes;
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCostPerMinute = callCostPerMinute;
    }

    @Override
    public boolean canSendSms() {
        return remainingSms > 0 || accountBalance >= smsCost;
    }

    @Override
    public boolean canSendMms() {
        return remainingMms > 0 || accountBalance >= mmsCost;
    }

    @Override
    public boolean canMakeCall(int seconds) {
        return remainingMinutes > 0 || accountBalance >= (seconds * (callCostPerMinute / 60));
    }

    @Override
    public void applySmsCharge() {
        if (remainingSms > 0) {
            remainingSms--;
        } else {
            accountBalance -= smsCost;
        }
    }

    @Override
    public void applyMmsCharge() {
        if (remainingMms > 0) {
            remainingMms--;
        } else {
            accountBalance -= mmsCost;
        }
    }

    @Override
    public void applyCallCharge(int seconds) {
        if (remainingMinutes > 0) {
            remainingMinutes--;
        } else {
            double callCost = seconds * (callCostPerMinute / 60);
            accountBalance -= callCost;
        }
    }

    @Override
    public void applyMonthlyFee() {
        // No monthly fee for mix contracts
    }

    @Override
    public String getContractInfo() {
        return "Umowa mix: Pozostałe SMSy: " + remainingSms + ", Pozostałe MMSy: " + remainingMms +
                ", Pozostałe minuty: " + remainingMinutes + ", Stan konta: " + accountBalance + " zł";
    }
}
