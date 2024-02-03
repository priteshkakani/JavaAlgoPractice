package practice;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo extends Thread{

    static HashMap<Integer,String> hm = new HashMap<Integer,String>();

    public void run(){
        hm.put(103,"D");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println("Child Thread going to add element");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        hm.put(100,"A");
        hm.put(200,"B");
        hm.put(300,"C");
        HashMapDemo t = new HashMapDemo();
        t.start();

        for(Object o : hm.entrySet())
        {
            Object s = o;
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(hm);

    }

}
