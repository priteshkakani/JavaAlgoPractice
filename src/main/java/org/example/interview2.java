package org.example;

public class interview2 {
    public static void main(String[] args) {
    String a = "aaaabbbb";
    System.out.println(met());
    }

    private static int met (){
        try{
            return 1;
        }
        catch(Exception e){
            return 2;
        }
        finally{
            return 3;
        }
    }
}
