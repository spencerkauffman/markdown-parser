import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
// Imports JUnit assert tests to be used in code
import static org.junit.Assert.*;
// Imports all files in JUnit to be used in code
import org.junit.*;
// Creates a class called MarkdownParseTest
public class MarkdownParseTest {
    MarkdownParse markdownParse = new MarkdownParse();
    // Denotes a test
    @Test
    // Test method header
    public void addition() {
        // Checks to see if expected value (2) is equal to actual value (1+1)
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException {
        ArrayList<String> expected = new ArrayList<>(List.of("https://something.com", "some-thing.html"));
        ArrayList<String> actual = markdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        assertEquals(expected, actual);
    }

    @Test
    public void testNewFile() throws IOException {
        ArrayList<String> expected = new ArrayList<>(List.of("https://g.com"));
        ArrayList<String> actual = markdownParse.getLinks(Files.readString(Path.of("new-test-file.md")));
        assertEquals(expected, actual);
    }

    @Test
    public void testNewFile1() throws IOException {
        ArrayList<String> expected = new ArrayList<>(List.of("https://s.com"));
        ArrayList<String> actual = markdownParse.getLinks(Files.readString(Path.of("new-test-file1.md")));
        assertEquals(expected, actual);
    }

    @Test
    public void testNewFile2() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = markdownParse.getLinks(Files.readString(Path.of("new-test-file2.md")));
        assertEquals(expected, actual);
    }
}
