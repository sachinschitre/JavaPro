package src.main.java.demo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort the list of people by age using an inline comparator
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.age, p2.age);
            }
        });

        System.out.println("Sorted by age:");
        for (Person person : people) {
            System.out.println(person);
        }

        // Sort the list of people by name using an inline comparator (lambda expression)
         Collections.sort(people, (p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("Sorted by name:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
