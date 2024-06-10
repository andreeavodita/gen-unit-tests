import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.net.URL;

public class DownloaderTest {

    @Test
    public void testDownload() {
        // Given
        Downloader downloader = new Downloader();
        String testUrl = "https://example.com/test.txt";

        // When
        byte[] downloadedBytes = null;
        try {
            downloadedBytes = downloader.download(new URL(testUrl));
        } catch (IOException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Then
        assertNotNull(downloadedBytes);
        assertTrue(downloadedBytes.length > 0);
    }
}
