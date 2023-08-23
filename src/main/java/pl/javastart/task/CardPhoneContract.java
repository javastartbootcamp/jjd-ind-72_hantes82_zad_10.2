package pl.javastart.task;

class CardPhoneContract extends PhoneContract {
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
    public void sendSms() {
        if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
            sentSmsCount++;
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void sendMms() {
        if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
            sentMmsCount++;
            System.out.println("MMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    public void makeCall(int seconds) {
        double callCost = seconds * (callCostPerMinute / 60);
        if (accountBalance == 0) {
            System.out.println("Nie udało się wykonać rozmowy - brak środków lub czasu rozmowy do wykorzystania");
        }
        if (accountBalance >= callCost) {
            accountBalance -= callCost;
            usedCallSeconds += seconds;
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else {
            double callTime = accountBalance / (callCostPerMinute / 60);
            System.out.println("Rozmowa trwała " + callTime + " sekund");
            usedCallSeconds += callTime;
            accountBalance = 0;
        }
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