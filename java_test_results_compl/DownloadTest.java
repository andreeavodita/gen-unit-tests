import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadTest {

    @Test
    public void testDownload() throws IOException {
        // Given
        Path downloadDirectory = Paths.get("path/to/download/directory");
        String gav = "groupId/artifactId/version";
        URL url = new URL("https://example.com/maven2/" + gav + ".jar");
        Path outputPath = downloadDirectory.resolve(gav + ".jar");

        // When
        Files.copy(url.openStream(), outputPath);

        // Then
        assertTrue(Files.exists(outputPath));
    }
}
