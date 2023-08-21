package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new CardPhoneContract(0.2, 0.1, 0.2, 0.5));

        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();
    }
}
