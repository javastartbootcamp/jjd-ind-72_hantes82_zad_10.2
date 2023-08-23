package pl.javastart.task;

abstract class PhoneContract {

    protected int sentSmsCount = 0;
    protected int sentMmsCount = 0;
    protected int usedCallSeconds = 0;

    abstract void sendSms();

    abstract void sendMms();

    abstract void makeCall(int seconds);

    abstract void applyMonthlyFee();

    abstract String getContractInfo();

}
