import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class PortCheckTest {

    @Test
    public void testCheckPort() {
        // Given
        String errorMessage = "Invalid port: ";

        // When/Then
        assertThrows(IOException.class, () -> checkPort(errorMessage, "-1"));
        assertThrows(IOException.class, () -> checkPort(errorMessage, "0"));
        assertDoesNotThrow(() -> checkPort(errorMessage, "80")); // Valid port number
        assertDoesNotThrow(() -> checkPort(errorMessage, "65535")); // Valid port number
        assertThrows(IOException.class, () -> checkPort(errorMessage, "65536"));
    }

    // Method to be tested
    public void checkPort(String errorMessage, String port) throws IOException {
        int portNumber;
        try {
            portNumber = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            throw new IOException(errorMessage + port, e);
        }
        if (portNumber < 1 || portNumber > 65535) {
            throw new IOException(errorMessage + port);
        }
    }
}
