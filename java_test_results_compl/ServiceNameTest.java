import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceNameTest {

    @Test
    public void testServiceName() {
        // Given
        String port = "-1"; // Invalid port number

        // When/Then
        assertThrows(IOException.class, () -> checkPort(port), "Invalid port: " + port);

        port = "0"; // Invalid port number
        assertThrows(IOException.class, () -> checkPort(port), "Invalid port: " + port);

        port = "80"; // Valid port number
        assertDoesNotThrow(() -> checkPort(port)); // No exception should be thrown

        port = "65535"; // Valid port number
        assertDoesNotThrow(() -> checkPort(port)); // No exception should be thrown

        port = "65536"; // Invalid port number
        assertThrows(IOException.class, () -> checkPort(port), "Invalid port: " + port);
    }

    // Method to be tested
    public void checkPort(String port) throws IOException {
        int portNumber;
        try {
            portNumber = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            throw new IOException("Invalid port: " + port, e);
        }
        if (portNumber < 1 || portNumber > 65535) {
            throw new IOException("Invalid port: " + port);
        }
    }
}
