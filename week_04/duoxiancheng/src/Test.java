import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
                 FutureTask futureTask = new FutureTask(new Callable(){
                     @Override
                     public Object call() throws Exception {
                         return sum();
                     }
                 });
                 Thread thread = new Thread(futureTask);
                 thread.start();
                 if(!futureTask.isDone())
                         System.out.println("task has not finished!");
                 System.out.println(futureTask.get());
             }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static void main1(String[] args) throws Exception {
                 //线程池
                 ExecutorService executorService = Executors.newCachedThreadPool();
                 Future future = executorService.submit(new Callable(){
                     @Override
                     public Object call() throws Exception {
                         return sum();
                     }
                 });
                 if(!future.isDone())
                        System.out.println("task has not finished!");
                 System.out.println(future.get());
             }
}
