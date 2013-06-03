/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;

import java.io.IOException;
import java.net.*;

public class Sample6 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //ServerSocket server = new ServerSocket(1234,50,InetAddress.getByName("0.0.0.0"));
        //ServerSocket server = new ServerSocket(1234,50,InetAddress.getByName("::"));
        //ServerSocket server = new ServerSocket(); server.bind(new InetSocketAddress("::", 12345));
        ServerSocket server = new ServerSocket(1234);
        out.printf("Listening on %s%n",  server.getLocalSocketAddress());
        while(++count<10) {
            Socket client = server.accept();
            printAndClose(client);
        }
    }

    private static void printAndClose(Socket s) {
        out.printf("Connected %s#%d <- %s#%d%n", 
            s.getLocalAddress(), s.getLocalPort(), s.getInetAddress(), s.getPort());
        try { s.close(); } catch (Exception ignored) { }
    }
}
