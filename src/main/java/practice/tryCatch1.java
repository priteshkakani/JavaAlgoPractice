package practice;

/*public class tryCatch1 {
    public static void main(String[] args){
       int ret = value();
       System.out.println("Returned value : "+ret);
    }

    public static int value() {
        try {
            System.out.println("");
            System.out.println(34 / 0);
            return 1;
        } catch (ArithmeticException e) {
            System.out.println("catch");
            return 2;
        }
        finally {
            System.out.println("finally");
            return 3;
        }
    }
}*/

/*
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class FinalVariable {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");
        try(fileStream){
            String greeting = "Welcome to javaTpoint.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}*/
