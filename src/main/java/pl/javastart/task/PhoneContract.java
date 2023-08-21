package pl.javastart.task;

interface PhoneContract {
    boolean canSendSms();

    boolean canSendMms();

    boolean canMakeCall(int seconds);

    void applySmsCharge();

    void applyMmsCharge();

    void applyCallCharge(int seconds);

    void applyMonthlyFee();

    String getContractInfo();
}
