package concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleThreadPool {

    private ConcurrentLinkedQueue<Runnable> tasks = new ConcurrentLinkedQueue<>();

    private List<Mythread> mythreads = new LinkedList<>();

    public SimpleThreadPool(int threadNum) {
        for(int i = 0; i < threadNum; ++i){
            mythreads.add(new Mythread());
        }
        for (Mythread mythread : mythreads) {
            mythread.start();
        }
    }

    public void execute(Runnable runnable) {
        tasks.add(runnable);
    }

    class Mythread extends Thread {

        private Runnable task;

        public Mythread(Runnable runnable) {
            this.task = runnable;
        }

        public Mythread() {

        }

        @Override
        public void run() {
            while(true) {
                if(task != null) {
                    task.run();
                    task = null;
                } else{
                    task = tasks.poll();
                }
            }
        }

    }

    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(4);
        for(int i = 0; i < 7; ++i) {
            simpleThreadPool.execute(()->{
                System.out.println("i am task NO.");
            });
        }
    }
}
