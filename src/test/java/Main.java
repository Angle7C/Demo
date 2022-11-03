import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.concurrent.*;

public class Main {
    private static final ThreadLocal<BlockingQueue<Runnable>> t=ThreadLocal.withInitial(()->new ArrayBlockingQueue<Runnable>(20));
    public static void main(String[] args) {
        Executor executor=new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,t.get());

    }
    static class MyRunable implements Runnable{
        String command;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"commend: "+command);
            processCommand();
            System.out.println(Thread.currentThread().getName()+"commend: "+command);

        }
        private void processCommand(){
            try{
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
@AllArgsConstructor
@ToString
sealed class  Item permits SubItem {
    public int score;
    public int rank;
}
