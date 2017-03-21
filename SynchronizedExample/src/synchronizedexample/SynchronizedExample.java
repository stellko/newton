package synchronizedexample;

public class SynchronizedExample implements Runnable {

//  Banken som man använder. 
    static Bank myBank;

    public static void main(String[] args) {

//	Skapar ett objekt av bank och kör igång två trådar, skall representera uttag två olika ställen samtidigt.
        myBank = new Bank();

        SynchronizedExample thread1 = new SynchronizedExample();
        SynchronizedExample thread2 = new SynchronizedExample();

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();

    }

    @Override
    public void run() {

//	Ta ut 7000 på två ställen samtidigt, samt kolla saldo efteråt.
        myBank.withdrawMoney(7000);
    }
}

/**
 * Banken, där det går att lägga in och ta ut pengar.
 */
class Bank {

    private int bankAccount = 10000;

    public void depositMoney(int deposit) {
        bankAccount += deposit;
    }

    //	Detta är inte en säker metod (för banken) om trådning används.
    //	Om det finns pengar så returneras true och dras från kontot, annars false.
    public void withdrawMoney(int withdraw) {

        System.out.println("Var god vänta..");

        if (bankAccount - withdraw >= 0) {
            // Tar lite tid att ta ut pengar.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            bankAccount -= withdraw;
            System.out.println("Det gick att ut " + withdraw + ":- du har nu " + bankAccount + ":- kvar på kontot.");
        } else {
            System.out.println("Du kunde ej ta ut " + withdraw + ":- du har bara " + bankAccount + ":- kvar på kontot.");
        }

    }
}
