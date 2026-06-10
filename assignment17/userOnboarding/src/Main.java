public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyTask();
        t.start();
        t.join();
    }
}

class MyTask extends Thread{
    public void run(){
        System.out.println("Hello from "+ Thread.currentThread().getName());
    }
}