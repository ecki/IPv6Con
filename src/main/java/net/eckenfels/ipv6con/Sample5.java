/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;

import java.io.IOException;
import java.net.*;

public class Sample5 {
    public static void main(String[] args) throws IOException {
        String host = "www.heise.de"; int port = 80;
        InetAddress address = InetAddress.getByName(host);
        InetSocketAddress sockAddr = new InetSocketAddress(address, port);

        printAndClose( new Socket(host, port) );

        printAndClose( new Socket(address, port) );

        Socket s = new Socket(); s.connect(sockAddr);
        printAndClose(s);
    }

    private static void printAndClose(Socket s) {
        out.printf("Connected %s#%d -> %s#%d%n", 
            s.getLocalAddress(), s.getLocalPort(), s.getInetAddress(), s.getPort());
        try { s.close(); } catch (Exception ignored) { }
    }
}
