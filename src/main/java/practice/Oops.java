package practice;

import java.util.Comparator;

class Test
{
    // static variable
    int a = 10;
    int b;

    // static block
    static {
        System.out.println("Static block initialized.");
        //b = a * 4;
    }

    public static void main(String[] args)
    {
        System.out.println("from main");
        //System.out.println("Value of a : "+a);
        //System.out.println("Value of b : "+b);
    }
}

class GFG implements Comparable<Test>{

    static String str = "GeeksforGeeks";

    @Override
    public int compareTo(Test other) {
        return this.str.compareTo(String.valueOf(other.a));
    }

    // Static class
    static class MyNestedClass {

        // non-static method
        public void disp(){
            System.out.println(str);
        }
    }

    public static void main(String args[])
    {
        GFG.MyNestedClass obj
                = new GFG.MyNestedClass();
        obj.disp();
    }
}

class Calculator implements Comparator<Test> {

    public void add(String name){
        System.out.println("Name");
    }

    // Method with two int parameters
    public int add(int a, int b) {
        return a + b;
    }

    // Method with three int parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with two double parameters
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public int compare(Test o1, Test o2) {
        return Integer.compare(o1.a,o2.b);
    }
}

class Opps{
    public static void main(String[] args){

    }
}
class StockPriceCalculator{
    
    public void add(){
        System.out.println();
    }

    public void add(int i){
        System.out.println(i);
    }

    public static void main(String[] args)
    {
        StockPriceCalculator spc = new StockPriceCalculator();
        spc.add();
    }
}


class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
