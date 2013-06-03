/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;
import java.net.*;

public class Sample3 {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("http", "2001:DB8::1234:ABCD%13", 80, "");
        out.printf("URL1 toString=%s host=%s port=%d%n",
                   url1.toExternalForm(), url1.getHost(), url1.getPort());
        URL url2 = new URL("https://[2001:DB8::1234:ABCD%13]/test");
        out.printf("URL2 toString=%s host=%s port=%d%n",
                   url2.toExternalForm(), url2.getHost(), url2.getPort());
    }
}
