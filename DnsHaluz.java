import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DnsHaluz {
    // TTL for DNS cache in seconds (should always match TTL of DNS caching)
    private static final int NETWORK_ADDRESS_CACHE_TTL = 5;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        java.security.Security.setProperty("networkaddress.cache.ttl", NETWORK_ADDRESS_CACHE_TTL + "");
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("iteration " + i);
                System.out.println("getAllByName for " + args[0] + ":");
                var addresses = InetAddress.getAllByName(args[0]);
                System.out.println(Arrays.toString(addresses));
                System.out.println("getByName for " + args[0] + ":");
                var address = InetAddress.getByName(args[0]);
                System.out.println(address);
                System.out.println();
                Thread.sleep(1000);
            } catch (UnknownHostException | InterruptedException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}
