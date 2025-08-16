package src.main.java.demo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsDemo {
    /**
     * The main method demonstrates usage of Java's Spliterator with a list of names.
     * <ul>
     *   <li>Creates a list of names and obtains a Spliterator.</li>
     *   <li>Prints Spliterator characteristics and estimated size.</li>
     *   <li>Traverses elements using {@code forEachRemaining} and prints them.</li>
     *   <li>Shows how to split a Spliterator using {@code trySplit}, prints the estimated size and traverses the split elements.</li>
     *   <li>Attempts to split the Spliterator again and prints the results.</li>
     *   <li>Calls additional demo methods: {@code demoStringImmutabilityAndHashCaching()}, {@code demoFlatMap()}, and {@code demoMapMulti()}.</li>
     * </ul>
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        java.util.List<String> names = java.util.Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        java.util.Spliterator<String> spliterator = names.spliterator();

        System.out.println("Spliterator characteristics: " + spliterator.characteristics());
        System.out.println("Estimated size: " + spliterator.estimateSize());

        System.out.println("Traversing elements using tryAdvance:");
        spliterator.forEachRemaining(System.out::println);
       

        // Demo splitting
        java.util.Spliterator<String> split = names.spliterator().trySplit();
        if (split != null) {
             System.out.println(split.estimateSize());
            System.out.println("Elements in split spliterator:");
            split.forEachRemaining(System.out::println);
        }

         // Demo splitting
        split.trySplit();
        if (split != null) {
             System.out.println(split.estimateSize());
            System.out.println("Elements in split spliterator:");
            split.forEachRemaining(System.out::println);
        }
            demoStringImmutabilityAndHashCaching();
            demoFlatMap();
            demoMapMulti();
            demoMapMultiWithFilter();

    }
    
    public static void demoStringImmutabilityAndHashCaching() {
        String s1 = "immutable";
        String s2 = new String("immutable");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));

        int hash1 = s1.hashCode();
        int hash2 = s2.hashCode();

        System.out.println("Hash code of s1: " + hash1);
        System.out.println("Hash code of s2: " + hash2);

        System.out.println("Hash codes are equal: " + (hash1 == hash2));

        // Demonstrate that hash code remains constant
        System.out.println("Hash code of s1 (again): " + s1.hashCode());
        System.out.println("Hash code of s2 (again): " + s2.hashCode());

        // Explanation
        System.out.println("String content is immutable, but hash field is cached internally for performance.");
        System.out.println("Multiple threads may compute hash simultaneously, but result is always the same due to immutability.");
    }
    public static void demoFlatMap() {
        java.util.List<String> words = java.util.Arrays.asList("apple", "banana", "cherry");

        System.out.println("**** Demo of flatMap():");
        java.util.stream.Stream<String> stream = words.stream();

        stream.flatMap(word -> {
            java.util.List<String> result = new java.util.ArrayList<>();
            result.add(word.toUpperCase());
            if (word.length() > 5) {
                result.add(word.substring(0, 5));
            }
            return result.stream();
        }).forEach(System.out::println);
    }
    public static void demoMapMulti(){

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        double percentage = .01;
        List<Double> evenDoubles = integers.stream()
            .<Double>mapMulti((integer, consumer) -> {
                if (integer % 2 == 0) {
                    consumer.accept((double) integer * (1 + percentage));
                }   
            })
            .collect(Collectors.toList());
        System.out.println("**** Demo of mapMulti(): ");
        System.out.println("Even Doubles with percentage increase: " + evenDoubles);
    }

    // Alternate method without using mapMulti
    public static void demoMapMultiWithFilter() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        double percentage = .01;
        List<Double> evenDoubles = integers.stream()
            .filter(integer -> integer % 2 == 0)
            .map(integer -> (double) integer * (1 + percentage))
            .collect(Collectors.toList());
        System.out.println("**** Demo of mapMulti() alternative: ");
        System.out.println("Even Doubles with percentage increase: " + evenDoubles);
    }
}
