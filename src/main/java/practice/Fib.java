package practice;

public class Fib {
    public static int getNthFib(int n) {
        // Write your code here.
        if(n==1) getNthFib(1);
        if(n==0) getNthFib(0);
        while(n>1)
            return getNthFib(n-1)+getNthFib(n-2);
        return -1;
    }

    public static void main(String args[]){
        System.out.println(5);
    }
}
