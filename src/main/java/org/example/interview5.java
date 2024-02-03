package org.example;
//Find out the sub-array having the largest sum

//Eg : {-5, -3, 4, -2, 7, 5, -3}”
//Result: {4,-2,7,5}
//Eg 2 : {-5, -3, 1, -4, 5, 9, -3}”
//Result: { 5,9 }
public class interview5 {
    public static void main(String[] args) {
        //start -> positive number start
        //end -> positive number end
        int[] a = {-5, -3, 4, -2, 7, 5, -3};
        int len = a.length;
        int max_sum=0;
        int temp_sum=0;
        for(int i =0;i<len-1;i++) {
            {
                if (a[i] > 0) temp_sum = a[i];
                else temp_sum = 0;
            }
            for (int j = i + 1; i < len; i++) {
                if (temp_sum + a[j] > temp_sum) temp_sum = temp_sum + a[j];
                if (temp_sum > max_sum) max_sum = temp_sum;
            }
        }
        System.out.println(max_sum);
    }
}
