package theoretical_multithread.all;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.Что такое "InterruptedException" и в каких случаях он может возникнуть при работе
 * с потоками? Как правильно обрабатывать InterruptedException?
 *
 * 2.Какая разница между использованием ключевого слова synchronized и явным использованием объектов Lock,
 * таких как ReentrantLock?
 *
 * 3.*Какие основные практики и рекомендации следует учитывать при проектировании многопоточных приложений,
 * чтобы обеспечить безопасность и эффективность работы потоков?
 *
 * 4.Что такое монитор в контексте многопоточности и какие задачи он решает?
 */
public class theoreticalTaskLocksAndException {

    /**
     * У вас есть простое многопоточное приложение, которое использует объект ReentrantLock для синхронизации
     * доступа к общему ресурсу. Однако приложение не работает должным образом из-за проблем с блокировкой.
     * Ваша задача - поправить код так, чтобы приложение работало корректно. Вам необходимо обеспечить правильную
     * блокировку и разблокировку объекта Lock.
     */
    public class LockExample {
        private static int sharedResource = 0;
        private static Lock lock = new ReentrantLock();

        public static void main(String[] args) {
            int numThreads = 3;
            Thread[] threads = new Thread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                threads[i] = new Thread(new Worker());
                threads[i].start();
            }

            for (int i = 0; i < numThreads; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Final sharedResource value: " + sharedResource);
        }

        static class Worker implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lock.lock();
                    try {
                        sharedResource++;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }































    /**
     * 1. - это исключение, которое возникает в Java, когда поток был прерван другим потоком с использованием метода
     * interrupt(). Оно может возникнуть в различных случаях, например, при выполнении операций,
     * которые ожидают какого-то события (например, при вызове Object.wait(), Thread.sleep() или при блокировке монитора).
     * Это исключение обычно указывает на необходимость завершения работы потока, например, когда приложение должно быть
     * завершено или поток должен быть остановлен по запросу пользователя. Правильная обработка InterruptedException
     * обычно включает в себя очистку и завершение работы потока.
     *
     * 2.synchronized - это встроенная механизм синхронизации, который использует мониторы объектов. Это простой в
     * использовании, но менее гибкий способ.
     * Объекты Lock, такие как ReentrantLock, предоставляют более гибкий и детализированный контроль
     * над блокировкой и разблокировкой. Они позволяют устанавливать условия для ожидания, пытаться получить
     * блокировку с тайм-аутом и реагировать на неудачные попытки получить блокировку.
     *
     * 3.Избегайте гонок (race conditions) путем правильной синхронизации доступа к общим ресурсам.
     * Используйте высокоуровневые механизмы синхронизации, такие как java.util.concurrent, где это возможно.
     * Избегайте "Deadlock" с помощью хорошо продуманных порядков блокировки и избегания циклических зависимостей блокировок.
     * Планируйте потоки и избегайте избыточной конкуренции.
     * Используйте неизменяемые объекты там, где это возможно, чтобы уменьшить потребность в синхронизации.
     * Остерегайтесь "публичных" объектов блокировок, чтобы избежать нежелательного доступа.
     *
     * 4. это абстракция, предоставляемая Java, для обеспечения синхронизации и безопасности потоков при доступе
     * к общим ресурсам. Монитор позволяет одному потоку входить в "критическую секцию" кода (ограниченную блоком
     * synchronized или объектом Lock) и выполнять операции над общими данными, в то время как другие потоки ожидают,
     * пока монитор не будет освобожден. Задачи монитора включают в себя предотвращение гонок (race conditions) и
     * обеспечение атомарности операций.
     *
     *Задача.
     *
     * import java.util.concurrent.locks.Lock;
     * import java.util.concurrent.locks.ReentrantLock;
     *
     * public class LockExample {
     *     private static int sharedResource = 0;
     *     private static Lock lock = new ReentrantLock();
     *
     *     public static void main(String[] args) {
     *         int numThreads = 3;
     *         Thread[] threads = new Thread[numThreads];
     *
     *         for (int i = 0; i < numThreads; i++) {
     *             threads[i] = new Thread(new Worker());
     *             threads[i].start();
     *         }
     *
     *         for (int i = 0; i < numThreads; i++) {
     *             try {
     *                 threads[i].join();
     *             } catch (InterruptedException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *
     *         System.out.println("Final sharedResource value: " + sharedResource);
     *     }
     *
     *     static class Worker implements Runnable {
     *         @Override
     *         public void run() {
     *             for (int i = 0; i < 10000; i++) {
     *                 lock.lock();
     *                 try {
     *                     sharedResource++;
     *                 } finally {
     *                     lock.unlock();
     *                 }
     *             }
     *         }
     *     }
     * }
     *
     */
}
