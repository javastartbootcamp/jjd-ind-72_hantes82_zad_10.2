package pl.javastart.task;

class Phone {
    private PhoneContract contract;
    private int sentSmsCount;
    private int sentMmsCount;
    private int usedCallMinutes;

    public Phone(PhoneContract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        if (contract.canSendSms()) {
            contract.applySmsCharge();
            sentSmsCount++;
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    public void sendMms() {
        if (contract.canSendMms()) {
            contract.applyMmsCharge();
            sentMmsCount++;
            System.out.println("MMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    public void call(int seconds) {
        if (contract.canMakeCall(seconds)) {
            contract.applyCallCharge(seconds);
            usedCallMinutes += seconds / 60;
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else {
            System.out.println("Nie udało się wykonać rozmowy - brak środków lub minuty");
        }
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + sentSmsCount);
        System.out.println("Wysłanych MMSów: " + sentMmsCount);
        System.out.println("Liczba sekund rozmowy: " + usedCallMinutes * 60);
        System.out.println(contract.getContractInfo());
        System.out.println();
    }
}
