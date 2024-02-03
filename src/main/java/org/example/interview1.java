package org.example;

public class interview1 {
    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        int[] b = {3, 6, 9};
        //c = {5, 9, 4}
        int[] d = summa(a,b);
        for (int i = 0; i < d.length; i++)
            System.out.println(d[i]);
    }



        private static int[] summa ( int[] a, int[] b){
            int[] c = new int[a.length+1];
        c[0] = (a[0] + b[0]) % 10;
        for (int i = 1; i < a.length; i++)
            c[i] = (a[i - 1] + b[i - 1]) / 10 + (a[i] + b[i]) % 10;
        c[a.length] = (a[a.length - 1] + b[a.length - 1]) / 10;
        return c;
    }


}
