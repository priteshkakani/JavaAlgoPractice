package practice;

class FunctionalInterface1 {
    public static void main(String[] args){

        // create anonymous inner class object
        new Thread(() -> {
           System.out.println("New Thread Created");
        }).start();
    }
}
