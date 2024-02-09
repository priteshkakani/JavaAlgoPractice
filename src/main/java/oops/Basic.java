package oops;

public class Basic {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        Child child1 = new Parent();
        System.out.println(parent.salary);
        System.out.println(parent.ctc);
        System.out.println(child1.salary);

    }
}
