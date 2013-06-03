/* IPv6-Kongress.de - Java Anwendungen f�r IPv6 fit machen. */
package net.eckenfels.ipv6con;

import java.net.*;
import static java.lang.System.*;

public class Sample2 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(args[0]);
        out.printf("Looking up %s -> %s %s isLoop=%s%n",
                 args[0], address, address.getClass(), address.isLoopbackAddress());
    }
}
