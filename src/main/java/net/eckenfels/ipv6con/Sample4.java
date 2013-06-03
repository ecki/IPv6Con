/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;
import java.net.*;

public class Sample4 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] addrs = InetAddress.getAllByName(args.length>0?args[0]:null);
        for(InetAddress a : addrs)
            out.printf("- %s %s%n", a.getHostAddress(), a.getCanonicalHostName());
    }
}
