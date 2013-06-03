/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Sample8 {
    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName(args[0]);
        InetSocketAddress sockAddr = new InetSocketAddress(addr, Integer.valueOf(args[1]));

        out.printf("Is %s reachable with Ping/Echo? %s%n", addr, addr.isReachable(5*1000));

        Socket s = new Socket();
        s.setTrafficClass(17);
        s.connect(sockAddr);
        
        out.printf("connected %s -> %s%n", s.getLocalSocketAddress(), s.getRemoteSocketAddress());
    }
}
