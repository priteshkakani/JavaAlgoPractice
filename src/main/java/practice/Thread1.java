package practice;

public class Thread1 implements Runnable{
    public static void main(String[] args){
        Thread1 obj = new Thread1();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This code is outside of thread Runnable");
    }
    public void run(){
        System.out.println("This code is running in a thread Runnable");
    }
}
