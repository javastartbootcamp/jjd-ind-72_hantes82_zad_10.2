package pl.javastart.task;

class AbonamentPhoneContract extends PhoneContract {
    private double monthlyFee;

    public AbonamentPhoneContract(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void sendSms() {
        sentSmsCount++;
        System.out.println("SMS wysłany");
        // No charges for SMS on abonament contract
    }

    @Override
    public void sendMms() {
        sentMmsCount++;
        System.out.println("MMS wysłany");
        // No charges for MMS on abonament contract
    }

    @Override
    public void makeCall(int seconds) {
        usedCallSeconds += seconds;
        System.out.println("Rozmowa trwała " + seconds + " sekund");
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
