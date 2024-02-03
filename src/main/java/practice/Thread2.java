package practice;

public class Thread2 extends Thread{
    public void run(){
        System.out.println("This code is running in a thread");
    }

    public static void main(String[] args){
        // Creating thread object from our thread class
        Thread2 t1 = new Thread2();
        // Getting threads to run state from runnable.
        t1.start();
        System.out.println("This code is outside of thread");
    }
}
