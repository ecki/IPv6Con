/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class Sample7 {
    public static void main(String[] args) throws IOException {
        Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();
        for(NetworkInterface i: Collections.list(ifs)) {
            List<InterfaceAddress> as = i.getInterfaceAddresses();
            if (as == null || as.size() == 0) continue;
            out.printf("%s %%%d %s mtu:%d%n", i.getName(), i.getIndex(), 
                    i.getDisplayName(), i.getMTU());
            for(InterfaceAddress a : as)
                out.printf("  addr %s /%d%n", a.getAddress().getHostAddress(), 
                    a.getNetworkPrefixLength());
        }
    }
}
