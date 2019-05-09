import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class Java8Concurrent {
    public static void main(String[] args) throws Exception{
        // sleepTest();
        // executorsPractice();
        // callablePractice();
        // invokeAllTest();
        // scheduleTest();
        // readWriteLockPractice();
        // StampedLockPractice1();
    }

    private static void sleepTest() {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo: " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar: " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    // Executors必须显式的停止-否则它们将持续监听新的任务
    private static void executorsPractice() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        // 关闭executor
        try {
            System.out.println("attempt to shutdown executor");
            // shutdwon()会等待正在执行的任务执行完
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            // shutdownNow()会终止所有正在执行的任务并立即关闭execuotr
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    private static void callablePractice() {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());
        Integer result = 0;
        // 如果关闭executor，所有的未中止的future都会抛出异常
        // executor.shutdownNow();
        try {
            result = future.get(8, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
    }

    /**
     * Executors支持通过invokeAll()一次批量提交多个callable。这个方法结果一个callable的集合，然后返回一个future的列表。
     */
    private static void invokeAllTest() throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

        executor.invokeAll(callables).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }).forEach(System.out::println);
    }

    private static void scheduleTest() throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
                System.out.println("Scheduling thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        Runnable task2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling2: " + System.nanoTime());
                System.out.println("Scheduling2 thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(task2, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * ReadWriteLock接口规定了锁的另一种类型，包含用于读写访问的一对锁。
     * 读写锁的理念是，只要没有任何线程写入变量，并发读取可变变量通常是安全的。
     * 所以读锁可以同时被多个线程持有，只要没有线程持有写锁。这样可以提升性能和吞吐量，因为读取比写入更加频繁。
     * 
     * 当你执行这一代码示例时，你会注意到两个读任务需要等待写任务完成。
     * 在释放了写锁之后，两个读任务会同时执行，并同时打印结果。
     */
    private static void readWriteLockPractice() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                sleep(1);
            } finally {
                lock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }

    /**
     * StampedLock，它同样支持读写锁，
     * 就像上面的例子那样。与ReadWriteLock不同的是，StampedLock的锁方法会返回表示为long的标记。
     * 你可以使用这些标记来释放锁，或者检查锁是否有效。此外，StampedLock支持另一种叫做乐观锁（optimistic
     * locking）的模式。
     */
    private static void StampedLockPractice1() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(1);
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }


    private static void StampedLockPractice2() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            // 乐观的读锁通过调用tryOptimisticRead()获取，它总是返回一个标记而不阻塞当前线程，无论锁是否真正可用
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });

        stop(executor);
    }



    private static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}