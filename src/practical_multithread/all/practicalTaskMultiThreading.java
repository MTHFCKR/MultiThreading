package practical_multithread.all;
/**
 *Задача:
 * Вы должны создать многопоточную программу на Java, которая имитирует работу банка с
 * несколькими клиентами и банковскими счетами. У банка есть несколько счетов, и клиенты могут
 * выполнять операции по снятию и пополнению средств на счетах. Операции клиентов могут происходить параллельно,
 * и банк должен обеспечить безопасность доступа к счетам.
 *
 * Ваше решение должно включать в себя следующие элементы:
 *
 * Создание класса Bank с методами для пополнения (deposit) и снятия (withdraw) средств со счетов.
 *
 * Создание класса Account, представляющего банковский счет, с уникальным идентификатором и текущим балансом.
 *
 * Создание нескольких потоков-клиентов, которые выполняют операции пополнения и снятия средств.
 *
 * Обеспечение синхронизации доступа к счетам для избежания гонок и недопустимых состояний.
 */
public class practicalTaskMultiThreading {


































    /**
     *import java.util.concurrent.locks.Lock;
     * import java.util.concurrent.locks.ReentrantLock;
     *
     * public class BankSimulation {
     *     public static void main(String[] args) {
     *         Bank bank = new Bank();
     *
     *         // Создаем банковские счета
     *         Account account1 = new Account(1, 1000);
     *         Account account2 = new Account(2, 2000);
     *
     *         // Создаем потоки-клиентов
     *         Thread client1 = new Thread(new Client(bank, account1, account2));
     *         Thread client2 = new Thread(new Client(bank, account2, account1));
     *
     *         // Запускаем потоки-клиентов
     *         client1.start();
     *         client2.start();
     *
     *         try {
     *             client1.join();
     *             client2.join();
     *         } catch (InterruptedException e) {
     *             e.printStackTrace();
     *         }
     *
     *         System.out.println("Final balances:");
     *         System.out.println("Account 1: " + account1.getBalance());
     *         System.out.println("Account 2: " + account2.getBalance());
     *     }
     * }
     *
     * class Bank {
     *     private Lock lock = new ReentrantLock();
     *
     *     public void deposit(Account account, int amount) {
     *         lock.lock();
     *         try {
     *             account.deposit(amount);
     *         } finally {
     *             lock.unlock();
     *         }
     *     }
     *
     *     public void withdraw(Account account, int amount) {
     *         lock.lock();
     *         try {
     *             account.withdraw(amount);
     *         } finally {
     *             lock.unlock();
     *         }
     *     }
     * }
     *
     * class Account {
     *     private int id;
     *     private int balance;
     *
     *     public Account(int id, int balance) {
     *         this.id = id;
     *         this.balance = balance;
     *     }
     *
     *     public int getBalance() {
     *         return balance;
     *     }
     *
     *     public void deposit(int amount) {
     *         balance += amount;
     *     }
     *
     *     public void withdraw(int amount) {
     *         if (balance >= amount) {
     *             balance -= amount;
     *         }
     *     }
     * }
     *
     * class Client implements Runnable {
     *     private Bank bank;
     *     private Account fromAccount;
     *     private Account toAccount;
     *
     *     public Client(Bank bank, Account fromAccount, Account toAccount) {
     *         this.bank = bank;
     *         this.fromAccount = fromAccount;
     *         this.toAccount = toAccount;
     *     }
     *
     *     @Override
     *     public void run() {
     *         for (int i = 0; i < 100; i++) {
     *             int amount = (int) (Math.random() * 100);
     *             bank.withdraw(fromAccount, amount);
     *             bank.deposit(toAccount, amount);
     *         }
     *     }
     * }
     */
}
