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
        int callTime = contract.makeCall(seconds);
        if (callTime != 0) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else {
            System.out.println("Rozmowa trwała " + callTime + " sekund");
        }
    }

    public void printAccountState() {
        contract.getUsage();
        System.out.println(contract.getContractInfo());
        System.out.println();
    }
}
