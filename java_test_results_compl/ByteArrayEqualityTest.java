import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ByteArrayEqualityTest {

    @Test
    public void testByteArrayEquality() {
        // Given
        byte[] expected = {1, 2, 3};
        byte[] actual = {1, 2, 3};

        // When/Then
        assertArrayEquals(expected, actual);
    }
}
