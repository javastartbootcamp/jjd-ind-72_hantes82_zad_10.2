package pl.javastart.task;

import pl.javastart.task.contract.PhoneContract;

class Phone {
    private PhoneContract contract;

    public Phone(PhoneContract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        if (contract.sendSms()) {
            System.out.println("SMS wysłany");
        } else {
            System.out.println("SMS wysłany");
        }
    }

    public void sendMms() {
        if (contract.sendMms()) {
            System.out.println("MMS wysłany");
        } else {
            System.out.println("MMS wysłany");
        }
    }

    public void call(int seconds) {
        if (contract.makeCall(seconds) == seconds) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else if (contract.makeCall(seconds) == 0) {
            System.out.println("Nie udało się wykonać rozmowy - brak środków lub czasu rozmowy do wykorzystania");
        } else {
            System.out.println("Rozmowa trwała " + contract.makeCall(seconds) + " sekund");
        }
    }

    public void printAccountState() {
        contract.getUsage();
        System.out.println(contract.getContractInfo());
        System.out.println();
    }
}
