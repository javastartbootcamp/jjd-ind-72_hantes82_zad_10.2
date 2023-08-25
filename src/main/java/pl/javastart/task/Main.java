package pl.javastart.task;

import pl.javastart.task.contract.CardPhoneContract;
import pl.javastart.task.contract.MixPhoneContract;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixPhoneContract(5, .5, .5, 1, 5, 5, 0));

        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.call(60);
        phone.printAccountState();

      }
}


