import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DnsHaluz {
    // TTL for DNS cache in seconds (should always match TTL of DNS caching)
    private static final int NETWORK_ADDRESS_CACHE_TTL = 5;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        java.security.Security.setProperty("networkaddress.cache.ttl", NETWORK_ADDRESS_CACHE_TTL + "");
        try {
            var addresses = InetAddress.getAllByName(args[0]);
            System.out.println(Arrays.toString(addresses));
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
