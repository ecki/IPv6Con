/* IPv6-Kongress.de - Java Anwendungen für IPv6 fit machen. */
package net.eckenfels.ipv6con;

import static java.lang.System.out;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SampleHappyEyeballs {
    public static void main(String[] args) throws IOException {
        Socket s= connect(args[0], 80);
        out.printf("Connected to %s -> %s%n", s.getLocalAddress(), s.getInetAddress());
        OutputStream o = s.getOutputStream();
        o.write("GET / HTTP/1.0\n\r\n\r".getBytes()); o.flush();
        InputStream i = s.getInputStream();
        byte[] b = new byte[100];
        int l = i.read(b);
        out.printf("read: %d %s%n", l, new String(b, 0, l));

    }

    static Socket connect(String host, int port) throws IOException {
        long start = System.currentTimeMillis(), now = start;
        InetAddress[] as = InetAddress.getAllByName(host);
        Selector sel = Selector.open();
        try
        {
            int next = 1;
            IOException firstException = null;
            InetSocketAddress sa = new InetSocketAddress(as[0], port);
            out.printf("trying next=%d %s%n", next, sa);
            connectChannel(sel,  sa);

            int wait = 100;
            while(now < start + 40000) {
                sel.select(wait);
                wait = 500;
                Iterator<SelectionKey> keys = sel.selectedKeys().iterator();
                while(keys.hasNext())
                {
                    SelectionKey k = keys.next();
                    SocketChannel ch = (SocketChannel)k.channel();
                    k.cancel(); 
                    keys.remove();
                    try {
                        return forReturn(ch);
                    } catch (IOException ex) {
                        if (firstException == null)
                            firstException = ex;
                        out.printf("ex %s %s%n",  ch.toString(), ex);
                        sel.selectNow();
                    }
                }
                int count = sel.keys().size();
                if ((count < 3) && (next < as.length))
                {
                    sa = new InetSocketAddress(as[next++], port);
                    out.printf("adding next=%d %s%n", next, sa);
                    connectChannel(sel, sa);
                }
                now = System.currentTimeMillis();
                if (count == 0)
                    break;
            }

            if (firstException != null)
                throw new IOException("Cannot connect to " + host + ":80.", firstException);
            else
                throw new IOException("Cannot connect to " + host + ":80 within 10s");
        } finally {
            if (sel != null) {
                sel.selectNow();
                Set<SelectionKey> keys = sel.keys();
                for(SelectionKey k : keys)
                    try { k.channel().close(); } catch (Exception ignored) { } 
                sel.close();
            }
        }
    }

    private static void connectChannel(Selector sel, InetSocketAddress sa2) throws IOException {
        SocketChannel sc = SocketChannel.open(); sc.configureBlocking(false);
        sc.connect(sa2);
        sc.register(sel, SelectionKey.OP_CONNECT);
    }

    private static Socket forReturn(SocketChannel ch) throws IOException {
        ch.finishConnect();
        ch.configureBlocking(true); 
        return ch.socket();
    }
}
