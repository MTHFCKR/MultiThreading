package theoretical_multithread.all;
/**
 * 1.Какие средства и техники можно применить для реализации асинхронного программирования в языке программирования
        с поддержкой многопоточности?
 *
 * 2.Какие технологии и библиотеки для параллельных и распределенных вычислений вы знаете,
 * и в каких сферах они наиболее полезны?
 *
 * 3.Какие средства мониторинга и профилирования многопоточных приложений вы используете для анализа
 * и оптимизации производительности?
 */
public class theoreticalTaskMultiThreading {

    /**
     * У вас есть простое приложение, которое создает несколько потоков для выполнения некоторой работы.
     * Однако оно не работает должным образом из-за проблем с синхронизацией. Ваша задача - поправить код так,
     * чтобы приложение работало корректно. Вам необходимо обеспечить правильную синхронизацию потоков.
     */

    public class MultithreadingExample {
        private static int sharedVariable = 0;

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

            System.out.println("Final sharedVariable value: " + sharedVariable);
        }

        static class Worker implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    sharedVariable++;
                }
            }
        }
    }











    /**
     * 1.Промисы и асинхронные функции: Используются для управления асинхронными задачами и обработки результатов.
     * Колбеки и обратные вызовы: Позволяют указать действия, выполняемые после завершения асинхронной операции.
     *
     * Генераторы и асинхронные ключевые слова: В некоторых языках, таких как Python, они упрощают
     * асинхронное программирование.
     *
     * Асинхронное программирование позволяет многим задачам выполняться параллельно, улучшая отзывчивость
     * и производительность приложения.
     *
     * 2.Пул потоков (Thread Pool): Пул потоков предварительно создает ограниченное количество потоков,
     * которые могут выполнять задачи в очереди. Это уменьшает накладные расходы на создание и уничтожение потоков.
     * Производитель-Потребитель (Producer-Consumer): Используется для организации совместного доступа к
     * ресурсам, где производители создают данные, а потребители их используют.
     *
     * Барьеры и семафоры: Используются для синхронизации потоков в критических секциях.
     *
     * Мьютексы и CAS (Compare-and-Swap): Для обеспечения безопасного доступа к общим данным.
     *
     * 3.OpenMP: Для параллельного программирования на многоядерных системах.
     *
     * MPI (Message Passing Interface): Для распределенных вычислений и обмена данными между узлами кластера.
     * Apache Hadoop и Spark: Для обработки и анализа больших данных в распределенной среде.
     *
     * CUDA и OpenCL: Для параллельных вычислений на графических процессорах (GPU).
     * Эти технологии полезны в вычислениях, которые можно распараллелить или распределить между узлами.
     *
     *
     * Задача.
     *
     * import java.util.concurrent.locks.Lock;
     * import java.util.concurrent.locks.ReentrantLock;
     *
     * public class MultithreadingExample {
     *     private static int sharedVariable = 0;
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
     *         System.out.println("Final sharedVariable value: " + sharedVariable);
     *     }
     *
     *     static class Worker implements Runnable {
     *         @Override
     *         public void run() {
     *             for (int i = 0; i < 10000; i++) {
     *                 lock.lock(); // Захватываем монитор
     *                 try {
     *                     sharedVariable++;
     *                 } finally {
     *                     lock.unlock(); // Освобождаем монитор в блоке finally, чтобы избежать блокировки
     *                 }
     *             }
     *         }
     *     }
     * }
     *
     *
     */
}
