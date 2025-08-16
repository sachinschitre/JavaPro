package src.main.java.demo;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {

    @Test
    void testMainOutput() {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            CollectionsDemo.main(new String[]{});

            String output = outContent.toString();

            // Check for expected substrings in output
            assertTrue(output.contains("Spliterator characteristics:"), "Should print spliterator characteristics");
            assertTrue(output.contains("Estimated size:"), "Should print estimated size");
            assertTrue(output.contains("Traversing elements using tryAdvance:"), "Should print traversing elements");
            assertTrue(output.contains("Alice"), "Should print name Alice");
            assertTrue(output.contains("Bob"), "Should print name Bob");
            assertTrue(output.contains("Charlie"), "Should print name Charlie");
            assertTrue(output.contains("Diana"), "Should print name Diana");
            assertTrue(output.contains("Elements in split spliterator:"), "Should print split spliterator elements");
            assertTrue(output.contains("s1 == s2:"), "Should print string comparison");
            assertTrue(output.contains("Hash code of s1:"), "Should print hash code of s1");
            assertTrue(output.contains("**** Demo of flatMap():"), "Should print flatMap demo");
            assertTrue(output.contains("APPLE"), "Should print APPLE from flatMap");
            assertTrue(output.contains("BANANA"), "Should print BANANA from flatMap");
            assertTrue(output.contains("CHERRY"), "Should print CHERRY from flatMap");
            assertTrue(output.contains("**** Demo of mapMulti():"), "Should print mapMulti demo");
            assertTrue(output.contains("Even Doubles with percentage increase:"), "Should print even doubles");
        } finally {
            System.setOut(originalOut);
        }
    }
}