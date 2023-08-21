package pl.javastart.task;

class AbonamentPhoneContract implements PhoneContract {
    private double monthlyFee;

    public AbonamentPhoneContract(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public boolean canSendSms() {
        return true;
    }

    @Override
    public boolean canSendMms() {
        return true;
    }

    @Override
    public boolean canMakeCall(int seconds) {
        return true;
    }

    @Override
    public void applySmsCharge() {
        // No charges for SMS on abonament contract
    }

    @Override
    public void applyMmsCharge() {
        // No charges for MMS on abonament contract
    }

    @Override
    public void applyCallCharge(int seconds) {
        // No charges for calls on abonament contract
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
