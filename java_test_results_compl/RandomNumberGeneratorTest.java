import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    @Test
    public void testNextInt() {
        // Given
        SecureRandom secureRandom = new SecureRandom();

        // When
        int generatedNumber = secureRandom.nextInt();

        // Then
        assertNotNull(generatedNumber);
        // Add your assertions here
    }
}
