package pl.javastart.task.contract;

class AbonamentPhoneContract extends PhoneContract {
    private double monthlyFee;

    public AbonamentPhoneContract(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public boolean sendSms() {
        sentSmsCount++;
        return true;
        // No charges for SMS on abonament contract
    }

    @Override
    public boolean sendMms() {
        sentMmsCount++;
        return true;
        // No charges for MMS on abonament contract
    }

    @Override
    public int makeCall(int seconds) {
        usedCallSeconds += seconds;
        return seconds;
    }

    @Override
    public void applyMonthlyFee() {
        // Once per month, depends on option we have chosen :-)
    }

    @Override
    public String getContractInfo() {
        return "Umowa na abonament: Opłata miesięczna: " + monthlyFee + " zł";
    }
}
