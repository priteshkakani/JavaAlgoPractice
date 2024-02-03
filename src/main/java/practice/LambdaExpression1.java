package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Person> createPeopleList() {
        return Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("David", 40)
        );
    }
}

class LambdaExpression1 {

    public static void main(String args[]){
        new Thread(()-> {
            System.out.println("New Thread Created");
        }).start();
        List<Person> people = Person.createPeopleList();
        // Filter and Collect
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("People older than 30: " + filteredPeople);
        // Map
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Names: " + names);
        // Reduce
        int totalAge = people.stream().map(Person::getAge)
                .reduce(0,Integer::sum);
        System.out.println("Total age: " + totalAge);
        // Any match
        boolean anyMatch = people.stream().anyMatch(person -> person.getName().startsWith("A"));
        System.out.println("Any person with name starting with 'A'? " + anyMatch);
    }
}
