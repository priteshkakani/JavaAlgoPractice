package oops;

class Bike{
        void run(){System.out.println("running");}
    }
    class Splendor extends Bike{
        void run(){System.out.println("running safely with 60km");}

       /* public static void main(String args[]){
            Bike b = new Splendor();//upcasting
            b.run();
        }*/
    }

class Bank{
    float getRateOfInterest(){return 0;}
}
class SBI extends Bank{
    float getRateOfInterest(){return 8.4f;}
}
class ICICI extends Bank{
    float getRateOfInterest(){return 7.3f;}
}
class AXIS extends Bank{
    float getRateOfInterest(){return 9.7f;}
}
class TestPolymorphism{
    public static void main(String args[]){
        Bank b;
        b=new SBI(); // Upcasting.
        System.out.println("SBI Rate of Interest: "+b.getRateOfInterest());
        b=new ICICI(); // Upcasting.
        System.out.println("ICICI Rate of Interest: "+b.getRateOfInterest());
        b=new AXIS(); // Upcasting.
        System.out.println("AXIS Rate of Interest: "+b.getRateOfInterest());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

// Runtime polymorphism can't be achieved by data members.
public class Bike1{
    int speedlimit=90;
}
class Honda3 extends Bike {
    int speedlimit = 150;

    public static void main(String args[]) {
        //Bike1 obj1 = new Honda3();
        //System.out.println(obj1.speedlimit);//90
    }
}


