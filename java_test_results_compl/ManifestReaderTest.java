import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManifestReaderTest {

    @Test
    public void testManifestValue() {
        // Given
        File file = new File("path/to/your/file.jar");
        String attribute = "your-attribute";

        // When
        String manifestValue = null;
        try {
            manifestValue = getManifestValue(file, attribute);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Then
        assertEquals("expectedValue", manifestValue);
    }

    // Method to be tested
    public String getManifestValue(File file, String attribute) throws IOException {
        try (JarFile jarFile = new JarFile(file)) {
            Manifest manifest = jarFile.getManifest();
            if (manifest != null) {
                Attributes attributes = manifest.getMainAttributes();
                if (attributes != null) {
                    return attributes.getValue(attribute);
                }
            }
        }
        return null;
    }
}
