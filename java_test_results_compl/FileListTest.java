import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class FileListTest {

    @Test
    public void testList() {
        // Given
        Path directory = Path.of("/path/to/your/directory");

        // When
        Stream<Path> pathsStream = null;
        try {
            pathsStream = Files.list(directory);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }

        // Then
        assertNotNull(pathsStream);
        assertFalse(pathsStream.isEmpty(), "Directory should not be empty");
    }
}
