package demo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamDemo {
    public static void main(String[] args) {
        // Predefined list
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> data = reader.lines().collect(Collectors.toList()); // Separate lists to hold classified entries
        List<String> stringList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        // Classify entries
        for (String s : data) {
            if (isInteger(s)) {
                intList.add(Integer.parseInt(s));
            } else if (isDouble(s)) {
                doubleList.add(Double.parseDouble(s));
            } else {
                stringList.add(s);
            }
        }

        // Print in required order: string  double  int
        stringList.forEach(str -> System.out.println("String: " + str));
        doubleList.forEach(d -> System.out.println("Double: " + d));
        intList.forEach(i -> System.out.println("Int: " + i));
    }

    // Utility to check for integer
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Utility to check for double (excluding integers)
    private static boolean isDouble(String s) {
        try {
            if (s.contains(".") || s.toLowerCase().contains("e")) {
                Double.parseDouble(s);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
