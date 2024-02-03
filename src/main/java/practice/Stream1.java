package practice;

import java.util.*;
import java.util.stream.*;

//Count frequency of each element in the array
//int arr[] = {10,5,10,15,10,5};

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Stream1 {
    public static void main(String[] args){
        // making the array list object
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("mango");
        fruit.add("pineapple");
        fruit.add("kiwi");
        System.out.println("List of fruit-" + fruit);
        //use map() to convert into list of fruits
       /* List list = fruit.stream().map(s->s.length()).collect(Collectors.toList());
        System.out.println("List generated by map : "+list);*/

        // making the arraylist object of List of Integer
       /* List<List<Integer> > number = new ArrayList<>();

        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);
        List<Integer> flatList = number.stream().flatMap(list1 -> list1.stream())
                .collect(Collectors.toList());
        System.out.println("List generated by flatMap-"+flatList);*/

       /* String[] arr = {"Geeks","for","Geeks"};
        Stream<String> stm = Arrays.stream(arr);
        stm.forEach(str -> System.out.println(str + " "));
        */
        int arr1[] = {1,2,3,4,5};
        /*
        IntStream stm1 = Arrays.stream(arr1);
        stm1.forEach(a->System.out.println(a + " "));

        double[] dou = {1,2,3,4,5};
        DoubleStream stm2 = Arrays.stream(dou);
        stm2.forEach(d->System.out.print(d + " "));

        long[] lon = {1,2,3,4,5};
        LongStream stm3 = Arrays.stream(lon);
        stm3.forEach(d->System.out.print(d + " "));
*/
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        List<Float> productPriceList2 = productsList.stream()
                .filter(p -> p.price > 3000)
                .map(p->p.price)
                .collect(Collectors.toList());
        System.out.println(productPriceList2);

       /* for(int i:arr1)
            System.out.println(i);*/
        Iterator<Float> itr = productPriceList2.iterator();
        //System.out.println(itr.next());
        Iterator<String> itr2 = fruit.iterator();

        while(itr2.hasNext())
            System.out.println(itr2.next());
        while(itr2.hasNext())
        {
            String i = itr2.next();
            if(i.length() <= 5)
                itr2.remove();
        }
        System.out.println("New list of fruits : "+fruit);

        List l = Stream.of(1,2,3,4).map(i->i*2).collect(Collectors.toList());
        System.out.println("New list : "+l);

        Stream<String> stream = Stream.of("a","b","c");
        Optional<String> result = stream.filter(s->s.equals("d")).findFirst();
        System.out.println("New Stream: " + result);
    }
}
