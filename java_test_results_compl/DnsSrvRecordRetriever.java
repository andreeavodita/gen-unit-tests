import io.netty.handler.codec.dns.*;
import java.util.concurrent.ExecutionException;

public class DnsSrvRecordRetriever {

    public static int getPort(String server) throws InterruptedException, ExecutionException {
        Objects.requireNonNull(server, "Server name must not be null");

        DnsNameResolverBuilder builder = new DnsNameResolverBuilder();
        try (DnsNameResolver resolver = builder.build()) {
            DnsQuestion question = new DefaultDnsQuestion(server, DnsRecordType.SRV);
            DnsResponse response = resolver.query(question).get();

            for (DnsRecord record : response.records(DnsSection.ANSWER)) {
                if (record instanceof DnsRawRecord) {
                    ByteBuf content = ((DnsRawRecord) record).content();
                    content.skipBytes(4); // Skip priority and weight
                    int port = content.readUnsignedShort();
                    return port;
                }
            }
        }

        throw new ExecutionException("No SRV record found for server: " + server, null);
    }

    public static void main(String[] args) {
        try {
            String server = "_sip._tcp.example.com";
            int port = getPort(server);
            System.out.println("Port: " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
