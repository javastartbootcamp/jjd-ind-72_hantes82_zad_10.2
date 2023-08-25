package pl.javastart.task.contract;

class MixPhoneContract extends CardPhoneContract {
    private int remainingSms;
    private int remainingMms;
    private int remainingSeconds;
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double callCostPerMinute;

    public MixPhoneContract(double accountBalance, double smsCost, double mmsCost,
                            double callCostPerMinute, int remainingSms, int remainingMms,
                            int remainingMinutes, double accountBalance1, double smsCost1, double mmsCost1,
                            double callCostPerMinute1) {
        super(accountBalance, smsCost, mmsCost, callCostPerMinute);
        this.remainingSms = remainingSms;
        this.remainingMms = remainingMms;
        this.remainingSeconds = remainingMinutes / 60;
        this.accountBalance = accountBalance1;
        this.smsCost = smsCost1;
        this.mmsCost = mmsCost1;
        this.callCostPerMinute = callCostPerMinute1;
    }

    @Override
    public boolean sendSms() {
        if (remainingSms > 0) {
            remainingSms--;
            sentSmsCount++;
            return true;
        } else {
            return super.sendSms();
        }

    }

    @Override
    public boolean sendMms() {
        if (remainingMms > 0) {
            remainingMms--;
            sentMmsCount++;
            return true;
        } else {
            return super.sendMms();
        }
    }

    @Override
    public int makeCall(int seconds) {
        //Sprawdzam czy remainingMinutes sa w stanie obsluzyc polaczenie, jesli tak to odejmuje sekundy od remainingMinutes
        if ((remainingSeconds) >= seconds) {
            remainingSeconds -= seconds;
            usedCallSeconds += seconds;
            return seconds;
            //Sprawdzam czy w przypadku jak remaining minutes sa mniejsze niz wartosc seconds to czy w takiej sytuacji
            // accountState pozwala mi obsluzyc polaczenie
        } else if ((remainingSeconds) < seconds && accountBalance >=
                (seconds - (remainingSeconds) * (callCostPerMinute / 60))) {
            remainingSeconds = 0;
            accountBalance -= (seconds - remainingSeconds) * (callCostPerMinute / 60);
            usedCallSeconds += seconds;
            return seconds;
            //w przypadku gdy remainingMinutes i accountState nie pozwalaja na pelna obsluge odejmuje wartosci
            // i pozwalam na polaczenie do czasu wyczerpania srodkow
        } else if (remainingSeconds < seconds && accountBalance <
                (seconds - (remainingSeconds) * (callCostPerMinute / 60))) {
            double callTime = accountBalance * (callCostPerMinute / 60)  + remainingSeconds;
            remainingSeconds = 0;
            accountBalance = 0;
            usedCallSeconds += callTime;
            return (int) callTime;
            //Ostatnia opcja - calkowity brak srodkow
        } else {
            return 0;
        }

    }

    @Override
    public void applyMonthlyFee() {
        // No monthly fee for mix contracts
    }

    @Override
    public String getContractInfo() {
        return "Umowa mix: Pozostałe SMSy: " + remainingSms + ", Pozostałe MMSy: " + remainingMms +
                ", Pozostałe sekundy: " + remainingSeconds + ", Stan konta: " + accountBalance + " zł";
    }
}
