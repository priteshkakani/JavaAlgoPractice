package practice;

public class Lambda1 {
    interface StringFunction {
        String run(String str);
    }

    interface Sayable{
        public String say();
    }

    interface Addable{
        int add(int a,int b);
    }

    public class Main {
        public static void main(String[] args) {
            StringFunction exclaim = (s) -> s + "!";
            StringFunction ask = (s) -> s + "?";
            printFormatted("Hello", exclaim);
            printFormatted("Hello", ask);
            Sayable s = () -> {
                return "I have nothing to say";
            };
            System.out.println(s.say());
        }

        public static void printFormatted(String str, StringFunction format) {
            String result = format.run(str);
            System.out.println(result);
        }
    }
}
