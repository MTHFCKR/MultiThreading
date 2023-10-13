package practical_multithread.all;

/**
 *Задача:
 * Вам нужно создать многопоточное приложение, которое симулирует работу магазина с ограниченным количеством товаров
 * на складе. Магазин имеет несколько покупателей и ограниченное количество товаров. Ваша задача - реализовать
 * синхронизацию потоков для правильного учета и распределения товаров среди покупателей.
 *
 * Ваше решение должно включать в себя следующие элементы:
 *
 * Создание класса Store, который представляет магазин с ограниченным запасом товаров и методами для покупки и
 * добавления товаров.
 *
 * Создание класса Customer, представляющего покупателя, который будет пытаться купить товар в магазине.
 *
 * Использование объектов Lock для синхронизации доступа к ресурсам (товарам) и учета остатка товаров.
 *
 * Обеспечение безопасной работы потоков и правильной синхронизации при совместном доступе к магазину.
 */
public class practicalTaskLocksAndException {





































    /**
     *import java.util.concurrent.locks.Lock;
     * import java.util.concurrent.locks.ReentrantLock;
     *
     * public class StoreSimulation {
     *     public static void main(String[] args) {
     *         Store store = new Store(10); // Магазин с 10 товарами
     *
     *         // Создание нескольких покупателей
     *         Customer customer1 = new Customer("Customer 1", store);
     *         Customer customer2 = new Customer("Customer 2", store);
     *         Customer customer3 = new Customer("Customer 3", store);
     *
     *         // Запуск потоков-покупателей
     *         customer1.start();
     *         customer2.start();
     *         customer3.start();
     *
     *         try {
     *             customer1.join();
     *             customer2.join();
     *             customer3.join();
     *         } catch (InterruptedException e) {
     *             e.printStackTrace();
     *         }
     *     }
     * }
     *
     * class Store {
     *     private int stock;
     *     private Lock lock = new ReentrantLock();
     *
     *     public Store(int initialStock) {
     *         stock = initialStock;
     *     }
     *
     *     public void buy(String customerName, int quantity) {
     *         lock.lock();
     *         try {
     *             if (stock >= quantity) {
     *                 System.out.println(customerName + " bought " + quantity + " items.");
     *                 stock -= quantity;
     *             } else {
     *                 System.out.println(customerName + " couldn't buy " + quantity + " items.");
     *             }
     *         } finally {
     *             lock.unlock();
     *         }
     *     }
     *
     *     public void restock(int quantity) {
     *         lock.lock();
     *         try {
     *             System.out.println("Restocking " + quantity + " items.");
     *             stock += quantity;
     *         } finally {
     *             lock.unlock();
     *         }
     *     }
     * }
     *
     * class Customer extends Thread {
     *     private Store store;
     *
     *     public Customer(String name, Store store) {
     *         super(name);
     *         this.store = store;
     *     }
     *
     *     @Override
     *     public void run() {
     *         for (int i = 0; i < 3; i++) {
     *             int quantityToBuy = (int) (Math.random() * 4) + 1;
     *             store.buy(getName(), quantityToBuy);
     *             try {
     *                 sleep(100); // Покупатель ждет некоторое время перед следующей покупкой
     *             } catch (InterruptedException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *     }
     * }
     */
}
