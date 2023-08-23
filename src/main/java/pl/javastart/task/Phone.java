package pl.javastart.task;

class Phone {
    private PhoneContract contract;

    public Phone(PhoneContract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        contract.sendSms();
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void call(int seconds) {
        contract.makeCall(seconds);
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + contract.sentSmsCount);
        System.out.println("Wysłanych MMSów: " + contract.sentMmsCount);
        System.out.println("Liczba sekund rozmowy: " + contract.usedCallSeconds);
        System.out.println(contract.getContractInfo());
        System.out.println();
    }
}
