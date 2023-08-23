package pl.javastart.task;

class MixPhoneContract extends PhoneContract {
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
    public void sendSms() {
        if (remainingSms > 0) {
            remainingSms--;
            sentSmsCount++;
        } else if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
            sentSmsCount++;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void sendMms() {
        if (remainingMms > 0) {
            remainingMms--;
            sentMmsCount++;
        } else if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
            sentMmsCount++;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void makeCall(int seconds) {
        //Sprawdzam czy remainingMinutes sa w stanie obsluzyc polaczenie, jesli tak to odejmuje sekundy od remainingMinutes
        if ((remainingMinutes / 60) >= seconds) {
            remainingMinutes = (remainingMinutes / 60) - seconds;
            usedCallSeconds += seconds;
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            //Sprawdzam czy w przypadku jak remaining minutes sa mniejsze niz wartosc seconds to czy w takiej sytuacji
            // accountState pozwala mi obsluzyc polaczenie
        } else if ((remainingMinutes / 60) < seconds && accountBalance >=
                (seconds - ((double) remainingMinutes / 60)) * (callCostPerMinute / 60)) {
            remainingMinutes = 0;
            accountBalance -= (seconds - ((double) remainingMinutes / 60) ) * (callCostPerMinute / 60);
            usedCallSeconds += seconds;
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            //w przypadku gdy remainingMinutes i accountState nie pozwalaja na pelna obsluge odejmuje wartosci
            // i pozwalam na polaczenie do czasu wyczerpania srodkow
        } else if (((remainingMinutes / 60) < seconds && accountBalance <
                (seconds - ((double) remainingMinutes / 60)) * (callCostPerMinute / 60))) {
            double callTime = accountBalance * (callCostPerMinute / 60)  + (remainingMinutes / 60);
            remainingMinutes = 0;
            accountBalance = 0;
            usedCallSeconds += callTime;
            System.out.println("Rozmowa trwała " + callTime + " sekund");
            //Ostatnia opcja - calkowity brak srodkow
        } else {
            System.out.println("Nie udało się wykonać rozmowy - brak środków lub czasu rozmowy do wykorzystania");
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
