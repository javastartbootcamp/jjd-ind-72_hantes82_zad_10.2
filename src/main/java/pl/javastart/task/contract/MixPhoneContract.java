package pl.javastart.task.contract;

public class MixPhoneContract extends CardPhoneContract {
    private int remainingSms;
    private int remainingMms;
    private int remainingSeconds;

    public MixPhoneContract(double accountBalance, double smsCost, double mmsCost, double callCostPerMinute,
                            int remainingSms, int remainingMms, int remainingSeconds) {
        super(accountBalance, smsCost, mmsCost, callCostPerMinute);
        this.remainingSms = remainingSms;
        this.remainingMms = remainingMms;
        this.remainingSeconds = remainingSeconds;
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
//Przy testowaniu wyszło mi że brakuje zerowania remaining seconds w tej wersji ktora zrobiles
//(kiedy zaplanowana ilosc sekund jest wieksza niz remainingSeconds)

    @Override
    public int makeCall(int seconds) {
        if (remainingSeconds > 0) {
            if (remainingSeconds >= seconds) {
                remainingSeconds -= seconds;
                usedCallSeconds += seconds;
                return seconds;
            } else {
                int secondsToChange = seconds - remainingSeconds;
                int secondsLeft = remainingSeconds;
                remainingSeconds = 0;
                return remainingSeconds + super.makeCall(secondsToChange);
            }
        }
        return super.makeCall(seconds);
    }

    @Override
    public String getContractInfo() {
        return "Umowa mix: Pozostałe SMSy: " + remainingSms + ", Pozostałe MMSy: " + remainingMms +
                ", Pozostałe sekundy: " + remainingSeconds + ", Stan konta: " + accountBalance + " zł";
    }
}
