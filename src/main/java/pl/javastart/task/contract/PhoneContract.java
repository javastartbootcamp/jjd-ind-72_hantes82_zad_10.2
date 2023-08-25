package pl.javastart.task.contract;

public abstract class PhoneContract {

    protected int sentSmsCount = 0;
    protected int sentMmsCount = 0;
    protected int usedCallSeconds = 0;

    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract int makeCall(int seconds);

    public abstract String getContractInfo();

    public String  getUsage() {
        return "=== STAN KONTA ===\n" + "Wysłanych SMSów: " + sentSmsCount + "\n" + "Wysłanych MMSów: " + sentMmsCount + "\n" + "Liczba sekund rozmowy: "
                + usedCallSeconds;

    }
}
