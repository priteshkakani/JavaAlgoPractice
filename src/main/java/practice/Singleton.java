package practice;

class Singleton1 {
    private static Singleton1 single_instance = null;
    public String s;
    private Singleton1(){
        s = "Hello I am string part of Singleton class";
    }
    public static synchronized Singleton1 getInstance(){
        if (single_instance == null)
            single_instance = new Singleton1();
        return single_instance;
    }
}

class Singleton{
    public static void main(String[] args){
        Singleton1 x = Singleton1.getInstance();
        Singleton1 y = Singleton1.getInstance();
        Singleton1 z = Singleton1.getInstance();
        System.out.println("Hashcode of x is "+x.hashCode());
        System.out.println("Hashcode of y is "+x.hashCode());
        System.out.println("Hashcode of z is "+x.hashCode());
        if(x == y && y==z) {
            System.out.println("3 objects  point to same location on heap");
        }
        else {
            System.out.println("3 objects do not point to same location on heap");
        }
    }
}

